package com.example.test;


import java.util.LinkedList;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class RemoveNthNode {



    public static void main(String args[]) {

         ListNode node = new ListNode(10);
         node.next = new ListNode(20);
        node.next.next = new ListNode(30);
        node.next.next.next = new ListNode(40);
        node.next.next.next.next = new ListNode(50);

        ListNode tempNode = node;
        while(tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }





        System.out.println("After Delete -------- ");

        tempNode = removeNthFromEnd(node, 4);;

        while(tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {


            ListNode removeNode = head;
            ListNode previousNode = null;

            if( head == null || head.next == null) {
                head = null;
                return head;
            }
                for(int i =1 ; i< n ; i++) {
                    removeNode = removeNode.next;
                }
                while ( removeNode.next != null ) {
                    if(previousNode == null ) {
                        previousNode = head;
                    } else {
                        previousNode = previousNode.next;
                    }
                    removeNode = removeNode.next;
                }

                 if(n > 1 && previousNode == null) {
                   head = head.next;
                }
                else {
                    previousNode.next = previousNode.next.next;
                }

            return head;
    }

}

