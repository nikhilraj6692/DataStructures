package preparation.tree;

import java.util.Stack;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test01InorderTraversal
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree();

        inOrderTraversal(root);

        System.out.println();

        inOrderTraversalWithoutRecursion(root);
    }

    private static void inOrderTraversalWithoutRecursion(Node root)
    {
        Node temp = root;

        Stack<Node> st = new Stack();

        while (null != temp || st.size() > 0)
        {
            while (temp != null)
            {
                st.push(temp);
                temp = temp.left;
            }

            temp = st.pop();
            System.out.print(temp.data + " ");

            temp = temp.right;

        }
    }

    public static void inOrderTraversal(Node root)
    {
        Node temp = root;

        if (temp == null)
        {
            return;
        }

        inOrderTraversal(temp.left);
        System.out.print(temp.data + " ");
        inOrderTraversal(temp.right);

    }
}



