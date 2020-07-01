package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    Deque<Integer> stackin ;
    Deque<Integer> stackout ;

    public CQueue() {
        stackin = new ArrayDeque<>();
        stackout = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        while(!stackout.isEmpty()){
            stackin.push(stackout.pop());
        }
        stackin.push(value);
    }

    public int deleteHead() {
        while(!stackin.isEmpty()){
            stackout.push(stackin.pop());
        }
        return stackout.isEmpty()?-1:stackout.pop();
    }

}
