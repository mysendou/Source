package com.aug.jeff.test.coder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字节转字符流的操作
 * @author jeff
 *
 */
public class TestCharacterIO {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("sources/Character.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        int c;
        char[] chars = new char[2*1024];
        while ((c=isr.read(chars))!=-1) {
            String string = new String(chars, 0, c);
            System.out.println(string);
        }
        isr.close();
        fis.close();
    }
}
