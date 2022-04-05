package preparation.binarysearch;

public class Test03OrderNotKnownSortedSearch
{

    public static void main(String[] args)
    {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;

        /*
        here order is not known so just check if the order is ascending or descending, also check
         for edge case
         */
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
        {
            System.out.println("Element not present");
        } else
        {
            System.out.println("Element found at index " + result);
        }

        arr = new int[]{5, 4, 3, 2, 1};
        int N = arr.length;
        int X = 5;
        result = binarySearch(arr, 0, N - 1, X);
        if (result == -1)
        {
            System.out.println("Element not present");
        } else
        {
            System.out.println("Element found at index " + result);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int element)
    {
        if (arr.length == 1)
        {
            if (arr[0] == element)
            {
                return 0;
            } else
            {
                return -1;
            }
        } else if (arr.length > 1)
        {
            //-1 for desc, 1 for asc (Default)
            int order = 1;

            int i = 1;
            while (i++ < arr.length)
            {
                if (arr[i] != arr[i - 1])
                {
                    if (arr[i] < arr[i - 1])
                    {
                        order = -1;
                    }
                    break;
                }
            }

            if (order == -1)
            {
                return Test02BinarySearchOnReverseSortedArray.binarySearch(arr, start, end,
                    element);
            } else
            {
                return Test01BinarySearch.binarySearchIterative(arr, start, end, element);
            }
        }
        return -1;
    }
}
