package preparation.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
The algorithm can be implemented through a hashmap and doubly linked list where map will do get operation in O(1) time and
linked list will be able to insert and remove element in O(1) time. In linked list older one at the head and later
one at the tail...Here did it via node implementation but can be done through Deque also.
 */
public class Test52ImplementLRUCache {
    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}

class LRUCache {
    private Map<Integer, Node<Integer>> map = new HashMap<>();

    private int capacity = Integer.MIN_VALUE;
    private Node<Integer> head = null;
    private Node<Integer> tail = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void refer(Integer elem) {
        if (null == elem) {
            return;
        }

        if (map.containsKey(elem)) {
            Node<Integer> node = map.get(elem);

            //remove node from linked list from the front,i.e. head and place it at the tail
            removeNode(node);
        } else {
            if(map.size() == this.capacity){
                //size is equal to max capacity
                int removedVal = removeNodeFromBeginning();
                map.remove(removedVal);
            }
        }

        Node<Integer> node = new Node<>(elem);
        //update elem in the map , because it might happen that the node is already present in map but its link has to be
        //changed again
        map.put(elem, node);

        insertIntoLinkedList(node);
    }

    private void removeNode(Node<Integer> node) {
        if(node.prev!=null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next!=null){
            node.next.prev = node.prev;
        }else{
           tail = node.prev;
        }
    }

    private int removeNodeFromBeginning() {
        if(head.next==null){
            head = tail = null;
            return head.data;
        }else{
            head = head.next;
            return head.data;
        }
    }

    private void insertIntoLinkedList(Node<Integer> node) {
        if (null == head) {
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }


    public void display() {
        Node temp = this.head;
        while(null!=temp){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

