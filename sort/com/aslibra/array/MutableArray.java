package com.aslibra.array;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class MutableArray {

    private int[] array;
    private final static int INIT_SIZE = 10;
    private int size = 0;

    public int[] getArray() {
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }
        return tmp;
    }

    public MutableArray() {
        array = new int[INIT_SIZE];
    }

    public void add(int number) {
        if (size >= array.length) {
            //扩容
            int[] tmp = new int[array.length * 2];
            System.arraycopy(array, 0, tmp, 0, array.length);
            array = tmp;
        }
        array[size++] = number;
    }

    public void remove(int index) {
        if (size == 0) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

}
