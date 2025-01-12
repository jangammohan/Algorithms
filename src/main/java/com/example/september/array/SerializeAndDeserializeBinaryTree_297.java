package com.example.september.array;





import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.left = two;
        TreeNode three = new TreeNode(3);
        root.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        three.left = four;
        three.right = five;

        SerializeAndDeserializeBinaryTree_297 ser = new SerializeAndDeserializeBinaryTree_297();
        StringBuilder sb = new StringBuilder();
        String str = ser.serialize(root, sb).toString();
        System.out.println(str);
       // ser.deserialize(str);
    }

    public StringBuilder serialize(TreeNode root, StringBuilder sb) {

       if(root == null) {
          return sb.append("null");
       }
       sb.append(root.val).append(",");
       serialize(root.left, sb).append(",");
       serialize(root.right, sb);
        return sb;
    }

    public TreeNode deserialize(String data) {
        return deser(new LinkedList<String>(Arrays.asList(data.split(","))));
    }

    private TreeNode deser(Queue<String> list) {

        String st = list.poll();

        if(st.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(st));
        node.left = deser(list);
        node.right = deser(list);

        return node;
    }
}
