package preparation.bst;

import preparation.util.Node;

public class Test02SearchInABST
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        boolean isKeyPresent = searchInBST(root, 25);
        System.out.println(isKeyPresent ? "Found" : "Not Found");

        System.out.println();

        isKeyPresent = searchInBSTIterative(root, 11);
        System.out.println(isKeyPresent ? "Found" : "Not Found");
    }

    private static boolean searchInBSTIterative(Node<Integer> root, int key)
    {
        Node<Integer> curr = root;

        while (null != curr)
        {
            if (key == curr.data)
            {
                return true;
            } else if (key < curr.data)
            {
                curr = curr.left;
            } else if (key > curr.data)
            {
                curr = curr.right;
            }
        }

        return false;
    }

    private static boolean searchInBST(Node<Integer> root, int key)
    {
        if (root == null)
        {
            return false;
        }

        if (root.data == key)
        {
            return true;
        }

        if (key < root.data)
        {
            return searchInBST(root.left, key);
        } else if (key > root.data)
        {
            return searchInBST(root.right, key);
        }

        return false;
    }
}
