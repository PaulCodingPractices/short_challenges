package org.example.DataStructuresImplementation;


    public class BinaryTree<T> {
        private TreeNode<T> root;

        public BinaryTree() {
            root = null;
        }

        public void add(T value) {
            if (root == null) {
                root = new TreeNode<>(value);
            } else {
                add(root, value);
            }
        }

        private void add(TreeNode<T> node, T value) {
            if (node.left == null) {
                node.left = new TreeNode<>(value);
            } else if (node.right == null) {
                node.right = new TreeNode<>(value);
            } else {
                // recursively add to the left or right subtree
                if (Math.random() < 0.5) {
                    add(node.left, value);
                } else {
                    add(node.right, value);
                }
            }
        }

        public boolean contains(T value) {
            return contains(root, value);
        }

        private boolean contains(TreeNode<T> node, T value) {
            if (node == null) {
                return false;
            } else if (node.value.equals(value)) {
                return true;
            } else {
                return contains(node.left, value) || contains(node.right, value);
            }
        }

        public void remove(T value) {
            root = remove(root, value);
        }

        private TreeNode<T> remove(TreeNode<T> node, T value) {
            if (node == null) {
                return null;
            } else if (node.value.equals(value)) {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    // find the smallest value in the right subtree
                    TreeNode<T> minRight = node.right;
                    while (minRight.left != null) {
                        minRight = minRight.left;
                    }
                    // replace the node's value with the smallest value
                    node.value = minRight.value;
                    // remove the smallest value from the right subtree
                    node.right = remove(node.right, minRight.value);
                    return node;
                }
            } else {
                node.left = remove(node.left, value);
                node.right = remove(node.right, value);
                return node;
            }
        }

        private static class TreeNode<T> {
            private T value;
            private TreeNode<T> left;
            private TreeNode<T> right;

            public TreeNode(T value) {
                this.value = value;
                left = null;
                right = null;
            }
        }
    }

