package preparation.heap;

import java.util.PriorityQueue;

public class Test03SortANearlySortedArray {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);

        System.out.println("\n=========================\n");
        arr = new int[] { 2, 6, 3, 12, 56, 8 };
        n = arr.length;
        System.out.println("Following is sorted array");
        kSortWithMinHeap(arr, n, k);

    }

    /*
    here k is the threshold which will help pop the element when the q size exceeds threshold. min heap selected because we want
    minimum at the top
     */
    private static void kSortWithMinHeap(int[] arr, int n, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            q.add(arr[i]);

            if(q.size() > k){
                System.out.print(q.poll() + " ");
            }

        }

        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }

    /*
    by insertion sort. insertion sort is a sort in which we start from i as 1 and then have a j at i-1. Now continuously swap
    j with j+1 till j>=0 and jth element is greater ith element. finally put the value of i in j+1
     */
    private static void kSort(int[] arr, int n, int k) {
        for(int i=1; i< arr.length; i++){
            int j=i-1;
            int key = arr[i];

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    // A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
