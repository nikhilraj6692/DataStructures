package preparation.bst;

import preparation.util.Node;
import preparation.util.Pair;

public class Test10FindCeilAndFloorOfAKey
{

    public static void main(String[] args)
    {
        /* Construct the following tree
                   8
                 /   \
                /     \
               4       10
              / \     /  \
             /   \   /    \
            2     6 9     12
        */

        int[] keys = {2, 4, 6, 8, 9, 10, 12};

        for (int i = 1; i <= 15; i++)
        {
            Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
            Pair<Integer, Integer> pair = findFloorAndCeilIterative(root, i);
            System.out.println(
                "Ceil of " + i + " is " + pair.first + " and floor of " + i + " is " + pair.second);
        }

        System.out.print("------------------------------------------------\n");

        for (int i = 1; i <= 15; i++)
        {
            Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
            Pair<Integer, Integer> pair = findFloorAndCeilRecursive(root, i, -1, -1);
            System.out.println(
                "Ceil of " + i + " is " + pair.first + " and floor of " + i + " is " + pair.second);
        }

    }

    private static Pair<Integer, Integer> findFloorAndCeilRecursive(Node<Integer> root, int key,
        int ceil, int floor)
    {
        if (root == null)
        {
            return Pair.of(ceil, floor);
        }
        if (root.data == key)
        {
            return Pair.of(key, key);
        } else if (key < root.data)
        {
            ceil = root.data;
            return findFloorAndCeilRecursive(root.left, key, ceil, floor);
        } else if (key > root.data)
        {
            floor = root.data;
            return findFloorAndCeilRecursive(root.right, key, ceil, floor);
        }

        return Pair.of(ceil, floor);
    }

    private static Pair<Integer, Integer> findFloorAndCeilIterative(Node<Integer> root, int key)
    {
        Node<Integer> curr = root;
        int floor = -1, ceil = -1;

        while (null != curr)
        {
            if (key == curr.data)
            {
                return Pair.of(key, key);
            }
            if (key < curr.data)
            {
                ceil = curr.data;
                curr = curr.left;
            } else if (key > curr.data)
            {
                floor = curr.data;
                curr = curr.right;
            }
        }

        return Pair.of(ceil, floor);
    }
}
