package preparation.list;

import preparation.util.NodeWrapper;

public class Test21MergeFirstAndLastNodesContinuously {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5, 6 , 7};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        //Test01ListIntro.printList(mergeFirstAndLastNodeContinously(head));
        /*
        one way is to find the middle of linked list with slow and fast pointer where slow=head and fast=head.next. Now
        split it into two linked list and reverse second one...now we have two linked lists...just merge it by test12.
        second way is to create a deque and then add all elements. Form a linked list from deque with first and last
        element
         */
        //mergeFirstAndLastRecursively(head);
    }

    /*
    inspired from test23 recursive method.
     *//*
    private static void mergeFirstAndLastRecursively(Node<Integer> head) {
        Test01ListIntro.printList(merge(new NodeWrapper(head), head));
    }

    static Node<Integer> dummy = new Node<>();
    private static Node<Integer> merge(NodeWrapper left, Node<Integer> right) {
        if(right==null)
            return null;

        merge(left, right.next);
        if(dummy!=left.node) {
            dummy.next = left.node;
            dummy = dummy.next;

            left.node = left.node.next;
            dummy.next = right;
            dummy = dummy.next;
            dummy.next = null;
        }
        return right;

    }

    static class NodeWrapper
    {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    *//*private static Node<Integer> mergeFirstAndLastNodeContinously(Node<Integer> head) {
        if(null == head || null == head.next)
            return head;

        Node node = head;
        Node temp = mergeWithLast(head.next);
        Node newNode = node.next;
        node.next = temp;
        temp.next = mergeFirstAndLastNodeContinously(newNode);

        return head;
    }

    private static Node mergeWithLast(Node<Integer> node) {

        if(node == null || node.next ==null)
            return node;
        Node temp = mergeWithLast(node.next);
        return temp;

    }*/
}
