package preparation.list;

/*
output should be 15 14 13 12 9 8 7 6 5 4...just we have to think like how we reverse a linked
list...think of a new node,
whenever you see that one linked list data is smaller than the other in that case add this to new
 node and do the same
that you do in reverse....you have a prev node, new node.next = prev  and prev = newnode...here
we don't have next as
not needed..it is like a dummy node but in opposite direction with the help of prev node
 */
public class Test19MergeNodesFromEnd
{

    public static void main(String[] args)
    {
        int[] keys1 = new int[]{5, 7, 9};
        int[] keys2 = new int[]{4, 6, 8, 12, 13, 14, 15};
        Node<Integer> head1 = ListBuilder.createLinkedList(keys1);
        Node<Integer> head2 = ListBuilder.createLinkedList(keys2);

        Test01ListIntro.printList(mergeLinkedListFromEnd(head1, head2));
    }

    private static Node<Integer> mergeLinkedListFromEnd(Node<Integer> head1, Node<Integer> head2)
    {
        Node<Integer> result = null;
        Node<Integer> newNode = null;

        while (null != head1 && null != head2)
        {
            if (head1.data <= head2.data)
            {
                newNode = new Node(head1.data);
                newNode.next = result;
                result = newNode;
                head1 = head1.next;
            } else
            {
                newNode = new Node(head2.data);
                newNode.next = result;
                result = newNode;
                head2 = head2.next;
            }
        }

        while (null != head1)
        {
            newNode = new Node(head1.data);
            newNode.next = result;
            result = newNode;
            head1 = head1.next;
        }
        while (null != head2)
        {
            newNode = new Node(head2.data);
            newNode.next = result;
            result = newNode;
            head2 = head2.next;
        }

        return result;

    }
}
