package preparation.list;

/*
reverse nodes and skip nodes in a group of given number...below output for a group of 3 would be
3 2 1 4 5 6 9 8 7 10 11
 */
public class Test34AlternativelyReverseNodeIteratively {
    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6,7,8,9,10,11};

        Node<Integer> head = ListBuilder.createLinkedList(keys);
        head = alternativelyReverseNodeRecursively(head,3);
        Test01ListIntro.printList(head);

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        head = alternativelyReverseNodeIteratively(head,3);
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> alternativelyReverseNodeIteratively(Node<Integer> head, int groupSize) {
        Node frontNode;
        Node lastNode = null;
        Node prevNode = null;
        Node temp = head;

        while(null!=temp){
            frontNode = temp;
            int i=0;
            //iterate groupnode size
            while(i++<groupSize && null!=temp){
                temp = temp.next;
            }

            lastNode = reverseLinkedList(frontNode, groupSize);

            //link front node to temp
            frontNode.next = temp;

            if(null==prevNode){
                head = lastNode;
            }else{
                prevNode.next = lastNode;
            }

            //skip group size nodes
            i=0;
            while(i++<groupSize && null!=temp){
                prevNode =temp;
                temp = temp.next;
            }

        }

        return head;
    }

    private static Node<Integer> alternativelyReverseNodeRecursively(Node<Integer> head, int nodes) {
        Node<Integer> temp = head;
        Node prevNode = null;

        if(null ==temp)
            return null;

        //iterate n nodes
        int i=0;
        while(i++<nodes && null!=temp){
            temp = temp.next;
        }

        prevNode = reverseLinkedList(head, nodes);

        head.next = temp;

        //skip n nodes
        i=0;
        while(i++<nodes && null!=temp){
            head = temp;
            temp = temp.next;
        }

        head.next = alternativelyReverseNodeRecursively(temp, nodes);
        return prevNode;
    }
    public static Node<Integer> reverseLinkedList(Node<Integer> head, int k) {
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> next = null;

        while(null!=curr && k-->0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
