package preparation.bst;

import preparation.util.Node;

public class Test08FindPredecessorOfANodeInABST
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        /* Construct the following tree
                   15
                 /    \
                /      \
               10       20
              /  \     /  \
             /    \   /    \
            8     12 16    25
        */
        //https://www.ritambhara.in/inorder-successor-of-node-in-a-binary-tree/
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        for (Integer key : keys)
        {
            Node<Integer> predecessor = findPredecessor(root, key, null);
            System.out.println(
                "The predecessor of " + key + " is " + (null != predecessor ? predecessor.data
                    : null));
        }

        System.out.print("\n-----------------------------------\n");

        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        for (Integer key : keys)
        {
            Node<Integer> predecessor = findPredecessorIterative(root, key);
            System.out.println(
                "The predecessor of " + key + " is " + (null != predecessor ? predecessor.data
                    : null));
        }
    }

    /*
    do inorder and once the root data matches, return previous node
     */
    private static Node<Integer> findPredecessorIterative(Node<Integer> root, Integer key)
    {
        Node<Integer> curr = root;
        Node<Integer> parentNode = null;

        while (curr != null)
        {
            if (curr.data == key)
            {
                if (curr.left != null)
                {
                    return findMaximum(curr.left);
                } else
                {
                    break;
                }
            } else if (key < curr.data)
            {
                curr = curr.left;
            } else if (key > curr.data)
            {
                parentNode = curr;
                curr = curr.right;
            }
        }

        return parentNode;
    }

    /*
    if root data is equal to key then return the maximum from its left subtree if subtree is null
    . Otherwise return previous node
    For the right subtree there is an exceptional case, where we have to maintain prev node like
    in the case of 12
     */
    private static Node<Integer> findPredecessor(Node<Integer> root, int key,
        Node<Integer> prevNode)
    {
        if (root == null)
        {
            return null;
        }

        if (root.data == key)
        {
            if (root.left != null)
            {
                return findMaximum(root.left);
            }
        }

        if (key < root.data)
        {
            return findPredecessor(root.left, key, prevNode);
        } else if (key > root.data)
        {
            prevNode = root;
            return findPredecessor(root.right, key, prevNode);
        }

        return prevNode;
    }

    private static Node<Integer> findMaximum(Node<Integer> node)
    {
        if (null != node)
        {
            while (node.right != null)
            {
                node = node.right;
            }
        }

        return node;
    }


}
