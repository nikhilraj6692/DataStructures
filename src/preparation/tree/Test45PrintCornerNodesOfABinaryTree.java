package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class Test45PrintCornerNodesOfABinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree13();
        printCornerNodes(root);
    }

    private static void printCornerNodes(Node<Integer> root) {
        Queue<Node<Integer>> q= new LinkedList<>();
        int i, size;
        Node temp = null;
        q.add(root);

        while(!q.isEmpty()){
            i=0;
            size = q.size();

            while(i<size){
                temp = q.poll();
                if(i==0 || i ==size-1){
                    System.out.print(temp.data + " ");
                }

                if(null!=temp.left)
                    q.add(temp.left);
                if(null!=temp.right)
                    q.add(temp.right);
                i++;
            }

            System.out.println();
        }
    }
}
