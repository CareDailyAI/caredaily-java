/**
 * @FileName : PPFriendProspectJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPFriendsInfoModel;
import com.peoplepowerco.virtuoso.util.PPUtil;

public class PPFriendProspectJsonParser implements PPBaseJsonParser {
//    private List<PPFriendsInfoModel> m_FriendInfoList;
//    private Context m_Context;

//    public PPFriendProspectJsonParser(Context context)
//    {
//        this.m_Context = context;
//    }

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaUsers = null;

        PPFriendsInfoModel friendInfoModel = (PPFriendsInfoModel) obj[0];

        try
        {
            jaUsers = (jso.containsKey("users")) ? jso.getJSONArray("users") : null;

            //first grab the first entry in the users array
            if(jaUsers != null) {
                int iUsers = jaUsers.size();
                for(int usersIdx = 0; usersIdx < iUsers; usersIdx++) {
                    JSONObject jsonUser = jaUsers.getJSONObject(usersIdx);

                    //user id
                    friendInfoModel.setUserID((jsonUser.containsKey("id")) ? jsonUser.getInteger("id") : 0);
                    //first name
                    friendInfoModel.setFirstName((jsonUser.containsKey("firstName")) ? jsonUser.getString("firstName") : PPUtil.NULL_STRING);
                    //last name
                    friendInfoModel.setLastName((jsonUser.containsKey("lastName")) ? jsonUser.getString("lastName") : PPUtil.NULL_STRING);

                    //Now let's grab email details
                    JSONObject jsonEmail = (jsonUser.containsKey("email")) ? jsonUser.getJSONObject("email") : null;
                    if(jsonEmail != null) {
                        //email
                        friendInfoModel.setEmail((jsonEmail.containsKey("email")) ? jsonEmail.getString("email") : PPUtil.NULL_STRING);
                        //verified
                        friendInfoModel.setEmailVerified((jsonEmail.containsKey("verified")) ? jsonEmail.getBoolean("verified") : false);
                        //status
                        friendInfoModel.setEmailStatus((jsonEmail.containsKey("status")) ? jsonEmail.getInteger("status") : 0);
                    }
                }
            }

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        catch (OutOfMemoryError ex)
        {
            Runtime.getRuntime().gc();
        }

        return false;
    }
}
