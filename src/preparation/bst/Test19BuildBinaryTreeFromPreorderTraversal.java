package preparation.bst;

import java.util.concurrent.atomic.AtomicInteger;
import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test19BuildBinaryTreeFromPreorderTraversal
{

    public static void main(String[] args)
    {
        int[] preorder = {15, 10, 8, 12, 20, 16, 25};
        Node<Integer> root = buildTreeFromPreorder(preorder, 0, preorder.length);
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.print("\n-----------------------------------------\n");
        root = buildTreeFromPreorderSecondWay(preorder, 0, preorder.length - 1);
        Test01InorderTraversal.inOrderTraversal(root);

        //both the above ways have o(n^2) complexity. below method has O(n) complexity
        preorder = new int[]{15, 10, 8, 14, 20, 16, 25};
        System.out.print("\n-----------------------------------------\n");
        AtomicInteger index = new AtomicInteger(0);
        root = buildTreeFromPreorderOptimizedWay(preorder, index, Integer.MIN_VALUE,
            Integer.MAX_VALUE);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    public static Node<Integer> buildTreeFromPreorderOptimizedWay(int[] preorder,
        AtomicInteger index, int minValue, int maxValue)
    {
        if (index.get() == preorder.length)
        {
            return null;
        }

        int val = preorder[index.get()];
        if (val < minValue || val > maxValue)
        {
            return null;
        }

        Node<Integer> root = new Node<>(val);
        index.incrementAndGet();

        root.left = buildTreeFromPreorderOptimizedWay(preorder, index, minValue, val - 1);
        root.right = buildTreeFromPreorderOptimizedWay(preorder, index, val + 1, maxValue);
        return root;
    }

    private static Node<Integer> buildTreeFromPreorderSecondWay(int[] preorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        Node<Integer> root = new Node<>(preorder[start]);

        //i is nothing but the index till which left subtree exists
        int i;
        for (i = start; i <= end; i++)
        {
            if (preorder[i] > root.data)
            {
                break;
            }
        }

        root.left = buildTreeFromPreorderSecondWay(preorder, start + 1, i - 1);
        root.right = buildTreeFromPreorderSecondWay(preorder, i, end);

        return root;
    }

    private static Node<Integer> buildTreeFromPreorder(int[] preorder, int start, int end)
    {
        if (start == end)
        {
            return null;
        }
        //first node would be a root node
        Node<Integer> root = new Node(preorder[start]);

        //build left and right nodes array from i=start+1 and then form root.left and root.right
        int[] leftSubTree = new int[end];
        int[] rightSubTree = new int[end];
        int l = 0, r = 0;

        for (int i = start + 1; i < end; i++)
        {
            if (preorder[i] < preorder[start])
            {
                leftSubTree[l++] = preorder[i];
            } else if (preorder[i] > preorder[start])
            {
                rightSubTree[r++] = preorder[i];
            }
        }

        //call root.left and root.right recursively from the array formed
        root.left = buildTreeFromPreorder(leftSubTree, 0, l);
        root.right = buildTreeFromPreorder(rightSubTree, 0, r);
        return root;
    }
}
