package com.aug.jeff.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author jeff
 * 
 */
public class BufferRAndBuffW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("sources/Character.txt")));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("sources/Character3.txt")));
        String lineString;
        while ((lineString=br.readLine())!=null) {
            bw.write(lineString);
            bw.newLine();
            System.out.println(lineString);
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
