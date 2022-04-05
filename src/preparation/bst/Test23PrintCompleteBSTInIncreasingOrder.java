package preparation.bst;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test23PrintCompleteBSTInIncreasingOrder
{

    public static void main(String[] args)
    {
        int[] arr = {15, 10, 20, 8, 12, 18, 25};
        //above array is a level order traversal of a complete bst. complete bst has two child
        // nodes for each node
        //except leaf node

        //the concept is to mark left node of a node to be 2*index+1 th element and right node as
        // 2*index+2 th element
        Node<Integer> root = constructTree(arr, 0, null);
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.print("\n--------------------------\n");
        root = constructTreeIterative(arr);
        Test01InorderTraversal.inOrderTraversal(root);

    }

    private static Node<Integer> constructTreeIterative(int[] arr)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        Node<Integer> root = new Node<>(arr[0]);
        q.add(root);

        Map<Integer, Integer> valueIndexMapping = new LinkedHashMap<>();
        int i = 0;
        for (int num : arr)
        {
            valueIndexMapping.put(num, i++);
        }

        while (!q.isEmpty())
        {
            Node<Integer> curr = q.poll();
            int lIndex = 2 * (valueIndexMapping.get(curr.data)) + 1;
            int rIndex = 2 * (valueIndexMapping.get(curr.data)) + 2;

            if (lIndex <= arr.length - 1)
            {
                curr.left = new Node<>(arr[lIndex]);
                q.add(curr.left);
            }

            if (rIndex <= arr.length - 1)
            {
                curr.right = new Node<>(arr[rIndex]);
                q.add(curr.right);
            }
        }
        return root;
    }

    private static Node<Integer> constructTree(int[] arr, int index, Node<Integer> root)
    {
        if (index > arr.length - 1)
        {
            return null;
        }

        if (root == null)
        {
            root = new Node(arr[index]);
        }
        root.left = constructTree(arr, 2 * index + 1, root.left);
        root.right = constructTree(arr, 2 * index + 2, root.right);

        return root;
    }
}
