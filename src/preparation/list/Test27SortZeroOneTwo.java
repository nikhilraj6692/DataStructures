package preparation.list;

import com.sun.source.tree.Tree;

/*
Traverse the list and count the number of 0s, 1s, and 2s. Let the counts be n1, n2, and n3 respectively.
Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1, and finally n3 nodes with 2.
 */
public class Test27SortZeroOneTwo {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 0, 0, 1, 2, 1, 2, 1 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Node<Integer> temp = sortZeroOneTwo(head);
        Test01ListIntro.printList(temp);
    }

    private static Node<Integer> sortZeroOneTwo(Node<Integer> head) {
        Node<Integer> zero = new Node<>();
        Node<Integer> one = new Node<>();
        Node<Integer> two = new Node<>();
        Node<Integer> first = zero;
        Node<Integer> second = one;
        Node<Integer> third = two;
        Node<Integer> temp = head;

        while(null!=temp){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if (temp.data ==1){
                one.next = temp;
                one = one.next;
            }else if(temp.data == 2){
                two.next = temp;
                two = two.next;
            }
            temp =temp.next;
        }


        zero.next = second.next;
        one.next = third.next;
        two.next = null;

        return first.next;
    }

}
