package december;

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

public class DiameterOfBinaryTree_534 {
        int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return res;
    }

    public int calculate(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = calculate(root.left);
        int right =  calculate(root.right);
        res = Math.max(res, left+right);
        return 1 + Math.max(left, right);
    }


}
