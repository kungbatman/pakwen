package com.fileTest.pangou;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kung
 * @date 2020-10-16 17:05
 * @Description
 */
public class MagicalCoders {

    /**
     * 实现字节码和ASCII码互相转换
     *
     * @author ZR
     */

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("1.字节码->ASCII码");
//            System.out.println("2.ASCII码->字节码");
//            System.out.println("3.退出");
//            System.out.println("请输入要执行的命令序号:");
//            int num = sc.nextInt();
//            switch (num) {
//                case 1:
//                    System.out.println("请输入字节码:");
//                    byteToASCII(sc.nextInt());
//                    break;
//                case 2:
//                    System.out.println("请输入ASCII码:");
//                    ascToByte(sc.next());
//                    break;
//                case 3:
//                    System.out.println("已退出,欢迎下次使用.");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("您输入的指令不正确,.");
//                    break;
//            }
//        }
//        String filePath = ("f:/1.txt");
//        //File file = new File("hehe.txt");
//        String contents = new String("\r\nabc");
//        try {
//            addContainsToFile(filePath,2,contents);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        sd();

        System.out.println(codeString("src/main/webapp/resources/static/htmls/testHtml.html"));

//        Scanner scanner = new Scanner( new File("src/main/webapp/resources/static/htmls/testHtml.html"));
//        String line =scanner.nextLine();
//        String  regCharString = scanner.nextLine();
//        int num = calculateNum(line,regCharString);
//        System.out.println(num);
    }

    /**
     * 字节码->ASCII码
     *
     * @param bt
     */
    private static void byteToASCII(int bt) {
        char[] chars = Character.toChars(bt);
        System.out.println("对应的ASCII码为:" + new String(chars));

    }

    /**
     * ASCII码->字节码
     *
     * @param asc
     */
    private static void ascToByte(String asc) {
        int codePointAt = Character.codePointAt(asc, 0);
        System.out.println("对应的字节码为:" + codePointAt);

    }

    public static void addContainsToFile(String filePath, int position, String contents) throws IOException {
        //1、参数校验
        File file = new File(filePath);
        System.out.println(file);
        //判断文件是否存在
        if (!(file.exists() && file.isFile())) {
            System.out.println("文件不存在  ~ ");
            return;
        }
        //判断position是否合法
        if ((position < 0) || (position > file.length())) {
            System.out.println("position不合法 ~ ");
            return;
        }

        //2、创建临时文件
        File tempFile = File.createTempFile("sss", ".temp", new File("d:/"));
        //File tempFile = new File("d:/wwwww.txt");
        //3、用文件输入流、文件输出流对文件进行操作
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        FileInputStream inputStream = new FileInputStream(tempFile);
        //在退出JVM退出时自动删除
        tempFile.deleteOnExit();

        //4、创建RandomAccessFile流
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        //文件指定位置到 position
        rw.seek(position);

        int tmp;
        //5、将position位置后的内容写入临时文件
        while ((tmp = rw.read()) != -1) {
            outputStream.write(tmp);
        }
        //6、将追加内容 contents 写入 position 位置
        rw.seek(position);
        rw.write(contents.getBytes());

        //7、将临时文件写回文件，并将创建的流关闭
        while ((tmp = inputStream.read()) != -1) {
            rw.write(tmp);
        }
        rw.close();
        outputStream.close();
        inputStream.close();
    }


    public static void sd() throws IOException {
        String sstr = "  hi-sad // " + "\n" + "//functions-begin";
        System.out.println(sstr.indexOf("//") + "\n");
        System.out.println(sstr.indexOf("//functions-begin"));
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

    private static int calculateNum(String line,String regCharString)
    {
        int num =0;
        char c;
        char regChar = toUpperCase(regCharString.charAt(0));
        // TODO Auto-generated method stub
        for(int i =0;i<line.length();++i)
        {
            c=toUpperCase(line.charAt(i));
            if(c==regChar)
            {
                num++;
            }
        }

        return num;
    }

    private static Character toUpperCase(char charAt)
    {
        // TODO Auto-generated method stub
        if(charAt>='a'&&charAt<='z')
        {
            return (char) (charAt-'a'+'A');
        }
        return charAt;
    }


    private static void testListArrayList()
    {
       List<String> list = new LinkedList<>();
    }


//    public static void TestRegex() {
//
//
//            String testString = "第一回 风雪惊变\r\n  钱塘江浩浩江水，日日夜夜无穷无休的从临安牛家村边绕过，东流入海。";
//
//            Pattern p = Pattern.compile(("^\\s第")(.{1，9})["章节卷集部篇回"]("\\s)(.)(\n|\r|\r\n"));
//
//            Matcher matcher = p.matcher(testString);
//
//            while (matcher.find()) {
//
//                for (int i = 0; i <= matcher.groupCount(); i+) {
//
//                    System.out.println("group" + i + ":"  + matcher.start(i) +  -  + matcher.end(i));
//
//                    System.out.println(matcher.group(i));
//
//                }
//
//            }
//
//        }


}
