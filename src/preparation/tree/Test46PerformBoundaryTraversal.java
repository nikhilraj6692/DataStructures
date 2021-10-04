package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test46PerformBoundaryTraversal {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree14();
        performBoundaryTraversal(root);
    }

    /*
    divide into three parts: print left boundary, print right boundary and print leaves
     */
    private static void performBoundaryTraversal(Node<Integer> root) {
        if(null==root){
            return;
        }
        System.out.print(root.data + " ");

        printLeftBoundary(root.left);

        printLeaves(root);

        printRightBoundary(root.right);

    }

    private static void printLeaves(Node<Integer> node) {
        if(node == null)
            return;

        printLeaves(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    private static void printRightBoundary(Node<Integer> node) {
        if(node == null)
            return;

        if(node.right!=null){
            //bottom-up
            printRightBoundary(node.right);
            System.out.print(node.data + " ");
        }else if(node.left!=null){
            printRightBoundary(node.left);
            System.out.print(node.data + " ");
        }
    }

    private static void printLeftBoundary(Node<Integer> node) {
        if(node == null)
            return;

        if(node.left!=null){
            //top-down
            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        }else if(node.right!=null){
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }

    }

    private static boolean leaf(Node<Integer> node) {
        return node.left == null && node.right == null;
    }
}
