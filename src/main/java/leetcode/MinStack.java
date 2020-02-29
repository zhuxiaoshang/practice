package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.isEmpty()||min.peek()>x){
            min.push(x);
        }else
        {
            min.push(min.peek());
        }
    }

    public void pop() {
        if(!data.isEmpty())
        {
            data.pop();
            min.pop();
        }
    }

    public int top() {
        if(!data.isEmpty())
        {
            return data.peek();
        }
        throw new RuntimeException("");
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();

        }
        throw new RuntimeException("");
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        List<Integer> lis = new LinkedList<>();
        lis.add(1);
        lis.add(0, 2);
        System.out.println(lis);
    }
}
