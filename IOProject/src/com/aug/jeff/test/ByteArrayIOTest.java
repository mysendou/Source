package com.aug.jeff.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ByteArrayInputStream/ByteArrayOutputStream test
 * @author Jeff.Ma
 *
 */
public class ByteArrayIOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("sources/Character.txt");
        FileOutputStream fos = new FileOutputStream("sources/Character4.txt");

        byte[] bytes = new byte[2 * 1024];
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int c;
        while ((c=fis.read(bytes, 0, bytes.length))!=-1) {
            bais.read(bytes, 0, c);
            baos.write(bytes, 0, c);
            baos.writeTo(fos);
            baos.flush();
        }
        baos.close();
        bais.close();
        fos.close();
        fis.close();
    }
}
