package preparation.list;

public class Test32RemoveRedundantNodes {
    public static void main(String[] args) {
        // input coordinates
        int[][] keys = { {0, 1}, {0, 5}, {0, 8}, {2, 8},
                {5, 8}, {7, 8}, {7, 10}, {7, 12} };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i][0], keys[i][1], head);
        }

        head = removeNodes(head);
        printList(head);
    }

    // Helper function to print a given linked list
    public static void printList(Node head)
    {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.data + "," + ptr.data2);
            System.out.print("->");
        }
        System.out.println("null");
    }

    private static Node removeNodes(Node head) {
        Node startNode = head;
        Node prevNode = null;
        Node temp = head;

        while(null!=temp){
            if(temp.data!=startNode.data && temp.data2!=startNode.data2){
                startNode.next = prevNode;
                startNode = startNode.next;
            }
            prevNode = temp;
            temp = temp.next;
        }

        startNode.next = prevNode;
        return head;
    }

}
