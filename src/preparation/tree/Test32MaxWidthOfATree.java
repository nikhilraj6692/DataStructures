package preparation.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test32MaxWidthOfATree
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree3();
        System.out.print(findMaxWidth(root));
        System.out.println();
        Map<Integer, Integer> map = new TreeMap<>();
        findMaxRootRecursive(root, map, 0);
        System.out.println(map.values().toArray()[map.values().size() - 1]);
    }

    private static void findMaxRootRecursive(Node<Integer> root, Map<Integer, Integer> map,
        int level)
    {
        if (null != root)
        {
            int numberOfNodesAtALevel = map.getOrDefault(level, 0);
            map.put(level, ++numberOfNodesAtALevel);
            findMaxRootRecursive(root.left, map, level + 1);
            findMaxRootRecursive(root.right, map, level + 1);
        }
    }

    private static int findMaxWidth(Node<Integer> root)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);

        int max = Integer.MIN_VALUE, i, size;
        Node<Integer> temp = null;
        while (!q.isEmpty())
        {
            size = q.size();
            i = 0;

            while (i < size)
            {
                temp = q.poll();
                if (max < size)
                {
                    max = size;
                }
                if (null != temp.left)
                {
                    q.add(temp.left);
                }
                if (null != temp.right)
                {
                    q.add(temp.right);
                }
                i++;
            }
        }
        return max;
    }
}

