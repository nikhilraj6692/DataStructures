package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.Stack;

public class Test02PreorderTraversal {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree();

        preorderTraversal(root);

        System.out.println();

        preorderTraversalWithoutRecursion(root);
    }

    private static void preorderTraversalWithoutRecursion(Node<Integer> root) {
        Node temp = root;

        Stack<Node> stack = new Stack();

        stack.push(temp);
        while(!stack.isEmpty()){
            temp = stack.pop();
            System.out.print(temp.data + " ");

            if(temp.right!=null){
                stack.push(temp.right);
            }

            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    /*
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
    public static void preorderTraversal(Node<Integer> root) {
        Node temp = root;

        if(temp == null){
            return;
        }

        System.out.print(temp.data + " ");
        preorderTraversal(temp.left);
        preorderTraversal(temp.right);


    }
}
