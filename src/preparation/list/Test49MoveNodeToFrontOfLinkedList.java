package preparation.list;

public class Test49MoveNodeToFrontOfLinkedList {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3 };
        Node<Integer> head1 = ListBuilder.createLinkedList(keys);

        keys = new int[]{6, 4, 2};
        Node<Integer> head2 = ListBuilder.createLinkedList(keys);

        if(null!=head2){
            Node temp = head2;
            head2 = head2.next;
            temp.next = head1;
            head1 = temp;
        }

        Test01ListIntro.printList(head1);
        System.out.println();
        Test01ListIntro.printList(head2);
    }
}
