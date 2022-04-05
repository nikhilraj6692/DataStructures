package preparation.bst;

import java.util.concurrent.atomic.AtomicInteger;
import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test20BuildBinaryTreeFromPostOrderTraversal
{

    public static void main(String[] args)
    {
        /* Construct the following BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */

        int[] postorder = {8, 12, 10, 16, 25, 20, 15};

        Node<Integer> root = buildTreeFromPostOrderArray(postorder, 0, postorder.length - 1);
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.print("\n------------------------------------\n");
        //above method would be of O(n^2) complexity
        AtomicInteger index = new AtomicInteger(postorder.length - 1);
        root = buildTreeUsingPostOrderArrayOptimized(postorder, index, Integer.MIN_VALUE,
            Integer.MAX_VALUE);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node<Integer> buildTreeUsingPostOrderArrayOptimized(int[] postorder,
        AtomicInteger index, int minValue, int maxValue)
    {
        if (index.get() == -1)
        {
            return null;
        }

        int val = postorder[index.get()];
        if (val < minValue || val > maxValue)
        {
            return null;
        }

        Node<Integer> root = new Node<>(val);
        index.decrementAndGet();

        root.right = buildTreeUsingPostOrderArrayOptimized(postorder, index, val + 1, maxValue);
        root.left = buildTreeUsingPostOrderArrayOptimized(postorder, index, minValue, val - 1);

        return root;
    }

    private static Node<Integer> buildTreeFromPostOrderArray(int[] postorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int curr = postorder[end];
        Node<Integer> root = new Node<>(curr);

        //search for ith element which is smaller than the root element
        int i;
        for (i = end; i >= start; i--)
        {
            if (postorder[i] < curr)
            {
                break;
            }
        }

        root.right = buildTreeFromPostOrderArray(postorder, i + 1, end - 1);
        root.left = buildTreeFromPostOrderArray(postorder, start, i);

        return root;
    }
}
