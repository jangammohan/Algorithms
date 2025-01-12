package december.amazon;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class LCA_1644 {

     int count =0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lca(root, p, q);
        return count == 2 ? lca : null;
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null  ) {
            return null;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(root.val == p.val || root.val == q.val) {
            count++;
            return root;
        }

        return left == null ? right: right == null ? left : root;

//        if(left == right)
//            return null;
//        else if(left!= null && right!= null ) {
//            return root;
//        }else if(right == null){
//            return left;
//        }else
//            return right;

    }
}
