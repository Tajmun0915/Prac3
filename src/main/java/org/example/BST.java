package org.example;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println();
    }
    public void preOrderTraversal() {
        preOrderRecursive(root);
        System.out.println();
    }
    public void postOrderTraversal() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderRecursive(root.right);
        }
    }
    private void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }
    private void postOrderRecursive(TreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }
}

public class BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(12);
        bst.insert(2);
        bst.insert(45);
        bst.insert(11);
        bst.insert(23);
        bst.insert(1);
        bst.insert(9);
        bst.insert(4);

        System.out.println("Before Sorting :");

        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal();

        System.out.print("Pre-order Traversal: ");
        bst.preOrderTraversal();

        System.out.print("Post-order Traversal: ");
        bst.postOrderTraversal();
    }
}
