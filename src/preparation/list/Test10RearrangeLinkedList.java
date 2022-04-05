package preparation.list;

/*
rearrange linked list like link odd nodes then link even nodes in opposite order, i.e.
1->3->5->7->6->4->2
 */
public class Test10RearrangeLinkedList
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4, 5, 6};
        Node<Integer> head = ListBuilder.createLinkedList(keys);
        Node temp = arrangeListByEvenAndOdd(head);

        Test01ListIntro.printList(temp);

    }

    private static Node<Integer> arrangeListByEvenAndOdd(Node<Integer> head)
    {
        Node<Integer> odd = head;
        Node<Integer> even = head.next;

        Node<Integer> prevEven = null;
        Node<Integer> prevOdd = null;
        while (null != odd && null != even)
        {
            //for odd nodes
            if (null != odd && null != even)
            {
                prevOdd = odd;

                odd.next = even.next;
                odd = even.next;
            }

            //for even nodes
            if (null != even)
            {
                even.next = prevEven;
                prevEven = even;
                if (null != odd)
                {
                    even = odd.next;
                }
            }
        }

        if (null != odd)
        {
            odd.next = prevEven;
        } else if (null != even)
        {
            prevOdd.next = prevEven;
        }

        return head;
    }


    /*
    too complex...can be done via even and odd node...for even node, use reverse algo
     */
    private static Node<Integer> arrangeList(Node<Integer> head)
    {
        Node<Integer> temp = head;
        Node<Integer> prevNode = temp;
        Node<Integer> newNode = null;
        Node<Integer> node = null;

        int i = 0;
        while (null != temp.next)
        {
            temp = temp.next;
            if (i % 2 != 0)
            {
                prevNode.next = temp;
                prevNode = temp;
            } else
            {
                newNode = new Node<>(prevNode.next.data);
                if (node == null)
                {
                    node = newNode;
                    node.next = null;
                } else
                {
                    newNode.next = node;
                    node = newNode;
                }
            }

            i++;
        }

        temp.next = node;

        return head;
    }
}
