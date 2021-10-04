package preparation.binarysearch;

public class Test02BinarySearchOnReverseSortedArray {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        int N = arr.length;
        int X = 5;
        int result = binarySearch(arr, 0, N-1, X);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);

    }

    //oppposite of previous problem. just reverse condition for start and end
    public static int binarySearch(int[] arr, int start, int end, int elem) {
        while(start <= end){
            int mid = start + (end-start)/2;
            if(elem == arr[mid]){
                return mid;
            }else if(elem < arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
}
