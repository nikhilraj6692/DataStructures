package preparation.bst;

import java.util.Stack;
import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;
import preparation.util.NodeWrapper;

public class Test16SwapNodeToConvertToBST
{

    public static void main(String[] args)
    {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
 
        /* Construct the following BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */

        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);

        // swap any two nodes' values
        //swapData(root.left, root.right.right);
        swapData(root.left.left, root.left.right);
        // `x` and `y` stores node to be swapped
        NodeWrapper x = new NodeWrapper();
        NodeWrapper y = new NodeWrapper();

        // stores previously processed node in the inorder traversal
        // initialize it by `-INFINITY`
        NodeWrapper prev = new NodeWrapper(Integer.MIN_VALUE);
        correctBST(root, prev, x, y);
        swapData(x.node, y.node);
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.print("\n------------------------------\n");
        swapData(root.left, root.right.right);
        correctBSTIterative(root);
        Test01InorderTraversal.inOrderTraversal(root);

    }

    private static void correctBSTIterative(Node<Integer> root)
    {
        Node<Integer> curr = root;
        Stack<Node<Integer>> st = new Stack<>();
        Node<Integer> prevNode = null;
        Node<Integer> incorrectNode1 = null;
        Node<Integer> incorrectNode2 = null;

        while (null != curr || !st.isEmpty())
        {
            while (null != curr)
            {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();

            if (prevNode != null && curr.data <= prevNode.data)
            {
                if (incorrectNode1 == null)
                {
                    incorrectNode1 = prevNode;
                } else
                {
                    incorrectNode2 = curr;
                }
            }
            prevNode = curr;

            curr = curr.right;

        }

        //swap incorrect nodes
        swapData(incorrectNode1, incorrectNode2);
    }

    private static void correctBST(Node<Integer> root, NodeWrapper<Integer> prevNode,
        NodeWrapper<Integer> incorrectlyMappedNode1,
        NodeWrapper<Integer> incorrectlyMappedNode2)
    {
        if (root == null)
        {
            return;
        }

        correctBST(root.left, prevNode, incorrectlyMappedNode1, incorrectlyMappedNode2);
        if (null != prevNode && root.data <= prevNode.node.data)
        {
            if (incorrectlyMappedNode1.node != null)
            {
                incorrectlyMappedNode2.node = root;
            } else
            {
                incorrectlyMappedNode1.node = prevNode.node;
            }
        }
        prevNode.node = root;
        correctBST(root.right, prevNode, incorrectlyMappedNode1, incorrectlyMappedNode2);
    }

    public static void swapData(Node<Integer> first, Node<Integer> second)
    {
        int data = first.data;
        first.data = second.data;
        second.data = data;
    }


}


