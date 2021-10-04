package preparation.list;

/*
in this program we are going to copy list with the help of temp node...in case of iterative impl, just assure that if
temp==null, jthen keep a pointer of clonedhead otherise just use temp.next = new Node() and for recursion just use
temp
 */
public class Test02CopyList {
    public static void main(String[] args) {
        Node<Integer> head = ListBuilder.buildList1();
        Node<Integer> clonedHead = cloneListIterative(head);
        Test01ListIntro.printList(clonedHead);
        System.out.println();
        Test01ListIntro.printList(head);
        System.out.println();
        head.next.next.data = 5;
        Test01ListIntro.printList(head);
        System.out.println();
        Test01ListIntro.printList(clonedHead);

        System.out.println();
        Node<Integer> clonedNode = cloneListRecursive(head);
        Test01ListIntro.printList(clonedNode);
    }

    private static Node<Integer> cloneListRecursive(Node<Integer> head) {
        if(head == null)
            return null;

        Node temp = new Node<>(head.data);
        temp.next = cloneListRecursive(head.next);

        return temp;
    }

    private static Node<Integer> cloneListIterative(Node<Integer> head) {
        Node<Integer> temp = null;
        Node<Integer> clonedHead = null;
        Node<Integer> newData;

        while(head!=null){
            if(temp == null){
                newData = new Node(head.data);
                temp = newData;
                clonedHead = temp;
            }
            else{
                newData = new Node(head.data);
                temp.next = newData;
                temp = temp.next;
            }
            head = head.next;
        }

        return clonedHead;

    }


}
