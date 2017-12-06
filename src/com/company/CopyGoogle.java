package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CopyGoogle {


    public static void main(String[] args) throws IOException {
//        InputStream inputStream = new URL("https://google.com").openStream();
        File file = new File("C:\\Dev\\tel-ran\\input-output\\FileToRead.txt");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = System.out;
        copy(inputStream, outputStream);

    }
    private static void copy(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        //how many data to read in the row. If no buffer - will read byte per byte - worst option
        byte [] buff = new byte[64 * 1024];

        //inputStream.available() returns the number of the next bytes, that is it capable or reading.
        //If there are no bytes left - then it returns zero. Zero means - there is no more data to read.
        while (inputStream.available() > 0) {
            //This method blocks until input data is available,
            // end of file is detected, or an exception is thrown.
            //It has to write at least one byte. If there is no data or data is unavailable - then IOException will be thrown.
            int count = inputStream.read(buff);
//            //returns -1 when there are no more bytes to read
//            if (count == -1) {
//                return;
//            }
            outputStream.write(buff, 0, count);
        }
        inputStream.close();
        outputStream.close();
    }
}
