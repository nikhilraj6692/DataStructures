package preparation.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test41UpdateRandomPtrToMaxOfNodeToTheRight {
    public static void main(String[] args) {
        int[] keys = { 5, 10, 7, 9, 4, 3 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);
        head = updatePointersToMaxWithoutRecursion(head);
        Test01ListIntro.printListWithRandom(head);

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        head = updatePointersToMaxWithRecursion(head);
        Test01ListIntro.printListWithRandom(head);
    }

    private static Node<Integer> MAX = null;
    private static Node<Integer> updatePointersToMaxWithRecursion(Node<Integer> curr) {
        if(curr == null)
            return null;

        curr.next = updatePointersToMaxWithRecursion(curr.next);
        MAX = findMax(curr.next, MAX);
        curr.random = MAX;

        return curr;
    }

    private static Node<Integer> updatePointersToMaxWithoutRecursion(Node<Integer> head) {
        Node<Integer> curr = head;
        Node prev = null;
        Node MAX = null;
        //reverse list
        Node<Integer> rev = Test15ReverseALinkedList.reverseLinkedList(curr);
        curr = rev;
        //link node with max of prev node and MAX
        while(null!=rev){
            MAX = findMax(prev,MAX);
            prev = rev;
            rev.random = MAX;
            rev = rev.next;
        }

        head = Test15ReverseALinkedList.reverseLinkedList(curr);

        return head;
    }

    private static Node findMax(Node<Integer> prev, Node<Integer> max) {
        if(prev == null && max == null)
            return null;
        if(prev == null && max !=null)
            return max;
        if(prev!=null && max == null){
            return prev;
        }

        if(prev==null && max != null)
            return max;

        if(Math.max(prev.data, max.data) == prev.data)
            return prev;
        else
            return max;
    }
}
