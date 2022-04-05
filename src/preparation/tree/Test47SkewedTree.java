package preparation.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test47SkewedTree
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree15();
        System.out.println(isSkewed(node));
        System.out.print(isSkewedIterative(node));
    }

    private static boolean isSkewedIterative(Node<Integer> node)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(node);
        Node temp = null;

        while (!q.isEmpty())
        {
            temp = q.poll();

            if (temp.left != null && temp.right != null)
            {
                return false;
            }
            if (temp.left != null)
            {
                q.add(temp.left);
            } else if (temp.right != null)
            {
                q.add(temp.right);
            }
        }
        return true;
    }

    /*
    if height of the tree equal to number of nodes, then the tree is skewed
     */
    private static AtomicInteger size = new AtomicInteger(0);

    private static boolean isSkewed(Node<Integer> node)
    {
        int height = findHeightOfTree(node, size);
        return height == size.get();
    }

    private static int findHeightOfTree(Node<Integer> node, AtomicInteger size)
    {
        if (node == null)
        {
            return 0;
        } else
        {
            size.incrementAndGet();
        }
        return 1 + Integer.max(findHeightOfTree(node.left, size),
            findHeightOfTree(node.right, size));
    }
}
