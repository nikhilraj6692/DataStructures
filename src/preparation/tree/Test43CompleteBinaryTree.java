package preparation.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test43CompleteBinaryTree
{

    private static int count = 0;

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree3();
        System.out.println(checkIfCompleteBinaryTree(root));
        System.out.println();
        findTotalNumberOfNodes(root);
        int[] arr = new int[count];
        checkIfCompleteBinaryTreeWithArrayRepresentation(root, 0, arr);
        System.out.println(Arrays.stream(arr).allMatch(x -> x != 0));
    }

    private static void findTotalNumberOfNodes(Node<Integer> root)
    {
        if (root == null)
        {
            return;
        }
        count++;
        findTotalNumberOfNodes(root.left);
        findTotalNumberOfNodes(root.right);
    }

    private static void checkIfCompleteBinaryTreeWithArrayRepresentation(Node<Integer> root, int i,
        int[] arr)
    {
        if (root == null)
        {
            return;
        }
        arr[i] = root.data;
        checkIfCompleteBinaryTreeWithArrayRepresentation(root.left, 2 * i + 1, arr);
        checkIfCompleteBinaryTreeWithArrayRepresentation(root.right, 2 * i + 2, arr);
    }

    private static boolean checkIfCompleteBinaryTree(Node<Integer> root)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        boolean nullFound = false;

        Node temp = null;
        while (!q.isEmpty())
        {
            temp = q.poll();

            if (nullFound && (temp.left != null || temp.right != null))
            {
                return false;
            }
            if (null == temp.left && null != temp.right)
            {
                return false;
            }
            if (null != temp.left && null == temp.right)
            {
                nullFound = true;
            }
            if (null != temp.left)
            {
                q.add(temp.left);
            }
            if (null != temp.right)
            {
                q.add(temp.right);
            }


        }
        return true;
    }
}
