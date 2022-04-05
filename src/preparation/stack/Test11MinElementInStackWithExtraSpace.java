package preparation.stack;

import java.util.Stack;

/*
The problem is with extra space
In this problem, we are maintaining two stacks, one for values and other for minimum element. We
have to update minimum element
in the second stack if pushed data is less than top element or if second stack is empty then only
 push data in second stack.
At the time of popping, if the popped element is equal to top element in the second stack, then
pop element from second also so that
next number in the stack becomes minimum
 */
public class Test11MinElementInStackWithExtraSpace
{

    public static void main(String[] args)
    {
        StackC s = new StackC();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}

class StackC
{

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public StackC()
    {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int data)
    {
        if (minStack.isEmpty() || data < minStack.peek())
        {
            minStack.push(data);
        }
        stack.push(data);
        System.out.println("Number inserted : " + data);
    }


    public void getMin()
    {
        System.out.print("Minimum Number : ");
        if (minStack.isEmpty())
        {
            System.out.println("-1");
        } else
        {
            System.out.println(minStack.peek());
        }
    }

    public void pop()
    {
        System.out.print("Removed Number : ");
        int val;
        if (stack.isEmpty())
        {
            val = -1;
        } else
        {
            if ((val = stack.pop()) == minStack.peek())
            {
                minStack.pop();
            }
        }
        System.out.println(val);
    }

    public void peek()
    {
        System.out.print("Peeked Number : ");
        if (stack.isEmpty())
        {
            System.out.println("-1");
        } else
        {
            System.out.println(stack.peek());
        }
    }
}

