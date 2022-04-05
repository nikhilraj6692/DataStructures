package preparation.list;

public class Test22RearrangeNodesInASpecificManner
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4, 5, 6};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        rearrangeListWithFirstAndLastNode(head);

        System.out.println();
        keys = new int[]{1, 2, 3, 4, 5, 6, 7};
        head = ListBuilder.createLinkedList(keys);

        rearrangeListWithFirstAndLastNode(head);
    }

    private static void rearrangeListWithFirstAndLastNode(Node<Integer> head)
    {
        //find mid node and its links
        Node mid = findMidNode(head);

        //reverse next node (mid)
        Node node2 = reverse(mid);

        //merge both lists
        Node mergedNode = mergeNodes(head, node2);
        Test01ListIntro.printList(mergedNode);
    }

    private static Node mergeNodes(Node<Integer> first, Node second)
    {
        Node node1_next = null;
        Node node2_next = null;
        Node node1 = first;
        Node node2 = second;

        while (null != node1 && null != node2)
        {
            node1_next = node1.next;
            node1.next = node2;
            node2_next = node2.next;
            if (node1_next == null)
            {
                node2.next = node2_next;
            } else
            {
                node2.next = node1_next;
            }
            node1 = node1_next;
            node2 = node2_next;
        }

        return first;
    }

    private static Node reverse(Node mid)
    {
        if (mid == null)
        {
            return null;
        }

        Node curr = mid;
        Node prevNode = null;

        while (curr != null)
        {
            Node nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        return prevNode;
    }

    private static Node findMidNode(Node<Integer> head)
    {
        Node<Integer> slow = head;
        Node<Integer> fast = slow;
        Node<Integer> prevNode = null;

        while (null != fast && null != fast.next)
        {
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevNode.next = null;

        return slow;
    }
}
