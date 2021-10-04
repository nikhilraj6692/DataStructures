package preparation.list;

public class Test50MoveEvenNodesToTheEndOfTheLinkedListInReverseOrder {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        head = reverseEvenNodesAndAppendToOddNodes(head);
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> reverseEvenNodesAndAppendToOddNodes(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> even = null;
        Node<Integer> evenBackup = null;
        Node<Integer> odd = null;

        int count = 1;
        while(curr!=null){
            if(count%2==0){
                if(even==null){
                    even = curr;
                    evenBackup = even;
                }else{
                    even.next = curr;
                    even = curr;
                }
            }else{
                if(odd == null) {
                    odd = curr;
                }else{
                    odd.next = curr;
                    odd = curr;
                }
            }
            count++;
            curr = curr.next;
        }


        if(count%2!=0){
            odd.next = null;
        }else{
            even.next = null;
        }

        //reverse even backup
        Node<Integer> reverse = Test15ReverseALinkedList.reverseLinkedList(evenBackup);

        odd.next = reverse;

        return head;
    }
}
