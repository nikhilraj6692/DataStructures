package preparation.bst;

import preparation.util.Node;
import preparation.util.Pair;

import java.util.*;

public class Test13FindPairInBSTWithGivenSum {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
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
        Set<Integer> set = new HashSet<>();
        List<Pair<Integer, Integer>> allPairs = new ArrayList<>();
        findAllPairsWithGivenSum(root, 28, set, allPairs);
        for(Pair<Integer,Integer> pair : allPairs) {
            System.out.println(pair.first + " " + pair.second);
        }

        System.out.print("------------------------------------------\n");

        set = new HashSet<>();
        Pair<Integer, Integer> pair = findSinglePairsWithGivenSum(root, 28, set);
        System.out.println(pair.first + " " + pair.second);

        System.out.print("------------------------------------------\n");

        pair = findSinglePairsWithGivenSumIterative(root, 28);
        System.out.println(pair.first + " " + pair.second);


    }

    private static Pair<Integer, Integer> findSinglePairsWithGivenSumIterative(Node<Integer> root, int sum) {
        Set<Integer> set = new HashSet<>();
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node<Integer> temp = q.poll();

            if(set.contains(temp.data)){
                return Pair.of(temp.data, sum - temp.data);
            }else{
                set.add(sum - temp.data);
            }

            if(null!=temp.left){
                q.add(temp.left);
            }
            if(null!=temp.right){
                q.add(temp.right);
            }
        }
        return Pair.of(-1, -1);
    }

    private static Pair<Integer, Integer> findSinglePairsWithGivenSum(Node<Integer> root, int sum, Set<Integer> set) {
        if(root == null)
        return Pair.of(-1, -1);

        if(set.contains(root.data)){
            return Pair.of(root.data, sum-root.data);
        }else{
            set.add(sum-root.data);
        }

        Pair<Integer,Integer> pair = findSinglePairsWithGivenSum(root.left, sum, set);
        if(pair.first + pair.second == sum)
            return pair;

        return findSinglePairsWithGivenSum(root.right, sum, set);
    }

    //[13, 18, 20, 16,  ]
    private static Pair<Integer, Integer> findAllPairsWithGivenSum(Node<Integer> root, int sum, Set<Integer> set, List<Pair<Integer, Integer>> allPairs) {
        if(null == root)
            return Pair.of(-1, -1);

        if(set.contains(root.data)){
            allPairs.add(Pair.of(root.data, sum-root.data));
        }else{
            set.add(sum-root.data);
        }

        findAllPairsWithGivenSum(root.left, sum, set, allPairs);

        return findAllPairsWithGivenSum(root.right, sum, set, allPairs);
    }
}
