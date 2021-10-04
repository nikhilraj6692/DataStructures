package preparation.list;

public class Test37SwapAdjacentPointers {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        head = swapAdjacentNodes(head);
        Test01ListIntro.printList(head);
    }

    //2->1->4->3->6->5->7
    private static Node<Integer> swapAdjacentNodes(Node<Integer> head) {
        Node<Integer> temp = null;
        Node<Integer> prev = null;
        Node<Integer> curr = head;

        while(null!=curr && null!=curr.next){
            Node next = curr.next.next;
            Node swapped = swapNode(curr, curr.next);

            if(prev == null){
                head = swapped;
            }else{
               prev.next = swapped;
            }

            prev = curr;
            curr = next;
        }
        if(null!=curr){
            prev.next = curr;
        }
        return head;
    }

    private static Node<Integer> swapNode(Node<Integer> first, Node<Integer> second) {
        first.next = second;
        second.next = first;

        return second;
    }
}
