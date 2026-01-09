package Trees;

import java.util.*;

public class BinarySearchTree {

    public Node createTree(List<Integer> inputs) {
        Node root = new Node(inputs.get(0));
        for (int i = 1; i < inputs.size(); i++) {
            insertNode(root, inputs.get(i));
        }
        return root;
    }

    public void insertNode(Node root, int newValue) {
        if (newValue == root.val) {
            return;
        }
        if (newValue < root.val) {
            if (root.left != null) {
                insertNode(root.left, newValue);
            } else {
                root.left = new Node(newValue);
            }
        } else {
            if (root.right != null) {
                insertNode(root.right, newValue);
            } else {
                root.right = new Node(newValue);
            }
        }
    }

    public Node deleteNode(Node root, int value) {
        if(root == null) return null;
        if (value == root.val) {
            if (root.left == null && root.right == null) { 
                return null;
            }
            if(root.left != null ) {
                return root.left;
            }
            if(root.right != null) {
                return root.right;
            }
            if(root.left != null && root.right != null) {
                Node lastNode = root.right;
                while(lastNode.left != null) {
                    lastNode = lastNode.left;
                }
                root.val = lastNode.val;
                return deleteNode(root.right, lastNode.val);
            }

        }
        if (value < root.val) {
            root.left =  deleteNode(root.left, value);
        } else if (value > root.val) {
            root.right =  deleteNode(root.right, value);
        }
        return root;
    }
}
