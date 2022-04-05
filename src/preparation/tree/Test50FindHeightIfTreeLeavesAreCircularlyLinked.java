package preparation.tree;


import preparation.util.Node;

public class Test50FindHeightIfTreeLeavesAreCircularlyLinked
{

    public static void main(String[] args)
    {
        // construct the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);      // leaf node
        root.right.right = new Node(6);     // leaf node
        root.left.left.left = new Node(7);  // leaf node

        // construct a circular doubly linked list from leaves
        Node first = root.left.left.left;
        Node second = root.left.right;
        Node third = root.right.right;

        // set previous and next pointers of the linked list
        // (left and right child of a binary tree node, respectively)
        first.left = third;
        first.right = second;

        second.left = first;
        second.right = third;

        third.left = second;
        third.right = first;

        System.out.println("The height of the binary tree is " + height(root));
    }

    private static int height(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.left != null && root.left.right == root && root.right != null
            && root.right.left != null)
        {
            return 1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
