package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

import java.util.Arrays;

public class Test05HeightBalanceATree {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        /* Construct the following tree
                   15
                 /    \
                /      \
               10       20
              /  \     /  \
             /    \   /    \
            8     12 16    25
        */
        //sort the keys to create a height balanced tree
        //8, 10, 12, 15, 16, 20, 25
        Arrays.sort(keys);

        //create a height balanced tree. its a kind of split and form left and right
        Node<Integer> root = convert(keys, 0, keys.length-1, null);

        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node<Integer> convert(int[] keys, int start, int end, Node<Integer> root) {
        if(start>end)
            return root;

        int mid = (start + end)/2;

        root = new Node(keys[mid]);
        root.left = convert(keys, start, mid-1, root.left);
        root.right = convert(keys, mid + 1, end, root.right);

        return root;
    }
}
