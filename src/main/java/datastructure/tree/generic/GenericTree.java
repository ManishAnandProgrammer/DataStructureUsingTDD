package datastructure.tree.generic;

import java.util.*;

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

    public void traverse() {
        traverseRecursively(root);
    }

    private void traverseRecursively(final Node node) {
        System.out.println("Node Pre :- " + node.data);
        for(Node child : node.children) {
            System.out.println("Edge Pre :- " + node.data + " - " + child.data);
            traverseRecursively(child);
            System.out.println("Edge Post :- " + node.data + " - " + child.data);
        }
        System.out.println("Node Post :- " + node.data);
    }

    public void levelOrderTraverse() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(queue.size() > 0) {
            Node node = queue.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children) {
                queue.add(child);
            }
        }

        System.out.println(" .");
    }

    public void levelOrderTraverseInLine() {
        Queue<Node> parentQueue = new ArrayDeque<>();
        parentQueue.add(root);

        Queue<Node> childQueue = new ArrayDeque<>();
        while(parentQueue.size() > 0) {
            Node node = parentQueue.remove();
            System.out.print(node.data + " ");

            for(Node child: node.children) {
                childQueue.add(child);
            }

            if(parentQueue.size() == 0) {
                parentQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public void levelOrderTraverseInLineZigZag() {
        Stack<Node> parentStack = new Stack<>();
        parentStack.push(root);

        Stack<Node> childStack = new Stack<>();
        int level = 1;
        while(parentStack.size() > 0) {
            Node node = parentStack.pop();
            System.out.print(node.data + " ");

            if(level % 2 == 1) {
                for(int i = 0; i < node.children.size(); i++) {
                    childStack.push(node.children.get(i));
                }
            } else {
                for(int i = node.children.size() - 1; i >= 0; i--) {
                    childStack.push(node.children.get(i));
                }
            }

            if(parentStack.size() == 0) {
                parentStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
}
