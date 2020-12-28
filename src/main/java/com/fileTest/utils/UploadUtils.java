package com.fileTest.utils;

import java.io.*;

/**
 * @author kung
 * @date 2020-12-18 9:05
 * @Description
 */
public class UploadUtils {
    public static String readTxtFile(String filePath) {
        String content = "";
        try {
            String encoding = codeString(filePath);

            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                BufferedWriter bw = new BufferedWriter(new FileWriter("F:/Tencent/Hello/Qiju_Li.txt"));


                while ((lineTxt = bufferedReader.readLine()) != null) {
//                    content += "\"" + lineTxt + "\",";
                    bw.write(lineTxt);//在创建好的文件中写入"Hello I/O"
                }
                read.close();
                bw.close();//一定要关闭文件
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 获得文件编码
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        bin.close();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }
}
