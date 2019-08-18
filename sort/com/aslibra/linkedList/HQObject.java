package com.aslibra.linkedList;

/**
 * @author hqlulu
 * @date 2019/8/18 下午1:27
 */
public class HQObject {

    private HQObject next;
    private Integer number;
    private static HQObject firstPrintObject;

    @Override
    public String toString() {
        if (firstPrintObject == null){
            firstPrintObject = this;
        }
        if (firstPrintObject == next){
            firstPrintObject = null;
            return " HQObject{ " + number + " Looped}";
        }
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

    public void removeIndex(int removeIndex) {
        int index = 0;
        HQObject checkPos = this;
        while (true){
            HQObject tmp = checkPos.getNext();
            if (tmp == null) {
                break;
            }
            if (removeIndex == index++){
                checkPos.setNext(tmp.getNext());
                tmp.setNext(null);
                break;
            }
            checkPos = tmp;
        }
    }

}
