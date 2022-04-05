package preparation.binarysearch;

/*
in this problem, the index of an element may be swapped by its left or right index, meaning that
an index at i can be swapped
with i-1 or i+1 element. So if we search at mid, we must check at mid-1, mid+1. Keep in mind that
 the array does not overflow
or underflow. If does not match at any of mid, mid-1 or mid+1, do a regular search for left or
right sub array and ensure that
the new index in case of right subarray is mid+2 and in case of left is mid-2
 */
public class Test08SearchInANearlySortedArray
{

    public static void main(String[] args)
    {
        int arr[] = {3, 2, 10, 4, 40};
        int n = arr.length;
        int x = 4;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
        {
            System.out.println("Element is not present in array");
        } else
        {
            System.out.println("Element is present at index " +
                result);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int key)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }

            //check for mid-1 and also check if mid-1 >=0
            if (mid - 1 >= start && arr[mid - 1] == key)
            {
                return mid - 1;
            }
            if (mid + 1 <= end - 1 && arr[mid + 1] == key)
            {
                return mid + 1;
            }

            //now set start and end accordingly
            if (key < arr[mid])
            {
                end = mid - 2;
            } else
            {
                start = mid + 2;
            }
        }

        return -1;
    }
}
