package preparation.util;

public class TreeBuilder
{

    public static <T> Node<T> buildTree()
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        return root;
    }

    public static <T> Node<T> buildTree1()
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        return root;
    }

    public static <T> Node<T> buildTree2()
    {
        /* Construct the following tree
                   1
                 /    \
                /      \
               2        3
                \     /   \
                 \   /     \
                 4  5       6
                   / \
                  /   \
                 7     8
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        return root;
    }

    public static <T> Node<T> buildTree3()
    {
        /* Construct the following tree
                   1
                 /    \
                /      \
               2        3
              /  \      /   \
             /    \    /     \
            4      5  6      7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;
    }

    public static <T> Node<T> buildTree4()
    {
        Node root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;
    }

    public static <T> Node<T> buildTree5()
    {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     /
            5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);

        return root;
    }

    public static <T> Node<T> buildTree6()
    {
         /* Construct the following tree
                    1
                 /     \
                /       \
               2         3
              /  \      /  \
             /    \    /    \
            4      5  6      7
                     /       \
                    /         \
                   8          9
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);
        return root;
    }

    public static <T> Node<T> buildTree7()
    {
        /* Construct the following tree
                     1
                   /   \
                  2     3
                /     /   \
               4     5     6
             /     /   \     \
            4     5     5     7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(5);
        root.right.right.right = new Node(7);

        return root;
    }

    public static <T> Node<T> buildTree8()
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.right = new Node(12);
        return root;
    }

    public static <T> Node<T> buildTree9()
    {
        /* Construct the following tree
                     1
                   /   \
                  2     3
                      /   \
                     5     6
                   /   \
                  7     8
                      /  \
                     9   10
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.left.right.right = new Node(10);
        return root;
    }

    public static <T> Node<T> buildTree10()
    {
        /* Construct the following tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        return root;
    }

    public static <T> Node<T> buildTree11()
    {
         /* Construct the following tree
                   2
                 /   \
                /     \
               3       4
              / \     / \
             /   \   /   \
            5     6 8    10
        */

        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(8);
        root.right.right = new Node(10);
        return root;
    }

    public static <T> Node<T> buildTree12()
    {
         /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              / \       \
             /   \       \
            4     5       6
                        /   \
                       /     \
                      7       8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        return root;
    }

    public static <T> Node<T> buildTree13()
    {
         /* Construct the following tree
                     1
                  /   \
                /       \
              2           3
            /            /  \
           4            5    6
          /            / \    \
         7            8   9    10
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(10);
        return root;
    }

    public static <T> Node<T> buildTree14()
    {
        /* Construct the following tree
                     1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \     \         /
         8   9    10      11
            / \           /
           12 13         14
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.right = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.left = new Node(12);
        root.left.left.right.right = new Node(13);
        root.right.right.left.left = new Node(14);
        return root;
    }

    public static <T> Node<T> buildTree15()
    {
        Node root = new Node(15);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.left.left = new Node(18);
        root.right.left.left.right = new Node(20);
        return root;
    }

    public static <T> Node<T> buildTree16()
    {
        Node root = new Node("+");
        root.left = new Node("×");
        root.right = new Node("/");
        root.left.left = new Node("-");
        root.left.right = new Node("5");
        root.right.left = new Node("21");
        root.right.right = new Node("7");
        root.left.left.left = new Node("10");
        root.left.left.right = new Node("5");
        return root;
    }

    public static <T> Node<T> buildTree17()
    {
        Node root = new Node(25);
        root.left = new Node(8);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;
    }

    public static <T> Node<T> buildTree18()
    {
         /* Construct the following tree
                   8
                 /   \
                /     \
               3       5
              / \     / \
             /   \   /   \
            10    2 4     6
        */

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        return root;
    }

    public static <T> Node<T> buildTree19()
    {
        /* Construct the following tree
                  40
                /    \
               /      \
              15       8
             /  \     / \
            /    \   /   \
           30    20 5     2
        */

        Node root = new Node(40);

        root.left = new Node(15);
        root.right = new Node(8);

        root.left.left = new Node(30);
        root.left.right = new Node(20);

        root.right.left = new Node(5);
        root.right.right = new Node(2);

        return root;

        //whole subtree as bst
        /*
                  10
                /    \
               /      \
              15       8
             /  \     / \
            /    \   /   \
           12    20 5     2
         */
    }


}

