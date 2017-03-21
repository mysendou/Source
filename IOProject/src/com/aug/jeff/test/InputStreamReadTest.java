package com.aug.jeff.test;

import java.io.FileReader;

public class InputStreamReadTest {
    public static void main(String[] args) throws Exception {
        StringBuffer sbBuffer = new StringBuffer();
        char [] buf = new char[1024];
        FileReader fr = new FileReader("sources/First.txt");
        while(fr.read(buf)>0){
            sbBuffer.append(buf);
        }
        System.out.println(sbBuffer.toString());
    }
}
