package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.*;

public class Test39ReverseOrderTraversal {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree3();
        traverseReverse(node);
        System.out.println();
        Map<Integer, List<Node>> map = new TreeMap<>(Comparator.reverseOrder());
        traverseReverseWithHashing(map, 0, node);
        map.values().stream().flatMap(val-> val.stream()).forEach(x->System.out.print(x.data + " "));
        System.out.println();
        map = new TreeMap<>(Comparator.reverseOrder());
        traverseReverseWithRecursionAndHashing(map, 0, node);
        map.values().stream().flatMap(val-> val.stream()).forEach(x->System.out.print(x.data + " "));
    }

    private static void traverseReverseWithRecursionAndHashing(Map<Integer, List<Node>> map, int level, Node<Integer> node) {
        if(node==null)
            return;
        map.computeIfAbsent(level, k->new ArrayList<>()).add(node);
        traverseReverseWithRecursionAndHashing(map, level+1, node.left);
        traverseReverseWithRecursionAndHashing(map, level+1, node.right);
    }

    private static void traverseReverseWithHashing(Map<Integer, List<Node>> map, int level, Node<Integer> node) {
        Queue<Node<Integer>> q= new LinkedList<>();
        q.add(node);
        int i, size;

        Node temp = null;

        while(!q.isEmpty()){
            i=0;
            size=q.size();
            while(i++<size){
                temp = q.poll();
                map.computeIfAbsent(level, k->new ArrayList<>()).add(temp);
                if(null!=temp.left){
                    q.add(temp.left);
                }
                if(null!=temp.right){
                    q.add(temp.right);
                }

            }
            level++;


        }
    }

    private static void traverseReverse(Node<Integer> node) {
        Deque<Node<Integer>> dq = new ArrayDeque<>();
        Queue<Node<Integer>> q= new LinkedList<>();
        q.add(node);
        int i, size;

        Node temp = null;
        while(!q.isEmpty()){
            size = q.size();
            i=0;
            while(i++<size){
                temp = q.poll();
                dq.addLast(temp);

                if(null!=temp.right){
                    q.add(temp.right);
                }
                if(null!=temp.left){
                    q.add(temp.left);
                }

            }
        }

        while(!dq.isEmpty()){
            System.out.print(dq.pollLast().data + " ");
        }
    }
}
