package com.aslibra.sort;

import java.util.Random;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class FindTheK {

    public static void main(String[] args) {
        final int size = 20;
        final int max = 1000;
        int[] toSortArray = new int[size];

        // random
        System.out.printf("\nto sort array: ");
        Random random = new Random();
        for (int i = 0; i < toSortArray.length; i++) {
            toSortArray[i] = random.nextInt(max);
            System.out.print(toSortArray[i] + " ");
        }
        System.out.printf("\nquickSort");
        int[] quickArray = toSortArray.clone();
        int index = findTheKElement(quickArray, 0, quickArray.length - 1, 3);
        printResult(quickArray);
        System.out.printf("\nindex=%d %d", index, quickArray[index]);

    }

    /**
     * 快速排序
     * 把小于比较值的和大于比较值的数据分治
     * 交换位置是达到原地排序的目的,但是注意的是,不是稳定排序
     * @param array
     * @param start
     * @param end
     */
    private static int findTheKElement(int[] array, int start, int end, int target){
        printResult(array);
        System.out.printf("\nfindTheKElement=%d %d %d", start, end, target);
        if (start >= end) {
            return end;
        }

        // 比较值
        int privot = array[end];
        // 记录最终交换点,小于比较值的后一个位置,所以要++
        int index_swap = start;
        int tmp;
        for (int i = start; i < end; i++) {
            // 把小的交换到前面
            if (array[i] < privot) {
                if (index_swap != i) {
                    tmp = array[i];
                    array[i] = array[index_swap];
                    array[index_swap] = tmp;
                }
                // 交换的位置后移
                index_swap++;
            }
        }
        // 把比较值替换到交换点
        tmp = array[index_swap];
        array[index_swap] = array[end];
        array[end] = tmp;
        System.out.printf("\nfindTheKElement swap=%d", index_swap);
        int pos = array.length - index_swap;
        if (target == pos){
            return index_swap;
        }
        // 继续处理左右两边的数据
        if (pos < target){
            return findTheKElement(array, start, index_swap - 1, target);
        }else{
            return findTheKElement(array, index_swap + 1, end, target);
        }
    }

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
