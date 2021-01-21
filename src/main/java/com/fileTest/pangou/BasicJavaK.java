package com.fileTest.pangou;

import java.io.*;

/**
 * @author kung
 * @date 2020-12-02 9:43
 * @Description
 */
public class BasicJavaK {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        String path = "F:\\文物出版\\文件上传";
        File file = new File(path);
        func(file);
    }

    private static void func(File file) throws IOException {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile() && ("xls".equals(f.getName().substring(f.getName().lastIndexOf(".") + 1)) || "xlsx".equals(f.getName()
                    .substring(f.getName().lastIndexOf(".") + 1)))) {        //若是文件，直接打印
                System.out.println(f.getPath());
//                InputStream in = null;
//                in = new FileInputStream(f);
//                int tempbyte;
//                while ((tempbyte = in.read()) != -1) {
//                    System.out.write(tempbyte);
//                }
//                in.close();
            }
        }
    }
}
