package preparation.tree;

import java.util.ArrayList;
import java.util.List;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test19DistanceBetweenTwoNodes
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree2();
        findDistanceBetweenTwoNodes(root, root.right.left.left, root.right.right);
        findDistanceBetweenTwoNodes(root, root.left.right, root.right.left.right);

        //can also be done by finding the level of both nodes and add them
    }

    private static void findDistanceBetweenTwoNodes(Node<Integer> root, Node<Integer> left,
        Node<Integer> right)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Node temp = root;
        findPath(temp, list1, left);
        temp = root;
        findPath(temp, list2, right);

        int length1 = 0, length2 = 0;
        for (int i = 0; i < list1.size() && i < list2.size(); i++)
        {
            if (list1.get(i) != list2.get(i))
            {
                length1 = list1.size() - i;
                length2 = list2.size() - i;
                break;
            }
        }

        System.out.println(length1 + length2);


    }

    private static boolean findPath(Node<Integer> root, List<Integer> list, Node<Integer> node)
    {
        if (root == null)
        {
            return true;
        }
        list.add(root.data);

        if (node.data == root.data)
        {
            return true;
        }

        if (null != root.left &&
            findPath(root.left, list, node))
        {
            return true;
        }
        if (null != root.right &&
            findPath(root.right, list, node))
        {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }
}
