package preparation.binarysearch;

/*
this problem is again infinite, so will use previous problem concept. It is a combination of
first occurence problem and infinite
array problem,i.e. test04 and test12
 */
public class Test13FindIndexOfFirstOneInInfiniteBinarySortedArray
{

    public static void main(String[] args)
    {
        int arr[] = {0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println("Index = " +
            posOfFirstOne(arr));
    }

    private static int posOfFirstOne(int[] arr)
    {
        int low = 0;
        int high = 1;
        int key = 1;
        if (key < arr[low])
        {
            return -1;
        }

        while (key > arr[high])
        {
            low = high;
            high = high * 2;
        }
        ;

        int first = -1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key == arr[mid])
            {
                first = mid;

                //since we have to check for last occurence, so check in left subarray
                high = mid - 1;
            } else if (key < arr[mid])
            {
                high = mid - 1;
            } else
            {
                low = mid + 1;
            }
        }
        return first;
    }
}
