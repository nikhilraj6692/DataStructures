package preparation.list;

class emp
{

    private String name;

    emp(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


}

class Node<T>
{

    Node<T> next;
    Node<T> prev;
    T data;
    T data2;
    Node<T> left;
    Node<T> right;
    Node<T> random;
    Node<T> down;


    public Node(T data1, T data2, Node<T> next)
    {
        this.next = next;
        this.data = data1;
        this.data2 = data2;
    }

    public Node(T data1, Node<T> next)
    {
        this.next = next;
        this.data = data1;
    }

    public Node(T data)
    {
        this.next = null;
        this.data = data;
        this.prev = null;
    }

    public Node()
    {
        this.data = null;
        this.next = null;
    }
}

public class ListBuilder
{

    public static Node<Integer> buildList1()
    {
        return new Node<>(1, new Node<>(2, new Node<>(3, null)));
    }

    public static Node<Integer> createLinkedList(int[] keys)
    {
        Node<Integer> head = null;
        for (int i = keys.length - 1; i >= 0; i--)
        {
            head = new Node<>(keys[i], head);
        }

        return head;
    }

    public static Node createDoublyLinkedList(int[] keys)
    {
        Node<Integer> head = null;
        Node tail = null;
        for (int i = 0; i < keys.length; i++)
        {
            Node newNode = new Node(keys[i]);
            if (head == null)
            {
                head = newNode;
                tail = newNode;
            } else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

            }
        }

        tail.next = null;
        return head;
    }

}

class Pair<U, V>
{

    public final U first;       // first field of a pair
    public final V second;      // second field of a pair

    // Constructs a new preparation.tree.Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed preparation.tree.Pair immutable instance
    public static <U, V> Pair<U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}

