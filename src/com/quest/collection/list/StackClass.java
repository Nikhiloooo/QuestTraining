package com.quest.collection.list;

import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.search(2));
        System.out.println(stack.add(5));
        System.out.println("size of stack"+stack.size());
        System.out.println("elemet at index 0"+stack.get(0));

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
