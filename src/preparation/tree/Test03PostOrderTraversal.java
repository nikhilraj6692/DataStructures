package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.Stack;

public class Test03PostOrderTraversal {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree();

        postOrderWithRecursion(node);
        System.out.println();
        postOrderWithoutRecursionWithTwoStacks(node);
        System.out.println();
        postOrderWithoutRecursionWithOneStack(node);
    }

    /*
    check if the node is leaf node then pop it and print. If not, then if its left is not null, push to stack and make its left to null. Same with
    right node. It is done so that at each iteration, we dont have to go into loop and again push any left or right
     */
    private static void postOrderWithoutRecursionWithOneStack(Node<Integer> node) {
        Node<Integer> temp = null;
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            temp = stack.peek();
            if (isLeaf(temp)) {
                temp = stack.pop();
                System.out.print(temp.data + " ");
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    //null is needed because in backtracking, it will search for left and right which will go into
                    //endless loop.if the left and right is null, then it will just pop the value and print
                    temp.right = null;
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
    }

    private static boolean isLeaf(Node<Integer> temp) {
        return null != temp && null == temp.left && null == temp.right;
    }

    /*
     pop node and then push node data to out stack. check if node left is not null, then push node left to stack otherwise push node right to stack
     */
    private static void postOrderWithoutRecursionWithTwoStacks(Node<Integer> node) {
        Stack<Node> inStack = new Stack<>();
        Stack<Node> outStack = new Stack<>();
        Node<Integer> temp = null;
        inStack.push(node);
        while (!inStack.isEmpty()) {
            temp = inStack.pop();
            outStack.push(temp);

            if (temp.left != null) {
                inStack.push(temp.left);
            }
            if (temp.right != null) {
                inStack.push(temp.right);
            }
        }

        while (!outStack.isEmpty()) {
            System.out.print(outStack.pop().data + " ");
        }
    }

    private static void postOrderWithRecursion(Node<Integer> node) {
        if (null == node) {
            return;
        }
        postOrderWithRecursion(node.left);
        postOrderWithRecursion(node.right);
        System.out.print(node.data + " ");
    }
}
