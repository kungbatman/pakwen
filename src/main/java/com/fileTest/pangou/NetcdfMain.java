package com.fileTest.pangou;

import org.slf4j.LoggerFactory;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;
import ucar.nc2.dataset.NetcdfDataset;

import java.io.IOException;

/**
 * @author kung
 * @date 2019-08-30 10:59
 * @Description
 */
public class NetcdfMain {
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NetcdfMain.class);
    public static void main(String[] args){
        aa();
//        theStarinNightSky();
    }

    public static void aa() {
        // read完copyToNDJavaArray，这个读出来是几维转的就是几维，直接转相应几维java数组就好。
        try {
            NetcdfFile ncfile = null;
            ncfile = NetcdfDataset.open("F:\\meteorheat\\GRID_TJQX_PUB_TMP_AFTJ_000_DT_20190829080000_072-240_801.nc");
            // 存经纬度
            String var1 = "lon";// 此处严格区分大小写，不然找不到，不知道有什么变量的可以断点debug一下，鼠标移到上面ncfile那行看
            String var2 = "lat";
            String var3 = "TMP";
            String var4 = "time";
            Variable v1 = ncfile.findVariable(var1);
            Variable v2 = ncfile.findVariable(var2);
            Variable v4 = ncfile.findVariable(var4);
//            Variable v3 = ncfile.findVariable(var3);

            float[] lon = (float[]) v1.read().copyToNDJavaArray();// 因为经纬度是二维的，直接
            // copyToNDJavaArray结果就是二维的，强转一下就好，然后java的二维数组大家该咋用咋用就行了
            float[] lat = (float[]) v2.read().copyToNDJavaArray();
            int size = ((Long) v4.getSize()).intValue();
            int[] startTimeI = new int[]{0};
            int[] endTimeI = new int[]{size};
            int[] timeArray = (int[]) v4.read(startTimeI, endTimeI).copyTo1DJavaArray();
//            double[][][] temp = (double[][][]) v3.read().copyTo1DJavaArray();
            int timeStart = -1;
            if (timeArray != null && timeArray.length > 0) {
                for (int k = 0; k < timeArray.length; k++) {
                    if (timeArray[k] == 1) {
                        timeStart = k;
                        break;
                    }
                }
            }

            if (timeStart == -1) {
                LOGGER.error("从文件取time时，未取到0点");
            }
            for(int i = 0; i < lon.length; i++){
                System.out.println("第 " + i + " 个lon " + lon[i]);
            }
            for(int i = 0; i < lat.length; i++){
                System.out.println("第 " + i + " 个lat " + lat[i]);
            }
            for(int i = 0; i < timeArray.length; i++){
                System.out.println("第 " + i + " time " + timeArray[i]);
            }



            ncfile.close();
        } catch (IOException e1) {// TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (InvalidRangeException e) {
            e.printStackTrace();
        }
    }

    public static void theStarinNightSky(){
        System.out.println("夜空中最亮的星\n" + "请照亮我前行\n" + "能否听清\n" +"孤独的叹息\n");
    }

}
