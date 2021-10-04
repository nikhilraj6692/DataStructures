package preparation.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test28RemoveDuplicates {
    public static void main(String[] args) {
        int keys[] = {5, 3, 4, 2, 5, 4, 1, 3};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Test01ListIntro.printList(removeDuplicates(head));

        System.out.println();
        head = ListBuilder.createLinkedList(keys);
        Test01ListIntro.printList(removeDuplicatesEasyApproach(head));
    }

    private static Node<Integer> removeDuplicatesEasyApproach(Node<Integer> head) {
        if(null==head)
            return null;

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Set<Integer> set = new HashSet<>();
        //[1,2,3]
        //1,2,2,2,3
        while(null!=curr){
            if(!set.contains(curr.data)){
                set.add(curr.data);
                prev = curr;

            }else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return head;
    }

    private static Node<Integer> removeDuplicates(Node<Integer> head) {
        Set<Integer> set = new HashSet<>();
        Node<Integer> temp = head;
        Node<Integer> prevNode = null;
        while(null!=temp){
            if(!set.contains(temp.data)){
                if(null!=prevNode) {
                    prevNode.next = temp;
                }
                prevNode = temp;
                set.add(temp.data);
            }
            temp = temp.next;
        }

        prevNode.next = null;

        return head;
    }
}
