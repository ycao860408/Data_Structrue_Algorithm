package com.atguigu.packageDemo;

import demo.Student;

import java.util.Arrays;

public class PackageDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Student st1 = new Student(12, "John");
        System.out.println(st1);
        int binaryValue = 0xfff;
        System.out.println(binaryValue);
        byte i = 7;
        System.out.println(i);
        int[] arrs = new int[]{1, 2, 2, 4, 4, 5,9};
        System.out.println(Arrays.toString(arrs));
        System.out.println(Arrays.binarySearch(arrs, 10));
    }
}
