package preparation.list;

public class Test51FlattenAMultiLevelLinkedList {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);

        // set head node
        Node head = one;

        // set next pointers
        one.next = four;
        four.next = fourteen;
        fourteen.next = fifteen;
        five.next = nine;
        nine.next = ten;
        seven.next = eight;
        eleven.next = thirteen;

        // set down pointers
        one.down = two;
        two.down = three;
        four.down = five;
        five.down = six;
        six.down = seven;
        ten.down = eleven;
        eleven.down = twelve;

        System.out.println("The original list is :");
        printOriginalList(head);

        flattenList(head);
        System.out.println("\n\nThe flattened list is :");
        printFlattenedList(head);
    }

    private static Node flattenList(Node head) {
        Node curr = head;

        if(null == curr)
            return null;

        Node next = curr.next;
        curr.next = flattenList(curr.down);


        //next is not null...iterate till end and make it curr
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = flattenList(next);

        return head;
    }

    public static void printFlattenedList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Utility function to print a list with `down` and `next` pointers
    public static void printOriginalList(Node head)
    {
        if (head == null) {
            return;
        }

        System.out.print(" " + head.data + " ");

        if (head.down != null)
        {
            System.out.print("[");
            printOriginalList(head.down);
            System.out.print("]");
        }

        printOriginalList(head.next);
    }
}
