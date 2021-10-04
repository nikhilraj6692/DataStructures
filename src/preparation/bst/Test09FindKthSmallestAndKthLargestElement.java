package preparation.bst;


import preparation.util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

//8 10 12 15 16 20 25
public class Test09FindKthSmallestAndKthLargestElement {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        int k = 2;
        List<Integer> finalList = new ArrayList<>();
        kthWithExtraSpace(root, finalList);
        System.out.println("Smallest " + k + "th element :: " + finalList.get(k-1));
        System.out.println("Largest " + k + "th element :: " + finalList.get(finalList.size()-k));

        System.out.print("\n---------------------------\n");
        int smallest = kthSmallestIterative(root, k);
        System.out.println("Smallest " + k + "th element :: " + smallest);

        int largest = kthLargestIterative(root, k);
        System.out.println("Largest " + k + "th element :: " + largest);

        System.out.print("\n---------------------------\n");
        AtomicInteger nodeCount = new AtomicInteger(0);
        smallest = kthSmallestRecursive(root, k, nodeCount);
        System.out.println("Smallest " + k + "th element :: " + smallest);

        nodeCount = new AtomicInteger(0);
        largest = kthLargestRecursive(root, k, nodeCount);
        System.out.println("Largest " + k + "th element :: " + largest);
    }

    private static int kthLargestRecursive(Node<Integer> root, int k, AtomicInteger nodeCount) {
        if(root == null)
            return -1;

        int right = kthLargestRecursive(root.right, k, nodeCount);

        /*
        as soon as node is found, then return the node from right subtree..as we have to break, so using this condition
         */
        if(right!=-1)
            return right;

        if(nodeCount.incrementAndGet() == k)
            return root.data;

        return kthLargestRecursive(root.left, k, nodeCount);
    }

    private static int kthSmallestRecursive(Node<Integer> root, int k, AtomicInteger nodeCount) {
        if(root == null)
            return -1;

        int left = kthSmallestRecursive(root.left, k, nodeCount);

        /*
        as soon as node is found, then return the node from left subtree..as we have to break, so using this condition
         */
        if(left!=-1)
            return left;

        if(nodeCount.incrementAndGet() == k){
            return root.data;
        }

        return kthSmallestRecursive(root.right, k, nodeCount);
    }

    private static int kthLargestIterative(Node<Integer> root, int k) {
        Node<Integer> curr = root;
        Stack<Node<Integer>> st = new Stack<>();

        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.right;
            }

            curr = st.pop();
            if(--k==0){
                return curr.data;
            }

            curr = curr.left;
        }

        return -1;
    }

    /*
    this method keeps a count of visited kth element. As soon as k becomes 0, return the element
     */
    private static int kthSmallestIterative(Node<Integer> root, int k) {
        Stack<Node<Integer>> st = new Stack<>();
        Node<Integer> curr = root;

        while(curr!=null || !st.isEmpty()){
            while(null!=curr){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            if(--k == 0){
               return curr.data;
            }

            curr = curr.right;
        }

        return -1;
    }

    /*
    this method takes extra space as list which has ordered data and then print kth smallest and largest element
     */
    private static void kthWithExtraSpace(Node<Integer> root, List<Integer> list) {
        if(root == null)
            return;
        kthWithExtraSpace(root.left, list);
        list.add(root.data);
        kthWithExtraSpace(root.right, list);
    }
}
