package preparation.list;

/*
important ques...if group size is 3 then 3 2 1 6 5 4 9 8 7...can be done via stack also where we push k elements in
stack in a loop in which head!=null...and create a linked list from stack by peeking , linking and then popping...for
maintaining head node, use prev as null
 */
public class Test16ReverseListinGroups {
    public static void main(String[] args) {
        int[] keys = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Node<Integer> finalNode = reverseInGroups(head,3);
        Test01ListIntro.printList(finalNode);
    }

    //1->2->3->4->5->6
    //4->3->2->1->6->5->null
    /*
    it is maintaining a pair because with pair we will get to know that which node is the next starting node of linked
    list to be reversed...
     */
    private static Node<Integer> reverseInGroups(Node<Integer> head, int num) {
        if(null==head)
            return null;

        Node<Integer> curr = head;
        Node backup = curr;
        Pair<Node<Integer>, Node<Integer>> pair = reverseList(curr, num);
        backup.next = reverseInGroups(pair.second, num);
        return pair.first;
    }

    private static Pair<Node<Integer>, Node<Integer>> reverseList(Node<Integer> curr, int num) {
        int i = 0;

        Node<Integer> prevNode = null;
        while(null!=curr){
           Node next = curr.next;
           curr.next = prevNode;
           prevNode = curr;
           curr = next;

           if(i==num-1)
               break;
           else
               i++;

        }

        return Pair.of(prevNode, curr);

    }
}
