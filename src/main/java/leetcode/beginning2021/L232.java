package leetcode.beginning2021;

import java.util.Stack;

/**
 * 栈实现队列
 *
 * @author: zhushang
 * @create: 2021-04-15 10:48
 */
public class L232 {
  Stack<Integer> in;
  Stack<Integer> out;

  public L232() {
    in = new Stack<>();
    out = new Stack<>();
  }

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.isEmpty() ? -1 : out.pop();
  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.isEmpty() ? -1 : out.peek();
  }

  public boolean empty() {
    return out.isEmpty() && in.isEmpty();
  }
}
