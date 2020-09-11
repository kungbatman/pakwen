package com.sword;

/**
 * @author kung
 * @date 2020-05-26 8:21
 * @Description
 */
public class Day1 {
    public static boolean Find(int [][] array,int target){
        int m = array.length - 1;
        int i = 0;
        while (m >= 0 && i < array[0].length){
            if(array[m][i] > target){
                m --;
            }else if(array[m][i] < target){
                i ++;
            }else return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] arr = {{2,3,9},{3,5,8},{7,15,16},{15,16,17}};
        boolean a = Find(arr,4);
        System.out.println(a);
    }
}
