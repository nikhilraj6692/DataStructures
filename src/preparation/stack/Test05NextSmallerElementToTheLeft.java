package preparation.stack;

import java.util.Stack;

/*
same concept as previous ones. pop element if stack is not empty and stack element is greater than arr[i]. if stack is empty
then print MAX otherwise print top element. and add arr[i] to the stack
 */
public class Test05NextSmallerElementToTheLeft {
    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 2, 5};
        int n = arr.length;
        printPrevSmaller(arr, n);
    }

    private static void printPrevSmaller(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                System.out.print("MAX" + " ");
            }else{
                System.out.print(stack.peek() + " ");
            }

            stack.add(arr[i]);
        }
    }
}
