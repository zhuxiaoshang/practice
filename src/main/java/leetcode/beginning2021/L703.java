package leetcode.beginning2021;

import java.util.PriorityQueue;

/**
 * @author: zhushang
 * @create: 2021-04-15 13:13
 */
public class L703 {
  PriorityQueue<Integer> q;
  int k;

  public L703(int k, int[] nums) {
    this.k = k;
    q = new PriorityQueue<>(k);
    for (int n : nums) {
      q.add(n);
    }
  }

  public int add(int x) {
    q.add(x);
    while (q.size() > k) {
      q.poll();
    }
    return q.peek();
  }

  // 最小堆
  static class MyPriorityQueue {
    int[] elements;
    int k;
    int size;

    public MyPriorityQueue(int k, int[] elements) {
      this.k = k;
      this.elements = new int[k + 1];
      for (int e : elements) {
        add(e);
      }
    }

    public int add(int x) {
      if (size < k) { // 未满
        size++;
        elements[size] = x; // 添加到末尾
        int i = size;
        while (i / 2 > 0 && elements[i] < elements[i / 2]) {
          swap(elements, i, i / 2);
          i /= 2;
        }
      } else {
        if (elements[1] < x) {
          elements[1] = x;
          heaplify();
        }
      }
      System.out.println("heap top is :" + elements[1]);
      return elements[1];
    }

    private void heaplify() {
      for (int i = 1; i <= size / 2; i++) {
        if (i * 2 <= size && elements[i] > elements[2 * i]) {
          swap(elements, i, i * 2);
        }

        if (i * 2 + 1 <= size && elements[i] > elements[2 * i + 1]) {
          swap(elements, i, 2 * i + 1);
        }
      }
    }

    private void swap(int[] arr, int a, int b) {
      arr[a] = arr[a] ^ arr[b];
      arr[b] = arr[a] ^ arr[b];
      arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
      int[] arr = {4, 5, 8, 2};
      MyPriorityQueue q = new MyPriorityQueue(3, arr);
    }
  }
}
