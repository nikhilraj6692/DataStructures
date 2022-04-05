package preparation.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test44DiagonalOfATree
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree();
        Map<Integer, List<Node<Integer>>> map = new TreeMap<>();
        findDiagonal(root, 0, map);
        map.entrySet().forEach(x -> {
            x.getValue().stream().forEach(y -> System.out.print(y.data + " "));
            System.out.println();
        });
        printDiagonalRecursively(root);
    }

    private static void printDiagonalRecursively(Node<Integer> root)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        Node<Integer> temp = null;
        Node<Integer> lastNode = new Node(-1);

        while (root != null)
        {
            q.add(root);
            root = root.right;
        }
        q.add(lastNode);

        while (q.size() != 1)
        {
            temp = q.poll();
            if (temp != lastNode)
            {
                System.out.print(temp.data + " ");
                temp = temp.left;

                while (temp != null)
                {
                    q.add(temp);
                    temp = temp.right;
                }
            } else
            {
                q.add(lastNode);
                System.out.println();
            }


        }
    }


    private static void findDiagonal(Node<Integer> root, int diagonal,
        Map<Integer, List<Node<Integer>>> map)
    {
        if (root == null)
        {
            return;
        }

        map.computeIfAbsent(diagonal, k -> new ArrayList<>()).add(new Node<>(root.data));
        findDiagonal(root.left, diagonal + 1, map);
        findDiagonal(root.right, diagonal, map);
    }


}
