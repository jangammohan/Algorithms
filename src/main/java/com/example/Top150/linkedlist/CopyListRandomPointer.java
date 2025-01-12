package com.example.Top150.linkedlist;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListRandomPointer {

    public Node copyRandomList(Node head) {

        Node newhead = null;
        Node returnHead = null;;
        Node temp = head;
        Map<Integer, Node> hashMap = new HashMap<>();

        while(temp!= null) {
            if(newhead == null) {
                newhead = new Node(temp.val);
                hashMap.put(temp.val, newhead);
                returnHead = newhead;
            }else {

                newhead.next = new Node(temp.val);
                hashMap.put(temp.val, newhead.next);
                newhead =  newhead.next;
            }
            temp = temp.next;
        }
        temp = head;
        while(temp!= null) {
            if(temp.random == null) {
                //continue;
            }else {
                Node newNode = hashMap.get(temp.val);
                newNode.random = hashMap.get(temp.random.val);
            }
            temp = temp.next;
        }

        return newhead;
    }
}
