package preparation.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test36LevelOrderTraversal
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree3();
        traverseLevelWise(node);
        System.out.println();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        traverseLevelWiseUsingRecursion(map, 0, node);
        map.values().stream().flatMap(val -> val.stream()).forEach(x -> System.out.print(x + " "));

    }

    private static void traverseLevelWiseUsingRecursion(Map<Integer, List<Integer>> map, int level,
        Node<Integer> node)
    {
        if (node == null)
        {
            return;
        }

        map.computeIfAbsent(level, k -> new ArrayList<>()).add(node.data);
        traverseLevelWiseUsingRecursion(map, level + 1, node.left);
        traverseLevelWiseUsingRecursion(map, level + 1, node.right);
    }

    private static void traverseLevelWise(Node<Integer> node)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(node);

        Node temp = null;
        while (!q.isEmpty())
        {
            temp = q.poll();
            System.out.print(temp.data + " ");

            if (null != temp.left)
            {
                q.add(temp.left);
            }
            if (null != temp.right)
            {
                q.add(temp.right);
            }


        }
    }
}
