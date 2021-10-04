package preparation.tree;

import preparation.util.Node;
import preparation.util.Pair;
import preparation.util.TreeBuilder;

import java.util.*;

public class Test33VerticalTraversalOfTree {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree9();
        traverseVertically(node);
        System.out.println();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        traverseVerticallyRecursively(node, map, 0);
        System.out.print(map.values());
    }

    private static void traverseVerticallyRecursively(Node<Integer> node, Map<Integer, List<Integer>> map, int hd) {
        if(null!=node){
            map.computeIfAbsent(hd, k-> new ArrayList<>()).add(node.data);
            traverseVerticallyRecursively(node.left, map, hd - 1 );
            traverseVerticallyRecursively(node.right, map, hd + 1 );
        }
    }

    private static void traverseVertically(Node<Integer> node) {
        Queue<Pair<Node<Integer>,Integer>> q = new LinkedList<>();
        q.add(Pair.of(node,0));
        int i, size;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(node.data)));
        Pair<Node<Integer>, Integer> pair = null;
        Node temp =null;
        int hd = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            pair = q.poll();
            temp = pair.first;
            hd = pair.second;

            if(temp.left!=null){
                q.add(Pair.of(temp.left, hd-1));
                putIntoMap(map, hd-1, temp.left);
            }

            if(temp.right!=null){
                q.add(Pair.of(temp.right, hd+1));
                putIntoMap(map, hd+1, temp.right);
            }
        }

        System.out.print(map.values());

    }

    private static void putIntoMap(Map<Integer, List<Integer>> map, int hd, Node<Integer> temp) {
        map.computeIfAbsent(hd, k->new ArrayList<>()).add(temp.data);
    }
}
