package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test12ReconstructABSTWithNodesInAGivenRange
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        /* Construct the following tree
               15
             /    \
            /      \
           10       20
          / \      /  \
         /   \    /    \
        8    12 16     25
        */
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        root = truncate(root, 9, 12);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node<Integer> truncate(Node<Integer> root, int low, int high)
    {
        if (root == null)
        {
            return null;
        }

        root.left = truncate(root.left, low, high);
        root.right = truncate(root.right, low, high);

        if (root.data < low)
        {
            root = root.right;
        } else if (root.data > high)
        {
            root = root.left;
        }

        return root;
    }
}
