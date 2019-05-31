package com.my.app.myleetcodeproject.DataStructure;

public class StackQueueTest {


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        while (stack.getHead()!=null){
            System.out.printf(stack.pop()+"");

        }
    }





}
