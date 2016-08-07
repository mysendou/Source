package com.jeff.IO;

public class IOUtilTest {
    public static void main(String[] args) {
        try {
            IOUtil.printHex("source/test.txt", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
