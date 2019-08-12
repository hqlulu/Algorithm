package com.aslibra.array;

import com.aslibra.Utils;

import java.util.Random;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class TestSortedArray {
    public static void main(String[] args){
        final int size = 20;
        SortedArray sortedArray = new SortedArray(size);
        Random random = new Random();
        for (int i=0;i<size*2;i++){
            sortedArray.add(random.nextInt(100));
            System.out.println(sortedArray);
        }
        for (int i=0;i<size*2;i++){
            sortedArray.update(random.nextInt(20), random.nextInt(100));
            System.out.println(sortedArray);
        }
        for (int i=0;i<size*2;i++){
            sortedArray.delete(random.nextInt(20));
            System.out.println(sortedArray);
        }
    }

}
