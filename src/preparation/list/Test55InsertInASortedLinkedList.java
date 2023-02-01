package preparation.list;

public class Test55InsertInASortedLinkedList {

    public static void main(String[] args) {
        int[] keys = {3, 5, 1};
        Node<Integer> node = ListBuilder.createLinkedList(keys);
        
        new Solution().insert(node, 0);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node<Integer> head, int insertVal) {
        Node<Integer> backUphead = head;
        Node<Integer> tempHead = null;
        if(null == backUphead){
            tempHead = new Node(insertVal);
            backUphead = tempHead;
            head = backUphead;
            head.next = head;
            return head;
        } else {
            //find smallest value in linked list
            Node<Integer> minNode = null;
            while(backUphead.next != head){
                if(minNode == null){
                    minNode = new Node(backUphead.data);
                }else{
                    if(backUphead.data < minNode.data){
                        minNode = backUphead;
                    }
                }
                backUphead = backUphead.next;
            }
            System.out.println(minNode.data);
            while(!(insertVal >= minNode.data && insertVal<=minNode.next.data)){
                //insertVal is the least element
                if(minNode.next == head){
                    break;
                }

                minNode = minNode.next;
            }
            tempHead = new Node(insertVal);
            tempHead.next = minNode.next;
            minNode.next = tempHead;
        }

        return head;
    }
}
