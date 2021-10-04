package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

/*
a sum tree is what we did in test08
 */
public class Test11CheckIfBinaryTreeIsASumTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree4();

        float check = checkIfBinaryTreeIsASumTree(root);

        if(check==root.data){
            System.out.println("Its a sum tree");
        }else{
            System.out.println("Its not a sum tree");
        }

        int data =checkIfBinaryTreeIsASumTree1(root);

        if(data==root.data*2){
            System.out.println("Its a sum tree");
        }else{
            System.out.println("Its not a sum tree");
        }
    }

    private static float checkIfBinaryTreeIsASumTree(Node<Integer> root) {
        if(null==root){
            return 0;
        }

        if(root.left==null && root.right==null) {
            return root.data/2;
        }
        else if( checkIfBinaryTreeIsASumTree(root.left) + checkIfBinaryTreeIsASumTree(root.right) == root.data/2){
            return root.data;
        }else{
            return 0;
        }

    }

    private static int checkIfBinaryTreeIsASumTree1(Node<Integer> root) {
        if(null==root){
            return 0;
        }

        int data = root.data;

        int sum = checkIfBinaryTreeIsASumTree1(root.left) + checkIfBinaryTreeIsASumTree1(root.right);

        if(isLeafNode(root)){
            return data;
        }else{
            return sum+data;
        }

    }

    private static boolean isLeafNode(Node<Integer> root) {
        return root.left==null && root.right==null;
    }
}
