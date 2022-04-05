package preparation.binarysearch;

public class Test07FindAnElementInARotatedSortedArray
{

    public static void main(String[] args)
    {
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr1.length;
        int key = 7;
        System.out.println("Index of the element is : "
            + pivotedBinarySearch(arr1, n, key));

        System.out.print("\n=========================\n");
        System.out.println("Index of the element is : "
            + pivotedBinarySearchRecursiveOnePass(arr1, n, key, 0, n - 1));
    }

    /*
    search in left if start is less than mid, then search for key if key is between start and mid
     then search in left or search
     in right
     */
    private static int pivotedBinarySearchRecursiveOnePass(int[] arr, int n, int key, int start,
        int end)
    {
        if (start > end)
        {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == key)
        {
            return mid;
        }

        //left array is sorted....try searching in this one
        if (arr[start] <= arr[mid])
        {
            if (arr[start] <= key && key <= arr[mid])
            {
                return pivotedBinarySearchRecursiveOnePass(arr, n, key, start, mid - 1);
            }
            return pivotedBinarySearchRecursiveOnePass(arr, n, key, mid + 1, end);
        }

        if (key >= arr[mid] && key <= arr[end])
        {
            return pivotedBinarySearchRecursiveOnePass(arr, n, key, mid + 1, end);
        }
        return pivotedBinarySearchRecursiveOnePass(arr, n, key, start, mid - 1);

    }

    /*
    same question as before...we can find out the pivot(min element in array) before which array
    is rotated and from which array
     is not rotated.Now we got two sub arrays. Find element in any one of the two. If found, then
      return otherwise return -1;
     */
    private static int pivotedBinarySearch(int[] arr, int n, int key)
    {
        int start = 0;
        int end = n - 1;
        int pivot = 0;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            //check for pivot
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
            {
                pivot = mid;
                break;
            } else if (arr[start] <= arr[mid])
            {
                //left is sorted...search in right. equal to is must otherwise infinite loop
                start = mid + 1;
            } else if (arr[mid] <= arr[end])
            {
                //right is sorted...search in left. equal to is must otherwise infinite loop
                end = mid - 1;
            }
        }

        //form two binary arrays with pivot and search in them
        int left = Test01BinarySearch.binarySearchIterative(arr, 0, pivot - 1, key);
        int right = Test01BinarySearch.binarySearchIterative(arr, pivot, n - 1, key);

        if (left == -1 && right == -1)
        {
            return -1;
        } else
        {
            return Math.max(left, right);
        }
    }
}
