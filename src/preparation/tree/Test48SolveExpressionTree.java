package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test48SolveExpressionTree
{

    public static void main(String[] args)
    {
        Node<String> node = TreeBuilder.buildTree16();
        System.out.print(solveExpressionTree(node));
    }

    private static int solveExpressionTree(Node<String> node)
    {
        if (node == null)
        {
            return 0;
        }
        if (null == node.left && null == node.right)
        {
            return Integer.valueOf(node.data);
        }
        int left = solveExpressionTree(node.left);
        int right = solveExpressionTree(node.right);
        return process(node.data, left, right);
    }

    private static int process(Object op, int x, int y)
    {
        if (op == "+")
        {
            return x + y;
        }
        if (op == "-")
        {
            return x - y;
        }
        if (op == "×")
        {
            return x * y;
        }
        if (op == "/")
        {
            return x / y;
        }

        return 0;
    }
}
