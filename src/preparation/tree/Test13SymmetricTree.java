package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

/*
a symmetric tree has mirror image of branches on both sides of node but not value...with same
value, symmetric
tree will become mirror tree
 */
public class Test13SymmetricTree
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree5();
        node.left.left = new Node(8);
        if (isTreeSymmetric(node, node))
        {
            System.out.println("Symmetric tree");
        } else
        {
            System.out.println("Asymmetric tree");
        }
    }

    private static boolean isTreeSymmetric(Node<Integer> left, Node<Integer> right)
    {
        if (left == null && right != null)
        {
            return false;
        }
        if (left != null && right == null)
        {
            return false;
        }
        if (left == null && right == null)
        {
            return true;
        }

        return isTreeSymmetric(left.left, right.right) && isTreeSymmetric(left.right, right.left);

    }
}
