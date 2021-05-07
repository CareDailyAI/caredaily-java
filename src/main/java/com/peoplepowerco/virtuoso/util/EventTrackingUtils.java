package com.peoplepowerco.virtuoso.util;


import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EventTrackingUtils {

    public static String EventKey;

    public static String getEventData(String content) throws Exception {
        if (TextUtils.isEmpty(content)) {
            throw (new InvalidParameterException());
        }

        byte[] textBytes = Base64.decode(content.getBytes(), Base64.DEFAULT);
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(EventKey.getBytes());
        SecretKeySpec newKey = new SecretKeySpec(EventKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
        return new String(cipher.doFinal(textBytes));
    }
}
