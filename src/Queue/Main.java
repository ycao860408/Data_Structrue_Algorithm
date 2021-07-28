package Queue;

import Queue.Impl.ArrayOfQueue;
import Queue.Impl.CircularArrayQueue;
import Queue.Impl.LinkedListOfQueue;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new LinkedListOfQueue<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
        System.out.println();
        MyQueue<Integer> queue2 = new ArrayOfQueue<>();

        for (int i = 0; i < 15; i++) {
            queue2.offer(i);
            queue2.print();
            System.out.println();
        }
        System.out.println(queue2.poll());
        queue2.print();
        System.out.println(queue2.peek());
        System.out.println();
        MyQueue<Integer> queue3 = new CircularArrayQueue<>();
        for (int i = 0; i < 9; i++) {
            queue3.offer(i);
            queue3.print();
            System.out.println();
        }
        System.out.println(queue3.poll());
        queue3.print();
        System.out.println(queue3.poll());
        queue3.print();
    }
}
