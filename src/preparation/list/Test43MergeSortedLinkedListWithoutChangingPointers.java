package preparation.list;

public class Test43MergeSortedLinkedListWithoutChangingPointers
{

    public static void main(String[] args)
    {
        Node first = new Node(2);
        first.next = new Node(6);
        first.next.next = new Node(9);
        first.next.next.next = new Node(10);
        first.next.next.next.next = new Node(15);

        // construct the second list
        Node second = new Node(1);
        second.next = new Node(4);
        second.next.next = new Node(5);
        second.next.next.next = new Node(20);

        // print both lists before the merge
        System.out.print("Before Merging:\n\n");
        Test01ListIntro.printList(first);
        System.out.println();
        Test01ListIntro.printList(second);
        System.out.println();

        // merge both lists
        second = mergeLists(first, second);

        System.out.print("After Merging:\n\n");
        Test01ListIntro.printList(first);
        System.out.println();
        Test01ListIntro.printList(second);
        System.out.println();
    }

    //swap elements if first.data is less than second.data. After swap it may be possible that
    // the second list has become unordered,
    //so order it and then again compare
    private static Node mergeLists(Node<Integer> first, Node<Integer> second)
    {
        Node<Integer> curr1 = first;
        Node<Integer> curr2 = second;

        while (null != curr1 && null != curr2)
        {
            if (curr1.data > curr2.data)
            {
                //swap data
                swap(curr1, curr2);
            }
            curr1 = curr1.next;

            //rearrange second list
            curr2 = rearrangeSecondList(curr2.next, new Node(curr2.data));
        }
        return curr2;
    }

    //  6 8 10
    // 9
    private static Node<Integer> rearrangeSecondList(Node<Integer> curr2,
        Node<Integer> nodeToBeAdded)
    {
        if (curr2 == null)
        {
            return nodeToBeAdded;
        }

        if (nodeToBeAdded.data < curr2.data)
        {
            nodeToBeAdded.next = curr2;
            return nodeToBeAdded;
        }

        Node headNode = curr2;
        Node prevNode = null;
        while (null != curr2)
        {
            if (curr2.data >= nodeToBeAdded.data)
            {
                prevNode.next = nodeToBeAdded;
                nodeToBeAdded.next = curr2;
            }
            prevNode = curr2;
            curr2 = curr2.next;
        }

        return headNode;
    }

    private static void swap(Node<Integer> curr1, Node<Integer> curr2)
    {
        int temp = curr1.data;
        curr1.data = curr2.data;
        curr2.data = temp;
    }
}
