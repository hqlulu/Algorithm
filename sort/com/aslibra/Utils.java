package com.aslibra;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class Utils {
    /**
     * 打印数组
     * @param toSortArray
     */
    public static void printResult(int[] toSortArray){
        System.out.print("\nArray = ");
        for (int i = 0; i < toSortArray.length; i++) {
            System.out.print(toSortArray[i] + " ");
        }
    }
}
