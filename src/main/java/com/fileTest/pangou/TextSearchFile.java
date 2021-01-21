package com.fileTest.pangou;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author kung
 * @date 2021-01-07 14:00
 * @Description
 */
public class TextSearchFile {
//    public static List<File> searchFiles(File folder, final String keyword) {
//        List<File> result = new ArrayList<File>();
//        if (folder.isFile())
//            result.add(folder);
//
//        File[] subFolders = folder.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                if (file.isDirectory()) {
//                    return true;
//                }
//                if (file.getName().toLowerCase().contains(keyword)) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        if (subFolders != null) {
//            for (File file : subFolders) {
//                if (file.isFile()) {
//                    // 如果是文件则将文件添加到结果列表中
//                    result.add(file);
//                } else {
//                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
//                    result.addAll(searchFiles(file, keyword));
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        List<File> files = searchFiles(new File("F:/文物出版/"), "html.txt");
//        System.out.println("共找到:" + files.size() + "个文件");
//        for (File file : files) {
//            System.out.println(file.getAbsolutePath());
//        }
//    }

   static HashMap filelist = new HashMap();

    /**
     * 递归方法
     *
     * @param path 文件路径
     */
    public static void find(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        //如果文件数组为null则返回
        if (files == null)
            return;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                //判断是不是文件夹，如果是文件夹则继续向下查找文件
                find(files[i].getAbsolutePath());
            } else {
                //记录文件路径
                String filePath = files[i].getAbsolutePath().toLowerCase();
                //记录文件名
                String fileName = files[i].getName().toLowerCase();
//                System.out.println("---"+strFileName);
                filelist.put(fileName, filePath);
            }
        }
    }

    public static void main(String[] args) {
        //需要遍历的路径，也就是你要查找文件所在的路径
        String path = "F:" + File.separator + "气象局部署war" + File.separator +"to_server_2020050914" + File.separator;
        find(path);
        System.out.println("路径:" + filelist.get("meteorheat.war").toString().split(":")[1]);
        System.out.println(filelist);
        filelist = null;
    }
}