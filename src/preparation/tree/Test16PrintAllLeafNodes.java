package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test16PrintAllLeafNodes {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree6();

        printAllTheLeafNodes(root);
    }

    private static void printAllTheLeafNodes(Node<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node<Integer> temp = null;
        while(!q.isEmpty()){
            temp = q.poll();

            if(null==temp.left && null==temp.right){
                list.add(temp.data);
            }else{
                if(null!=temp.left){
                    q.add(temp.left);
                }
                if(null!=temp.right){
                    q.add(temp.right);
                }
            }


        }

        list.stream().forEach(e-> System.out.print(e + " "));
    }
}
