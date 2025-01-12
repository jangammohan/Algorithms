package com.example.amazon.medium;

import java.util.*;
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int val, Node next, Node prev ) {
        this.key = key;
        this.next = next;
        this.value = val;
        this.prev = prev;
    }
        }

public class LRUCache {

    Map<Integer, Node> input ;
    Node head;
    Node last;
    int currentCapacity;

    public LRUCache(int capacity) {
        input = new HashMap<>();
        this.currentCapacity = capacity;

    }

    public int get(int key) {
        Node value = input.get(key);
        if(value == null) {
            return -1;
        }
        moveNodeToFirst(value);
        return value.value;
    }

    public void put(int key, int value) {
        Node val = input.get(key);
        if(val == null && input.size() == currentCapacity ) {
            removeFromTail();
        }

        if(val == null) {
            val = new Node(key, value, null, null);
            addNodeFirst(val);
        }
        val.value = value;
        input.put(key, val);

    }

    private void addNodeFirst(Node node) {
        if(head == null) {
            head =  node;
            last = node;
        } else {
            node.next = head;
            node.prev = head.prev;
            head.prev = node;
            //last = head;
            head = node;

        }
    }

    private void removeFromTail() {
        this.input.remove(last.key);
        Node temp = last.prev;
        temp.next = null;
        last = temp;

    }

    private void moveNodeToFirst(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        if(prev!= null) {
            prev.next = next;
        }
        if(next!= null) {
            next.prev = prev;
        }
        addNodeFirst(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
