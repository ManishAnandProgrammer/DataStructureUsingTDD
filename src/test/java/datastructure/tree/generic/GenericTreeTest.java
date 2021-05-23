package datastructure.tree.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericTreeTest {

    private GenericTree tree;

    @BeforeEach
    void init() {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        tree = new GenericTree(arr);
    }

    @Test
    void displayTree() {
        tree.display();
    }

    @Test
    @DisplayName("Size Recursive")
    void sizeOfTree() {
        assertEquals(12, tree.size());
    }

    @Test
    void cachedSizeAndRecursiveSizeShouldBeSame() {
        assertEquals(tree.getSizeFromCached(), tree.size());
    }

    @Test
    void max() {
        assertEquals(120, tree.maxInTree());
    }

    @Test
    void heightTest() {
        assertEquals(3, tree.height());
    }

    @Test
    void traverse() {
        tree.traverse();
    }

    @Test
    void levelOrderTraverse() {
        tree.levelOrderTraverse();
    }

    @Test
    void levelOrderTraverseInLine() {
        tree.levelOrderTraverseInLine();
    }

    @Test
    void levelOrderTraverseInLineZigZag() {
        tree.levelOrderTraverseInLineZigZag();
    }

    @Test
    void levelOrderTraverseWithoutSecondQueue() {
        tree.levelOrderTraverseWithoutSecondQueue();
    }

    @Test
    void levelOrderTraverseUsingCounter() {
        tree.levelOrderTraverseUsingCounter();
    }

    @Test
    void levelOrderTraverseUsingPairClass() {
        tree.levelOrderTraverseUsingPairClass();
    }

    @Test
    void mirror() {
        tree.mirror();
    }
}
