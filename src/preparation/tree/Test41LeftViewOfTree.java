package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Test41LeftViewOfTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree2();
        printLeftViewOfTree(root);
        System.out.println();
        Map<Integer, Node<Integer>> map =new TreeMap<>();
        printLeftViewOfTreeWithRecursion(root, 0, map);
        map.values().stream().flatMap(x-> Stream.of(x)).forEach(x->System.out.print(x.data + " "));
    }

    private static void printLeftViewOfTreeWithRecursion(Node<Integer> root, int level, Map<Integer, Node<Integer>> map) {
        if(null==root)
            return;
        map.putIfAbsent(level, root);
        printLeftViewOfTreeWithRecursion(root.left, level+1, map);
        printLeftViewOfTreeWithRecursion(root.right, level+1, map);
    }

    private static void printLeftViewOfTree(Node<Integer> root) {
        Queue<Node<Integer>> q= new LinkedList<>();
        q.add(root);
        int i,size;
        Node<Integer> temp = null;

        while(!q.isEmpty()){
            i=0;
            size = q.size();
            while(i<size){
                temp = q.poll();

                if(i==0){
                    System.out.print(temp.data +  " ");
                }
                if(null!=temp.left)
                    q.add(temp.left);
                if(null!=temp.right)
                    q.add(temp.right);

                i++;
            }
        }
    }
}
