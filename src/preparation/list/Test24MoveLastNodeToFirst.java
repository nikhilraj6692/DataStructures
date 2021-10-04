package preparation.list;

public class Test24MoveLastNodeToFirst {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(moveLastToFistNode(head));

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(moveLastToFistNodeHavingCircularLink(head));
    }

    /*
    one way is to make the list circular...then do lastnode=head and prevnode.next=null;
     */
    public static Node<Integer> moveLastToFistNodeHavingCircularLink(Node<Integer> head) {
        Node<Integer> temp = head;
        Node<Integer> prevNode = null;

        while(temp.next!=null){
            prevNode = temp;
            temp = temp.next;
        }
        temp.next = head;
        head = temp;
        prevNode.next = null;
        return head;
    }

    /*
    can also be done by recursion
     */
    private static Node<Integer> moveLastToFistNode(Node<Integer> head) {
        Node<Integer> temp = head;
        Node<Integer> prevNode = temp;

        while(null!=temp.next){
            prevNode = temp;
            temp = temp.next;
        }
        prevNode.next = null;
        temp.next = head;
        head = temp;

        return head;
    }


}
