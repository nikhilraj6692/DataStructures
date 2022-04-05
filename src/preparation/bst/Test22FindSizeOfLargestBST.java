package preparation.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test22FindSizeOfLargestBST
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree19();

        //find inorder first, then find the largest subarray with increasing sequence and finally
        // find the middle and the
        //length of the sub array. below method is too lengthy but if we have to only find the
        // length, it would be O(n)
        List<Integer> list = new ArrayList<>();
        findInorder(root, list);
        List<Integer> preOrderedList = new ArrayList<>();
        findPreorder(root, preOrderedList);

        findLargestIncreasingSubsequenceAndPrintLengthAlongWithMiddleElement(
            list.stream().mapToInt(i -> i).toArray(),
            preOrderedList.stream().mapToInt(i -> i).toArray());

        System.out.print("\n--------------------------------\n");
        //this method calculates at each and every node whether the tree is in BST or not. If the
        // root is in bst then return
        //size of the bst, but this method only works if whole subtree is a bst like in
        // buildTree19() comments
        int size = findLargestBST(root);
        System.out.print("The length of largest bst is :: " + size);
    }

    private static int findLargestBST(Node<Integer> root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        {
            return size(root);
        }

        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }

    private static int size(Node<Integer> root)
    {
        if (root == null)
        {
            return 0;
        }

        return size(root.left) + 1 + size(root.right);
    }

    private static boolean isBST(Node<Integer> root, int minValue, int maxValue)
    {
        if (root == null)
        {
            return true;
        }

        if (root.data < minValue || root.data > maxValue)
        {
            return false;
        }

        return isBST(root.left, minValue, root.data) && isBST(root.right, root.data, maxValue);
    }

    //30 15 20 40 5 8 2
    private static void findLargestIncreasingSubsequenceAndPrintLengthAlongWithMiddleElement(
        int[] arr, int[] preOrderArray)
    {
        int max = Integer.MIN_VALUE, len = 1, start = -1, startF = -1, endF = -1;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > arr[i - 1])
            {
                if (len == 1)
                {
                    start = i - 1;
                }
                len++;
            } else
            {
                //initialize length
                len = 1;
            }
            if (len > max)
            {
                startF = start;
                endF = i;
                max = len;
            }

        }

        Set<Integer> inOrderedSubarray = Arrays.stream(Arrays.copyOfRange(arr, startF, endF + 1)).
            boxed().collect(Collectors.toSet());

        //now find the preorder of the nodes, separate out all the elements from original orray
        // which actually is present in
        //sub array
        int[] subArray = Arrays.stream(preOrderArray).boxed()
            .filter(x -> inOrderedSubarray.contains(x)).mapToInt(x -> x).toArray();

        System.out.print("The length of largest bst is :: " + max + " and the bst is rooted at :: "
            + subArray[0]);
    }

    private static void findInorder(Node<Integer> root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        findInorder(root.left, list);
        list.add(root.data);
        findInorder(root.right, list);
    }

    private static void findPreorder(Node<Integer> root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        list.add(root.data);
        findPreorder(root.left, list);
        findPreorder(root.right, list);
    }
}
