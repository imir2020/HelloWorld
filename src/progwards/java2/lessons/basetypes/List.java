package ru.progwards.java2.lessons.basetypes;

public class List<T> {
    class Do<T> {
        private T data;
        private Do<T> prev;
        private Do<T> next;

        public Do(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Do<T> getPrev() {
            return prev;
        }

        public Do<T> getNext() {
            return next;
        }


        public void setPrev(Do<T> temp) {
            prev = temp;
        }

        public void setNext(Do<T> temp) {
            next = temp;
        }
    }

    Do<T> head;
    Do<T> tail;

    public Do<T> getHead() {
        return head;
    }

    public Do<T> getTail() {
        return tail;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T data) {//Стратегия FIFO, а должна быть стратегия наоборот - LIFO
        Do<T> temp = new Do<>(data);
        if (isEmpty()) {
            head = temp;
        } else {
            tail.setNext(temp);
        }
        temp.setPrev(head);
        tail = temp;
    }

    public void addLast(T data) {//Стратегия FIFO, а должна быть стратегия наоборот - LIFO
        Do<T> temp = new Do<>(data);
        if (isEmpty()) {
            tail = temp;
        } else {
            head.setPrev(temp);
        }
        //temp.setNext(tail);
        head = temp;
    }

    public static void main(String[] args) {
        List<Integer> two = new List<>();
       // two.addFirst(76);
        //two.addFirst(-32);
        //two.addFirst(65);
        //two.addFirst(-54);
       // two.addFirst(796);
        two.addLast(-342);
        two.addLast(665);
        two.addLast(-44);
        two.addLast(499);
        List<Integer>.Do<Integer> current = two.getTail();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrev();
        }
    }
}
