package com.aug.jeff.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = new FileInputStream("sources/Character.txt");
        FileInputStream fis2 = new FileInputStream("sources/Character.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        
        FileOutputStream fos = new FileOutputStream("sources/Character5.txt");
        int c;
        byte [] bytes = new byte[2*1024];
        while ((c=sis.read(bytes, 0, bytes.length))!=-1) {
            fos.write(bytes, 0, c);
            fos.flush();
        }
        fos.close();
        sis.close();
        fis1.close();
        fis2.close();
    }
}
