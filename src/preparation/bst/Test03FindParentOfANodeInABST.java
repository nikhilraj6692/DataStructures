package preparation.bst;

import preparation.util.Node;

public class Test03FindParentOfANodeInABST
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        searchInBSTWithParent(root, 12, null);

        System.out.println();

        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        searchInBSTWithParentIterative(root, 18);
    }

    private static void searchInBSTWithParentIterative(Node<Integer> root, int key)
    {
        Node<Integer> parent = null;
        Node<Integer> curr = root;

        while (null != curr)
        {
            if (curr.data == key)
            {
                if (parent == null)
                {
                    System.out.println(
                        "The key found is a root node, hence it does not have a parent");
                } else if (key < parent.data)
                {
                    System.out.println("The key found is a left node of parent " + parent.data);
                } else if (key > parent.data)
                {
                    System.out.println("The key found is a right node of parent " + parent.data);
                }

                return;
            } else if (key < curr.data)
            {
                parent = curr;
                curr = curr.left;
            } else if (key > curr.data)
            {
                parent = curr;
                curr = curr.right;
            }
        }

        System.out.println("Key is not found!!");
    }

    private static void searchInBSTWithParent(Node<Integer> root, int key, Node<Integer> parent)
    {
        if (root == null)
        {
            System.out.println("Key is not found!!");
            return;
        }

        if (root.data == key)
        {
            if (parent == null)
            {
                System.out.println("The key found is a root node, hence it does not have a parent");
            } else if (key < parent.data)
            {
                System.out.println("The key found is a left node of parent " + parent.data);
            } else if (key > parent.data)
            {
                System.out.println("The key found is a right node of parent " + parent.data);
            }

            return;
        }

        if (key < root.data)
        {
            searchInBSTWithParent(root.left, key, root);
        } else if (key > root.data)
        {
            searchInBSTWithParent(root.right, key, root);
        }
    }
}
