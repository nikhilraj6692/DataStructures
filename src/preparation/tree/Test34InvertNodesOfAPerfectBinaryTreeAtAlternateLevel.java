package preparation.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import preparation.util.Node;
import preparation.util.TreeBuilder;

//checkWithInorderMethodAlso
public class Test34InvertNodesOfAPerfectBinaryTreeAtAlternateLevel
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree10();
        invertAlternateNodesIterative(node);
        Test01InorderTraversal.inOrderTraversal(node);
        System.out.println();
        node = TreeBuilder.buildTree10();
        invertAlternateNodesRecursive(node);

        Test01InorderTraversal.inOrderTraversal(node);
    }

    private static void invertAlternateNodesRecursive(Node<Integer> node)
    {
        invertTree(node.left, node.right, true);
    }

    private static void invertTree(Node<Integer> first, Node<Integer> second, boolean invert)
    {
        if (first == null || second == null)
        {
            return;
        }
        if (invert)
        {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
        invertTree(first.left, second.right, !invert);
        invertTree(first.right, second.left, !invert);
    }

    private static void invertAlternateNodesIterative(Node<Integer> node)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        int i, size;
        Node<Integer> temp = null;
        boolean invert = false;
        Stack<Integer> stack = new Stack<>();
        Queue<Node<Integer>> nodeQueue = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty())
        {
            size = q.size();

            i = 0;
            while (i++ < size)
            {
                temp = q.poll();

                if (null != temp.left)
                {
                    q.add(temp.left);
                }
                if (null != temp.right)
                {
                    q.add(temp.right);
                }

                if (invert)
                {
                    stack.push(temp.data);
                    nodeQueue.add(temp);
                }

            }

            if (!invert)
            {
                invert = true;
            } else
            {
                while (!nodeQueue.isEmpty())
                {
                    Node n = nodeQueue.poll();
                    n.data = stack.pop();
                }
                invert = false;
            }
        }
    }

}
