package preparation.list;

/*
basic list operations
 */
public class Test01ListIntro {
    public static void main(String[] args) {
        Node<Integer> head = ListBuilder.buildList1();
        //print list
        printList(head);

        System.out.println();
        //add to the front
        head = addNodeAtHead(5, head);
        printList(head);

        //add to the tail
        System.out.println();
        head = ListBuilder.buildList1();
        head = addNodeAtTail(4, head);
        printList(head);
    }

    private static Node<Integer> addNodeAtTail(int data, Node<Integer> head) {
        Node temp = head;
        Node<Integer> newData = new Node<>(data);

        if(null == head){
            head = newData;
        }else{
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newData;
        }

        return head;
    }

    private static Node<Integer> addNodeAtHead(int key, Node<Integer> node) {
        Node<Integer> head = node;
        Node<Integer> newData = new Node<>(key);

        newData.next = head;
        head = newData;

        return head;
    }

    public static void printList(Node<Integer> node) {
        Node<Integer> temp = node;

        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void printListWithRandom(Node<Integer> node) {
        Node<Integer> temp = node;

        while(temp!=null){
            System.out.print(temp.data + "(" + (temp.random==null?"X":temp.random.data)+") ");
            temp = temp.next;
        }
    }


}
