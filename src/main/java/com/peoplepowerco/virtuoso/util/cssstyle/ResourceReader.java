package com.peoplepowerco.virtuoso.util.cssstyle;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceReader {

    public static String readTextFromResource(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        InputStream raw = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;
        try {
            raw = assetManager.open(fileName);
            i = raw.read();
            while (i != -1) {
                stream.write(i);
                i = raw.read();
            }
            raw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }
}
