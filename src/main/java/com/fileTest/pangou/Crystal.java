package com.fileTest.pangou;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.fileTest.Constant.Constant;
import com.fileTest.Entity.Person;
import com.fileTest.utils.IdcardUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.tools.javac.util.Convert;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kung
 * @date 2019-06-25 8:43
 * @Description
 */

public class Crystal {
    public static String a = "hah";
    /**
     * 集中器接收数据中文名
     */
    public static final List<String> COMMANDLISTCHINESE = Arrays.asList("心跳周期", "IP", "端口",
            "集中器地址", "月冻结日期", "网络接入点", "集中器版本号", "集中器时钟", "集中器状态", "采集器地址", "表编号");

    /**
     * 集中器接收数据中文名
     */
    public static final List<String> COMMANDLISTCODE = Arrays.asList("heartweeknum", "ip", "port",
            "collectorsaddr", "freezemonth", "netpoint", "version", "datetime", "status", "hostaddr", "meterno");

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Crystal.class);

    public static String type = "1";

    public static void main(String[] args) throws Exception {
//        System.out.println(getBetweenDates2("20200801", "20200827"));
//        returnLongWord("What if we try a super-long word such as otorhinolaryngology you know");
//        returnLongWord(" ");
//        int[] a = {1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 92, 234, 88, 27, 34, 7, 3, 967, 223, 111, 45};
////        bubbleSort(a);
//
//        selectionSort(a);
//
//
//        String[] xi = hourAgo();
//        System.out.println(Arrays.toString(xi));
//
//        maps();
//
//        caculateTotalTime("2020-01-01", "2020-04-01");
//        getBetweenDates("20191101", "20200331");
//
//
//        String sDt = "22020-04-27 12:57:47";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dt2 = sdf.parse(sDt);
////继续转换得到秒数的long型
//        long time1 = dt2.getTime();
//
//        long time2 = System.currentTimeMillis();
//        System.out.println(getDistanceTime(time1, time2));
//        String time = LocalDate.now().toString();
//        if(!getDistanceTime(time1, time2)){
//            System.out.println("走了这" + time);
//        }
//
//        testParams();
//
//        getStartAndEnd("","",LocalDate.now());

//        testBigDecimal();

//        stringToDate2("2018-11-19 19:41:33");


//        String a = "payTime=2020-07-01+14%3A01%3A43&connectSys=OPENCHANNEL&sign
// =7B59BA5911678F7E1E76FBDC385638B9B8C6C849A6DB02757B0445C8839ABEC7&merName=%E6%B5%8B%E8%AF%95%E9%80%80%E8%B4%A7555&mid=898340149000005
// &invoiceAmount=1&settleDate=2020-07-01&billFunds=%E7%8E%B0%E9%87%91%E6%94%AF%E4%BB%980.01%E5%85%83%E3%80%82&buyerId=o8wNP0XVjAcCe-1
// -nRoXdZFfVarY&mchntUuid=4aa8728a06a04f7385869df8b659cd01&tid=88880001&instMid=YUEDANDEFAULT&receiptAmount=1&targetOrderId
// =4200000608202007012285911401&signType=SHA256&orderDesc=%E6%B5%8B%E8%AF%95%E9%80%80%E8%B4%A7555&seqId=00763904862N&merOrderId
// =3194202007011401357745576977&targetSys=WXPay&UV=AIZq&totalAmount=1&createTime=2020-07-01+14%3A01%3A37&buyerPayAmount=1&notifyId
// =7edd328b-22d2-435b-be07-7a7f94c27445&subInst=000100&status=TRADE_SUCCESS";
//        stringJin(a);

//        String idcard = "532801197112130019";
//        if (IdcardUtils.validateIdCard18(idcard)) System.out.println("正确");
//
//
//        System.out.println("身份证信息： " + IdcardUtils.getProvinceByIdCard(idcard) + " " + IdcardUtils.getBirthByIdCard(idcard) + " " +
//                IdcardUtils.getGenderByIdCard(idcard));

//        doSomething();
//        stringJin("fegs");
//        tests111();

//        System.out.println(getIds("#12#+#16#+#35#"));
//        getIdss();
//        testPerson();


//        script();

//        System.out.println("loacl==" + getBetweenDays("2020-08-14", "2020-08-10"));

//        LocalDate start_date = LocalDate.parse("2020-09-01");
//        LocalDate yesterday = start_date.plusDays(-1);
//        LocalDate tomorrow = start_date.plusDays(1);
//        System.out.println("yesterday==" +yesterday + "tomorrow==" + tomorrow);

        jsonStr();
    }

    public static void a() {
//        String joStr = "{name:\"张三\",age:\"20\"}";
//        //将json字符串转化为JSONObject
//        JSONObject jsonObject = JSONObject.parseObject(joStr);
//        //通过getString("")分别取出里面的信息
//        String name = jsonObject.getString("name");
//        String age = jsonObject.getString("age");
//        //输出   张三  20
//        System.out.println(name+"  "+age);
//
//        String jaStr = "[{user:{name:\"张三\",age:\"20\"}},{score:{yuwen:\"80\",shuxue:\"90\"}}]";
//        //将jsonArray字符串转化为JSONArray
//        JSONArray jsonArray = JSONArray.parseArray(jaStr);
//        //取出数组第一个元素
//        JSONObject jUser = jsonArray.getJSONObject(0).getJSONObject("user");
//        //取出第一个元素的信息，并且转化为JSONObject
//        String name2 = jUser.getString("name");
//        String age2 = jUser.getString("age");
//        //输出  张三  20
//        System.out.println(name2+"  "+age2);
//        //取出数组第二个元素，并且转化为JSONObject
//        JSONObject jScore = jsonArray.getJSONObject(1).getJSONObject("score");
//        //取出第二个元素的信息
//        String yuwen = jScore.getString("yuwen");
//        String shuxue = jScore.getString("shuxue");
//        //输出   80  90
//        System.out.println(yuwen+"   "+shuxue);
//        List list = new ArrayList();
//        list.add("a");
//        list.add("a");
//        list.add("b");
//        try {
//            list.add("s");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        list.add("b");
//        System.out.println("list=1= " + list.size() + " ---- " + list);
//        list.remove(0);
//        System.out.println("list=2= " + list.size() + " ---- " + list);
//        list.add("b");
//        list.remove(0);
//        System.out.println("list=3= " + list.size() + " ---- " + list);
//        System.out.println("=====a========== " + a);
//        String now_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        a = "ji";
//        System.out.println("=============== " + now_time);
//        System.out.println("=====a2========== " + a);
//        a = "jis";
//        System.out.println("======a3========= " + a);
//        String a = "34";
//        String b = "op";
//        System.out.println("======a3========= " + a+b);
//        System.out.println("======a3========= " + a+","+b);
//
//        String str  = "{\"type\":\"url\",\"data\":{\"title\":\"title\",\"content\":\"content\",\"adress\":\"http://ph73rv233.bkt
// .clouddn.com/WIN_20181104_10_24_58_Pro.mp4\",\"time\":\"timr\"}}";
//
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(str);
//        StringBuffer sb = new StringBuffer();
//        String s = "\"staId\"" + ":" + "\""+ b + "\"";
//        sb.append("{");
//        sb.append(s);
//        sb.append(",");
//        sb.append("\"data\":");
//        sb.append(str);
//        sb.append("}");
//        System.out.println("======sb========= " + sb.toString());

//        System.out.println(year + " 年 " + month +  " 月 " + day + " 日");
//        String time = "12日20时-13日02时";
//        String foreDay = "";
//        if (time.indexOf("日") > 0) {
//            int pos = time.indexOf("日");
//            foreDay = time.substring(0, pos);
//        }
//        if(month == 11){
//            if(Integer.valueOf(foreDay) < day){
//
//                calendar.set(Calendar.YEAR,year+1);
//                calendar.set(Calendar.MONTH,0);
//                calendar.set(Calendar.DAY_OF_MONTH,Integer.valueOf(foreDay));
//            }
//            System.out.println("跨年 " + calendar.getTime());
//        }else {
//            if(Integer.valueOf(foreDay) < day){
//                calendar.set(Calendar.MONTH,month+1);
//                calendar.set(Calendar.DAY_OF_MONTH,Integer.valueOf(foreDay));
//            }
//            System.out.println("跨月" + calendar.getTime());
//        }
//
//        String yr = String.valueOf(calendar.get(Calendar.YEAR));
//        String mh = String.valueOf(calendar.get(Calendar.MONTH) + 1);
//        System.out.println(yr + " 年 " + mh +  " 月 " + foreDay + " 日");
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, 7);
//        String year = String.valueOf(cal.get(Calendar.YEAR));
//        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
//        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
//        if (month.length() < 2) {
//            month = "0" + month;
//        }
//        if (day.length() < 2) {
//            day = "0" + day;
//        }
//        String ymd = year + month + day;
//
//        System.out.println("7天后 —————— " + ymd);
//
//        Gson gson = new Gson();
//        String data = gson.toJson(year);
//        System.out.println("7天后 ——data———— " + data);
//
//
//        Gson gson2 = new Gson();
//        List<HeatForecastDaysHttpBean> persons = new ArrayList<HeatForecastDaysHttpBean>();
//
//        HeatForecastDaysHttpBean heatForecastDaysHttpBean = new HeatForecastDaysHttpBean();
//        heatForecastDaysHttpBean.setTime(ymd);
//        heatForecastDaysHttpBean.setTimeTwo("武清");
//        heatForecastDaysHttpBean.setType("17");
//
//        String str = gson2.toJson(heatForecastDaysHttpBean);
//        System.out.println("7天后 ——data———— " + str);
//        String str2 = str.toString().replace("time","时间");
//        String str3 = str2.toString().replace("timeTwo","地点");
//        String str4= str3.toString().replace("type","类型");
//        String str5 = str4.toString().replace("name","姓名");
//        System.out.println("7天str4后 ——dastr4ta———— " + str5);
        Date s = new Date();
        String ss = DateFormatUtils.format(s, "yyyy-MM-dd HH:mm:ss");
        System.out.println("ss ——ss———— " + ss);
//
//        List<String> list = Arrays.asList("2","2","34");
//        for(int k = 0; k < list.size(); k++){
//            System.out.println("———— " + list.get(k));
//        }

//        commandParamDecode("[{\"hostaddr\":\"000000000041\"},{\"hostaddr\":\"0000000000A8\"}]");


        String str = "哈哈哈";
        System.out.println("字符串为: " + str.replace("\"", ""));

        float java = 200.43f;
        System.out.println("吨数: " + java / 1000);

        String freezedayDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        System.out.println("今天日期: " + freezedayDate);

        float num = 0f;
        float num2 = (float) (Math.round(num / 1000 * 1000)) / 1000;  //100指的是要保留的小数位数
        System.out.println(num2);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal_1 = Calendar.getInstance();
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = format.format(cal_1.getTime());

        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = format.format(cale.getTime());

        System.out.println("firstDay = " + firstDay + "  " + "lastDay = " + lastDay);


        SimpleDateFormat format5 = new SimpleDateFormat("yyyy-MM");
        Calendar cal_5 = Calendar.getInstance();
        cal_5.add(Calendar.MONTH, -2);
        String lastMonth = format5.format(cal_5.getTime());

        //上月日期
        SimpleDateFormat format6 = new SimpleDateFormat("yyyy-MM");
        Calendar cal_6 = Calendar.getInstance();
        cal_6.add(Calendar.MONTH, -1);
        String lastMonth2 = format6.format(cal_6.getTime());

        System.out.println("lastMonth = " + lastMonth + "  " + "lastMonth2 = " + lastMonth2);

        Constant.CODE_TIMEOUT = 2;

        anc(3);

        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        String tDay = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        System.out.println("tDay " + tDay);
    }


    public static String commandParamDecode(String commandParam) {
        String commandParams = commandParam;
        for (int i = 0; i < COMMANDLISTCODE.size(); i++) {
            commandParams = commandParams.replace(COMMANDLISTCODE.get(i), COMMANDLISTCHINESE.get(i));
        }
        System.out.println("commandParams== " + commandParams);
        return commandParams;

    }

    public static int anc(int a) {
        System.out.println("aa = " + a);

        Person person = new Person();
        person.setName("");

        System.out.println(person.toString());
        return a;
    }

    public static void returnLongWord(String str) {
        String longWord = "";
        String temp = "";
        if (StringUtils.isEmpty(str) || StringUtils.isBlank(str)) {
            System.out.println("请输入英文句子");
            return;
        }
        String[] array = str.split(" ");

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].length() > array[i + 1].length()) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        longWord = array[array.length - 1];
        System.out.println("最长单词: " + longWord + " ,长度为: " + longWord.length());
    }

    public static void bubbleSort(int[] array) {
        int length = array.length;
        int temp = 0;
        long strt = System.currentTimeMillis();
        System.out.println(strt + "ms");
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end + "ms");
        System.out.println("用时: " + (end - strt) + "ms");
        System.out.println("重排后的数组为: " + Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        int length = array.length;
        int temp = 0;
        long strt = System.currentTimeMillis();
        System.out.println(strt + "ms");
        //选择排序的优化
        for (int i = 0; i < length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < length; j++) {// 选最小的记录
                if (array[j] < array[k]) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end + "ms");
        System.out.println("用时: " + (end - strt) + "ms");
        System.out.println("选择排序后的数组为: " + Arrays.toString(array));

        int a = 0;
        int b = 0;
        for (int i = 0; i < 5; i++) {
            if (i > 2) a += i;
            else b += i;
        }
        System.out.println("a= " + a + " " + "b= " + b);
    }


    public static String[] hourAgo() throws Exception {
        String[] times = new String[2];
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        String time = df.format(calendar.getTime());
        times[0] = time.substring(0, 8);
        times[1] = time.substring(8, 10);
        System.out.println(df.format(new Date()));


        String sePort = "02";
        //设备编号 = 7位网关ID(高位补零) + 2位串口(01 02 03 04 05 06) + 3位设备地址(高位补零1-255)
        String gatewayId = String.format("%7d", 2).replace(" ", "0");
        String devAddr = String.format("%3d", 23).replace(" ", "0");
        System.out.println("设备编号: " + gatewayId + sePort + devAddr);


        Calendar begin = Calendar.getInstance();
        begin.setTime(new Date());//给定起始时间
//比如100小时
        System.out.println("时间起始: " + df.format(begin.getTime()));
        for (int i = 0; i < 24; i++) {
//执行你的操作
            begin.add(Calendar.HOUR, -1);//增加了一小时
            System.out.println("时间: " + df.format(begin.getTime()));
        }
        String regularExpression = "(([1-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))";
        boolean matches = "33".matches(regularExpression);
        if (!matches) {
            System.out.println("设备地址不符合要求应为1-255数字  添加失败");
        } else {
            System.out.println("符合标准");
        }
        String re2 = "^[1-9]\\d+([+-]\\d+)+$";
        String re3 = "[+\\-]";
        boolean matches2 = "2677-3490+3435".matches(re2);
        if (matches2) {
            System.out.println("设备地址不符合要求应为1-255数字  添加失败" + matches2);
        } else {
            System.out.println("符合标准" + matches2);
        }

        String[] add = "2677-3490+3435".split("[\\+,-]");
        System.out.println(add[2]);

        return times;
    }

    public static void maps() {
        Integer id = 2;
        String devId = "23";
        try {

            ConcurrentMap<String, String> idsCache = new ConcurrentHashMap<>();
            idsCache.put(id + "&" + devId + "&" + "20200401" + "&" + "1", "23.45");
            idsCache.put(id + "&" + 233 + "&" + "20200401" + "&" + "1", "23.45");
            System.out.println("map:" + idsCache.toString());

            List list = new ArrayList();
            if (list == null || list.size() <= 0) System.out.println("无数据" + list.size());


            if (idsCache.containsKey("2" + "&" + 23 + "&" + "20200401" + "&" + "1")) System.out.println("保护");
            Iterator<String> iter = idsCache.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                String value = idsCache.get(key);
                System.out.println(key + " " + value);
                if (key.indexOf("&" + 23 + "&") != -1) {
                    //"只要test.indexOf('This')返回的值不是-1说明test字符串中包含字符串'This',相反如果包含返回的值必定是-1"
                    System.out.println("存在包含关系，因为返回的值不等于-1" + key);
                }
                String[] strings = key.split("&");
                System.out.println("==" + strings[1]);
            }

            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> map1 = new HashMap<>();
            map.put(1, 2);
            map.put(4, 7);
            map.put(2, 0);
            map1.put(2, 23);
            int a = map.get(1);
            int b = map1.get(a);
            System.out.println("Interger" + a + " int " + b);

            System.out.println("IntergerIntergerIntergerIntergerInterger" + map.get(87));

            Integer an = 4;
            int bn = 4;
            if (an == bn) System.out.println("Integer=int?");
            Set<Integer> keys = map.keySet();
            System.out.println("keys" + keys);

            Iterator it = keys.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }


            idsCache = null;

            System.out.println("map:" + idsCache.toString() + idsCache.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("map:异常");
        }
        System.out.println("这还走了?" + devId);
    }

    public static int caculateTotalTime(String startTime, String endTime) throws ScriptException {

        double d = 114.14 / 30;
        BigDecimal b = new BigDecimal(d);
        d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);

        String a = "2.1";
        System.out.println(Double.valueOf(a));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 = formatter.parse(endTime);
            long ts1 = date1.getTime();

            l = (ts1 - ts) / (1000 * 60 * 60 * 24) + 1;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("时间天数: " + l.intValue());


        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

        String strs = "a1+b4-c-d2";
        String[] args = new String[]{"3.78", "3.663", "19.54", "23.353"};

        String[] devNo = strs.split("[\\+,-]"); //公式中的设备编号

        //遍历设备数组 得出公式结果
        for (int i = 0; i < devNo.length; i++) {
//            System.out.println(jse.eval(strs));
//            if(i == 1) continue;
            strs = strs.replaceAll(devNo[i], args[i]);
            System.out.println(i + devNo[i]);
        }
        System.out.println("jisaun22222 :" + strs);
        Object ha = jse.eval(strs);
        System.out.println("jisaun :" + Double.valueOf("" + ha));

        String strs2 = "312203+203001-302305-412204";
        String[] devNo2 = strs2.split("[\\+,-]"); //公式中的设备编号
        Arrays.sort(devNo2);
        System.out.println(Arrays.toString(devNo2));
        List<String> formulaList = new ArrayList<>();
        String newFormula = "";
        for (int i = 0; i < devNo2.length; i++) {
            System.out.println("值 " + strs2.indexOf(devNo2[i]) + "结束 " + devNo2[i].length());
            if (strs2.indexOf(devNo2[i]) == 0) {
                newFormula += "+" + devNo2[i];
            } else {
                newFormula += strs2.substring(strs2.indexOf(devNo2[i]) - 1, strs2.indexOf(devNo2[i]) + devNo2[i].length());
            }
            formulaList.add(devNo2[i]);
        }

        System.out.println("新公式= " + newFormula + formulaList);
        if (formulaList.contains("412204")) System.out.println("包含");

        if (Double.valueOf("" + ha) < 0) System.out.println("公式结果不能为负值公式" + strs + "异常");

        System.out.println(Double.valueOf("2.534"));


        String[] arg = new String[]{"02", "03", "05"};
        List list = new ArrayList();
        list.add("02");
        list.add("03");
        list.add("06");
        boolean result = false;
        //第一种：List
        result = Arrays.asList(arg).contains("02");
        if (Arrays.asList(arg).contains("02") && !Arrays.asList(arg).contains("05")) {
            System.out.println("对了");
        } else if (list.contains("02") && !list.contains("05")) {
            System.out.println("对了" + 1 + "&" + "23" + "&" + "20200331");
            type = "2";
            System.out.println("type= " + type);
        }

        double DayQty = 3.44;
        double energyConvers = 2.34;
        double qtyEng = 23.24;
        double qtyTime = 1;
        System.out.println("计算结果: " + new BigDecimal(Double.toString(DayQty * energyConvers + qtyEng + qtyTime * energyConvers))
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(energyConvers + qtyEng);
        return l.intValue();
    }

    /*
     *计算time2减去time1的差值 差值只设置 几天 几个小时 或 几分钟
     * 根据差值返回多长之间前或多长时间后
     * */
    public static boolean getDistanceTime(long time1, long time2) throws ParseException {

        boolean check = true;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff;

        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//        if (day != 0) return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
//        if (hour != 0) return hour + "小时" + min + "分钟" + sec + "秒";
//        if (min != 0) return min + "分钟" + sec + "秒";
//        if (sec != 0) return sec + "秒";

        if (day != 0) check = false;
        if (hour != 0 && hour > 21) check = false;
//        if (min != 0) return min + "分钟" + sec + "秒";
//        if (sec != 0) return sec + "秒";


        return check;
    }

    public static List<String> getBetweenDates(String start, String end) {

        List<String> result = new ArrayList<String>();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            Date start_date = sdf.parse(start);

            Date end_date = sdf.parse(end);

            Calendar tempStart = Calendar.getInstance();

            tempStart.setTime(start_date);

            Calendar tempEnd = Calendar.getInstance();

            tempEnd.setTime(end_date);

            while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {

                result.add(sdf.format(tempStart.getTime()));

                tempStart.add(Calendar.DAY_OF_YEAR, 1);

            }

        } catch (ParseException e) {

            e.printStackTrace();

        }

        Collections.sort(result);
//        Collections.reverse(result);
        System.out.println("list" + result);

        String allSupe = "0,1,9,10,15,";
        String[] ids = allSupe.split(",");
        System.out.println("长度 ：" + ids.length);

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("a", 4);
        System.out.println("key: " + getKey(map, 2));

        String str = "";
        String[] strings = str.split(",");
        System.out.println("str长度: " + strings.length);

        return result;
    }


    private static String getKey(Map<String, Integer> map, Object value) {

        String key = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("count: " + entry.getKey());
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
                continue;
            }
        }

        Map<String, String> map1 = new HashMap();
        map1.put("1", "总");
        map1.put("2", "分");
        map1.put("11", "分2");
        map1.put("16", "分3");
        String aaa = "1,2,11,16";
        String nnn = "";
        String[] strings = aaa.replace("", "").replace("，", ",").split(",");
        String chineseNm = aaa.replace(",", "-");
        for (int i = 0; i < strings.length; i++) {
            chineseNm = chineseNm.replaceFirst(strings[i], map1.get(strings[i]));
            nnn += map1.get(strings[i]) + ",";
            strings[i] = map1.get(strings[i]);
        }
        System.out.println(chineseNm + "     " + nnn + Arrays.asList(strings));


        List a = new ArrayList();
        List b = new ArrayList();
        List c = new ArrayList();

        List d = new ArrayList();

        a.add("1");
        a.add("2");
        a.add("3");
        b.add("12");
        b.add("13");
        c.add("14");

        d.add(a);
        d.add(b);
        d.add(c);
        String ids = StringUtils.join(d, ",");

        System.out.println("dddd= " + ids.replace("[", "").replace("]", "").replace(" ", ""));
        return key;
    }

    public static void testParams() {
        Integer a = null;
        String b = "";
//        String str = doSomething(a,b);

        String firstDayOf2015 = LocalDate.now().plusDays(-1).toString().replace("-", "");
        String firstDayOf = LocalDate.now().minusMonths(1).toString().replace("-", "").substring(0, 6);
        System.out.println("======值=====" + firstDayOf2015 + "====" + firstDayOf);
        String l = "";

        Person p = new Person();
        p.setName(l);
        System.out.println(p.getName());

        String valvestatus = null;
        String tapstatus = "1";
        if (StringUtils.isNotEmpty(tapstatus)) {
            valvestatus = "1".equals(tapstatus) ? "1" : "2".equals(tapstatus) ? "2" : "3";
        }
        System.out.println("=========== 阀门 ======= " + valvestatus);
    }

    public static void doSomething() {

        String str = "sssasgasg34";
        boolean matches = str.matches("[A-Za-z0-9]*");
        if (!matches) System.out.println("表格数据第" + "行, "
                + "网关编号 " + " 长度必须在15-16位 ;");

    }

    public static String[] getStartAndEnd(String startTime, String endTime, LocalDate localDate) {
        String[] ret = new String[2];
        if (startTime == null) startTime = "11-01";
        if (endTime == null) endTime = "03-31";
        String[] startDate = startTime.split("-");
        String[] endDate = endTime.split("-");
        if (startDate == null || startDate.length != 2) {
            startTime = "11-01";
        }
        if (endDate == null || endDate.length != 2) {
            endTime = "03-31";
        }

        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int curMonth = cal.get(Calendar.MONTH) + 1;
        int curDay = cal.get(Calendar.DAY_OF_MONTH);


        System.out.println("year : " + year + " month : " + curMonth + " day : " + curDay);

        String month = String.valueOf(curMonth);
        String day = String.valueOf(curDay);
        if (month.length() < 2) {
            month = "0" + month;
        }
        if (day.length() < 2) {
            day = "0" + day;
        }
        String curTime = month + day;

        startTime = startTime.replace("-", "");
        endTime = endTime.replace("-", "");
        if (startTime.compareTo(endTime) >= 0) {
            // 跨年
            if (startTime.compareTo(curTime) > 0) {
                // 现在时间小于开始时间，需要和结束时间比
                ret[0] = (year - 1) + startTime;
                ret[1] = year + endTime;
            } else {
                // 现在时间大于开始时间
                ret[0] = year + startTime;
                ret[1] = (year + 1) + endTime;
            }
        } else {
            // 不跨年
            if (startTime.compareTo(curTime) > 0) {
                ret[0] = (year - 1) + startTime;
                ret[1] = (year - 1) + endTime;
            } else {
                ret[0] = year + startTime;
                ret[1] = year + endTime;
            }
        }
        System.out.println(Arrays.asList(ret));

        String dates = localDate.toString().replace("-", "");
        if ((dates.compareTo(ret[0]) > 0 && dates.compareTo(ret[1]) < 0) || dates.compareTo(ret[0]) == 0 || dates.compareTo
                (ret[1]) == 0) {
            System.out.println("在");
        } else {
            System.out.println("不在");
        }


        return ret;
    }

    public static void testBigDecimal() {
        String dayQty = new BigDecimal("0").add(
                new BigDecimal("0")).add(
                new BigDecimal("0")).add(
                new BigDecimal("10")).add(
                new BigDecimal("4")).add(
                new BigDecimal("4"))
                .setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        System.out.println("日用量计算结果为: " + dayQty);

        int b = 1;
        String a = "" + (b + 1);
        System.out.println("a====: " + a);
        String c = null;

        Map<String, String> map = new HashMap<>();
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");

        Collection<String> values = map.values();
        values.remove(String.valueOf("二"));

        map.remove("");

        System.out.println(map);

        String mm = "";
        if (StringUtils.isEmpty(mm)) System.out.println("空");
        String nn = null;
        if (StringUtils.isEmpty(nn)) System.out.println("空空");

        String theDayBeforeNow = LocalDate.now().plusDays(-1).toString().replace("-", "");
        System.out.println("====theDayBeforeNow===" + theDayBeforeNow);
    }

    public static Date stringToDate2(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(time);
    }


    public static void stringJin(String a) {
//        if (StringUtils.isNotEmpty(a)) {
//            String[] strings = a.replace("=", ":").split("&");
//            System.out.println(Arrays.asList(strings));
//
//            JSONArray array = JSONArray.parseArray(JSON.toJSONString(Arrays.asList(strings)));
//            System.out.println(array);
//            System.out.println(array.getString(array.size() - 1));
//        }
//
//        List list = new ArrayList();
//        for (int i = 0; i < 6; i++) {
//            if (i / 2 == 0) {
//                list.add("2");
//            } else {
//                list.add("1");
//            }
//        }
//        System.out.println(list);

        String ad = "2+454+54*454";

        String regularExpression = "(^[1-9]+)+(|[+-\\\\*\\\\/]\\d+)+$";
        boolean matches = ad.matches(regularExpression);
        if (!matches) {
            System.out.println("表格数据第" + "设备地址不符合要求应为1-255数字  添加失败；");
        } else {
            System.out.println("通过");
        }

        String asd = "12+13-133*124/54+13";
        String as = "0.8*#12#+#17#+0.4*(#12#+#122#);0.8*#1014#+#144#+0.4*(#140#+#108#);";
        System.out.println("asd" + asd.replace("13", "00"));
        String[] params = asd.split("[\\+,-]");
        System.out.println(Arrays.asList(params));
        List ids = new ArrayList();
        Pattern p = Pattern.compile("#(\\w+)#");
        Matcher m = p.matcher("0.8*#12#+#17#+0.4*(#12#+#122#);0.8*#1014#+#144#+0.4*(#140#+#108#);");
        while (m.find()) {
            ids.add(m.group(1));
//            System.out.println(m.group(1));
        }
//        System.out.println(ids.get(1));
        System.out.println(ids);


//        if(list.size() >0) return;
//        String str = "1022，1023，1024，1025";
//        String s2 = str.replaceAll("，", ",");
//        System.out.println(str + " ===== " + s2);
//
//        LocalDate localDate=LocalDate.now();
//        //指定时间，注意，如果使用下面的这种获取方式，一定要注意必须为严格的yy-mm-dd,9月必须为09,1号必须为01，否则会报错
//        LocalDate day = localDate.plusDays(-1);
//        System.out.println("day = " + day.toString().replace("-", ""));

    }


    public static void tests111() {

//        String reg = "[!$^&*|bai{}';'\\\",<>/?~！￥%……du&*——|{}【】‘；：”“'。，、？]";
        String reg2dd = "`~!@#$%^&*()+=%";
//        boolean matches = reg2dd.matches(reg);
//        if (matches) {
//            System.out.println("公式中" + reg2dd + "中，公式格式不正确,只能是数字与运算符号+-*/组合;");
//        } else {
//            System.out.println("通过了啦啦啦啦");
//        }

        String regs = "[\"'<>《》,，?？@\\$%\\^&_a-zA-Z~`\\[\\]\\{\\}.;；（）\\u4e00-\\u9fa5]+?";

        Pattern pattern = Pattern.compile(regs);

        String testStr = "#3#+#34#<>?？";

        Matcher matcher = pattern.matcher(testStr);


        while (matcher.find()) {
            System.out.println("**** " + matcher.group(0));
        }

        boolean matches = reg2dd.matches(regs);
        if (matches) {
            System.out.println("公式中" + testStr + "中，公式格式不正确,只能是数字与运算符号+-*/组合;");
        } else {
            System.out.println("通过了啦啦啦啦");
        }


        String str = "-2+3+54+41+13-454+451+113+5234+4421-365+5534-4+46561+366+5564+431";
        Map<String, String> map = new HashMap();
        map.put("2", "10.34");
        map.put("3", "5.31");
        map.put("41", "16.54");

        String[] params = str.split("[\\+,\\-,\\*,\\/]");
        String[] params2 = str.split("[\\d]+");
        String str2 = "";
        System.out.println("开始： " + Arrays.asList(params) + "   " + params.length);
        System.out.println("开始： " + Arrays.asList(params2) + "  " + params2.length);
//        for (int i = 0; i < params.length; i++) {
//            if (map.containsKey(params[i]) && StringUtils.isNotEmpty(map.get(params[i]))) {
//                params[i] = map.get(params[i]);
//            } else {
//                params[i] = "0.0";
//            }
//            if (i != params.length - 1) {
//                str2 += params[i] + params2[i + 1];
//            } else {
//                str2 += params[i];
//            }
//
//        }
        System.out.println("结束： " + Arrays.asList(params));
        System.out.println("结束： " + str.replaceAll("[\\d]+", "#" + "" + "#"));
        System.out.println("结束： " + str2);
    }

    public static List<String> getIds(String str) {
        List ids = new ArrayList();
        List ids2 = new ArrayList();
        Pattern p = Pattern.compile("#(\\w+)#");
        Pattern p2 = Pattern.compile("#(\\w+)");
        Matcher m = p.matcher(str);
        Matcher m2 = p2.matcher(str);
        while (m.find()) {
            ids.add(m.group(1));
        }
        while (m2.find()) {
            ids2.add(m2.group(0));
        }
        System.out.println("------ " + ids2);
        if (ids.size() != ids2.size()) ids = null;
        return ids;
    }


    public static void getIdss() {
        String str = "1232141";
        String str2 = "ww";
        Map<String, String> m = new HashMap();
        m.put("1", "21");
        for (int i = 0; i < 5; i++) {
            if (StringUtils.isNotEmpty(str)) {

                for (int j = 0; j < 5; j++) {
                    if (m.containsKey("2")) {
                        System.out.println("包含");
                    } else {
                        System.out.println(str);
                        break;
                    }
                }
            }
            if (StringUtils.isNotEmpty(str2)) {
                System.out.println("lail ");
            }

            System.out.println(i);
        }

        Double a = 23.45;
        Double b = 24.45;
        String qty = new BigDecimal(a).add(new BigDecimal(b)).setScale(2, BigDecimal
                .ROUND_HALF_UP).toString();
        System.out.println(qty);


    }

    public static void testPerson() throws ParseException {

        Map<String, Person> map = new HashMap<>();

        Person person = new Person();
        List<Person> list = new ArrayList<>();
        person.setName("hhh");
        person.setId("2");

        person.setPlatcode("0");


        for (int i = 1; i < 5; i++) {
            Person persons = new Person();
            persons.setName("h1");
            persons.setId("" + i);
            if (i < 3) {
                persons.setQty("0");
                persons.setPlatcode("" + (i - 1));
            } else {
                persons.setQty("2");
                persons.setPlatcode("" + 2);
            }


            list.add(persons);
            map.put("" + i, persons);
        }

        for (int k = 1; k < 5; k++) {


//            if (map.containsKey("" + (k - 1)))
//                map.get("" + (k - 1)).setQty(new BigDecimal(map.get("" + (k)).getQty()).add(new BigDecimal(map.get("" + (k - 1)).getQty
// ()))
//                        .toString());
            mapsssss(map, k);
        }

        person.setRel(list);

        System.out.println(person.toString() + "=== " + new Gson().toJson(person) + "===\n" + map);

//        String s = "2020-09-13";
//        Timestamp time = Timestamp.valueOf(s);
//        System.out.println("时间+ ====" + time.toString());


        String string = "20160424";
        StringBuilder sb = new StringBuilder(string);
        sb.insert(4, "-");
        sb.insert(7, "-");
        System.out.println("----------" + sb.toString());

        int i = (int) (59 * Math.random());//随机生成0-100的数
        String s = "";
        if (i < 10) {
            s = "0" + i;
        } else {
            s = "" + i;
        }
        System.out.println("随机数为" + s);

    }

    private static void mapsssss(Map<String, Person> map, int k) {
        if (map.containsKey("" + (k - 1))) {
            map.get("" + (k - 1)).setQty(new BigDecimal(map.get("" + (k)).getQty()).add(new BigDecimal(map.get("" + (k - 1)).getQty()))
                    .toString());
            if (k - 1 > 0)
                mapsssss(map, k - 1);
        }

    }

    public static void script() throws ScriptException {
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        String k = jse.eval("1.12" + "+" + "0.14").toString();
        System.out.println(new BigDecimal(k).setScale(2, BigDecimal
                .ROUND_HALF_UP).toString());

//        System.out.println(k);
    }


    public static List<String> getBetweenDays(String start, String end) {
        List<String> totalDates = new ArrayList<>();
        String s = "2019-12-21";
        String e = "2020-01-10";
        LocalDate start_date = LocalDate.parse(start);
        LocalDate end_date = LocalDate.parse(end);

        while (!start_date.isAfter(end_date)) {
            totalDates.add(start_date.toString().replace("-",""));
            start_date = start_date.plusDays(1);
        }
        return totalDates;
    }



    public static List<String> getBetweenDates2(String start, String end) {

        List<String> result = new ArrayList<String>();
        try {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date start_date = sdf.parse(start);
            Date end_date = sdf.parse(end);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start_date);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end_date);

            while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
                result.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collections.sort(result);
//        Collections.reverse(result);
//        System.out.println("list" + result);
        return result;
    }

    public static void jsonStr(){
        Gson gson = new Gson();
//        List<HeatForecastDaysHttpBean> persons = new ArrayList<HeatForecastDaysHttpBean>();
//
//        HeatForecastDaysHttpBean heatForecastDaysHttpBean = new HeatForecastDaysHttpBean();
//        heatForecastDaysHttpBean.setTime(ymd);
//        heatForecastDaysHttpBean.setTimeTwo("武清");
//        heatForecastDaysHttpBean.setType("17");
//
//        String str = gson2.toJson(heatForecastDaysHttpBean);
        HeatForecastDaysHttpBean heatForecastDaysHttpBean = new HeatForecastDaysHttpBean();
        heatForecastDaysHttpBean.setTime("2020-09-29");
        heatForecastDaysHttpBean.setTimeTwo("武清");
        heatForecastDaysHttpBean.setType("17");
        String str = gson.toJson(heatForecastDaysHttpBean);
        System.out.println("==: " + str);
    }

}
