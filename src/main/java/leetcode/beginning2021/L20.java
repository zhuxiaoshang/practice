package leetcode.beginning2021;

import java.util.Stack;

/**
 * @author: zhushang
 * @create: 2021-04-15 10:31
 */
public class L20 {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.empty() || stack.pop() != '(') return false;
      } else if (c == ']') {
        if (stack.empty() || stack.pop() != '[') return false;
      } else {
        if (stack.empty() || stack.pop() != '{') return false;
      }
    }

    return stack.isEmpty();
  }
}
