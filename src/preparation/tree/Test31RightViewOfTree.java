package preparation.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test31RightViewOfTree
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree2();
        findRightViewOfTreeIterative(root);
        System.out.println();
        Map<Integer, Node> map = new TreeMap<>();
        map.put(0, root);
        findRightViewOfTreeRecoursive(root, map, 0);
        map.entrySet().stream().forEach(x -> System.out.print(x.getValue().data + " "));
    }

    private static void findRightViewOfTreeRecoursive(Node<Integer> root, Map<Integer, Node> map,
        int level)
    {
        if (null != root)
        {
            map.put(level, root);
            findRightViewOfTreeRecoursive(root.left, map, level + 1);
            findRightViewOfTreeRecoursive(root.right, map, level + 1);

        }
    }

    private static boolean isLeaf(Node temp)
    {
        return temp.left == null && temp.right == null;
    }

    private static void findRightViewOfTreeIterative(Node<Integer> root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node<Integer> temp = null;
        int i, size;
        while (!q.isEmpty())
        {
            size = q.size();
            i = 0;
            while (i < size)
            {
                temp = q.poll();

                if (i == size - 1)
                {
                    System.out.print(temp.data + " ");
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
    }
}
