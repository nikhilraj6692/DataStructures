package preparation.tree;

import java.util.Stack;
import preparation.util.Node;

public class Test52ConstructTree
{

    public static void main(String[] args)
    {
        String postfix = "ab+cde+**";
        Node root = constructTree(postfix);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node constructTree(String postfix)
    {
        Stack<Node> stack = new Stack<>();
        for (char c : postfix.toCharArray())
        {
            if (isOperator(c))
            {
                Node x = stack.pop();
                Node y = stack.pop();
                stack.add(new Node(c, y, x));
            } else
            {
                stack.add(new Node(c));
            }
        }

        return stack.peek();
    }

    private static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
