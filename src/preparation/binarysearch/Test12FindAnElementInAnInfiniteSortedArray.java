package preparation.binarysearch;

/*
since it is an infinite sorted array, so we cannot mark any high... we will mark low as 0 and high as 1. find key if between or
equal to low and high. if no, then make low equal to previous high and make high as 2*previous high. Repeat this process till
we get an element which is between some low and some high. Then it becomes bounded problem and same as ordinary binary search.
Cannot be solutioned on platform. We assume that the definition of infinite is limited to array below.
 */
public class Test12FindAnElementInAnInfiniteSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int n = arr1.length;
        int key = 10;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
    }

    private static int pivotedBinarySearch(int[] arr, int n, int key) {
        //find low and high bound
        int low = 0;
        int high = 1;

        if(key<arr[low]){
            return -1;
        }

        //think opposite of !(key>arr[low] && key<=arr[high]) => key<arr[low] (handled above) && key>arr[high]
        while(key > arr[high]){
            low = high;
            high = 2*high;
        }

        return Test01BinarySearch.binarySearchIterative(arr, low, high, key);
    }
}
