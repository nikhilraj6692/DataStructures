package preparation.list;

public class Test48StackimplementationInLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.print("The stack is empty");
        }
        else {
            System.out.print("The stack is not empty");
        }
    }
}

class Stack{
    Node top;

    Stack(){
        this.top = null;
    }


    public void push(int data) {
        Node node = new Node();
        if(node == null){
            System.out.println("Stack Overflow");
            System.exit(1);
        }

        System.out.println("Inserting " + data);
        node.data = data;

        if(top == null){
            top = node;
        }else{
            node.next = top;
            top = node;
        }
    }

    public int pop() {
        if(null == top){
            System.out.println("Stack underflow");
            System.exit(1);
        }

        System.out.println("Removing " + peek());

        Node temp = top;
        top = top.next;

        return (int) temp.data;
    }

    public int peek() {
        if(null == top){
            System.out.print("Stack underflow");
            System.exit(1);
        }
        return (int) top.data;
    }

    public boolean isEmpty() {
        return top==null;
    }
}

