package com.aug.jeff.file.test;

import java.io.File;
import java.io.IOException;

import com.aug.jeff.file.FileUtil;

public class FileUtilTest {
    public static void main(String[] args) {
        File file = new File("sources");
        try {
            FileUtil.listDirectoryWithChildren(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        System.out.println(FileUtil.checkFileInDir(file, "build1.txt"));
//        System.out.println(FileUtil.existFile(file, "build2.txt"));
    }
}
