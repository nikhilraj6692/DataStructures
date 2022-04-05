package preparation.tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test30FindMinimumDepthOfATree
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree8();
        System.out.println(findMinimumDepth(root));

    }

    private static int findMinimumDepth(Node<Integer> root)
    {
        Queue<Node> q = new LinkedList<>();
        Map<Node, Integer> map = new LinkedHashMap<>();
        q.add(root);
        map.put(root, 0);

        Node temp = null;
        int level = -1;
        while (!q.isEmpty())
        {
            temp = q.poll();
            level = map.get(temp);

            if (isLeaf(temp))
            {
                return (level + 1);
            }
            if (null != temp.left)
            {
                q.add(temp.left);
                map.put(temp.left, level + 1);
            }
            if (null != temp.right)
            {
                q.add(temp.right);
                map.put(temp.right, level + 1);
            }
        }
        return -1;
    }

    private static boolean isLeaf(Node temp)
    {
        return temp.left == null && temp.right == null;
    }
}
