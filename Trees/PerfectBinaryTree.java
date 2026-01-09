package Trees;

public class PerfectBinaryTree {

    public int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth =  depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isPerfectBinaryTree(Node root, int level, int depth) {
        if(root == null ){
            return true;
        }
        if(root.left == null && root.right == null) {
            return depth == level + 1;
        }
        if(root.left == null || root.right == null){
            return false;
        }

        return isPerfectBinaryTree(root.left, level + 1, depth) && isPerfectBinaryTree(root.right, level+1, depth);
    }

    public boolean checkPerfection(Node root) {
        int depth = depth(root);
        return isPerfectBinaryTree(root, 0, depth);
    }
    
}
