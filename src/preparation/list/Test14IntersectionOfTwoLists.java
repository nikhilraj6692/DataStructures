package preparation.list;

public class Test14IntersectionOfTwoLists {
    public static void main(String[] args) {
        int[] keys = { 1, 4, 7, 10, 13 };
        Node<Integer> head1 = ListBuilder.createLinkedList(keys);

        keys = new int[] {2, 4, 6, 8, 10, 15 };
        Node<Integer> head2 = ListBuilder.createLinkedList(keys);

        Node<Integer> node = findIntersection(head1, head2);
        Test01ListIntro.printList(node);

        System.out.println();
        node = findIntersectionRecursion(head1, head2);
        Test01ListIntro.printList(node);
    }

    /*
    combination of sortedlinked lists recursion plus normal recursion of linked list
     */
    private static Node<Integer> findIntersectionRecursion(Node<Integer> head1, Node<Integer> head2) {
        if(head1 == null)
            return null;
        if(head2 == null)
            return null;

        if(head1.data < head2.data){
            return findIntersectionRecursion(head1.next, head2);
        }else if(head1.data > head2.data){
            return findIntersectionRecursion(head1, head2.next);
        }

        Node temp = new Node(head1.data);
        temp.next = findIntersectionRecursion(head1.next, head2.next);

        return temp;

    }

    /*
    in case we have to find out linked list of intersecting nodes
     */
    private static Node<Integer> findIntersection(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummyNode = new Node<>();
        Node<Integer> traversingNode = dummyNode;

        while(null!=head1.next && null!=head2.next){
            if(head1.data < head2.data){
                head1 = head1.next;
            }
            else if(head1.data > head2.data){
                head2 = head2.next;
            }else{
                traversingNode.next = head1;
                traversingNode = traversingNode.next;
                head1=head1.next;
                head2=head2.next;
            }
        }

        traversingNode.next = null;

        return dummyNode.next;
    }
}
