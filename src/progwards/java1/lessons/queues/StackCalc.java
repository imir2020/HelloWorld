package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    private ArrayDeque<Double> queue = new ArrayDeque<Double>();

    // положить value на вершину стека
    public void push(double value) {
        queue.offerLast(value);
    }


    // взять (убрать) значение с вершины стека
    public double pop() {

        return queue.pollLast();
    }

    // сложить 2 верхних значения на стеке, результат положить на стек
    public void add() {
        if (queue.size() < 2) return;
        queue.offerLast(queue.pollLast() + queue.pollLast());
    }

    // вычесть верхнее значение на стеке, из следующего по глубине
    public void sub() {
        if (queue.size() < 2) return;
        queue.offerLast(-queue.pollLast() + queue.pollLast());
    }

    // умножить 2 верхних значения на стеке, результат положить на стек.
    public void mul() {
        if (queue.size() < 2) return;
        queue.offerLast(queue.pollLast() * queue.pollLast());
    }

    // поделить на верхнее значение на стеке, следующее по глубине,
    public void div() {
        if (queue.size() < 2) return;
        Double e1 = queue.pollLast();
        queue.offerLast(queue.pollLast() / e1);
    }

    public static void main(String[] args) {

    }
}
