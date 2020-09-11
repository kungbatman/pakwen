package com.fileTest.pangou;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.sql.*;

import java.util.Date;

/**
 * @author kung
 * @date 2020-09-01 16:46
 * @Description
 */
public class InsertData {
    static Connection conn = null;

    public static final int[] ids = {
            299, 300, 301, 302, 303, 304, 305, 306, 307, 308,
            309, 310, 311, 312, 313, 314, 315, 316, 317, 318,
            319, 320, 321, 322, 323, 324, 325, 326, 327, 328,
            329, 330, 331, 332, 333, 334, 335, 336, 337, 338,
            339, 340, 341, 342, 343, 344, 345, 346, 347, 348,
            349, 350, 351, 352, 434, 435, 436, 437, 438, 439,
            440, 353, 354, 355, 356, 357, 358, 359, 360, 361,
            362, 363, 364, 519, 520, 521, 522, 523, 524, 525,
            526, 527, 365, 366, 367, 368, 369, 370, 371, 372,
            373, 374, 375, 376, 377, 378, 379, 380, 381, 382,
            383, 384, 385, 749, 750, 751, 752, 830, 831, 832,
            833, 386, 387, 388, 389, 390, 391, 392, 393, 394,
            395, 396, 397, 398, 399, 400, 401, 402, 403, 404,
            405, 406, 407, 408, 409, 410, 411, 412, 413, 414,
            415, 416, 417, 418, 419, 420, 421, 422, 423, 424,
            425, 426, 427, 428, 429, 430, 431, 432, 433, 434,
            435, 436, 437, 438, 439, 440, 441, 442, 443, 444,
            445, 446, 447, 448, 449, 450, 451, 452, 453, 454,
            455, 456, 457, 458, 459, 460, 461, 462, 463, 464,
            465, 466, 467, 468, 469, 470, 471, 472, 473, 474,
            475, 476, 477, 478, 479, 480, 481, 482, 483, 484,
            485, 486, 487, 488, 489, 490, 491, 492, 493, 494,
            495, 496, 497, 498, 499, 500, 501, 502, 503, 504,
            505, 506, 507, 508, 509, 510, 511, 512, 513, 514,
            515, 516, 517, 518, 519, 520, 521, 522, 523, 524,
            525, 526, 527, 528, 529, 530, 746, 747, 748, 749,
            750, 751, 752, 830, 831, 832, 833, 1179, 1180, 1181

    };


    public static void initConn() throws ClassNotFoundException, SQLException {

        String sql;
        String url = "jdbc:mysql://localhost:3306/energybill?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";

        String username = "root";
        String password = "root";
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String randomStr(int size) {
        //定义一个空字符串
        String result = "";

        for (int i = 0; i < 6; ++i) {
            //生成一个97~122之间的int类型整数
            int intVal = (int) (Math.random() * 26 + 97);
            //强制转换（char）intVal 将对应的数值转换为对应的字符
            //将字符进行拼接
            result = result + (char) intVal;
        }
        //输出字符串
        return result;
    }


    public static void insert() {
        // 开时时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO eng_dev_elect_his (dev_id, dev_type,dev_proto,total_elec_engy,create_time) VALUES ";

        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();
            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 20200801; i <= 20200831; i++) {
                StringBuilder sb = new StringBuilder("" + i);
                sb.insert(4, "-");
                sb.insert(7, "-");
//                String day = ("" + i)
                //时间循环
//                for(){}

                String day = sb.toString();
                // 第次提交步长

                for (int j = 0; j <= 23; j++) {
                    String hour = "";
                    if (j < 10) {
                        hour = "0" + j;
                    } else {
                        hour = "" + j;
                    }
                    for (int k = 0; k <= 59; k++) {
                        String min = "";
                        if (k < 10) {
                            min = "0" + k;
                        } else {
                            min = "" + k;
                        }


                        for (int l = 0; l < ids.length; l++) {
                            // 构建sql后缀

                            int num = (int) (59 * Math.random());//随机生成0-100的数
                            String s = "";
                            if (num < 10) {
                                s = "0" + num;
                            } else {
                                s = "" + num;
                            }

                            String date = day + " " + hour + ":" + min + ":" + s;

                            suffix.append("(" + ids[l] + ", '01', " + "'00', " + new BigDecimal(10 * k * l * Math.random()).setScale(2,
                                    BigDecimal.ROUND_HALF_UP) + " ," + "'" + date + "'" + "),");
                        }

                        k += 6;
                    }
                }

                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " s");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        initConn();
        insert();
    }


}
