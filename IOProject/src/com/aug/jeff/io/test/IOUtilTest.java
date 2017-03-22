package com.aug.jeff.io.test;

import java.io.File;
import java.io.IOException;

import com.aug.jeff.io.IOUtil;

public class IOUtilTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("sources/test2/test2-1/test.txt");
        File file2 = new File("sources/test2/test2-1/testCopyWithBuffer.txt");
        IOUtil.copyFileByBuffer(file1,file2);
    }
}
