/*
 * Trees.java
 *
 * This file contains Java implementations of various tree data structures and operations
 * without using any built-in functions. Each section is thoroughly commented
 * to explain each step and logic behind the tree operations.
 *
 */

public class Trees {
    
    // Tree Node class for binary trees
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        // Constructor to create a new node
        TreeNode(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
    
    // Binary Search Tree class
    static class BinarySearchTree {
        TreeNode root;
        
        // Constructor to initialize empty BST
        BinarySearchTree() {
            this.root = null;
        }
        
        // Insert a new value into the BST
        public void insert(int value) {
            root = insertRec(root, value);
        }
        
        // Recursive helper method to insert a value
        private TreeNode insertRec(TreeNode node, int value) {
            // Base case: if node is null, create new node
            if (node == null) {
                return new TreeNode(value);
            }
            
            // If value is less than current node, go left
            if (value < node.data) {
                node.left = insertRec(node.left, value);
            }
            // If value is greater than current node, go right
            else if (value > node.data) {
                node.right = insertRec(node.right, value);
            }
            
            // Return the unchanged node pointer
            return node;
        }
        
        // Search for a value in the BST
        public boolean search(int value) {
            return searchRec(root, value);
        }
        
        // Recursive helper method to search for a value
        private boolean searchRec(TreeNode node, int value) {
            // Base case: if node is null, value not found
            if (node == null) {
                return false;
            }
            
            // If value matches current node, found
            if (value == node.data) {
                return true;
            }
            
            // If value is less than current node, search left
            if (value < node.data) {
                return searchRec(node.left, value);
            }
            // If value is greater than current node, search right
            else {
                return searchRec(node.right, value);
            }
        }
        
        // Delete a value from the BST
        public void delete(int value) {
            root = deleteRec(root, value);
        }
        
        // Recursive helper method to delete a value
        private TreeNode deleteRec(TreeNode node, int value) {
            // Base case: if node is null, value not found
            if (node == null) {
                return null;
            }
            
            // If value is less than current node, go left
            if (value < node.data) {
                node.left = deleteRec(node.left, value);
            }
            // If value is greater than current node, go right
            else if (value > node.data) {
                node.right = deleteRec(node.right, value);
            }
            // If value matches current node, this is the node to delete
            else {
                // Case 1: Node has no children (leaf node)
                if (node.left == null && node.right == null) {
                    return null;
                }
                // Case 2: Node has one child
                else if (node.left == null) {
                    return node.right;
                }
                else if (node.right == null) {
                    return node.left;
                }
                // Case 3: Node has two children
                else {
                    // Find inorder successor (smallest value in right subtree)
                    TreeNode successor = findMin(node.right);
                    // Replace node's data with successor's data
                    node.data = successor.data;
                    // Delete the successor
                    node.right = deleteRec(node.right, successor.data);
                }
            }
            
            return node;
        }
        
        // Find minimum value in a subtree
        private TreeNode findMin(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        
        // Find maximum value in a subtree
        private TreeNode findMax(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
        
        // Calculate height of the tree
        public int height() {
            return heightRec(root);
        }
        
        // Recursive helper method to calculate height
        private int heightRec(TreeNode node) {
            // Base case: if node is null, height is -1
            if (node == null) {
                return -1;
            }
            
            // Calculate height of left and right subtrees
            int leftHeight = heightRec(node.left);
            int rightHeight = heightRec(node.right);
            
            // Return maximum height plus 1 for current node
            return Math.max(leftHeight, rightHeight) + 1;
        }
        
        // Count total number of nodes
        public int countNodes() {
            return countNodesRec(root);
        }
        
        // Recursive helper method to count nodes
        private int countNodesRec(TreeNode node) {
            // Base case: if node is null, count is 0
            if (node == null) {
                return 0;
            }
            
            // Count current node + left subtree + right subtree
            return 1 + countNodesRec(node.left) + countNodesRec(node.right);
        }
        
        // In-order traversal (Left → Root → Right)
        public void inorderTraversal() {
            System.out.print("Inorder: ");
            inorderRec(root);
            System.out.println();
        }
        
        // Recursive helper method for in-order traversal
        private void inorderRec(TreeNode node) {
            if (node != null) {
                inorderRec(node.left);    // Visit left subtree
                System.out.print(node.data + " ");  // Visit root
                inorderRec(node.right);   // Visit right subtree
            }
        }
        
        // Pre-order traversal (Root → Left → Right)
        public void preorderTraversal() {
            System.out.print("Preorder: ");
            preorderRec(root);
            System.out.println();
        }
        
        // Recursive helper method for pre-order traversal
        private void preorderRec(TreeNode node) {
            if (node != null) {
                System.out.print(node.data + " ");  // Visit root
                preorderRec(node.left);   // Visit left subtree
                preorderRec(node.right);  // Visit right subtree
            }
        }
        
        // Post-order traversal (Left → Right → Root)
        public void postorderTraversal() {
            System.out.print("Postorder: ");
            postorderRec(root);
            System.out.println();
        }
        
        // Recursive helper method for post-order traversal
        private void postorderRec(TreeNode node) {
            if (node != null) {
                postorderRec(node.left);  // Visit left subtree
                postorderRec(node.right); // Visit right subtree
                System.out.print(node.data + " ");  // Visit root
            }
        }
        
        // Level-order traversal (breadth-first)
        public void levelorderTraversal() {
            System.out.print("Levelorder: ");
            int height = height();
            for (int i = 0; i <= height; i++) {
                printLevel(root, i);
            }
            System.out.println();
        }
        
        // Helper method to print nodes at a specific level
        private void printLevel(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            
            if (level == 0) {
                System.out.print(node.data + " ");
            } else {
                printLevel(node.left, level - 1);
                printLevel(node.right, level - 1);
            }
        }
        
        // Check if tree is balanced
        public boolean isBalanced() {
            return isBalancedRec(root) != -1;
        }
        
        // Recursive helper method to check if tree is balanced
        private int isBalancedRec(TreeNode node) {
            // Base case: if node is null, height is 0
            if (node == null) {
                return 0;
            }
            
            // Check if left subtree is balanced
            int leftHeight = isBalancedRec(node.left);
            if (leftHeight == -1) {
                return -1;
            }
            
            // Check if right subtree is balanced
            int rightHeight = isBalancedRec(node.right);
            if (rightHeight == -1) {
                return -1;
            }
            
            // Check if current node is balanced
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            
            // Return height of current node
            return Math.max(leftHeight, rightHeight) + 1;
        }
        
        // Mirror/Invert the tree
        public void mirror() {
            mirrorRec(root);
        }
        
        // Recursive helper method to mirror the tree
        private void mirrorRec(TreeNode node) {
            if (node == null) {
                return;
            }
            
            // Swap left and right children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            // Recursively mirror left and right subtrees
            mirrorRec(node.left);
            mirrorRec(node.right);
        }
    }
    
    // Main method to test the tree operations
    public static void main(String[] args) {
        // Create a new Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        // Test traversals
        bst.inorderTraversal();
        bst.preorderTraversal();
        bst.postorderTraversal();
        bst.levelorderTraversal();
        
        // Test search
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));
        
        // Test tree properties
        System.out.println("Height: " + bst.height());
        System.out.println("Node count: " + bst.countNodes());
        System.out.println("Is balanced: " + bst.isBalanced());
        
        // Test deletion
        bst.delete(20);
        System.out.println("After deleting 20:");
        bst.inorderTraversal();
        
        // Test mirror
        bst.mirror();
        System.out.println("After mirroring:");
        bst.inorderTraversal();
    }
}
