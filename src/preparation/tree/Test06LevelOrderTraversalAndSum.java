package preparation.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import preparation.util.Node;
import preparation.util.TreeBuilder;

/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             /      /   \
            /      /     \
           4      5       6
                 / \
                /   \
               7     8
       */
public class Test06LevelOrderTraversalAndSum
{

    public static void main(String[] args)
    {
        Node node = TreeBuilder.buildTree();
        traverseLevelWise(node);
        System.out.println();

    }

    public static void traverseLevelWise(Node<Integer> node)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Map<Node<Integer>, Integer> map = new HashMap<>();

        Node<Integer> temp = null;
        map.put(node, 0);
        int level = 0;
        int maxLevel = 0;
        while (!queue.isEmpty())
        {
            //map.put((temp = queue.poll()),level);
            temp = queue.poll();
            if (temp.left != null)
            {
                queue.add(temp.left);
                level = map.get(temp);
                map.put(temp.left, ++level);
            }
            if (temp.right != null)
            {
                queue.add(temp.right);
                level = map.get(temp);
                map.put(temp.right, ++level);
            }
            //maxLevel = Math.max(maxLevel, level);
        }

        int[] sum = new int[level + 1];
        for (Map.Entry<Node<Integer>, Integer> entry : map.entrySet())
        {
            sum[entry.getValue()] += entry.getKey().data;
        }
        Arrays.stream(sum).forEach(x -> System.out.print(x + " "));
    }
}
