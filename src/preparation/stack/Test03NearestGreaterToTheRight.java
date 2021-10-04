package preparation.stack;

import java.util.Stack;

/*
stack is used for normally those problems in there are two loops and inner loop is dependent upon i, like i=0, j=i+1 till n or
i=0; j=0 to i or i=n; j=n to 0....  in this problem bruteforce would be i=0 to n, j=i+1 to n
 */
//this problem can also be defined as nearest largest element
public class Test03NearestGreaterToTheRight {
    public static void main(String[] args) {
        int arr[]= {1, 3, 2, 4};
        int n = arr.length;
        printNGE(arr, n);
    }

    /*
    start from last element and traverse towards left, for every element check if stack is empty or not, stack is empty meaning
    there is no higher element nearest to the number at a particular index. else if stack is not empty, then pop the element which
    is less than the number at the index and then print topmost element. finally add the current index element to the stack.
     */
    private static void printNGE(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> finalAnswer = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                finalAnswer.push(-1);
            }
            else
                finalAnswer.push(stack.peek());

            stack.push(arr[i]);
        }

        while(!finalAnswer.isEmpty()){
            System.out.print(finalAnswer.pop() + " ");
        }
    }
}
