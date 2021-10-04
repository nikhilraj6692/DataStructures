package preparation.list;

/*
very very important problem
 */
public class Test13MergeSortedLinkedLists {
    public static void main(String[] args) {
        int[] keys1 = new int[] {3,4,5,7,9};
        int[] keys2 = new int[] {6,8,12, 13, 14 ,15};
        Node<Integer> head1 = ListBuilder.createLinkedList(keys1);
        Node<Integer> head2 = ListBuilder.createLinkedList(keys2);

        Node<Integer> finalNode = mergeLists(head1, head2);
        Test01ListIntro.printList(finalNode);

        System.out.println();

        head1 = ListBuilder.createLinkedList(keys1);
        head2 = ListBuilder.createLinkedList(keys2);

        finalNode = mergeListsUsingDummyNode(head1, head2);
        Test01ListIntro.printList(finalNode);

        System.out.println();

        head1 = ListBuilder.createLinkedList(keys1);
        head2 = ListBuilder.createLinkedList(keys2);

        finalNode = mergeListsUsingRecursion(head1, head2);
        Test01ListIntro.printList(finalNode);
    }


    private static Node<Integer> mergeListsUsingRecursion(Node<Integer> head1, Node<Integer> head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.data<=head2.data)
        {
            head1.next = mergeListsUsingRecursion(head1.next, head2);
            return head1;
        }else{
            head2.next = mergeListsUsingRecursion(head1, head2.next);
            return head2;
        }

    }

    private static Node<Integer> mergeListsUsingDummyNode(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummyNode = new Node<>();
        Node<Integer> traversingNode = dummyNode;

        while(true){
            if(head1 == null) {
                traversingNode.next = head2;
                break;
            }

            if(head2 == null) {
                traversingNode.next = head1;
                break;
            }

            if(head1.data<=head2.data){
                traversingNode.next = head1;
                head1 = head1.next;
            }else{
                traversingNode.next = head2;
                head2 = head2.next;
            }

            traversingNode = traversingNode.next;
        }

        return dummyNode.next;
    }

    /*
    iterate through first list and check if second list current node is smaller or greater. If smaller and prevNode==null, then
    attach second curr node to first curr node, else keep a track of prevNode each time and do same steps
     */
    private static Node<Integer> mergeLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> curr1 = head1;
        Node<Integer> curr2 = head2;
        Node<Integer> prevNode = null;
        Node<Integer> curr2_nextNode = null;
        Node<Integer> curr1_nextNode = null;

        while(true){
            if(curr1 == null) {
                prevNode.next = curr2;
                break;
            }

            if(curr2 == null) {
                prevNode.next = curr1;
                break;
            }


            if(curr2.data <= curr1.data){
                curr2_nextNode = curr2.next;
                if(prevNode == null){
                    curr2.next = curr1;
                    head1 = curr2;
                }else{
                    prevNode.next = curr2;
                    curr2.next = curr1;
                }
                prevNode = curr2;
                curr2 = curr2_nextNode;
            }else{
                curr1_nextNode = curr1.next;
                if(prevNode == null){
                    curr1.next = curr2;
                    head1 = curr1;
                }else{
                    prevNode.next = curr1;
                    curr1.next = curr2;
                }
                prevNode = curr1;
                curr1 = curr1_nextNode;


                //OR
               /* prevNode = curr1;
                curr1 = curr1.next;*/

            }
        }

        return head1;
    }
}
