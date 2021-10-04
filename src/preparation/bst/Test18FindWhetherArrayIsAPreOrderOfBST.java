package preparation.bst;

import preparation.util.Node;

import java.util.concurrent.atomic.AtomicInteger;

public class Test18FindWhetherArrayIsAPreOrderOfBST {
    public static void main(String[] args) {
        int[] seq = { 15, 10, 8, 12, 20, 16, 25 };

        //int[] seq = { 15, 10, 8, 12, 20, 16, 25 };

        /*
        construct tree and find preorder along with comparision with sequence. If it does not match then return false
         */
        Node<Integer> root= Test01InsertionInABST.supplyKeysAndCreateBST(seq);
        boolean isArrayAPreorderSequence = findIfArrayIsAPreorder(seq, root);
        System.out.print(isArrayAPreorderSequence? "Sequence is a preorder traversal of tree" : "Sequence is not a preorder" +
                "traversal of tree");

        System.out.print("\n-------------------------\n");
        //directly construct the preorder array
        AtomicInteger index = new AtomicInteger(0);
        Test19BuildBinaryTreeFromPreorderTraversal.buildTreeFromPreorderOptimizedWay(seq, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //if index is equal to seq.length, it means that all the nodes are traversed and it is in same order as preorder traversal
        System.out.print(seq.length == index.get()? "Sequence is a preorder traversal of tree" : "Sequence is not a preorder" +
                "traversal of tree");

    }

    private static int index = 0;
    private static boolean findIfArrayIsAPreorder(int[] seq, Node<Integer> root) {
        if(root == null)
            return true;

        if(seq[index++]!= root.data){
            return false;
        }

        return findIfArrayIsAPreorder(seq, root.left) && findIfArrayIsAPreorder(seq, root.right);
    }
}
