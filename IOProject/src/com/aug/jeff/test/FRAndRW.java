package com.aug.jeff.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符的方式读取写入文件
 * FileReader/FileWriter
 * @author jeff
 *
 */
public class FRAndRW {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("sources/Character.txt");
        FileWriter fw = new FileWriter("sources/Character2.txt");
        char[] chars = new char[2*1024];
        int c;
        while ((c=fr.read(chars))!=-1) {
            fw.write(chars, 0, chars.length);
            fw.flush();
        }
        fw.close();
        fr.close();
    }
}
