package com.aslibra.array;

import com.aslibra.Utils;

import java.util.Random;

/**
 * Created by hqlulu on 2019/8/11.
 * @author hqlulu
 */
public class Test {
    public static void main(String[] args){
        MutableArray mutableArray = new MutableArray();
        Random random = new Random();
        for (int i=0;i<40;i++){
            mutableArray.add(random.nextInt(100));
            Utils.printResult(mutableArray.getArray());
        }
        for (int i=0;i<40;i++){
            mutableArray.remove(0);
            Utils.printResult(mutableArray.getArray());
        }
    }

}
