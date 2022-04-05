package preparation.list;

/*
iterate through the list and keep a prevNode at the same point as temp which is initially pointed
 to head. Only make prevNode
to temp if temp data is not equal to prevNode and then print the root
 */
public class Test09RemoveDuplicatesFromLinkedList
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 2, 2, 3, 4, 4, 5};

        Node<Integer> root = ListBuilder.createLinkedList(keys);
        removeDuplicates(root);

        Test01ListIntro.printList(root);
    }

    private static Node<Integer> removeDuplicates(Node<Integer> root)
    {
        Node<Integer> temp = root;

        Node<Integer> prevNode = temp;
        while (null != temp.next)
        {
            temp = temp.next;
            if (prevNode.data != temp.data)
            {
                prevNode.next = temp;
                prevNode = temp;
            }

        }

        return root;
    }
}
