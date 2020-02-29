package leetcode;

import java.util.Stack;

/**
 * 基本计算器II,主要思想：利用栈
 */
public class Calculate {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        s = s.trim();

        Stack<Integer> data = new Stack<>();
        Stack<String> operator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if('0'<=s.charAt(i)&&s.charAt(i)<='9'){}


        }
        return 1;
    }
}
