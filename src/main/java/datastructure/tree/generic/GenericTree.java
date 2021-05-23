package datastructure.tree.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTree {

    private Node root;
    private int size;

    private class Node {
        private int data;
        private List<Node> children = new ArrayList<>();

        Node(int data) {
            this.data = data;
        }
    }

    public GenericTree(int[] inputs) {
        Stack<Node> stack = new Stack<>();
        for(int i=0; i< inputs.length; i++) {
            if(inputs[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node(inputs[i]);
                size++;

                if(stack.size() > 0) {
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }
                stack.push(node);
            }
        }
    }

    public void display() {
        displayRecursively(root);
    }

    private void displayRecursively(final Node node) {
        String display = node.data + " -> ";
        for(Node child: node.children) {
            display += child.data + ", ";
        }
        display += ".";

        System.out.println(display);

        for(Node child: node.children) {
            displayRecursively(child);
        }
    }

    public int size() {
        return findSizeRecursively(root);
    }

    private int findSizeRecursively(final Node root) {
        int size = 0;
        for(Node child: root.children) {
            int childSize = findSizeRecursively(child);
            size += childSize;
        }
        size += 1;
        return size;
    }

    public int getSizeFromCached() {
        return size;
    }

    public int maxInTree() {
        return findMaxInTree(root);
    }

    private int findMaxInTree(Node root) {
        int max = Integer.MIN_VALUE;
        for(Node child: root.children) {
            int maxInChild = findMaxInTree(child);
            max = Math.max(max, maxInChild);
        }
        return Math.max(max, root.data);
    }

    public int height() {
       return heightOfTree(root);
    }

    private int heightOfTree(Node root) {
        int height = -1;
        for(Node child: root.children) {
            int childHeight = heightOfTree(child);
            height = Math.max(height, childHeight);
        }
        return height+1;
    }
}
