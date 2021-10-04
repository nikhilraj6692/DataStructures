package preparation.binarysearch;

/*
Find peak element as test16findmaxinbitonicarray. this your pivot. cut it into two sub arrays and find the element. one with
sorted subarray(test01) and other wth sorted subarray in decreasing order(test02) and the last one is pivot itself
 */
public class Test17SearchInBitonicArray {
    public static void main(String[] args) {
        int arr[] = { -8, 1, 2, 3, 4, 5, -2, -3 };
        int key = -2;
        int n, l, r;
        n = arr.length;
        l = 0;
        r = n - 1;
        int index;
        index = findBitonicPoint(arr, n, l, r);

        int x = searchBitonic(arr, n, key, index);

        if (x == -1) {
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element Found at index "
                    + x);
        }
    }

    private static int searchBitonic(int[] arr, int n, int key, int index) {
        if(key == arr[index])
            return index;

        int left = Test01BinarySearch.binarySearchIterative(arr, 0, index-1, key);
        int right = Test02BinarySearchOnReverseSortedArray.binarySearch(arr, index+1, n-1, key);

        if(left==-1 && right==-1) {
            return -1;
        }else{
            return Math.max(left, right);
        }
    }

    private static int findBitonicPoint(int[] arr, int n, int l, int r) {
        return Test15FindPeakElement.findPeak(arr, n, l, r);
    }
}
