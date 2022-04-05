package preparation.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test37SpiralOrderTraversal
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree3();
        traverseSpiral(node);
        System.out.println();
        Map<Integer, Deque<Integer>> map = new TreeMap<>();
        traverseRecursive(node, 0, map);
        map.values().stream().flatMap(val -> val.stream()).forEach(x -> System.out.print(x + " "));
    }

    private static void traverseRecursive(Node<Integer> node, int level,
        Map<Integer, Deque<Integer>> map)
    {
        if (node == null)
        {
            return;
        }

        if (level % 2 == 0)
        {
            map.computeIfAbsent(level, k -> new ArrayDeque<>()).addFirst(node.data);
        } else
        {
            map.computeIfAbsent(level, k -> new ArrayDeque<>()).addLast(node.data);
        }
        traverseRecursive(node.left, level + 1, map);
        traverseRecursive(node.right, level + 1, map);
    }

    private static void traverseSpiral(Node<Integer> node)
    {
        boolean spiral = false;
        Deque<Node<Integer>> dq = new ArrayDeque<>();
        dq.add(node);

        int i, size;
        Node temp = null;

        while (!dq.isEmpty())
        {
            if (spiral)
            {
                size = dq.size();
                i = 0;
                while (i++ < size)
                {
                    temp = dq.pollLast();
                    System.out.print(temp.data + " ");
                    if (null != temp.left)
                    {
                        dq.addFirst(temp.left);
                    }
                    if (null != temp.right)
                    {
                        dq.addFirst(temp.right);
                    }
                }
                spiral = false;
            } else
            {
                size = dq.size();
                i = 0;
                while (i++ < size)
                {
                    temp = dq.pollFirst();
                    System.out.print(temp.data + " ");

                    if (null != temp.right)
                    {
                        dq.addLast(temp.right);
                    }
                    if (null != temp.left)
                    {
                        dq.addLast(temp.left);
                    }
                }
                spiral = true;
            }
        }

    }
}
