package preparation.list;

/*
bogus question...no need to do it...gc will come and clear ut all unreferenced objects in the memory
 */
public class Test03DeleteList {
    public static void main(String[] args) {
        Node<Integer> head = ListBuilder.buildList1();
        head = deleteListRecursive(head);
        if (null == head) {
            System.out.println("List deleted");
        } else {
            System.out.println("Not deleted");
        }

        head = ListBuilder.buildList1();
        head = printListIterative(head);
        if (null == head) {
            System.out.println("List deleted");
        } else {
            System.out.println("Not deleted");
        }
    }

    private static Node<Integer> printListIterative(Node<Integer> head) {
        Node nextNode = null;

        while(null!=head){
            nextNode = head;
            head = head.next;
            nextNode = null;
        }

        return head;
    }

    private static Node<Integer> deleteListRecursive(Node<Integer> head) {
        if(null == head)
            return null;

        head.next = deleteListRecursive(head.next);
        head = null;
        return head;
    }

}
