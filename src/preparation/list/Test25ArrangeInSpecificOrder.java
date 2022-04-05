package preparation.list;

public class Test25ArrangeInSpecificOrder
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Node<Integer> temp = arrangeInSpecificOrder(head);
        Test01ListIntro.printList(temp);
    }

    private static Node<Integer> arrangeInSpecificOrder(Node<Integer> head)
    {
        Node dummyNode = new Node();
        Node backupNode = dummyNode;
        Node temp = head;

        while (null != temp && null != temp.next && null != temp.next.next)
        {
            Node node = temp.next.next;
            dummyNode.next = temp.next;
            dummyNode = dummyNode.next;

            temp.next = node;
            temp = node;

        }

        temp.next = backupNode.next;

        return head;


    }
}
