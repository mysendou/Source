package com.aug.jeff.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamTest {
    public static void main(String[] args) {
        try {
            byte [] bWrite = {11,21,3,40,5};
            OutputStream os = new FileOutputStream("sources/test.txt");
            for(int i = 0; i < bWrite.length; i++){
                os.write(bWrite[i]);
            }
            os.close();

            InputStream is = new FileInputStream("sources/test.txt");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.println(is.read() + " ");
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
