package preparation.tree;

import preparation.util.Node;

public class Test27ConvertToTreeFromInorderAndLevelorder {
    public static void main(String[] args) {
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] level    = { 1, 2, 3, 4, 5, 6, 7 };

        Node<Integer> node = convertToTree(inorder, level, 0 , inorder.length-1);

        Test01InorderTraversal.inOrderTraversal(node);
    }

    private static int levelNode = 0;

    private static Node<Integer> convertToTree(int[] inorder, int[] level, int start, int end) {
        if(start>end)
            return null;

        if(start==end)
            return new Node(inorder[start]);

        Node<Integer> node = new Node(level[levelNode++]);

        int index = searchInorder(inorder, start, end, node);
        node.left = convertToTree(inorder,level, start, index-1);
        node.right = convertToTree(inorder, level, index+1, end);
        return node;
    }

    private static int searchInorder(int[] inorder, int start, int end, Node<Integer> node) {
        for(int i = start; i<=end; i++){
            if(inorder[i] == node.data){
                return i;
            }
        }
        return -1;
    }
}
