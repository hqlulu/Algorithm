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
        System.out.printf("\nto sort array: ");
        Random random = new Random();
        for (int i = 0; i < toSortArray.length; i++) {
            toSortArray[i] = random.nextInt(max);
            System.out.print(toSortArray[i] + " ");
        }
        bubbleSort(toSortArray.clone());
        insertionSort(toSortArray.clone());
        selectionSort(toSortArray.clone());
        mergeSort(toSortArray.clone());

//        int[] toSortArray2 = new int[1];
//        toSortArray2[0] = 1;
//        bubbleSort(null);
    }

    /**
     * 冒泡排序
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
     * 插入排序
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
     * 选择排序
     * 从第一个开始,在后面找一个最小的,更换位置
     * 不是稳定的排序,同样的值的元素次序可能会更换
     * @param toSortArray
     */
    private static void selectionSort(int[] toSortArray) {
        System.out.printf("\nselectionSort");
        if ( toSortArray == null){
            System.out.printf("\narray null");
            return;
        }
        if (toSortArray.length <= 1){
            printResult(toSortArray);
            return;
        }
        int min,minIndex,tmp;
        for (int i = 0;i<toSortArray.length-1;i++){
            min = toSortArray[i];
            minIndex = i;
            for (int j = i+1;j<toSortArray.length;j++){
                if (toSortArray[j]<min){
                    min = toSortArray[j];
                    minIndex = j;
                }
            }
            // swap
            if (i != minIndex){
                tmp = toSortArray[i];
                toSortArray[i] = toSortArray[minIndex];
                toSortArray[minIndex] = tmp;
            }
        }
        printResult(toSortArray);
    }

    /**
     * 归并排序
     * @param toSortArray
     */
    private static void mergeSort(int[] toSortArray) {
        System.out.printf("\nmergeSort");
        if ( toSortArray == null){
            System.out.printf("\narray null");
            return;
        }
        if (toSortArray.length <= 1){
            printResult(toSortArray);
            return;
        }

        int[] result = mergeSortArray(toSortArray.clone());
        printResult(result);

        int[] result2 = new int[toSortArray.length];
        int start = 0;
        int end = toSortArray.length - 1;
        mergeSortArrayV2(toSortArray.clone(), result2, start, end);
        printResult(result2);
    }

    /**
     * 递归调用处理分拆合并逻辑
     * 以最大2个元素来拆分数组
     * 合并时优先考虑前一个数组的值,保证同值不乱序
     * 最终排序就是两个值的比较,合并时选择比较两个数组的第一个值大小
     * 优化:内存使用方式可以更加灵巧
     * @param toSortArray
     * @return
     */
    private static int[] mergeSortArray(int[] toSortArray){
        // 超过2个,继续拆分
        if (toSortArray.length>2){

            // split
            int mid = toSortArray.length >> 1;
            int[] array1 = new int[mid];
            int[] array2 = new int[toSortArray.length-mid];
            for (int i=0;i<mid;i++){
                array1[i] = toSortArray[i];
            }
            int j = 0;
            for (int i=mid;i<toSortArray.length;i++){
                array2[j++] = toSortArray[i];
            }
//            System.out.printf("\nsplit 1:");
//            printResult(array1);
//            System.out.printf("\nsplit 2:");
//            printResult(array2);

            // merge
            int[] result1 = mergeSortArray(array1);
            int[] result2 = mergeSortArray(array2);
            int[] result = new int[toSortArray.length];
            int r1 = 0;
            int r2 = 0;
            int r = 0;
            while (r1 < result1.length && r2 < result2.length) {
                result[r++] = result1[r1] <= result2[r2] ? result1[r1++] : result2[r2++];
            }
            while (r1 < result1.length) {
                result[r++] = result1[r1++];
            }
            while (r2 < result2.length) {
                result[r++] = result2[r2++];
            }
//            System.out.printf("\nmerge:");
//            printResult(result);
            return result;
        }

        // 处理最小的排序交换
        if (toSortArray.length>1 && toSortArray[0]>toSortArray[1]){
            int[] tmp = new int[2];
            tmp[0] = toSortArray[1];
            tmp[1] = toSortArray[0];
//            System.out.printf("\nreturn:");
//            printResult(tmp);
            return tmp;
        }
//        System.out.printf("\nreturn:");
//        printResult(toSortArray);
        return toSortArray;
    }

    /**
     * 归并排序的内存优化版本
     * @param toSortArray
     * @return
     */
    private static void mergeSortArrayV2(int[] toSortArray, int[] result, int start, int end){
        if (start == end){
            return;
        }

        // split
        int length = end - start;
        int mid = length >> 1;
        int start1 = start;
        int start2 = start + mid + 1;
        int end1 = start + mid;
        int end2 = end;

        // merge
        mergeSortArrayV2(toSortArray, result, start1, end1);
        mergeSortArrayV2(toSortArray, result, start2, end2);

        // 按顺序复制到结果数组
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = toSortArray[start1] <= toSortArray[start2] ? toSortArray[start1++] : toSortArray[start2++];
        }
        while (start1 <= end1) {
            result[k++] = toSortArray[start1++];
        }
        while (start2 <= end2) {
            result[k++] = toSortArray[start2++];
        }

        // 复制已排序的结果到原数据
        for (int i=start;i<=end;i++){
            toSortArray[i] = result[i];
        }
    }

    /**
     * 打印数组
     * @param toSortArray
     */
    private static void printResult(int[] toSortArray){
        System.out.println("\ntoSortArray = ");
        for (int i = 0; i < toSortArray.length; i++) {
            System.out.print(toSortArray[i] + " ");
        }
    }
}
