package preparation.list;

import java.util.HashSet;
import java.util.Set;

public class Test45FindIntersectionPointOfLinkedLists {
    public static void main(String[] args) {
        int[] keys = new int[] {1, 2, 3, 4, 5};
        Node<Integer> list1 = ListBuilder.createLinkedList(keys);

        keys = new int[] {3, 2, 1};
        Node<Integer> list2 = ListBuilder.createLinkedList(keys);

        list2.next.next.next = list1.next;

        Node<Integer> node = findIntersectionPoint(list1, list2);
        System.out.print(node.data);
    }

    private static Node<Integer> findIntersectionPoint(Node<Integer> list1, Node<Integer> list2) {
        Set<Node> set = new HashSet<>();
        while(null!=list1){
            set.add(list1);
            list1 = list1.next;
        }

        while(null!=list2){
            if(set.contains(list2))
                return list2;
            list2 = list2.next;
        }

        return new Node();
    }
}
