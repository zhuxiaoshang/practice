package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MedianFinder {
    private List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            for (int i = 0; i < list.size()-1; i++) {
//                if(list.get(i))
            }
        }
    }

    public double findMedian() {
return 0;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        System.out.println(l.get(1));
    }
}
