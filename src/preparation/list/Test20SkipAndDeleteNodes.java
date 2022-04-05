package preparation.list;

public class Test20SkipAndDeleteNodes
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Test01ListIntro.printList(skipAndDeleteNodes(head, 2, 2));
        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(skipAndDeleteNodesByQueue(head, 2, 2));
    }

    private static Node<Integer> skipAndDeleteNodesByQueue(Node<Integer> head, int toSkip,
        int toDelete)
    {
        Node<Integer> temp = head;
        Node<Integer> prev = null;

        while (null != temp)
        {
            int i = 0;
            while (null != temp && i++ < toSkip)
            {
                prev = temp;
                temp = temp.next;
            }
            i = 0;
            while (null != temp && i++ < toDelete)
            {
                temp = temp.next;
            }

            prev.next = temp;
        }

        return head;
    }

    private static Node<Integer> skipAndDeleteNodes(Node<Integer> head, int toSkip, int toDelete)
    {
        if (null == head)
        {
            return head;
        }

        Node temp = head;
        Node backUp = null;

        int skip = 0;
        int delete = 0;
        while (null != temp)
        {
            if (skip < toSkip)
            {
                backUp = temp;
                temp = temp.next;
                skip++;

            } else if (delete < toDelete)
            {
                temp = temp.next;
                delete++;
            } else if (delete == toDelete)
            {
                backUp.next = temp;
                delete = 0;
                skip = 0;
            }

        }

        if (delete != 0 && delete < toDelete)
        {
            backUp.next = null;
        }

        return head;
    }


}
