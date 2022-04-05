package preparation.list;

/*
to do with extra pointer, we can keep a reference of previous node so that we can always connect
prevNode.next = new node
and new node.next = temp.next when temp.data is greater than new node data...but without extra
pointer start from temp.next
only and check for its not null along with till its next is less than new node data
 */
public class Test05InsertANodeAtCorrectPosInSortedLinkedList
{

    public static void main(String[] args)
    {
        int[] keys = {2, 4, 6, 8};

        //create linked list
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        //print linked list
        Test01ListIntro.printList(head);

        System.out.println();
        //insert node at position
        head = sortedInsert(head, new Node(5));
        head = sortedInsert(head, new Node(9));
        head = sortedInsert(head, new Node(1));
        //print linked list
        Test01ListIntro.printList(head);

        System.out.println();

        head = ListBuilder.createLinkedList(keys);

        //print linked list
        Test01ListIntro.printList(head);

        System.out.println();
        //insert node at position
        head = sortedInsertWithoutExtraPointer(head, new Node(5));
        head = sortedInsertWithoutExtraPointer(head, new Node(9));
        head = sortedInsertWithoutExtraPointer(head, new Node(1));
        //print linked list
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> sortedInsertWithoutExtraPointer(Node<Integer> head,
        Node<Integer> node)
    {
        if (head == null)
        {
            return null;
        }

        if (node.data <= head.data)
        {
            node.next = head;
            head = node;
            return head;
        } else
        {
            Node<Integer> temp = head;
            while (null != temp.next && temp.next.data < node.data)
            {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }

        return head;
    }

    private static Node<Integer> sortedInsert(Node<Integer> head, Node<Integer> node)
    {
        Node<Integer> temp = head;
        Node<Integer> prevPointer = null;
        if (null == temp)
        {
            return null;
        }

        //check if node to be inserted is less than the head element. point node to head and node
        // as head
        if (node.data <= temp.data)
        {
            node.next = temp;
            temp = node;
            head = temp;
        } else
        {
            //iterate till node data is greater than or equal to temp data. Maintain previous
            // node and next node as temp.
            //Finally, point previous node to new node and new node to temp and return head
            while (null != temp && node.data > temp.data)
            {
                prevPointer = temp;
                temp = temp.next;
            }
            node.next = temp;
            prevPointer.next = node;
        }

        return head;

    }
}
