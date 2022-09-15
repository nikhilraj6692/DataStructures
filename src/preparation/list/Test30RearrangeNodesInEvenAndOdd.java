package preparation.list;

/*
just do even and odd...always check for even.next, odd.next, even and odd as null
 */
public class Test30RearrangeNodesInEvenAndOdd
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4};
        Node<Integer> head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(rearrangeInEvenAndOdd(head));

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(rearrangeInEvenAndOddWithoutDummy(head));
    }

    private static int count = -1;

    /*
    1,2,3,4
    1>3>5>7>9>null

     */
    private static Node<Integer> rearrangeInEvenAndOddWithoutDummy(Node<Integer> head)
    {
        Node odd = head;
        Node even = odd.next;
        Node evenFirst = even;

        while (true)
        {
            if (even == null || even.next == null || odd == null || odd.next == null)
            {
                break;
            }

            if (null != even.next && odd.next != null)
            {
                odd.next = even.next;
                odd = even.next;
                even.next = odd.next;
                even = odd.next;
            }


        }

        odd.next = evenFirst;

        return head;
    }

    private static Node rearrangeInEvenAndOdd(Node<Integer> head)
    {
        Node dummyEvenNode = new Node();
        Node dummyEvenHead = dummyEvenNode;
        Node dummyOddNode = new Node();
        Node dummyOddHead = dummyOddNode;
        Node temp = head;
        int count = 0;

        while (null != temp)
        {
            count++;
            if (count % 2 == 0)
            {
                dummyEvenNode.next = temp;
                dummyEvenNode = dummyEvenNode.next;
            } else
            {
                dummyOddNode.next = temp;
                dummyOddNode = dummyOddNode.next;
            }

            temp = temp.next;
        }

        dummyOddNode.next = null;
        dummyEvenNode.next = null;
        dummyOddNode.next = dummyEvenHead.next;

        return dummyOddHead.next;
    }
}
