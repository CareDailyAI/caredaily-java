/**
 * @FileName : PPFileChunkProcess.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage file chunk.
 *
 * @author bhargav
 */
public class PPFileChunkProcess {

    private static final String TAG = "PPFileChunkProcess";

    private String m_sFileLocation = null;

    // Default size 1 MB
    /*private int chunkSize 		= 1024 * 1024;*/
    private int chunkSize = 5242880;
    // Number of chunk
    private int numberOfChunk = 0;
    private int startIndex = 0;
    private int endIndex = 0;

    private long remainingBytes = 0;
    private long fileSize = 0;

    private File m_File = null;
    private FileInputStream m_FileInputStream = null;

    private byte[] m_Data = null;

    public PPFileChunkProcess() {
    }

    public PPFileChunkProcess(String m_sFileLocation) throws FileNotFoundException {
        this.m_sFileLocation = m_sFileLocation;
        init();
    }

    /**
     * Initialize all variable.
     *
     * @throws FileNotFoundException
     */
    private void init() throws FileNotFoundException {
        m_File = new File(m_sFileLocation);
        m_FileInputStream = new FileInputStream(m_File);

        fileSize = m_File.length();
        remainingBytes = fileSize;
        startIndex = 0;
        endIndex = (int) (isEOF() ? fileSize : chunkSize);
        numberOfChunk = (int) calculateFileChunk(fileSize, chunkSize);
    }

    /**
     * Get current file location.
     *
     * @return
     */
    public String getFileLocation() {
        return m_sFileLocation;
    }

    /**
     * Set file location
     *
     * @param m_sFileLocation
     */
    public void setFileLocation(String m_sFileLocation) {
        this.m_sFileLocation = m_sFileLocation;
    }

    /**
     * Get file chunk size.
     *
     * @return
     */
    public int getChunkSize() {
        return chunkSize;
    }

    /**
     * Set file chunk size
     *
     * @param chunkSize
     */
    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    /**
     * Get current start index.
     *
     * @return
     */
    public long getStartIndex() {
        return startIndex;
    }

    /**
     * Get current end index
     *
     * @return
     */
    public long getEndIndex() {
        return endIndex;
    }

    /**
     * Get remaining bytes
     *
     * @return
     */
    public long getRemainingBytes() {
        return remainingBytes;
    }

    /**
     * Get file size
     *
     * @return
     */
    public long getFilesize() {
        return fileSize;
    }

    /**
     * Get number of chunk
     *
     * @return
     */
    public int getNumberOfChunk() {
        return numberOfChunk;
    }

    /**
     * Read byte from file.
     *
     * @return
     * @throws IOException
     */
    public byte[] readBytes() throws IOException {
        m_Data = new byte[endIndex];

        if (m_File == null && !TextUtils.isEmpty(m_sFileLocation)) {
            init();
        }
        m_FileInputStream.read(m_Data, 0, endIndex);
        updateCounter();
        return m_Data;
    }


    /**
     * Delete the file after use
     */
    public void deleteFile() {
        if (m_File.exists())
            m_File.delete();
    }

    /**
     * Get all chunk from file.
     *
     * @return
     * @throws IOException
     */
    public List<byte[]> getAllChunkFromFile() throws IOException {
        List<byte[]> m_AllChunkList = new ArrayList<byte[]>();

        if (m_File == null && !TextUtils.isEmpty(m_sFileLocation)) {
            init();
        }
        if (m_File.exists()) {
            for (; numberOfChunk != 0; ) {
                byte[] m_Data = readBytes();
                m_AllChunkList.add(m_Data);
            }
        }
        return m_AllChunkList;
    }

    /**
     * Update file counter.
     */
    private void updateCounter() {
        remainingBytes = remainingBytes - endIndex;
        startIndex = startIndex + endIndex;
        endIndex = (int) (isEOF() ? remainingBytes : chunkSize);
        numberOfChunk--;
    }

    /**
     * Check End of File.
     *
     * @return
     */
    public boolean isEOF() {
        if (remainingBytes < chunkSize) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculate file chunk.
     *
     * @param fileSize
     * @param chunkSize
     * @return
     */
    public static double calculateFileChunk(double fileSize, double chunkSize) {
        double numberOfChunk = Math.ceil(fileSize / chunkSize);
        return numberOfChunk;
    }

    /**
     * Test fuction for read operation.
     *
     * @param m_byteList
     */
    public void testFile(List<byte[]> m_byteList) {
        String m_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test123.mp4";
        try {
            FileOutputStream fos = new FileOutputStream(m_path);
            for (byte[] bs : m_byteList) {
                fos.write(bs);
            }
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}