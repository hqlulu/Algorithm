package com.aslibra.linkedList;

/**
 * @author hqlulu
 * @date 2019/8/18 下午4:53
 */
public class CircleLinkedList {

    private LinkedObject head;
    private LinkedObject tail;

    private class LinkedObject {
        private LinkedObject next;
        private Object value;

        public LinkedObject getNext() {
            return next;
        }

        public void setNext(LinkedObject next) {
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public CircleLinkedList() {
        LinkedObject obj = new LinkedObject();
        this.head = obj;
    }

    public CircleLinkedList(Object value) {
        LinkedObject obj = new LinkedObject();
        obj.setValue(value);
        obj.setNext(obj);
        LinkedObject initHead = new LinkedObject();
        initHead.setNext(obj);
        this.head = initHead;
        this.tail = obj;
    }

    @Override
    public String toString() {
        LinkedObject startObj = this.head.getNext();
        LinkedObject tmp = this.head.getNext();
        StringBuilder sb = new StringBuilder();
        while (tmp != null) {
            sb.append("{");
            sb.append(tmp.getValue());
            sb.append("}");
            sb.append(tmp.getNext() == null ? " => null " : " => ");
            tmp = tmp.getNext();
            if (tmp == startObj) {
                sb.append("Looped");
                break;
            }
        }
        return sb.toString();
    }

    public void add(Object value) {
        LinkedObject next = this.head.getNext();
        LinkedObject obj = new LinkedObject();
        obj.setValue(value);
        obj.setNext(next == null ? obj : next);
        if (next == null) {
            this.head.setNext(obj);
        }
        if (this.tail == null) {
            this.tail = obj;
        }else{
            this.tail.setNext(obj);
            this.tail = obj;
        }
    }

    public void remove(Object value) {
        LinkedObject tmp = this.head.getNext();
        LinkedObject last = this.tail;
        while (tmp != null) {
            LinkedObject startObj = this.head.getNext();
            // need to remove obj
            if (tmp.getValue().equals(value)) {
                // remove first one
                if (tmp == startObj) {
                    // only one, point to self
                    if (tmp == tmp.getNext()) {
                        tmp.setNext(null);
                    }
                    LinkedObject next = tmp.getNext();
                    this.head.setNext(next);
                    this.tail.setNext(next);
                    LinkedObject tmp2 = tmp;
                    tmp = next;
                    tmp2.setNext(null);
                    continue;
                }
                // normal situation
                LinkedObject tmp2 = tmp;
                tmp = tmp2.getNext();
                last.setNext(tmp);
                tmp2.setNext(null);
                continue;
            }
            last = tmp;
            tmp = tmp.getNext();
            if (tmp == startObj) {
                break;
            }
        }
    }
}
