package com.fileTest.pangou;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

/**
 * @author kung
 * @date 2021-01-08 10:41
 * @Description
 */
public class KnowleageUnitInsert {
    static Connection conn = null;

    public static String code_pre = "CHT";

//    public static String[] entyrs = {
//            "北京市", "金", "考古发掘报告", "遗址的遗迹", "北京市文物研究所", "古墓葬", "墓葬",
//            "帝王陵墓", "陵墓", "皇陵", "陵寝", "遗址的遗迹", "金太祖睿陵", "金太宗恭陵", "金德宗顺陵",
//            "金世宗兴陵", "金睿宗景陵", "古建筑", "建筑形制", "金陵主陵区", "平面布局", "遗迹", "石桥",
//            "神道", "台址", "东侧大殿遗址", "西侧大殿遗址", "建筑遗址", "陵墙", "排水系统", "明代关帝庙遗址",
//            "清代小宝顶遗址", "清代大宝顶遗址", "清代棂星门遗址", "琉璃器", "器物图", "琉璃鸱吻",
//            "葬具", "木器", "木棺", "木材", "树种鉴定报告", "土壤鉴定报告", "铜器", "器物图", "铜饰件",
//            "盗洞", "台址", "月台", "器物图", "瓦当", "滴水", "釉套兽", "剑把构件", "铜饰件", "铜饰件把手",
//            "火焰纹铜", "铜门钉", "铜门钹", "建筑布局", "建筑形制", "遗迹平剖面（侧视）图", "玉锁", "镞",
//            "迦陵频伽", "鸱吻", "垂脊兽", "栏板", "鸟", "筒瓦", "勾头瓦", "木棺", "遗迹分布图", "享殿", "碑亭",
//            "石器", "纹饰图", "石台阶", "缠枝花", "发掘区/探方分布图", "西汉铜钱", "唐代铜钱", "五代十国铜钱",
//            "北宋铜钱", "南宋铜钱", "金代铜钱", "生产工具", "生活用具", "兵器", "金相学分析"
//    };

    public static String[] entyrs = {
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥钱币￥遗物登记表",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥气候、地理与环境￥遗址地理位置图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥遗迹分布图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥探方￥发掘区/探方分布图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥地层￥遗址地层图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥石桥",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥排水沟￥沟",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥石器￥纹饰图￥石台阶￥缠枝花纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗址平面图￥台址",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗址平面图￥台址",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗址平面图￥台址",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥神道",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥神道柱平",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥石踏道",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥石器￥纹饰图￥双龙图￥石栏板",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥石器￥纹饰图￥石栏板￥缠枝花纹",
            "北京￥清￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥建筑形制￥遗迹平剖面（侧视）图",
            "北京￥清￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥建筑形制￥遗迹分布图￥享殿￥碑亭",
            "北京￥清￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥建筑形制￥遗址平面图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗址平面图￥地宫",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥随葬品￥玉器￥器物图￥饰件￥",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁椁盖￥凤纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁￥凤纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥木棺",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥随葬品￥纹饰图￥木棺￥錾刻菱形纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥石椁",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁椁盖￥龙纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁￥龙纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁￥龙纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥纹饰图￥石椁￥龙纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗址平面图",
            "北京￥清￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗址平面图￥享殿￥碑亭",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗址平面图￥墓道",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥纹饰图￥墓门",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥葬具￥随葬品￥器物图￥铜首铁剑￥石器￥石枕",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥瓷器￥器物图￥白釉褐彩钵",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥瓷器￥器物图￥石笔洗",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石器￥器物图￥台阶条石",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥陶迦陵频伽头",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥农具￥手工工具￥器物图￥随葬品￥帽钉￥铁器",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥随葬品￥钱币￥西汉铜钱￥唐代铜钱￥五代十国铜钱￥北宋铜钱￥南宋铜钱￥金代铜钱￥",
            "北京市￥金￥考古发掘报告￥科技考古￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥金陵地质￥雷达探测报告",
            "北京市￥金￥考古发掘报告￥遗址的遗迹￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥陵寝￥遗址的遗迹￥金太祖睿陵￥金太宗恭陵￥金德宗顺陵￥金世宗兴陵￥金睿宗景陵￥",
            "北京市￥金￥考古发掘报告￥气候、地理与环境￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥金陵的气候环境￥水文调查报告",
            "北京市￥金￥考古发掘报告￥气候、地理与环境￥历史沿革￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥地理环境￥历史沿革￥发现￥工作概况",
            "北京市￥清￥考古发掘报告￥遗址的遗迹￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥遗迹￥北京房山金陵￥清代遗迹考略",
            "北京市￥金￥考古发掘报告￥地层￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥探方￥探方分布￥地层堆积",
            "北京市￥金￥考古发掘报告￥科技考古￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥东区地质￥地质雷达探测报告",
            "北京市￥金￥考古发掘报告￥可移动文物￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥饰品￥纺织品￥金陵凤棺",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥玉器￥器物图￥饰件￥鸟纹",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥墓主人的考证￥金太祖完颜阿骨打陵￥金太宗完颜吴乞买陵￥金德宗完颜宗干陵￥金睿宗完颜宗尧陵￥金世宗完颜雍陵￥",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥玉器￥器物图￥饰件",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石质构件￥琉璃构件￥陶质构件",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗迹平剖面（侧视）图￥木柱洞",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗址平面图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥复原图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图￥灶",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥建筑布局￥遗迹平剖面（侧视）图",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑形制￥遗迹平剖面（侧视）图",
            "北京￥明￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑布局￥遗址平面图￥关帝庙",
            "北京市￥金￥考古发掘报告￥可移动文物￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥饰品￥纺织品￥金陵凤棺",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥农具￥手工工具￥器物图￥随葬品￥叉￥铁器",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥脊兽",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥琉璃器￥圆眼勾头瓦",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥武士俑",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥琉璃器￥器物图￥妙音鸟",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥农具￥手工工具￥器物图￥随葬品￥耘锄￥铁器",
            "北京市￥金￥考古发掘报告￥历史沿革￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥历史与沿革",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥葬具￥木器￥木棺￥木材￥树种鉴定报告￥土壤鉴定报告",
            "北京市￥金￥考古发掘报告￥序￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥序",
            "北京市￥金￥考古发掘报告￥前言￥气候、地理与环境￥历史沿革￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥前言",
            "北京市￥金￥考古发掘报告￥遗址的遗迹￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥古建筑￥建筑形制￥金陵主陵区￥平面布局￥遗迹￥石桥￥神道￥台址￥东侧大殿遗址￥西侧大殿遗址￥建筑遗址￥陵墙￥排水系统￥明代关帝庙遗址￥清代小宝顶遗址￥清代大宝顶遗址￥清代棂星门遗址￥",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥随葬品￥铜器￥瓷器￥石器￥生活用品",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥器物图￥金器￥金丝花饰",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥器物图￥金器￥金丝帽盛子",
            "北京￥清￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥小宝顶",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥墙",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥兵器￥器物图￥矛￥铁器",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥农具￥手工工具￥器物图￥随葬品￥剁斧￥铁器",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥瓦当",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥瓦件",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥陶器￥装饰砖",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥器物图￥琉璃器￥滴水",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥纹饰图￥青石踏道￥缠枝花纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥栏板￥纹饰图￥牡丹纹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥壁画",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥慢坡",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥石器￥器物图￥石坐龙",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥房山金陵￥诸陵考￥十帝陵￥坤厚陵￥诸王兆域",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥中都金陵考",
            "北京市￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥显宗裕陵￥章宗道陵",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石器￥器物图￥柱础",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石器￥器物图￥龙头螭首",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石器￥器物图￥望柱",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥石器￥器物图￥鸱吻",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥瓷器￥器物图￥黑釉双耳罐",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥瓷器￥器物图￥白釉盘",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗物￥随葬品￥瓷器￥器物图￥瓷碗",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥随葬品￥瓷器￥石器￥器物图￥盘￥盏￥碟￥钵￥罐￥笔洗￥石杵",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥琉璃器￥随葬品￥器物图￥瓦当￥滴水￥釉套兽￥剑把构件",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥建筑构件￥随葬品￥陶器￥玉器￥器物图￥瓦当￥武士俑￥谥册",
            "北京￥金￥考古发掘报告￥北京市文物研究所￥古墓葬￥墓葬￥帝王陵墓￥陵墓￥皇陵￥遗址的遗迹￥烟囱￥炕面"

    };

    public static void initConn() throws ClassNotFoundException, SQLException {

        String sql;
        String url = "jdbc:mysql://localhost:3306/zsdy?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";

        String username = "root";
        String password = "123456";
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

    public static void insert() {
        // 开时时间
        Long begin = new Date().getTime();
        Random df = new Random();

//引用nextInt()方法

        // sql前缀
        String prefix = "INSERT INTO knowledge_unit (unit_name,number,front_title, back_title," +
                "original_title,remark,unit_type,author,number_page,quotation," +
                "ass_number,column_name,product_label,entry,img_url" +
                ") VALUES ";

        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 200; i++) {
                for (int j = 1; j <= 10000; j++) {
                    String code = code_pre + String.valueOf(i) + String.format("%012d", j);
                    int number = df.nextInt(105);
                    suffix.append("(" + "'" + code + ".jpg'," + "'" + code + "'," + "'北京金代皇陵F8台基下的台阶" + code + "'," + "'图版八-004 " +
                            "北京金代皇陵F1东北角柱础" + code + "'," +
                            "'图版八-004 F1东北角柱础" + code + "'," + "'北京金代皇陵F1东北角柱础','图片-图版(jpg)'," + "''," +
                            "'1', '', 'CH000009A00005','','文物考古资源库￥宋元考古￥不可移动文物数据库￥中国古代墓葬￥中国古代帝陵￥学术图片库￥墓葬图片库'," +
                            "'" + entyrs[number] + "'" + "," + "''" + "),");
                }

                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
//                System.out.println("sql : " + sql);
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
//        System.out.println(entyrs.length);
    }

}


