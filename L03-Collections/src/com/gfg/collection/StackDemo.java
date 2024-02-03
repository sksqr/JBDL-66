package com.gfg.collection;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //LIFO
        stack.push(5);
        stack.push(10);
        stack.push(1);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
