package com.company;

import java.io.*;

/**
 * @author Edward Kats
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
//        File file = ReadFile.class.getResource("ReadFile.txt").getFile();
        InputStream inputStream = ReadFile.class.getResourceAsStream("/ReadFile.txt");

        String content = getFileContent(inputStream);
        System.out.println(content);
        writeToFile(content);

    }

    private static void writeToFile(String content) throws IOException {
        String filename = "WriteFile.txt";
        File directory = new File("C:\\Dev\\tel-ran\\input-output\\files");
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File(directory, filename);

        OutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }

    private static String getFileContent(InputStream inputStream) throws IOException {
        byte [] buffer = new byte[30 * 1024];
        while (inputStream.available() > 0) {
            int read = inputStream.read(buffer);
            if (read ==  -1) {
                System.out.println("reached here");
                break;
            }
        }
        inputStream.close();
        return new String(buffer);
    }
}
