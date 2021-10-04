package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test15ReplaceElementWithNextLeastGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6};
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(arr);
        Test01InorderTraversal.inOrderTraversal(root);
        System.out.print("\n---------------\n");
        int[] modifiedArr = replaceTheArrayWithNextLeastGreaterElement(arr);
        System.out.print(Arrays.toString(modifiedArr));
    }


    /*
    can be done by bst by constructing a bst and then find inorder successor of each element. However, in place inorder
    successor can also be found by iterating the array from the end and then replace it with its successor at the time of inserting into bst
     */
    private static int[] replaceTheArrayWithNextLeastGreaterElement(int[] arr) {
        Node<Integer> root = null;
        for(int i =arr.length-1; i>=0; i--){
            AtomicInteger successor = new AtomicInteger(-1);
            root = insertAndFindSuccessor(root, successor, arr[i]);
            arr[i] = successor.get();
        }
        return arr;
    }

    private static Node<Integer> insertAndFindSuccessor(Node<Integer> root, AtomicInteger successor, int val) {
        if(root == null)
            return new Node(val);

        if(val < root.data){
            successor.set(root.data);
            root.left = insertAndFindSuccessor(root.left, successor, val);
        }else if(val > root.data){
            root.right = insertAndFindSuccessor(root.right, successor, val);
        }

        return root;
    }
}
