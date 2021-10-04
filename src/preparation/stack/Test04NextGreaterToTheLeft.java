package preparation.stack;

import java.util.Stack;

/*
same as before just change the condition of greater to smaller and iterate from 0 to n-1. in this brute force, i=0 to n,
j=i-1 to j>=0
 */
public class Test04NextGreaterToTheLeft {
    public static void main(String[] args) {
        int arr[]= {1, 3, 2, 4};
        int n = arr.length;
        printNGEToLeft(arr, n);
    }

    private static void printNGEToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                System.out.print("-1" + " ");
            }else {
                System.out.print(stack.peek() + " ");
            }

            stack.push(arr[i]);
        }
    }
}
