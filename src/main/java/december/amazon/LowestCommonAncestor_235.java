package december.amazon;

import com.sun.source.tree.Tree;

public class LowestCommonAncestor_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left,p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        if(left == right) {
            return null;
        }



        return (right == null) ? left : left==null? right : root;
    }
}