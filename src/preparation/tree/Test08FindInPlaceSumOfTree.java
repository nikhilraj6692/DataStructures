package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

//do postorder, as in this ques we to process first left then right and then pass on value from
// left+right+their
//data to root which will recursively pass to main root
public class Test08FindInPlaceSumOfTree
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree2();

        findInPlaceSumOfTree(node);
        Test02PreorderTraversal.preorderTraversal(node);

        System.out.println();

        node = new Node<>(1);
        node.left = new Node<>(2);
        node.right = new Node<>(3);

        findInPlaceSumOfTree(node);
        Test02PreorderTraversal.preorderTraversal(node);

        System.out.println();

        node = new Node<>(1);
        node.left = new Node<>(2);
        node.right = new Node<>(3);

        toSumTree(node);
        Test02PreorderTraversal.preorderTraversal(node);

        System.out.println();

        node = TreeBuilder.buildTree2();
        toSumTree(node);
        Test02PreorderTraversal.preorderTraversal(node);

        System.out.print("Done");
    }

    private static int toSumTree(Node<Integer> node)
    {
        // Base case
        if (node == null)
        {
            return 0;
        }

        // Store the old value
        int old_val = node.data;

        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        node.data = toSumTree(node.left) + toSumTree(node.right);

        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return node.data + old_val;
    }

    private static int findInPlaceSumOfTree(Node<Integer> node)
    {
        if (null == node)
        {
            return 0;
        }

        int sum = 0;

        if (null != node.left)
        {
            sum = sum + node.left.data;
        }
        if (null != node.right)
        {
            sum = sum + node.right.data;
        }

        sum = sum + findInPlaceSumOfTree(node.left) + findInPlaceSumOfTree(node.right);
        node.data = sum;

        return sum;

    }
}
