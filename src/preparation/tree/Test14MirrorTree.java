package preparation.tree;

import java.util.LinkedList;
import java.util.Queue;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test14MirrorTree
{

    public static void main(String[] args)
    {
        Node<Integer> node = TreeBuilder.buildTree3();
        Node<Integer> mainNode = TreeBuilder.buildTree3();
        convertToMirrorIterative(node);
        inorder(node);

        //check if both trees are mirror trees or not...same like symmetric tree ut with same values
        //node.left = mainNode.left;
        if (isTreeMirror(mainNode, node))
        {
            System.out.println("Mirror tree");
        } else
        {
            System.out.println("Not a mirror tree");
        }

        System.out.println();

        Node<Integer> node1 = TreeBuilder.buildTree3();
        convertToMirrorRecursive(node1);
        inorder(node1);

        System.out.println();

        node1 = TreeBuilder.buildTree3();
        Node<Integer> finalN = convertToMirrorRecursive1(node1);
        inorder(finalN);
    }

    private static boolean isTreeMirror(Node<Integer> mainNode, Node<Integer> node)
    {
        if (mainNode == null && node != null)
        {
            return false;
        }
        if (mainNode != null && node == null)
        {
            return false;
        }
        if (mainNode == null && node == null)
        {
            return true;
        }
        if (mainNode.data != node.data)
        {
            return false;
        }

        return isTreeMirror(mainNode.left, node.right) && isTreeMirror(mainNode.right, node.left);
    }

    /*
    postorder traversal and swap left and right children
     */
    private static void convertToMirrorRecursive(Node<Integer> node)
    {
        if (null == node)
        {
            return;
        }
        convertToMirrorRecursive(node.left);
        convertToMirrorRecursive(node.right);
        swap(node.left, node.right, node);
    }

    /*
    this way we are just rotating the nodes...but note that when we rotate the link reference
    gets changed in first
    call and it may lead to incorrect node for second call...so keep variables in temp as that
    the output comes right
     */
    private static Node<Integer> convertToMirrorRecursive1(Node<Integer> node)
    {
        if (null == node)
        {
            return null;
        }
        Node tempL = node.left;
        Node tempR = node.right;
        node.left = convertToMirrorRecursive1(tempR);
        node.right = convertToMirrorRecursive1(tempL);

        return node;
    }


    private static void inorder(Node<Integer> node)
    {
        if (null != node)
        {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    private static void convertToMirrorIterative(Node<Integer> node)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node<Integer> temp = null;
        while (!q.isEmpty())
        {
            temp = q.poll();

            if (temp.left != null)
            {
                q.add(temp.left);
            }

            if (temp.right != null)
            {
                q.add(temp.right);
            }
            swap(temp.left, temp.right, temp);
        }
    }

    private static void swap(Node<Integer> left, Node<Integer> right, Node<Integer> node)
    {
        Node temp = left;
        left = right;
        right = temp;
        node.left = left;
        node.right = right;
    }


}
