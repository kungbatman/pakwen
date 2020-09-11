package com.fileTest.pangou;

import org.apache.commons.lang3.StringUtils;

/**
 * @author kung
 * @date 2019-12-12 8:24
 * @Description
 */
public class ReturnDemo {
    public static void main(String[] args) {
//        if (demo(5, "")) {
//            System.out.println("输入值小于3");
//        }
//        String a = convert("查询出错");
//        System.out.println("==转码后= " + a);
//
//        String b = decodeUnicode2(a);
//        System.out.println("==解码= " + b);
        multi();
    }

    public static boolean demo(int a, String c) {
        if (StringUtils.isNotEmpty(c)) {
            if (a >= 3) {
                return false;
            } else {
                int b = 4;
                System.out.println("b=" + b);
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 将字符串转成unicode
     *
     * @param str 待转字符串
     * @return unicode字符串
     */
    public static String convert(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>> 8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        System.out.println("sb= " + sb.toString());
        return (new String(sb));
    }

    public static String decodeUnicode2(String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = null;
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static void multi(){
        int i,j;
        for(i = 1; i <= 9;i++){
            for (j = 1;j <= i; j++){
                System.out.print(j + "*" + i + "=" +(i*j)+"\t");
            }
            System.out.println();
        }
        float a = 123.2334f;
        float b = (float)Math.round(a*100)/100;
        System.out.println(b);

        String t = "j**i**788";
        String[] ss = StringUtils.split(t, "**");
        for (int k = 0; k < ss.length; k++){
            System.out.println(ss[k]);
        }

    }

}