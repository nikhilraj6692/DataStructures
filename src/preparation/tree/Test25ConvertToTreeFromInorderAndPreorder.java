package preparation.tree;

import preparation.util.Node;

public class Test25ConvertToTreeFromInorderAndPreorder
{

    static int preIndex = 0;

    /*
    also print post order from inorder and preorder
     */
    public static void main(String[] args)
    {
        Test25ConvertToTreeFromInorderAndPreorder tree =
            new Test25ConvertToTreeFromInorderAndPreorder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        System.out.print("post order traversal is : ");
        Node node = convertToTree(in, pre, 0, in.length - 1);
        System.out.println();
        System.out.print("inorder traversal is :");
        Test01InorderTraversal.inOrderTraversal(node);

        //check for another method in gkg
    }

    private static Node<Character> convertToTree(char[] in, char[] pre, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        Node<Character> node = new Node(pre[preIndex++]);

        if (start == end)
        {
            System.out.print(node.data + " ");
            return node;
        }
        int index = search(in, start, end, node.data);

        node.left = convertToTree(in, pre, start, index - 1);
        node.right = convertToTree(in, pre, index + 1, end);
        System.out.print(node.data + " ");
        return node;
    }

    private static int search(char[] in, int start, int end, char c)
    {
        for (int i = 0; i < in.length; i++)
        {
            if (in[i] == c)
            {
                return i;
            }
        }
        return -1;
    }
}

