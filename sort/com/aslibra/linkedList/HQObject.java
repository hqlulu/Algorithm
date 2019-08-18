package com.aslibra.linkedList;

/**
 * @author hqlulu
 * @date 2019/8/18 下午1:27
 */
public class HQObject {

    private HQObject next;
    private Integer number;

    @Override
    public String toString() {
        return " HQObject{ " + number +
                " next=>" + next + "}";
    }

    public HQObject getNext() {
        return next;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNext(HQObject next) {
        this.next = next;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
