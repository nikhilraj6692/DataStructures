package preparation.tree;

import preparation.util.Node;

public class Test28ConvertToTreeUsingPreorderAndBooleanArray
{

    public static void main(String[] args)
    {
        int[] preorder = {1, 2, 4, 5, 3, 6, 8, 9, 7};
        int[] isLeaf = {0, 0, 1, 1, 0, 0, 1, 1, 1};

        Node<Integer> node = constructTree(preorder, isLeaf);
        Test01InorderTraversal.inOrderTraversal(node);
        System.out.println();
        Test02PreorderTraversal.preorderTraversal(node);
    }

    private static int preOrderPointer = 0;

    private static Node<Integer> constructTree(int[] preorder, int[] isLeaf)
    {
        Node<Integer> node = new Node<>(preorder[preOrderPointer]);
        if (isLeaf[preOrderPointer] == 1)
        {
            return node;
        }
        preOrderPointer++;
        node.left = constructTree(preorder, isLeaf);
        preOrderPointer++;
        node.right = constructTree(preorder, isLeaf);

        return node;

    }
}
