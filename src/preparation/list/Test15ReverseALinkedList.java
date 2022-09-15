package preparation.list;

public class Test15ReverseALinkedList
{

    public static void main(String[] args)
    {
        int keys[] = {1, 2, 3, 4, 5, 6};

        Node<Integer> head = ListBuilder.createLinkedList(keys);
        head = reverseLinkedList(head);
        Test01ListIntro.printList(head);

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        head = reverseLinkedListRecursive(head);
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> reverseLinkedListRecursive(Node<Integer> head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        /*
       temp is because our reference for end node will not change
         */
        Node temp = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static Node<Integer> reverseLinkedList(Node<Integer> head)
    {
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> next = null;

        while (null != curr)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
