package preparation.list;

public class Test35IterateAdoublyLinkedList {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5 };
        Node<Integer> head = ListBuilder.createDoublyLinkedList(keys);
        Test01ListIntro.printList(head);
    }
}
