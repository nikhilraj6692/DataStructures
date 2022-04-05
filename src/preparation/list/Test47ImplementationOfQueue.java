package preparation.list;

public class Test47ImplementationOfQueue
{

    public static void main(String[] args)
    {
        CustomQueue q = new CustomQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.printf("The front element is %d\n", q.peek());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        if (q.isEmpty())
        {
            System.out.print("The queue is empty");
        } else
        {
            System.out.print("The queue is not empty");
        }
    }
}

class CustomQueue
{

    Node front = null, rear = null;

    public void enqueue(int data)
    {
        Node node = new Node(data);

        System.out.printf("Inserting %d\n", data);

        if (front == null)
        {
            front = node;
            rear = node;
        } else
        {
            rear.next = node;
            rear = node;
        }
    }

    public int dequeue()
    {
        if (front == null)
        {
            System.out.println("Queue underflow");
            System.exit(0);
        }
        Node node = front;
        front = front.next;

        if (front == null)
        {
            rear = null;
        }

        System.out.printf("Removing %d\n", node.data);
        return (int) node.data;

    }

    public int peek()
    {
        if (front == null)
        {
            System.out.println("Queue is empty");
            System.exit(1);
        }

        return (int) front.data;
    }

    public boolean isEmpty()
    {
        return front == null && rear == null;
    }
}

