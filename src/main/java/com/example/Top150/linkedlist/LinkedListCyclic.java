package com.example.Top150.linkedlist;


class ListNode {
     int val;
      ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
      }
    ListNode() {}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class LinkedListCyclic {
    public static void main(String[] args) {

        ListNode three = new ListNode(3);

        ListNode two = new ListNode(2);
        three.next = two;
        ListNode zero = new ListNode(0);
        two.next = zero;
        ListNode four = new ListNode(-4);
        zero.next = four;
        four.next = two;
        System.out.println(hasCycle(three));
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if(slow == fast) {
            return true;
        }

        while(slow != null && fast!= null &&  fast.next!= null ) {

            slow =  slow.next  ;
            fast = fast.next.next ;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}
