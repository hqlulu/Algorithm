package com.aslibra.linkedList;

import java.util.Random;

/**
 * @author hqlulu
 * @date 2019/8/18 下午1:29
 */
public class Test {
    public static void main(String[] args){
        // 哨兵
        HQObject linkedList = new HQObject();
        HQObject head = linkedList;
        int size = 8;
        Random random = new Random();
        for (int i=0;i<size;i++){
            HQObject obj = new HQObject();
            obj.setNumber(random.nextInt() % 1000);
            head.setNext(obj);
            head = obj;
        }
        System.out.print("linkedList = " + linkedList.getNext());

        // revert linked list
        HQObject lineRight = linkedList.getNext();
        HQObject lineLeft = null;
        while(lineRight.getNext() != null){
            HQObject tmp = lineRight;
            lineRight = tmp.getNext();
            tmp.setNext(lineLeft);
            lineLeft = tmp;
        }
        lineRight.setNext(lineLeft);
        linkedList.setNext(lineRight);
        System.out.print("\nAfter revert --------\nlinkedList = " + linkedList.getNext());
    }
}
