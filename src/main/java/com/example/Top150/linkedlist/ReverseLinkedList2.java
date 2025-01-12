package com.example.Top150.linkedlist;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left >= right ){
            return head;
        }

       int arr[] = new int[right-left+1];
        ListNode leftNode = head;

        for(int i=1; i<left;i++){
            leftNode = leftNode.next;
          }
        ListNode rightNode = leftNode;
        int index =0;
        for(int i =left; i<=right;i++){
            arr[index++] = rightNode.val;
            rightNode= rightNode.next;
        }

        while(left<=right) {

            leftNode.val = arr[--index];
            leftNode = leftNode.next;
        }

        return head;

    }
}
