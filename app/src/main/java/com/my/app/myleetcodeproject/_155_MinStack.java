package com.my.app.myleetcodeproject;

import java.util.Stack;

/**
 * @description: 155. Min MyStack 最小栈
 * @author: ouyangxin
 * @date: 2018-10-25 17:49
 * @version: 1.0
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
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

        System.out.println(stack.getMin() + "");
    }

    static class MinStack {

        private int min_val = Integer.MAX_VALUE;
        private Stack<Integer> s = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        /**
         * 这里十分巧妙！
         * 1.如果输入值小于最小值，先把当前的 min_val 入栈
         * 2.min_val 的赋值为输入值
         * 3.输入值入栈
         * <p>
         * 这样做的原因是，先把旧的最小值入栈，然后min_val再赋值为最新的最小值，
         * 那么最小值的前一个数一定是第二小的数，因为是旧的最小值，
         * 如果再pop的时候，最小值出栈了，min_val直接赋值栈顶的数就可以了 @see #pop()
         */
        private void push(int x) {
            if (x <= min_val) {//这里的 <= 要注意
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
