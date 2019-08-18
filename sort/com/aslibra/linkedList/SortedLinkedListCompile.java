package com.aslibra.linkedList;

import java.util.Random;

/**
 * @author hqlulu
 * @date 2019/8/18 下午6:11
 */
public class SortedLinkedListCompile {
    public static void main(String[] args) {

        // 哨兵
        HQObject linkedList = new HQObject();
        HQObject head = linkedList;
        int size = 7;
        int page = 100;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            HQObject obj = new HQObject();
            obj.setNumber(i * page + Math.abs(random.nextInt() % page));
            head.setNext(obj);
            head = obj;
        }
        System.out.print("\nlinkedList = " + linkedList.getNext());

        // 哨兵
        HQObject linkedList2 = new HQObject();
        HQObject head2 = linkedList2;
        for (int i = 0; i < size + 5; i++) {
            HQObject obj = new HQObject();
            obj.setNumber(i * page + Math.abs(random.nextInt() % page));
            head2.setNext(obj);
            head2 = obj;
        }
        System.out.print("\nlinkedList = " + linkedList2.getNext());

        // 哨兵
        HQObject linkedList3 = new HQObject();
        HQObject head3 = linkedList3;
        HQObject head_1 = linkedList.getNext();
        HQObject head_2 = linkedList2.getNext();

        while (head_1 != null && head_2 != null) {
            Integer n1 = head_1.getNumber();
            Integer n2 = head_2.getNumber();
            if (n1 <= n2) {
                HQObject tmp = head_1;
                head3.setNext(head_1);
                head3 = head_1;
                head_1 = tmp.getNext();
                linkedList.setNext(head_1);
                tmp.setNext(null);
            } else {
                HQObject tmp = head_2;
                head3.setNext(head_2);
                head3 = head_2;
                head_2 = tmp.getNext();
                linkedList2.setNext(head_2);
                tmp.setNext(null);
            }
        }
        System.out.print("\nlinkedList3 = " + linkedList3.getNext());
        System.out.print("\nlinkedList = " + linkedList.getNext());
        System.out.print("\nlinkedList2 = " + linkedList2.getNext());

        while (head_1 != null) {
            HQObject tmp = head_1;
            head3.setNext(head_1);
            head3 = head_1;
            head_1 = tmp.getNext();
            linkedList.setNext(head_1);
            tmp.setNext(null);
        }
        System.out.print("\nlinkedList3 = " + linkedList3.getNext());
        System.out.print("\nlinkedList = " + linkedList.getNext());
        System.out.print("\nlinkedList2 = " + linkedList2.getNext());

        while (head_2 != null) {
            HQObject tmp = head_2;
            head3.setNext(head_2);
            head3 = head_2;
            head_2 = tmp.getNext();
            linkedList2.setNext(head_2);
            tmp.setNext(null);
        }
        System.out.print("\nlinkedList3 = " + linkedList3.getNext());
        System.out.print("\nlinkedList = " + linkedList.getNext());
        System.out.print("\nlinkedList2 = " + linkedList2.getNext());

    }
}
