package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.*;

public class Test40PrintTreeInASpecificOrder {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree10();
        Map<Integer, List<Node>> map = new TreeMap<>();;
        traverseInSpecificOrderWithHashing(map, 0, root);
        printMap(map);

        System.out.println();

        map = new TreeMap<>(Comparator.reverseOrder());
        traverseInSpecificOrderWithHashing(map, 0, root);
        printMap(map);

        System.out.println();

        map = new TreeMap<>(Comparator.reverseOrder());
        traverseInSpecificOrderWithRecursionAndHashing(map, 0, root);
        printMap(map);


    }

    private static void traverseInSpecificOrderWithRecursionAndHashing(Map<Integer, List<Node>> map, int level, Node<Integer> root) {
        if(root == null)
            return;
        map.computeIfAbsent(level, k->new ArrayList<>()).add(root);
        traverseInSpecificOrderWithRecursionAndHashing(map, level+1, root.left);
        traverseInSpecificOrderWithRecursionAndHashing(map, level+1, root.right);
    }

    private static void printMap(Map<Integer, List<Node>> map) {
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            List<Node> val = entry.getValue();
            int i = 0, j = val.size() - 1;

            while (i <= j) {
                if (i == j) {
                    System.out.print(val.get(i).data + " ");
                } else {
                    System.out.print(val.get(i).data + " " + val.get(j).data + " ");
                }
                i++;
                j--;
            }
        }
    }

    private static void traverseInSpecificOrderWithHashing(Map<Integer, List<Node>> map, int level, Node<Integer> node) {
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
}
