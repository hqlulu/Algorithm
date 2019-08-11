package com.aslibra.sort;

import java.util.Random;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class AllSortMethod {

    public static void main(String[] args) {
        final Integer size = 20;
        final Integer max = 1000;
        Integer[] toSortArray = new Integer[size];

        // random
        Random random = new Random();
        for (Integer i = 0; i < toSortArray.length; i++) {
            toSortArray[i] = random.nextInt(max);
            System.out.print(toSortArray[i] + ",");
        }
        bubbleSort(toSortArray.clone());

        Integer[] toSortArray2 = new Integer[1];
        toSortArray2[0] = 1;
        bubbleSort(null);
    }

    /**
     * 从第一个位置起,逐个对比相邻的,大的就向后交换
     * 优化:如果走一遍没有交换,说明已经有序,可以停止
     * @param toSortArray
     */
    private static void bubbleSort(Integer[] toSortArray) {
        System.out.printf("\nbubbleSort");
        if ( toSortArray == null){
            System.out.printf("\narray null");
            return;
        }
        if (toSortArray.length <= 1){
            printResult(toSortArray);
            return;
        }
        Integer tmp;
        boolean swaped;
        for (Integer i = toSortArray.length - 1; i > 0; i--) {
            swaped = false;
            for (Integer j = 0; j< i; j++){
                if (toSortArray[j]>toSortArray[j+1]){
                    // swap
                    tmp = toSortArray[j];
                    toSortArray[j] = toSortArray[j+1];
                    toSortArray[j+1] = tmp;
                    swaped = true;
                }
            }
            if (!swaped){
                System.out.printf("\nno swap i=%d", i);
                break;
            }
        }
        printResult(toSortArray);
    }



    private static void printResult(Integer[] toSortArray){
        System.out.println("\ntoSortArray = ");
        for (Integer i = 0; i < toSortArray.length; i++) {
            System.out.print(toSortArray[i] + ",");
        }
    }
}
