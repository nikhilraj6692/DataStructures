package preparation;

import java.util.PriorityQueue;

public class Test02Segregate0And1InArray
{

    public static void main(String[] args)
    {
        int[] arr = solve(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 });
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static int[] solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            if(A[i] == 1){
                q.add(i);
            }else{
                //swap with q.peek() and 0th index in case 0th index is less than q.peek()
                if(null!=q.peek() && i>q.peek()){
                    int oneIndex = q.poll();
                    A[oneIndex] = 0;
                    A[i] = 1;
                    q.add(i);
                }
            }
        }

        return A;
    }
}
