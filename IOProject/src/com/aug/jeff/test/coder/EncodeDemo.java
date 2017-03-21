package com.aug.jeff.test.coder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * test encoding
 * 
 * @author Jeff.Ma
 * 
 */
public class EncodeDemo {
    public static void main(String[] args) {
        // testInputStreamCoder();
        // testOutputStreamCoder();
        // test3();
        encode();
    }

    /**
     * 测试各自编码
     */
    private static void encode() {
        String name = "";
//        toHex(name.getBytes());
        System.out.println(name.length());
        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            // toHex(iso8859);
            System.out.println(iso8859.length);
            byte[] gb2312 = name.getBytes("GB2312");
            // toHex(gb2312);
            System.out.println(gb2312.length);
            byte[] gbk = name.getBytes("GBK");
            // toHex(gbk);
            System.out.println(gbk.length);
            byte[] utf16 = name.getBytes("UTF-16");
            // toHex(utf16);
            System.out.println(utf16.length);
            byte[] utf8 = name.getBytes("UTF-8");
            // toHex(utf8);
            System.out.println(utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节到字符互相转换测试
     */
    private static void test3() {
        String s = "字节到字符互相转换测试";
        try {
            byte[] byteArray = s.getBytes("UTF-8");
            String s2 = new String(byteArray, "UTF-8");
            System.out.println(s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试输出流
     */
    private static void testOutputStreamCoder() {
        String fileName = "sources/file2.txt";
        String charset = "UTF-8";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, charset);
            outputStreamWriter.write("测试中文");
            outputStreamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试输入流
     */
    private static void testInputStreamCoder() {
        String fileName = "sources/file.txt";
        String charset = "UTF-8";
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
            System.out.println(stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * byte 数组以16进制输出
     * 
     * @param b
     */
    public static void toHex(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase());
        }

    }
}
