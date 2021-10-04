package preparation.list;

import java.util.Stack;

//try to understand with two nodes first
public class Test36ReverseADoublyLinkedList {
    public static void main(String[] args) {
        int[] keys = { 1, 2 };
        Node<Integer> head = ListBuilder.createDoublyLinkedList(keys);

        head = reverseListUsingStack(head);
        Test01ListIntro.printList(head);
        
        System.out.println();
        head = ListBuilder.createDoublyLinkedList(keys);

        head = reverseListUsingSwap(head);
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> reverseListUsingSwap(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> temp = null;

        while(null!=curr){
            // swap `next` and `prev` pointers for the current node
            swap(curr);

            // update the previous node before moving to the next node
            temp = curr;

            // move to the next node in the doubly linked list (advance using
            // `prev` pointer since `next` and `prev` pointers were swapped)
            curr = curr.prev;
        }

        if(temp!=null){
            head = temp;
        }
        return head;
    }

    private static void swap(Node node) {
        Node prev = node.prev;
        node.prev = node.next;
        node.next = prev;
    }

    private static Node<Integer> reverseListUsingStack(Node<Integer> head) {
        Stack<Integer> stack = new Stack<>();
        Node<Integer> temp = head;

        while(null!=temp){
            stack.push(temp.data);
            temp = temp.next;
        }

        Node<Integer> temp2 = head;

        while(null!=temp2){
            temp2.data = stack.pop();
            temp2 = temp2.next;
        }

        return head;
    }

}
