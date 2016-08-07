package com.jeff.IO;

import java.io.FileInputStream;

import org.apache.commons.lang.StringUtils;

public class IOUtil {
    /**
     * 以字节的方式读取文件并将文件已 16 进制进行输出, 并且每输出 num 个进行换行
     * 
     * @param fileName 所读取的文件名
     * @param num 每输出 num 个进行换行
     * @throws Exception
     */
    public static void printHex(String fileName, int num) throws Exception {
        if (StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("输入的文件名为空");
        }
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int b;
        int count = 0;
        while ((b = fileInputStream.read()) != -1) {
            if(b < 0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "    ");

            if ((count++) % num == 0) {
                System.out.println();
            }
        }

        fileInputStream.close();
    }
}
