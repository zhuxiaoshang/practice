package leetcode;

import scala.collection.immutable.$colon$colon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    Map<Node, Integer> valuemap;
    LinkedList<Integer> l = new LinkedList<>();


    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        valuemap = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        if (node != head) {
            node.pre.next = node.next;
            if (node.next != null)
                node.next.pre = node.pre;
            node.next = head;
            head.pre = node;
            head = node;
        }
        if (node == tail && tail.pre != null)
            tail = tail.pre;
        return map.get(key).value;
    }

    public void put(int key, int value) {
        Node n;
        if (map.containsKey(key)) {
            n = map.get(key);
            Integer remove = valuemap.remove(n);
            map.remove(remove);
            if (n.pre != null)
                n.pre.next = n.next;
            if (n.next != null)
                n.next.pre = n.pre;
            n = new Node(value);

        } else {
            n = new Node(value);
            if (map.size() == capacity) {
                Integer remove = valuemap.remove(tail);
                map.remove(remove);

            }
            if (n == head) {
                head = head.next;
            }

        }
        if (tail!=null&&tail.pre != null) {
            tail.pre.next = n;
            n.pre = tail.pre;
        }
        tail = n;
        map.put(key, n);
        valuemap.put(n, key);
        if (map.size() == 1) {
            head = tail;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    class Node {
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
        }
    }
}
