package com.example.Top150.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode four = new ListNode(4);
        two.next = four;

        ListNode on = new ListNode(1);
        ListNode thre = new ListNode(3);
        on.next = thre;
        ListNode fo = new ListNode(4);
        thre.next = fo;

        ListNode res = mergeTwoLists(one, on);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) {
            return null;
        }

        ListNode head = new ListNode();
         ListNode current = head;
        while( list1 != null && list2 != null ) {

            int ls1Val =  list1.val ;
            int ls2Val =  list2.val ;

            if( ls1Val < ls2Val) {
                    current.next = new ListNode(ls1Val);
                list1 = list1.next;
            }else {
                    current.next = new ListNode(ls2Val);

                list2 = list2.next;
            }

            current = current.next;

        }

       current.next = (list1 != null) ? list1 : list2;
        return head.next;

    }
}
