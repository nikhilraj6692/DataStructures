package preparation.binarysearch;

public class Test09FloorOfAnElementInASortedArray
{

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};
        int n = arr.length;
        int x = 3;
        int index = floorSearch(
            arr, 0, n - 1,
            x);
        if (index == -1)
        {
            System.out.println(
                "Floor of " + x + " dosen't exist in array ");
        } else
        {
            System.out.println(
                "Floor of " + x + " is " + arr[index]);
        }

        System.out.print("======================================\n");
        index = floorSearchSimpler(
            arr, 0, n - 1,
            x);
        if (index == -1)
        {
            System.out.println(
                "Floor of " + x + " dosen't exist in array ");
        } else
        {
            System.out.println(
                "Floor of " + x + " is " + arr[index]);
        }
    }

    /*
    here is another simpler way to do...just do the binary search as it is and update the ans if
    mid is less than key.
     */
    public static int floorSearchSimpler(int[] arr, int start, int end, int key)
    {
        int ans = -1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }

            if (arr[mid] < key)
            {
                ans = mid;
                start = mid + 1;
            } else
            {
                end = mid - 1;
            }
        }

        return ans;
    }


    /*
    one way is to do binary operations the normal way. but while modifying start and end
    positions we will also check that
    if we are moving to left, then mid-1<key or not. if less then it means that key would not
    present but its floor is certainly
    present and that would be mid-1. same for mid+1 check > key. Also ensure that you are doing
    checks for mid-1 and mid+1 for
    overflow conditions.
     */
    private static int floorSearch(int[] arr, int start, int end, int key)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }

            if (arr[mid] < key)
            {
                if (mid + 1 > end || (mid + 1 <= end && key < arr[mid + 1]))
                {
                    return mid;
                }
                start = mid + 1;
            } else
            {
                if (mid - 1 >= start && key > arr[mid - 1])
                {
                    return mid;
                }
                end = mid - 1;
            }
        }

        return -1;
    }
}
