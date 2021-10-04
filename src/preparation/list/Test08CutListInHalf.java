package preparation.list;

import java.util.ArrayList;
import java.util.List;

/*
if the length is odd, then the first list should contain more nodes than the second list
Can be done by naive solution by iterating through the list, count the size of list and then finally cut in half
good solution would be to traverse via slow and fast pointer and cut the node till slow pointer and from slow pointer.next to end of the ode
 */
public class Test08CutListInHalf {
    public static void main(String[] args) {
        int[] keys = {6, 3, 4, 8, 2, 9, 10};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        cutIntoHalves(head);
    }

    private static void cutIntoHalves(Node<Integer> head) {
        Node<Integer> slow;
        Node<Integer> fast;

        slow=fast=head;

        while(null!=fast.next && null!=fast.next.next){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node secondHead = slow.next;
        slow.next = null;

        Test01ListIntro.printList(head);
        System.out.println();
        Test01ListIntro.printList(secondHead);

    }
}
