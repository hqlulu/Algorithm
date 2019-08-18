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
        HQObject startObj = this;
        HQObject tmp = this;
        StringBuilder sb = new StringBuilder();
        while (tmp != null){
            sb.append("{");
            sb.append(tmp.getNumber());
            sb.append("}");
            sb.append(tmp.getNext() == null ? " => null " : " => ");
            tmp = tmp.getNext();
            if (tmp == startObj){
                sb.append("Looped");
                break;
            }
        }
        return sb.toString();
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
            if (removeIndex == 0) {
                // fix loop
                HQObject tmp2 = tmp;
                while (true) {
                    tmp2 = tmp2.getNext();
                    if (tmp2.getNext() == tmp) {
                        tmp2.setNext(tmp.getNext());
                        break;
                    }
                    if (tmp2.getNext() == null) {
                        break;
                    }
                }
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
