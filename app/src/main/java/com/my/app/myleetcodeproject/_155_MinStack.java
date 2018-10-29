package com.my.app.myleetcodeproject;

import java.util.Stack;

/**
 * @description: 155. Min Stack 最小栈
 * @author: ouyangxin
 * @date: 2018-10-25 17:49
 * @version: 1.0
 */

public class _155_MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();


        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(1);

        stack.pop();

        System.out.println(stack.getMin()+"");
    }

    static class MinStack {

        private int min_val = Integer.MAX_VALUE;
        private Stack<Integer> s = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {}

        /**
         * 这里十分巧妙！
         * 1.如果输入值小于最小值，先把当前的 min_val 入栈
         * 2.min_val 的赋值为输入值
         * 3.输入值入栈
         *
         * 这样做的原因是，先把旧的最小值入栈，然后min_val再赋值为最新的最小值，
         * 那么最小值的前一个数一定是第二小的数，因为是旧的最小值，
         * 如果再pop的时候，最小值出栈了，min_val直接赋值栈顶的数就可以了 @see #pop()
         *
         */
        private void push(int x) {
            if (x <= min_val) {
                s.push(min_val);
                min_val = x;
            }
            s.push(x);
        }

        private void pop() {
            if (s.pop() == min_val) min_val = s.pop();
        }

        public int top() {
            return s.peek();
        }

        private int getMin() {
            return min_val;
        }
    }


}
