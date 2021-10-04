package preparation.list;

/*
merge like 1->4-->2->5->6->7...only two conditions to take care...a)always take next backup of both ll node
b)check lastly if any ll is not empty in case you have to merge remaining part also
 */
public class Test12MergeTwoLists {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3 };
        Node<Integer> head1 = ListBuilder.createLinkedList(keys);

        keys = new int[]{4, 5, 6, 7};
        Node<Integer> head2 = ListBuilder.createLinkedList(keys);

        Node<Integer>[] finalNode = mergeLists(head1, head2);
        for(Node node: finalNode){
            Test01ListIntro.printList(node);
            System.out.println();
        }

    }

    private static Node<Integer>[] mergeLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> l1_next = null;
        Node<Integer> l2_next = null;
        Node<Integer> l1_curr = head1;
        Node<Integer> l2_curr = head2;

        while(l1_curr!=null && l2_curr!=null){
            //make copy of next pointers
            l1_next = l1_curr.next;
            l2_next = l2_curr.next;

            //link first to second to first.next
            l1_curr.next = l2_curr;
            l2_curr.next = l1_next;

            //copy l1 next and l2 next to l1 and l2
            l1_curr = l1_next;
            l2_curr = l2_next;
        }

        head2 = l2_curr;

        return new Node[]{head1, head2};
    }
}
