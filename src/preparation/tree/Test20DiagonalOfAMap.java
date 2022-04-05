package preparation.tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import preparation.util.Node;
import preparation.util.TreeBuilder;

/*
can be done via iterative also...easy one
 */
public class Test20DiagonalOfAMap
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree();
        Map<Integer, Node<Integer>> map = new LinkedHashMap<>();

        findDiagonalSum(root, 0, map);
        System.out.println(
            map.values().stream().mapToInt(x -> x.data).boxed().collect(Collectors.toList()));
    }

    /*
    diagonal is like level...for right nodes, diagonal value would be same but for left, it would
     be diagonal + 1
    ...this recursive method can be used in level wise addition also.
     */
    private static void findDiagonalSum(Node<Integer> root, int diagonal,
        Map<Integer, Node<Integer>> map)
    {
        Node<Integer> node = map.getOrDefault(diagonal, new Node(0));
        map.put(diagonal, new Node(root.data + node.data));

        if (root.left != null)
        {
            findDiagonalSum(root.left, diagonal + 1, map);
        }

        if (root.right != null)
        {
            findDiagonalSum(root.right, diagonal, map);
        }

        return;
    }
}
