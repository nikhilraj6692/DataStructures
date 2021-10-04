package preparation.list;

/*
split like 1,3,5,7 and second as 2,4,6
 */
public class Test11SplitListWithAlternateElements {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Node<Integer>[] nodes = splitList(head);

        for(int i=0; i<nodes.length; i++){
            Test01ListIntro.printList(nodes[i]);
            System.out.println();
        }
    }

    /*
    easy one...just do with even and odd opposite condition
     */
    private static Node<Integer>[] splitList(Node<Integer> head) {
        Node<Integer> even = head.next;
        Node<Integer> odd = head;
        Node<Integer> evenBackUp = even;

        while(null!=odd && null!=even){
            if(null!=odd && null!=even){
                odd.next = even.next;
                odd = even.next;
            }

            if(null!=even && null!=odd){
                even.next = odd.next;
                even = odd.next;
            }
        }



        return new Node[]{head, evenBackUp};
    }

    private static Node<Integer>[] splitList2(Node<Integer> head) {
        Node<Integer> even = null;
        Node<Integer> temp = head;
        Node<Integer> odd = temp;
        Node<Integer> evenBackUp = null;

        while(null!=odd && null!=odd.next){
            Node<Integer> newNode = odd.next;
            odd.next = odd.next.next;
            odd = odd.next;
            newNode.next = null;

            if(even == null){
                even = newNode;
                evenBackUp = even;
            }else{
                even.next = newNode;
                even = even.next;
            }
        }

        return new Node[]{head, evenBackUp};
    }
}
