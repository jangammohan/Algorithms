package com.example.August.BFS;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class BinarySearchTreeToSortedDoubleLinkList {
    static Node doubleHead = new Node();
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root .right = new Node(3);

        Node ret = treeToDoublyList(root);
        System.out.println(ret.val);
    }

    public static Node treeToDoublyList(Node root) {


        Node current = doubleHead;

        traverseTree(root);

        current.right.left = doubleHead;
        doubleHead.right = current.right;
        return current.right;

    }

    private static void traverseTree(Node root) {
        if(root == null) {
            return ;
        }

        traverseTree(root.left );


            Node temp = new Node(root.val);
            doubleHead.right = temp;
            temp.left = doubleHead;
            doubleHead = doubleHead.right;


        traverseTree(root.right);

    }
}
