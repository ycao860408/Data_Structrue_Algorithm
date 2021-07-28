package stack.impl;

import stack.LinkedListStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args)  {
        IStackImpl<Integer> myStack = new IStackImpl(2);
        myStack.push(1);
        myStack.push(2);
        myStack.print();
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            System.out.println(myStack.peek());
            System.out.println("The size is " + myStack.size());
            System.out.println("The capacity is " + myStack.capacity());
        }

        for (int i = 10; i > 0; i--) {
            myStack.pop();
            System.out.println(myStack.peek());
            System.out.println("The size is " + myStack.size());
            System.out.println("The capacity is " + myStack.capacity());
        }

        LinkedListStack<Integer> myStack2 = new ILinkStack<>();
        myStack2.push(1);
        myStack2.push(2);
        for (int i = 0; i < 10; i++) {
            myStack2.push(i);
            System.out.println(myStack2.peek());
            System.out.println("The size is " + myStack2.size());
            //System.out.println("The capacity is " + myStack2.capacity());
        }

        for (int i = 10; i > 0; i--) {
            myStack2.pop();
            System.out.println(myStack2.peek());
            System.out.println("The size is " + myStack2.size());
            //System.out.println("The capacity is " + myStack.capacity());
        }
    }
}
