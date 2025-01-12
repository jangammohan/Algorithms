package com.example.Top150.linkedlist;

public class RemoveDuplicatesFromSorteList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        ListNode dummy = new ListNode();
        ListNode previous = dummy;
        previous.next = current;

       while(current != null ) {
           while (current.next != null && current.val == current.next.val) {
                current = current.next;
           }

           if(previous.next != current) {
               previous.next = current.next;
               current = previous.next;
           } else {
               previous = previous.next;
               current = current.next;
           }



       }
        return dummy.next;
    }
}
