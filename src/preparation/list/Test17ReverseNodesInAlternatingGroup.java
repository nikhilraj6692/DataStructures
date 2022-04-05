package preparation.list;

public class Test17ReverseNodesInAlternatingGroup
{

    public static void main(String[] args)
    {
        int[] keys = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Node<Integer> finalNode = reverseInGroups(head, 3);
        Test01ListIntro.printList(finalNode);
    }

    private static Node<Integer> reverseInGroups(Node head, int num)
    {
        Node curr = head;
        Node prevNode = null;

        int i = 0;
        while (null != curr)
        {
            Node nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;

            if (i == num - 1)
            {
                break;
            } else
            {
                i++;
            }
        }

        if (null != head)
        {
            i = 0;
            head.next = curr;
            while (i++ != num && curr != null)
            {
                head = curr;
                curr = curr.next;
            }

            head.next = reverseInGroups(curr, num);
        }

        return prevNode;
    }
}
