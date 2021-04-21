package leetcode.beginning2021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * @author: zhushang
 * @create: 2021-04-15 11:28
 */
public class L225 {
  Queue<Integer> in;
  Queue<Integer> out;

  public L225() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }

  public void push(int x) {
    in.add(x);
  }

  public int pop() {
    while (!in.isEmpty()) {
      if (in.size() > 1) {
        out.add(in.poll());
      } else {
        int res = in.poll();
        Queue<Integer> tmp;
        tmp = out;
        out = in;
        in = tmp;
        return res;
      }
    }
    throw new RuntimeException("");
  }

  public int top() {
    while (!in.isEmpty()) {
      if (in.size() > 1) {
        out.add(in.poll());
      } else {
        int res = in.poll();
        out.add(res);
        Queue<Integer> tmp;
        tmp = out;
        out = in;
        in = tmp;
        return res;
      }
    }
    throw new RuntimeException("");
  }

  public boolean empty() {
    return in.isEmpty();
  }
}
