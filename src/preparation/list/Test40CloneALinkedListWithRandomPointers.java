package preparation.list;

import java.util.HashMap;
import java.util.Map;

public class Test40CloneALinkedListWithRandomPointers {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next.next;
        head.next.next.random = head.next;

        Node<Integer> temp = cloneLinkedListWithTwoTravesalsAndHashing(head);
        Test01ListIntro.printListWithRandom(temp);

        System.out.println();
        temp = cloneLinkedListWithOneTraversalAndHashingRecursive(head, new HashMap<>());
        Test01ListIntro.printListWithRandom(temp);

        System.out.println();
        temp = cloneLinkedListWithoutHashing(head);
        Test01ListIntro.printListWithRandom(temp);
    }

    //create a list such that the list contains the items with main list and its duplicate adjacently
    private static Node<Integer> cloneLinkedListWithoutHashing(Node head) {
        //create a list such that the list contains the items with main list and its duplicate adjacently
        Node<Integer> curr = head;

        while(null!=curr){
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr = curr.next;
            curr.next = next;
            curr = next;
        }

        //iterate the list and link its adjacent node to corresponding adjacent random pointer
        curr = head;
        Node headNode = null;
        Node temp = null;

        while(null!=curr){
            if(null == headNode){
                headNode = curr.next;
                temp = headNode;
            }else{
                temp.next = curr.next;
                temp = temp.next;
            }

            if(null!=curr.random){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }


        return headNode;
    }

    private static Node<Integer> cloneLinkedListWithOneTraversalAndHashingRecursive(Node head, Map<Node,Node> map) {
        Node<Integer> temp = head;
        temp = cloneLinkedList(temp, map);
        temp = head;
        temp = cloneLinkedListWithRandomPointer(temp,map);
        return temp;
    }

    private static Node<Integer> cloneLinkedListWithRandomPointer(Node<Integer> temp, Map<Node, Node> map) {
        if(null == temp)
            return null;

        if(temp.random != null){
            map.get(temp).random = cloneLinkedListWithOneTraversalAndHashingRecursive(temp.random, map);
        }

        return temp;
    }

    private static Node<Integer> cloneLinkedList(Node<Integer> temp, Map<Node, Node> map) {
        if(null == temp)
            return null;

        if(map.get(temp) == null){
            map.put(temp, new Node(temp.data));
        }

        map.get(temp).next = cloneLinkedList(temp.next, map);

        return map.get(temp);
    }

    private static Node<Integer> cloneLinkedListWithTwoTravesalsAndHashing(Node head) {
        Node<Integer> temp = null;
        Node<Integer> curr = head;
        Map<Node<Integer>, Node<Integer>> map = new HashMap<>();
        Node<Integer> clonedHead = null;

        while(null!=curr){
            if(temp == null){
                temp = new Node(curr.data);
                clonedHead = temp;
            }else{
                temp.next = new Node<>(curr.data);
                temp = temp.next;
            }

            map.put(curr, temp);

            curr = curr.next;
        }

        curr = head;
        temp = clonedHead;

        while(null!=curr){
            if(curr.random!=null){
                temp.random = map.get(curr.random);
            }
            curr = curr.next;
            temp = temp.next;
        }

        return clonedHead;
    }
}
