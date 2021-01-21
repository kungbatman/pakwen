package com.fileTest.pangou;

import java.util.Arrays;

/**
 * @author kung
 * @date 2020-12-28 14:59
 * @Description
 */
public class Intervivew {
    public static void main(String[] args) {
//        int[] arrays = {3, 5, 1, 29, 467, 2, 12, 43, 19, 73, 8, 382, 334};
////        int[] narr = arr(arrays);
//        int[] narr = testArr(arrays, 13);
//        for (int i = 0; i < narr.length; i++) {
//            System.out.println(narr[i]);
//        }

        testA();
    }

    public static int[] arr(int[] iarr) {
//        Arrays.sort(iarr);
        int i, j, k;
        for (i = 0; i < iarr.length - 1; i++)
            for (j = 0; j < iarr.length - 1 - i; j++) {
                if (iarr[j] > iarr[j + 1]) {
                    k = iarr[j];
                    iarr[j] = iarr[j + 1];
                    iarr[j + 1] = k;
                }
            }
        return iarr;
    }

    public static int[] testArr(int a[], int n) {
        /*
         * 采用类似于选择排序的算法
         */
        for (int i = 0; i < n; i++) {
            //找最大值
            if (i % 2 == 0) {
                int j = i + 1;
                //记录最大值的位置
                int loc = i;
                for (; j < n; j++) {
                    if (a[j] > a[loc]) loc = j;
                }
                //发生交换
                if (loc != i) {
                    int temp = a[loc];
                    a[loc] = a[i];
                    a[i] = temp;
                }
            } else {
                //找最小值
                int j = i + 1;
                //记录最小值的位置
                int loc = i;
                for (; j < n; j++) {
                    if (a[j] < a[loc]) loc = j;
                }
                //发生交换
                if (loc != i) {
                    int temp = a[loc];
                    a[loc] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }


    public static void testA(){
        String url = "img\\aaa.jpg";
        String[] paths = url.split("\\.");
        System.out.println(paths[0]);
    }
}


