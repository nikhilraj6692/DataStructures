package preparation.list;

import java.util.LinkedList;
import java.util.Queue;

public class Test46PrintMultiLevelLinkedList
{

    public static void main(String[] args)
    {
        // create a multilevel linked list
        Node1 head = createHorizontalList(new int[]{1, 2, 3, 4, 5});
        head.child = createHorizontalList(new int[]{6, 7});
        head.next.next.child = createHorizontalList(new int[]{8, 9});
        head.child.next.child = createHorizontalList(new int[]{10, 11});
        head.child.next.child.child = createHorizontalList(new int[]{12});

        Node1 node = convertList(head);
        printList(node);
    }

    public static void printList(Node1 head)
    {
        Node1 ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    private static Node1 convertList(Node1 head)
    {
        Queue<Node1> q = new LinkedList<>();
        Node1 curr = head;
        Node1 prevNode = null;

        while (curr != null || !q.isEmpty())
        {
            if (curr == null)
            {
                Node1 temp = q.poll();
                prevNode.next = temp;
                curr = temp;
            } else
            {
                prevNode = curr;
                if (curr.child != null)
                {
                    q.add(curr.child);
                }

                curr = curr.next;
            }


        }

        return head;
    }

    // Helper function to create a linked list with elements of a given list
    public static Node1 createHorizontalList(int[] input)
    {
        Node1 head = null;
        for (int i = input.length - 1; i >= 0; i--)
        {
            head = new Node1(input[i], head, null);
        }
        return head;
    }


}

class Node1
{

    int data;
    Node1 next, child;

    Node1(int data, Node1 next, Node1 child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
