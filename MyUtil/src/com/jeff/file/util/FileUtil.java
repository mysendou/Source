package com.jeff.file.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

/**
 * File 的常见操作
 * 
 * @author Jeff.Ma
 * 
 */
public class FileUtil {

    /**
     * 
     * 列出目录下的说有文件夹和文件
     * 
     * @param dir 所要检测的目录
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是一个目录");
        }

        System.out.println(dir);
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }

    public static boolean existFile(File dir, String fileName) {
        boolean fileExist = false;

        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是一个目录");
        }

        if (StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("错查询的文件名为空");
        }

        fileExist = checkFileInDir(dir, fileName);
        if (fileExist) {
            return true;
        }

        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if(existFile(file, fileName)){
                        return true;
                    }
                }
            }
        }
        
        return fileExist;
    }

    /**
     * 查找文件加下是否存在某个文件(有后缀名)
     * 
     * @param dir 所查找的文件名
     * @param fileName 所查找的文件
     * @return
     */
    public static boolean checkFileInDir(File dir, final String fileName) {
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(fileName);
            }
        });
        if (files.length > 0) {
            return true;
        } else {
            return false;
        }
    }
}
