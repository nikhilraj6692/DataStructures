package preparation.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test07TopViewOfTree
{

    public static void main(String[] args)
    {
        Node node = TreeBuilder.buildTree2();
        findTopViewOfTree(node);

        System.out.println();

        node = TreeBuilder.buildTree2();
        findTopViewOfTree(node);

        node = TreeBuilder.buildTree2();
        Map<Integer, Integer> map = new TreeMap<>();
        int hd = 0;
        findTopViewOfTreeRecursive(node, map, hd);
        System.out.println(map.values());


    }


    private static void findTopViewOfTreeRecursive(Node node, Map<Integer, Integer> map, int hd) {
        if(null == node)
            return;
        if(!map.containsKey(hd)){
            map.put(hd, (int)node.data);
        }

        findTopViewOfTreeRecursive(node.left, map, hd-1);
        findTopViewOfTreeRecursive(node.right, map, hd+1);
    }

    /*
    for recursive, just add in map only once for each hd...use preorder traversal
     */
    private static void findTopViewOfTree(Node node)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        node.hd = 0;
        Map<Integer, Node> map = new TreeMap<>();
        map.put(node.hd, node);

        Node temp = null;
        while (!q.isEmpty())
        {
            temp = q.poll();

            if (null != temp.left)
            {
                q.add(temp.left);
                if (!map.containsKey(temp.hd - 1))
                {
                    map.put(temp.hd - 1, temp.left);
                }
                temp.left.hd = temp.hd - 1;
            }

            if (null != temp.right)
            {
                q.add(temp.right);
                if (!map.containsKey(temp.hd + 1))
                {
                    map.put(temp.hd + 1, temp.right);
                }
                temp.right.hd = temp.hd + 1;
            }
        }

        final List<Integer> arrayList = new ArrayList<>();

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(x -> {
            System.out.println(x.getKey() + " , " + x.getValue().data);
            arrayList.add((int) x.getValue().data);
        });

        arrayList.stream().forEach(x -> System.out.print((x + " ")));

    }
}
