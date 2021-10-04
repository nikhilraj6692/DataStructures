package preparation.list;

/*
naive solution to iterate the list , count nodes and then iterate the list to n-k times...one way is to have 'A' node iterated
till k position and then start another node from head also and iterate till 'A' is null...
 */
public class Test18FindNthNodeFRomEnd {
    public static void main(String[] args) {
        int keys[] = { 1, 2, 3, 4, 5,6, 7, 8 };
        Node head = ListBuilder.createLinkedList(keys);
        Node node = findNodeAtPosition(head,2);
        System.out.print(node.data);

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        findNodeAtPositionRecursively(head,2);
    }

    private static int findNodeAtPositionRecursively(Node head, int num) {
        if(head == null)
            return 0;

        int count = findNodeAtPositionRecursively(head.next, num) + 1;

        if(count == num)
            System.out.println(head.data + " ");

        return count;
    }


    private static Node findNodeAtPosition(Node head, int position) {
        int i =0;
        Node backup = head;

        while(i++<position){
            head = head.next;
        }

        while(null!=head){
            backup = backup.next;
            head = head.next;
        }

        return backup;
    }
}
