package december;



public class FlattenBinaryTree_114 {

    private TreeNode prev;
    public void flatten(TreeNode root) {

        if(root == null) {
            return ;
        }

        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = flattenTree(root.left);
        TreeNode right = flattenTree(root.right);

        if(left != null) {
            root.left = null;

            root.right = left;
            if(right!= null) {
                TreeNode temp = root.right;
                while(temp.right != null) {
                    temp= temp.right;
                }
                temp.right = right;
            }
        }


        return root;
    }



    public void flatten_LeetSolutionWithGlobal(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten_LeetSolutionWithGlobal(root.right);
        flatten_LeetSolutionWithGlobal(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
