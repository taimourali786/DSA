package Trees;

public class FullBinaryTree {
    
    public boolean isFullBinaryTree(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        
        if(root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }
        return false;
    }
}
