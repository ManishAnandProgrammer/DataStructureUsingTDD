package datastructure.tree.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GenericTreeTest {

    @Test
    void displayTree() {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        GenericTree tree = new GenericTree(arr);

        tree.display();
    }

    @Test
    @DisplayName("Size Recursive")
    void sizeOfTree() {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        GenericTree tree = new GenericTree(arr);

        Assertions.assertEquals(12, tree.size());
    }

    @Test
    void cachedSizeAndRecursiveSizeShouldBeSame() {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        GenericTree tree = new GenericTree(arr);

        Assertions.assertEquals(tree.getSizeFromCached(), tree.size());
    }

    @Test
    void max() {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        GenericTree tree = new GenericTree(arr);

        Assertions.assertEquals(120, tree.maxInTree());
    }
}
