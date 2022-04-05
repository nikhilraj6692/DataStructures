package preparation.tree;

import java.util.ArrayList;
import java.util.List;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test18FindAncestorsOfANode
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree2();

        printAncestors(node, 7);
        printAncestors(node, 6);
        printAncestorsWithoutRecursion(node, 7);
    }

    private static void printAncestorsWithoutRecursion(Node<Integer> node, int data)
    {

    }

    private static boolean isLeaf(Node<Integer> temp)
    {
        return null != temp && null == temp.left && null == temp.right;
    }

    private static void printAncestors(Node<Integer> node, int data)
    {
        List<Integer> path = new ArrayList<>();
        if (findPath(node, path, data))
        {
            path.stream().forEach(e -> System.out.print(e + " "));
        }
        System.out.println();
    }

    private static boolean findPath(Node<Integer> node, List<Integer> path, int data)
    {
        if (node == null)
        {
            return false;
        }

        if (node.data == data)
        {
            return true;
        }

        path.add(node.data);
        if (node.left != null && findPath(node.left, path, data))
        {
            return true;
        }
        if (node.right != null && findPath(node.right, path, data))
        {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
