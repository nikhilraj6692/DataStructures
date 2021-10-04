package preparation.tree;

import preparation.util.Node;

import java.util.Stack;

public class Test26ConvertToTreeFromInorderAndPostOrder {
    private static int postIndex = 0;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };
        postIndex = inorder.length-1;
        Node<Integer> node = constructTree(inorder, postorder, 0, inorder.length-1);
        Test01InorderTraversal.inOrderTraversal(node);
        System.out.println();
        Test02PreorderTraversal.preorderTraversal(node);
        System.out.println();
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }

    }

    private static Node<Integer> constructTree(int[] inorder, int[] postorder, int start, int end) {
        if(end<start){
            return null;
        }

        Node<Integer> node = new Node(postorder[postIndex--]);
        if(start == end) {
            stack.push(node.data);
            return node;
        }

        int index = search(inorder, node.data);
        node.right = constructTree(inorder, postorder, index+1, end);
        node.left = constructTree(inorder, postorder, start, index-1);
        stack.push(node.data);
        return node;

    }

    private static int search(int[] inorder, Integer data) {
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == data){
                return i;
            }
        }
        return -1;
    }
}
