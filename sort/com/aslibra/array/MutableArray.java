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
        System.arraycopy(array, 0, tmp, 0, size);
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
        System.arraycopy(array, index+1, array, index, size - index - 1);
        --size;
    }

}
