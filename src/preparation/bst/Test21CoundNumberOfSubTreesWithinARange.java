package preparation.bst;

import preparation.util.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Test21CoundNumberOfSubTreesWithinARange {
    public static void main(String[] args) {
        int low = 5, high = 20;

        // BST keys to construct BST shown in the diagram
        int[] keys = { 15, 25, 20, 22, 30, 18, 10, 8, 9, 12, 6 };
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        AtomicInteger count = new AtomicInteger(0);
        countSubTreesWithinARange(root, count, low, high);
        System.out.print("Count is :: " + count.get());

        System.out.print("\n-----------------------------------\n");
        int subTreeCount = countSubTreesWithinARangeIterative(root, low, high);
        System.out.print("Count is :: " + subTreeCount);
    }

    private static int countSubTreesWithinARangeIterative(Node<Integer> root, int low, int high) {
        Node<Integer> curr = root;
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(curr);
        int count = 0;

        while(!q.isEmpty()){
            Node<Integer> temp = q.poll();
            boolean left = false, right = false;

            if(null==temp.left || (null!=temp.left && temp.left.data >=low && temp.left.data <=high))
                left = true;

            if(null!=temp.left)
                q.add(temp.left);

            if(null==temp.right || (null!=temp.right && temp.right.data >=low && temp.right.data <=high))
                right = true;

            if(null!=temp.right)
                q.add(temp.right);

            if(left && right && temp.data >=low && temp.data <=high)
                count++;
        }

        return count;
    }

    private static boolean countSubTreesWithinARange(Node<Integer> root, AtomicInteger count, int low, int high) {
        if(root == null)
            return true;

        if(countSubTreesWithinARange(root.left, count, low, high) && countSubTreesWithinARange(root.right, count, low, high)
            && root.data >=low && root.data <= high){
            count.incrementAndGet();
            return true;
        }

        return false;
    }
}
