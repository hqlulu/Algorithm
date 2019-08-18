package com.aslibra.array;

import com.aslibra.Utils;

/**
 * Created by hqlulu on 2019/8/12.
 * @author hqlulu
 */
public class SortedArray {

    private int[] sortedArray;
    private int size = 0;

    public SortedArray(int length) {
        sortedArray = new int[length];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(sortedArray[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public boolean add(int number) {
        System.out.printf("add num:%d\n", number);
        if (size >= sortedArray.length - 1) {
            return false;
        }
        sortedArray[size++] = number;
        if (size == 1){
            return true;
        }
        for (int i = size - 2; i >= 0; i--) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                int tmp = sortedArray[i];
                sortedArray[i] = sortedArray[i + 1];
                sortedArray[i + 1] = tmp;
            } else {
                break;
            }
        }
        return true;
    }

    public void delete(int index) {
        System.out.printf("delete index:%d\n", index);
        if (index >= size) {
            return;
        }
        System.arraycopy(sortedArray, index, sortedArray, index+1, size - index - 1);
        --size;
    }

    public void update(int index, int number) {
        System.out.printf("update index:%d %d\n", index, number);
        if (index >= size) {
            return;
        }
        sortedArray[index] = number;
        if (index > 0 && sortedArray[index - 1] > number) {
            // move to 0
            for (int i = index - 1; i >= 0; i--) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = tmp;
                } else {
                    break;
                }
            }
        } else if (index < size - 1 && sortedArray[index + 1] < number) {
            // move to 0
            for (int i = index; i < size - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
