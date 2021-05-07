/**
 * @FileName : PPAndroidContactsManager.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.managers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.models.PPContactModel;

import java.util.ArrayList;
import java.util.List;

import static com.peoplepowerco.virtuoso.PPCommonInfo.MONITOR_SERVICE_PHONE_NUMBER;
import static com.peoplepowerco.virtuoso.PPCommonInfo.MONITOR_SUPPORT_PHONE_NUMBER;

public class PPAndroidContactsManager {
    private static final String TAG = PPAndroidContactsManager.class.getSimpleName();
    private static PPAndroidContactsManager instance = null;

    //Contacts list
    private List<PPContactModel> m_ContactList = null;
    private List<PPContactModel> m_MonitorContactList = null;

    private String m_LastName;
    private boolean needReset = false;

    private String[] projection = {
            ContactsContract.Data.MIMETYPE,
            ContactsContract.Data.CONTACT_ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Contactables.DATA,
            ContactsContract.CommonDataKinds.Contactables.TYPE,
    };

    private String selection = ContactsContract.Data.MIMETYPE + " in (?, ?)";
    private String[] selectionArgs = {
            ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE,
            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE,
    };

    private Uri uri = ContactsContract.CommonDataKinds.Contactables.CONTENT_URI;

    private static final String[] RECOMMEND_KEYS = {"dad", "mom", "father", "mother", "grand", "aunt", "uncle"};

    //registered handlers...
    //TODO: Determine if we want to send handler messages...
//    List<Handler> m_Handlers = new ArrayList<Handler>(3);

    /**
     * Hidden class constructor.
     */
    private PPAndroidContactsManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     *
     * @return
     */
    public static PPAndroidContactsManager getInstance() {
        synchronized (PPAndroidContactsManager.class) {
            if (instance == null) {
                instance = new PPAndroidContactsManager();
            }
        }
        return instance;
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
//        m_Handlers.clear();
        if (instance != null) {
            instance.m_ContactList.clear();
            instance.m_ContactList = null;
            instance.m_MonitorContactList.clear();
            instance.m_MonitorContactList = null;
            instance = null;
        }
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        m_ContactList = new ArrayList<PPContactModel>();
        m_MonitorContactList = new ArrayList<PPContactModel>();
    }

    public List<PPContactModel> getContactList(boolean bListClean) {
        if (m_ContactList.size() == 0) {
            refreshContactList();
        } else if (m_ContactList.size() > 0) {
            if (bListClean) {
                m_ContactList.clear();
                refreshContactList();
            }
        }
        return m_ContactList;
    }

    /**
     * Returns the users contact list in a form usable by our app.
     * On the first call, the list will be filled.
     * Each additional call simply returns the current list.
     * To refresh the list, make a call to refreshMonitorContactList().
     * Note: This method is not thread safe but should be ok since
     * this is not a high traffic method.
     *
     * @return
     */
    public List<PPContactModel> getMonitorContactList(boolean bListClean) {
        if (m_MonitorContactList.size() == 0) {
            refreshMonitorContactList();
        } else if (m_MonitorContactList.size() > 0) {
            if (bListClean || needReset) {
                m_MonitorContactList.clear();
                refreshMonitorContactList();
                needReset = false;
            }
        }
        return m_MonitorContactList;
    }

    public void refreshContactList() {
        ContentResolver cr = PPAppCenter.m_Context.getContentResolver();
        Cursor cursor = cr.query(uri, projection, selection, selectionArgs, Contacts.SORT_KEY_PRIMARY + " ASC");

        final int mimeTypeIdx = cursor.getColumnIndex(ContactsContract.Data.MIMETYPE);
        final int nameIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        final int dataIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Contactables.DATA);

        while (cursor.moveToNext()) {
            PPContactModel contact;
            contact = new PPContactModel();
            contact.sName = cursor.getString(nameIdx);
            String data = cursor.getString(dataIdx);
            String mimeType = cursor.getString(mimeTypeIdx);
            if (mimeType.equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {
                contact.sEmail = data;
            } else {
                contact.sPhone = data;
            }
            m_ContactList.add(contact);
        }
        cursor.close();
    }

    /**
     * Refreshes the current contact list.
     * This method only needs to be called if we suspect that the user
     * has recently modified their contacts.  One feature that will use
     * this method is the ability to add a Friend to your contact list if
     * they are not already there.
     */
    public void refreshMonitorContactList() {
        ContentResolver cr = PPAppCenter.m_Context.getContentResolver();
        Cursor cursor = cr.query(uri, projection, selection, selectionArgs, Contacts.SORT_KEY_PRIMARY + " ASC");

        final int mimeTypeIdx = cursor.getColumnIndex(ContactsContract.Data.MIMETYPE);
        final int contactIdx = cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID);
        final int nameIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        final int dataIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Contactables.DATA);

        ArrayList<PPContactModel> recommendContacts = new ArrayList<>();
        ArrayList<PPContactModel> normalContacts = new ArrayList<>();

        while (cursor.moveToNext()) {
            String contactName = cursor.getString(nameIdx);
            String data = cursor.getString(dataIdx);
            String mimeType = cursor.getString(mimeTypeIdx);
            if (contactName.startsWith("#") || contactName.startsWith("$") || contactName.startsWith("/")
                    || contactName.startsWith("@")
                    || mimeType.equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {
                continue;
            } else {
                if (!android.util.Patterns.PHONE.matcher(data).matches() || data.equals(MONITOR_SERVICE_PHONE_NUMBER)
                        || data.equals(MONITOR_SUPPORT_PHONE_NUMBER) || formatPhone(data).startsWith("1800")) {
                    continue;
                }
            }

            PPContactModel contact = new PPContactModel();
            contact.sContactId = cursor.getString(contactIdx);
            contact.sName = contactName;
            contact.sPhone = data;

            if (isRecommendContacts(contactName) || isSelf(contactName)) {
                if (recommendContacts.isEmpty()) {
                    PPContactModel seperator = new PPContactModel();
                    seperator.sName = "Recommended Contacts";
                    seperator.bIsSeperator = true;
                    recommendContacts.add(seperator);
                }
                recommendContacts.add(contact);
            } else {
                if (normalContacts.isEmpty()) {
                    PPContactModel seperator = new PPContactModel();
                    seperator.sName = "Select Contact";
                    seperator.bIsSeperator = true;
                    normalContacts.add(seperator);
                }
                normalContacts.add(contact);
            }
        }
        if (!recommendContacts.isEmpty()) {
            recommendContacts.get(recommendContacts.size() - 1).bIsLast = true;
        }

        if (!normalContacts.isEmpty()) {
            normalContacts.get(normalContacts.size() - 1).bIsLast = true;
        }
        m_MonitorContactList.addAll(recommendContacts);
        m_MonitorContactList.addAll(normalContacts);
        cursor.close();
    }

    private String formatPhone(String phone) {
        String retValue = phone.replace("-", "");
        retValue = retValue.replace(" ", "");
        return retValue;
    }

    /**
     * Resets the selected flags for contact entries so they may be reused without calling the
     * database again.
     */
    public void resetFlags() {
        for (PPContactModel model : m_ContactList) {
            model.bChecked = false;
        }
    }

    private boolean isSelf(String name) {
        if (null != m_LastName && name.contains(m_LastName)) {
            return true;
        }
        return false;
    }

    public static boolean isRecommendContacts(String name) {
        for (int i = 0; i != RECOMMEND_KEYS.length; ++i) {
            String key = RECOMMEND_KEYS[i];
            if (name.toLowerCase().contains(key)) {
                return true;
            }
        }
        return false;
    }

    public void clearMineContacts() {
        m_LastName = null;
    }

    public void setMineLastName(String name) {
        if (null == m_LastName || !m_LastName.equals(name)) {
            needReset = true;
        } else {
            needReset = false;
        }
        m_LastName = name;
    }
}
