package preparation.binarysearch;

/*
wherever sorted comes, think of binary search for O(logn) time complexity. also note that all the
 problems in this package can be
done by linear search
 */
public class Test01BinarySearch
{

    public static void main(String[] args)
    {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
        {
            System.out.println("Element not present");
        } else
        {
            System.out.println("Element found at index " + result);
        }

        System.out.print("\n=================\n");
        result = binarySearchIterative(arr, 0, n - 1, x);
        if (result == -1)
        {
            System.out.println("Element not present");
        } else
        {
            System.out.println("Element found at index " + result);
        }
    }

    public static int binarySearchIterative(int[] arr, int start, int end, int elem)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (elem == arr[mid])
            {
                return mid;
            } else if (elem < arr[mid])
            {
                end = mid - 1;
            } else
            {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int elem)
    {
        int mid = start + (end - start) / 2;
        if (start > end)
        {
            return -1;
        }
        if (elem == arr[mid])
        {
            return mid;
        }

        if (elem < arr[mid])
        {
            return binarySearch(arr, start, mid - 1, elem);
        } else
        {
            return binarySearch(arr, mid + 1, end, elem);
        }
    }
}
