package preparation.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import preparation.util.Node;
import preparation.util.TreeBuilder;

/*
inorder and postorder or inorder and preorder is a length method...we can solve by checking for
each node with
the subtree node. if data matches, it means that we have to go to check if left and right is also
 equal..If at
any point data is not equal, then check for left and subtree, similarly check for right and
subtree. anyone should
be true.
 */
public class Test12BinaryTreeIsASubtree
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree3();

        if ((isSubtree(root, root.right)))
        {
            System.out.println("Is is subtree");
        } else
        {
            System.out.println("Not a subtree");
        }

        System.out.println();
        if ((isSubtreeRecursive(root, root.right)))
        {
            System.out.println("Is is subtree");
        } else
        {
            System.out.println("Not a subtree");
        }
    }

    private static boolean isSubtreeRecursive(Node<Integer> tree, Node<Integer> subTree)
    {
        //doing this because we will go on shortening tree and subtree. if a subtree lies in a
        // tree then
        //ofcourse subtree will become null at some time and tree may be null or may not be null.
        if (subTree == null)
        {
            return true;
        }
        if (tree == null)
        {
            return false;
        }

        if (isIdentical(tree, subTree))
        {
            return true;
        }

        return isIdentical(tree.left, subTree) || isIdentical(tree.right, subTree);
    }

    private static boolean isIdentical(Node<Integer> tree, Node<Integer> subTree)
    {
        if (tree == null && subTree == null)
        {
            return true;
        }
        if (tree == null || subTree == null)
        {
            return false;
        }

        return tree.data == subTree.data && isIdentical(tree.left, subTree.left) && isIdentical(
            tree.right, subTree.right);
    }

    /*
    find inorder and postorder or inorder and preorder and then check if both are equal or not
     */
    private static boolean isSubtree(Node<Integer> node1, Node<Integer> node2)
    {
        if (toString(inorder(node1)).contains(toString(inorder(node2))) && toString(
            preorder(node1)).contains(toString(preorder(node2))))
        {
            return true;
        }
        return false;


    }

    public static String toString(List<Integer> list)
    {
        if (list == null)
        {
            return "";
        }
        return list.toString().replace("[", "").replace("]", "");
    }

    /*
    1) Create an empty stack nodeStack and push root node to stack.
    2) Do the following while nodeStack is not empty.
    ….a) Pop an item from the stack and print it.
    ….b) Push right child of a popped item to stack
    ….c) Push left child of a popped item to stack
     */
    private static List<Integer> preorder(Node<Integer> node)
    {
        List<Integer> list = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack();

        Node<Integer> curr = node;
        stack.push(node);
        while (stack.size() > 0)
        {
            curr = stack.pop();
            list.add(curr.data);

            if (null != curr.right)
            {
                stack.push(curr.right);
            }
            if (null != curr.left)
            {
                stack.push(curr.left);
            }

        }

        System.out.println(list.toString());

        return list;
    }


    private static List<Integer> inorder(Node<Integer> node)
    {
        List<Integer> list = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();

        Node<Integer> curr = node;
        while (curr != null || stack.size() > 0)
        {
            while (null != curr)
            {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.data);

            curr = curr.right;

        }

        System.out.println(list.toString());

        return list;
    }
}
