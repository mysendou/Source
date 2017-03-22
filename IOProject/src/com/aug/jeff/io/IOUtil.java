package com.aug.jeff.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
    /**
     * 读取指定文件内容，按照16进制输出到控制台 并且每输出10个byte换行
     * 
     * @param fileName
     *            单字节读取不适合大文件，大文件效率很低
     * @throws Exception
     */
    public static void printHex(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        int b;
        int i = 1;
        while ((b = fis.read()) != -1) {
            if (b <= 0xf) {
                // 只有一位的时候补0
                System.out.print(0);
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        fis.close();
    }

    /**
     * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[2 * 1024];
        int bytes = 0;
        int j = 1;
        while((bytes = in.read(buf,0,buf.length))!=-1){
            for(int i = 0 ; i < bytes;i++){
                System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");
                if(j++%10==0){
                    System.out.println();
                }
            }
        }
        in.close();
    }
    
    /**
     * 文件拷贝，字节批量读取
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream is = new FileInputStream(srcFile);
        FileOutputStream os = new FileOutputStream(destFile);
        byte[] buf = new byte[4*1024];
        int b;
        while ((b=is.read(buf,0,buf.length))!=-1) {
            os.write(buf, 0, b);
            os.flush();
        }
        os.close();
        is.close();
    }
    
    /**
     * 带有缓冲区的文件拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int i = 0;
        while ((i=bis.read())!=-1) {
            bos.write(i);
            bos.flush();
        }
        bos.close();
        bis.close();
    }
}
