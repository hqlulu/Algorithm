package com.aslibra.sort;

import java.util.Random;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class AllSortMethod {

    public static void main(String[] args) {
        final int size = 20;
        final int max = 1000;
        int[] toSortArray = new int[size];

        // random
        Random random = new Random();
        for (int i = 0; i < toSortArray.length; i++) {
            toSortArray[i] = random.nextInt(max);
            System.out.print(toSortArray[i] + ",");
        }
        bubbleSort(toSortArray.clone());
        insertionSort(toSortArray.clone());

        int[] toSortArray2 = new int[1];
        toSortArray2[0] = 1;
        bubbleSort(null);
    }

    /**
     * 从第一个位置起,逐个对比相邻的,大的就向后交换
     * 优化:如果走一遍没有交换,说明已经有序,可以停止
     * @param toSortArray
     */
    private static void bubbleSort(int[] toSortArray) {
        System.out.printf("\nbubbleSort");
        if ( toSortArray == null){
            System.out.printf("\narray null");
            return;
        }
        if (toSortArray.length <= 1){
            printResult(toSortArray);
            return;
        }
        int tmp;
        boolean swaped;
        for (Integer i = toSortArray.length - 1; i > 0; i--) {
            swaped = false;
            for (int j = 0; j< i; j++){
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

    /**
     * 取一个数,在已排序区间从后往前找自己的位置,比大小,换位置
     * 比拟打扑克抓牌过程,先拿起一张,然后抓一张,在手里的牌找位置插入
     * 优化方式:数据量大时,可以用二分法找位置
     * @param toSortArray
     */
    private static void insertionSort(int[] toSortArray) {
        System.out.printf("\ninsertionSort");
        if ( toSortArray == null){
            System.out.printf("\narray null");
            return;
        }
        if (toSortArray.length <= 1){
            printResult(toSortArray);
            return;
        }
        int sortedIndex = 0;
        int tmp;
        for (int i = sortedIndex+1;i<toSortArray.length;i++){
            for (int j = sortedIndex + 1;j>0;j--){
                // 左边的牌大,则换位置
                if (toSortArray[j]<toSortArray[j-1]){
                    tmp = toSortArray[j];
                    toSortArray[j] = toSortArray[j-1];
                    toSortArray[j-1] = tmp;
                }
            }
            sortedIndex ++;
        }
        printResult(toSortArray);
    }

    /**
     * 打印数组
     * @param toSortArray
     */
    private static void printResult(int[] toSortArray){
        System.out.println("\ntoSortArray = ");
        for (int i = 0; i < toSortArray.length; i++) {
            System.out.print(toSortArray[i] + ",");
        }
    }
}
