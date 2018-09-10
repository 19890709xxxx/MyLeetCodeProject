package com.my.app.myleetcodeproject;

import java.util.Stack;

/**
 * @description: 有效的括号
 * @author: ouyangxin
 * @date: 2018-08-21 18:25
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */

public class _20_ValidParentheses {

    //这道题考的是栈的相关操作

    public static void main(String[] args) {
        System.out.println(isValid("[{}]") + "");
    }

    private static boolean isValid(String s) {

        if (s.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {//将输入的字符串进行遍历，如果是左边的符号，栈入栈对应相反的右边符号
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) {
                /*
                * 如果遍历后，三个左符号都没有匹配到，栈为空，说明输入都字符并不符合左符号先出现的规则
                *
                * 或者栈pop出最后一位不等于当前的遍历的字符,返回false
                *
                * 为什么要判断栈最后一位是否和现在遍历的字符相等呢？因为左符号都没有匹配到，那么输入的字符就肯定是右符号
                *
                * 那么这时候我们要寻找合格的结果是上一个遍历字符是现在这个右字符对应的左字符，比如现在是'}',那么上一个
                *
                * 遍历字符必须是'{'结果才成立，由于我们判断左字符，入栈右字符，那么这时候栈顶的字符必须和现在遍历的字符
                *
                * 相等，才符合规则
                * */
                return false;
            }
        }

        //在经过 stack.pop == c 的判断后，符合规则的栈应该被清空了，如果栈不为空，说明输入不符合规则
        return stack.isEmpty();
    }
}
