package com.aslibra.linkedList;

import java.util.Random;

/**
 * @author hqlulu
 * @date 2019/8/18 下午3:48
 */
public class CycleLinkedListTest {
    public static void main(String[] args) {
        // 哨兵
        HQObject linkedList = new HQObject();
        HQObject head = linkedList;
        int size = 8;
        Random random = new Random();
        for (int i=0;i<size;i++){
            HQObject obj = new HQObject();
            obj.setNumber(random.nextInt() % 1000);
            obj.setNext(linkedList.getNext());
            head.setNext(obj);
            head = obj;
        }
        System.out.print("linkedList = " + linkedList.getNext());

        // remove index 0
        int removeIndex = 2;
        linkedList.removeIndex(removeIndex);
        System.out.print("\nAfter remove "+removeIndex+" --------\nlinkedList = " + linkedList.getNext());

        // remove index 2
        removeIndex = 0;
        linkedList.removeIndex(removeIndex);
        System.out.print("\nAfter remove "+removeIndex+" --------\nlinkedList = " + linkedList.getNext());


    }
}
