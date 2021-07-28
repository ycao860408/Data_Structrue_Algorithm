package Heap.impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[] {2, 23, 30, 8, 32, 31, 41, 1,15};
        for (Integer num : nums) {
            maxHeap.offer(num);
        }

        maxHeap.print();
        System.out.println();
        maxHeap.poll();
        maxHeap.print();
        System.out.println();

        MaxHeapImpl<Integer> maxHeap1 = new MaxHeapImpl<>(nums);
        maxHeap1.print();
        System.out.println();

        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (a.score == b.score) {
                    return a.name.compareTo(b.name);
                }
                return a.score - b.score;
            }
        });
        Student[] students = new Student[]{new Student("Tom", 100), new Student("Jim", 78),
        new Student("Peter", 87), new Student("Edward", 89), new Student("Antonio", 78)};
        for (Student student : students) {
            pq.offer(student);
        }

        Iterator<Student> iterator = pq.iterator();

        while (iterator.hasNext()) {
            Student curStudent = iterator.next();
            System.out.println("Name: " + curStudent.name + ", Score: " + curStudent.score);
        }
        System.out.println();
        while (!pq.isEmpty()) {
            Student curStudent = pq.poll();
            System.out.println("Name: " + curStudent.name + ", Score: " + curStudent.score);
        }
    }

    private static class Student {
        String name;
        int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
