package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.concurrent.atomic.AtomicInteger;

/*
can be done easily using hashing with and without recursion...same examples as previous ones
 this one is with recursion and without hashing
 */
public class Test42FindNextNodeAtSameLevel {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree12();
        AtomicInteger in = new AtomicInteger(-1);
        System.out.println(findNextNode(root,5, in, 0));
    }

    private static int findNextNode(Node<Integer> root, int data, AtomicInteger in, int level) {
        if(root == null)
            return -1;
        if(data == root.data){
            in.set(level);
            return -1;
        }
        if(in.get()!=-1 && level == in.get()){
            return root.data;
        }
        int left=findNextNode(root.left, data, in, level+1);

        if(left!=-1){
            return left;
        }
        int right=findNextNode(root.right, data, in, level+1);
        return right;
    }

}
