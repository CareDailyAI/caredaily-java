package com.peoplepowerco.virtuoso.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.EnumMap;

/**
 * Created by edwardliu on 2019/04/19.
 */

public class BitmapUtils {

    private static final int INT_QR_CODE_SIZE = 860;

    private static Bitmap compressImage(Bitmap image) {
        if (null == image) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 200) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        image.recycle();
        return bitmap;
    }

    public static Bitmap getImage(String srcPath, int biggest, int bigger, int big) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        int be = 1;
        if (w > 4000 || h > 4000) {
            be = biggest;
        } else if (w > 2000 || h > 2000) {
            be = bigger;
        } else if (w > 1000 || h > 1000) {
            be = big;
        }
        newOpts.inJustDecodeBounds = false;
        newOpts.inSampleSize = be;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        if (null == bitmap) {
            return null;
        }
        return compressBitmap(bitmap);
    }

    public static Point getImageSize(String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        return new Point(w, h);
    }

    public static Bitmap compressBitmap(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 200) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        image.recycle();
        return bitmap;
    }

    public static byte[] getImageBytes(String srcPath, int biggest, int bigger, int big) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        int be = 1;
        if (w > 4000 || h > 4000) {
            be = biggest;
        } else if (w > 2000 || h > 2000) {
            be = bigger;
        } else if (w > 1000 || h > 1000) {
            be = big;
        }
        newOpts.inJustDecodeBounds = false;
        newOpts.inSampleSize = be;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        if (null == bitmap) {
            return null;
        }
        try {
            bitmap = rotateImageIfRequired(bitmap, srcPath);
        } catch (IOException e) {
            bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        }
        if (null == bitmap) {
            return null;
        }
        return compressBitmapToByte(bitmap);
    }

    public static byte[] getImageBytes(String srcPath, int biggest, int bigger, int big, int maxSize) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        int be = 1;
        if (w > 4000 || h > 4000) {
            be = biggest;
        } else if (w > 2000 || h > 2000) {
            be = bigger;
        } else if (w > 1000 || h > 1000) {
            be = big;
        }
        newOpts.inJustDecodeBounds = false;
        newOpts.inSampleSize = be;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        if (null == bitmap) {
            return null;
        }
        try {
            bitmap = rotateImageIfRequired(bitmap, srcPath);
        } catch (IOException e) {
            bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        }
        if (null == bitmap) {
            return null;
        }
        return compressBitmapToByte(bitmap, maxSize);
    }

    public static byte[] compressBitmapToByte(Bitmap image, int maxSize) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > maxSize) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        return baos.toByteArray();
    }

    public static byte[] compressBitmapToByte(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 200) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        return baos.toByteArray();
    }

    private static Bitmap rotateImageIfRequired(Bitmap img, String imagePath) throws IOException {
        ExifInterface ei = new ExifInterface(imagePath);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }

    private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }

    public static Bitmap generateAndDisplayQRCode(final String qrCode) {
        Bitmap bitmap = null;
        try {
            QRCodeWriter writer = new QRCodeWriter();
            EnumMap<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix result = writer.encode(qrCode, BarcodeFormat.QR_CODE,
                INT_QR_CODE_SIZE, INT_QR_CODE_SIZE, hints);
            int width = result.getWidth();
            int height = result.getHeight();
            int[] pixels = new int[width * height];
            // All are 0, or black, by default
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    pixels[offset + x] = result.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
                }
            }
            //generate bitmap
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}