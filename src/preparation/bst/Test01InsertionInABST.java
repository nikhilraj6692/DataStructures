package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test01InsertionInABST
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        Test01InorderTraversal.inOrderTraversal(supplyKeysAndCreateBST(keys));

        System.out.println();

        Node root = null;
        for (int key : keys)
        {
            root = insertInBSTIterative(key, root);
        }
        Test01InorderTraversal.inOrderTraversal(root);
    }

    public static Node supplyKeysAndCreateBST(int[] keys)
    {
        Node node = null;
        for (int key : keys)
        {
            node = insertInBST(key, node);
        }
        return node;
    }

    private static Node insertInBSTIterative(int key, Node<Integer> root)
    {
        if (null == root)
        {
            return new Node(key);
        }

        Node<Integer> parent = root;
        Node<Integer> curr = parent;

        while (null != curr)
        {
            parent = curr;

            if (key < curr.data)
            {
                curr = curr.left;
            } else if (key > curr.data)
            {
                curr = curr.right;
            }
        }

        if (key < parent.data)
        {
            parent.left = new Node<>(key);
        } else if (key > parent.data)
        {
            parent.right = new Node<>(key);
        }

        return root;
    }

    private static Node insertInBST(int key, Node<Integer> node)
    {
        if (node == null)
        {
            return new Node(key);
        } else if (key < node.data)
        {
            /*Node<Integer> temp = insertInBST(key, node.left);
            if(temp.data == key){
                node.left = new Node(key);
            }
            return node;*/

            //OR

            node.left = insertInBST(key, node.left);
        } else if (key > node.data)
        {
           /* Node<Integer> temp = insertInBST(key, node.right);
            if(temp.data == key){
                node.right = new Node(key);
            }
            return node;*/

            //OR

            node.right = insertInBST(key, node.right);
        }

        return node;
    }
}
