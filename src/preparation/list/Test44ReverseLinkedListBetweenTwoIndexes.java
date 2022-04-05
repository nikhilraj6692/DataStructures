package preparation.list;

public class Test44ReverseLinkedListBetweenTwoIndexes
{

    public static void main(String[] args)
    {
        int m = 2, n = 5;

        Node head = null;
        for (int i = 7; i >= 1; i--)
        {
            head = new Node(i, head);
        }

        Test01ListIntro.printList(head);
        System.out.println();
        head = reverseLinkedListBetweenIndexes(head, m, n);
        Test01ListIntro.printList(head);
    }

    private static Node reverseLinkedListBetweenIndexes(Node head, int m, int n)
    {
        Node<Integer> curr = head;

        int count = 1;
        Node<Integer> prev = null;
        Node<Integer> prevLink = null;

        while (curr != null && count < m)
        {
            prevLink = curr;
            curr = curr.next;
            count++;
        }
        Node<Integer> backUpNextLink = curr;

        Node next = null;
        while (count >= m && count <= n && curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        prevLink.next = prev;
        backUpNextLink.next = next;
        return head;
    }
}
