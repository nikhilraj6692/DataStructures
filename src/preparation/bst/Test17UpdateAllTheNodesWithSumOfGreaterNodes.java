package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

import java.util.concurrent.atomic.AtomicInteger;

public class Test17UpdateAllTheNodesWithSumOfGreaterNodes {
    public static void main(String[] args) {
        int[] keys = { 5, 3, 2, 4, 6, 8, 10 };

        /* Construct the following tree
                   5
                 /   \
                /     \
               3       8
              / \     / \
             /   \   /   \
            2     4 6    10
        */

        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);

        /*
        find sum in one iteration and then in another iteration, update the nodes with updated sum
         */
        int sum = findSum(root);

        /*either do via atomic or return sum in each recursion */
        AtomicInteger sumAtomic = new AtomicInteger(sum);
        updateBSTAtomic(root, sumAtomic);
        Test01InorderTraversal.inOrderTraversal(root);
        
        System.out.print("\n---------------------------\n");
        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        updateBST(root, sum);
        Test01InorderTraversal.inOrderTraversal(root);

        //2 3 4 5 6 8 10
        /*
        another technique can be to start from the rightest node (i.e. reverse inorder) and then keep on adding nodes in a variable
        and return that that variable. Add this variable to the root data. This will ensure that only one traversal is required
         */
        System.out.print("\n---------------------------\n");
        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        updateBSTReverseInorder(root, 0);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static int updateBSTReverseInorder(Node<Integer> root, int total_so_far) {
        if(root == null)
            return total_so_far;

        total_so_far = updateBSTReverseInorder(root.right, total_so_far);
        root.data = root.data + total_so_far;
        total_so_far = root.data;

        total_so_far = updateBSTReverseInorder(root.left, total_so_far);
        return total_so_far;
    }

    private static int updateBST(Node<Integer> root, int sum) {
        if(root == null)
            return sum;

        sum = updateBST(root.left, sum);
        int temp = root.data;
        root.data = sum;
        sum = sum - temp;

        sum =  updateBST(root.right, sum);

        return sum;
    }

    private static void updateBSTAtomic(Node<Integer> root, AtomicInteger sum) {
        if(root == null)
            return;

        updateBSTAtomic(root.left, sum);
        //sum is substracted so as to update new sum for next node
        int temp = root.data;
        root.data=sum.get();
        sum.set(sum.get() - temp);
        updateBSTAtomic(root.right, sum);

    }

    private static int findSum(Node<Integer> root) {
        if(root == null){
            return 0;
        }

        return root.data + findSum(root.left) + findSum(root.right);
    }
}
