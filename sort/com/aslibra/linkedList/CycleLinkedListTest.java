package com.aslibra.linkedList;

import java.util.Random;

/**
 * @author hqlulu
 * @date 2019/8/18 下午3:48
 */
public class CycleLinkedListTest {

    public static void main(String[] args) {
        CircleLinkedList linkedList = new CircleLinkedList("8888");
        int size = 8;
        Random random = new Random();
        System.out.print("\nlinkedList = " + linkedList);

        linkedList.add(555);
        linkedList.add(555);
        for (int i=0;i<size;i++){
            linkedList.add(random.nextInt() % 1000);
            if (i == 4) {
                linkedList.add(555);
            }
            System.out.print("\nlinkedList = " + linkedList);
        }

        linkedList.remove(555);
        System.out.print("\nremoved 555 \nlinkedList = " + linkedList);
    }
}
