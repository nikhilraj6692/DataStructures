package preparation.heap;

import java.util.PriorityQueue;

public class Test02KLargestElementsInTheArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 23, 12, 9, 30, 2, 50 };
        int k = 3;
        kLargest(arr, k);
    }

    /*
    can be done through sort . optimization:you have to find k largest elements, so create min heap in which topmost element is
     minimum
     */
    private static void kLargest(int[] arr, int k) {
        PriorityQueue<Integer> q= new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);

            if(q.size() > k){
                q.poll();
            }
        }

        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }
}
