package preparation.list;

import java.util.HashSet;
import java.util.Set;

public class Test26DetectCycleInList {
    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};
        Node head = ListBuilder.createLinkedList(keys);
        head.next.next.next.next = head.next;
        System.out.println(detectCircularListBySet(head));

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        head.next.next.next.next = head.next;
        System.out.println(detectCircularListByPointers(head));
    }

    private static boolean detectCircularListByPointers(Node head) {
        Node slow = head;
        Node fast = slow;

        while(null!=fast && null!=fast.next){
            slow =slow.next;
            fast = fast.next.next;

            if(slow==fast)
                return true;
        }

        return false;
    }

    private static boolean detectCircularListBySet(Node head) {
        Set set = new HashSet<>();

        while(null!=head){
            if(set.contains(head.data)){
                return true;
            }
            set.add(head.data);
            head = head.next;
        }

        return false;
    }
}
