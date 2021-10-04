package preparation.list;

public class Test49MergeSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

class MergeSort{

    public void sort(int[] arr, int start, int end) {
        if(start < end){
            int mid = (start + end)/2;
            sort(arr,start,mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        //create two temp arrays
        for(int i=0;i<n1;i++){
            left[i] = arr[start + i];
        }
        for(int j=0; j<n2;j++){
            right[j] = arr[mid + 1 + j];
        }

        //now copy temp array into original
        int i=0, j=0;
        int k = start;

        while(i<n1 && j<n2){
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
