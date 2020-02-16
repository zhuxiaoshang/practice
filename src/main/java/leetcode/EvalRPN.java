package leetcode;

import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int first = stack.pop();
                int second = stack.pop();
                int result =0 ;
                switch (tokens[i]) {
                    case "+":
                        result = second+first;
                        break;
                    case "-":
                        result = second-first;
                        break;
                    case "*":
                        result = second*first;
                        break;
                    case "/":
                        result = second/first;
                        break;
                }
                stack.push(result);

            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }

        }
        return stack.pop();
    }
}
