package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

/*
a min heap is a heap which is a complete binary tree and its parent is smaller than its left node and right node
 */
public class Test35CheckIfTreeIsHeapOrNot {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree11();
        if (checkIfATreeIsMinHeap(root) == 0) {
            System.out.println("It is a min heap");
        } else {
            System.out.println("It is not a min heap");
        }

        System.out.println();

        if (checkIfATreeIsMinHeapRecursive(root, null)) {
            System.out.println("It is a min heap");
        } else {
            System.out.println("It is not a min heap");
        }

    }

    private static boolean checkIfATreeIsMinHeapRecursive(Node<Integer> node, Node<Integer> parent) {
        if(node == null){
            return true;
        }

        if(null!=parent && parent.data > node.data){
            return false;
        }

        if((node.left!=null && node.right ==null) || (node.right!=null && node.left ==null)){
            return false;
        }

        return checkIfATreeIsMinHeapRecursive(node.left, node) && checkIfATreeIsMinHeapRecursive(node.right, node);

    }

    private static int checkIfATreeIsMinHeap(Node<Integer> root) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);

        Node<Integer> temp = null;
        while(!q.isEmpty()){
            temp = q.poll();

            if((temp.left!=null && temp.right ==null) || (temp.right!=null && temp.left ==null)){
                return -1;
            }

            if(null!=temp.left){
                if(temp.data>temp.left.data)
                    return -1;
                q.add(temp.left);
            }

            if(null!=temp.right){
                if(temp.data>temp.right.data)
                    return -1;
                q.add(temp.right);
            }

        }
        return 0;
    }
}
