package preparation.binarysearch;

/*
In this problem, the array is not sorted but still we can try to solve it via binary search. The
idea is that for a peak element
the element should be greater than its left and right. If by chance it is not peak then we have
to decide whether we have to move
left or right. If we think closely, we may move towards the element which is more than the
current element. It may ensure that
the element is higher than its left or right. If it is not then certainly we can have an element
at the end or at the start of
the array which would be greater than its adjacent element, depending on the direction we moved
before.

ex: 1 3 20 4 1 0
mid is 3, arr[3] = 4. it is not peak because it is greater than 1 but less than 20. So, move
towards 20 and make end = mid-1.
mid is 1, arr[1] = 3 which can't be mid, so we moved towards 20 and made start as mid + 1. Now
both start and end are at same point
so that is the answer.

Think for this ex:40 30 20 4 1 0...mid is 3, arr[3] = 4. it is not peak because it is greater
than 1 but less than 20. So, move
 towards 20 and make end = mid-1. mid is 1, arr[1] = 30 which can't be mid, so we moved towards
 40 and made end as mid - 1.
 Now both start and end are at same point so that is the answer.

 So, the movement always guarantee that we are moving towards correct direction
 */
public class Test15FindPeakElement
{

    public static void main(String[] args)
    {
        int arr[] = {1, 3, 20, 4, 1, 0};
        int n = arr.length;
        System.out.println(
            "Index of a peak point is " + findPeak(arr, n, 0, n - 1));
    }

    public static int findPeak(int[] arr, int n, int start, int end)
    {
        if (arr.length == 1)
        {
            return arr[0];
        }

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            //check for mid>0 and mid<n-1 because for mid=0 and mid=n-1 we have to check only for
            // 1 and n-2 respectively
            if (mid > 0 && mid < n - 1)
            {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                {
                    return mid;
                } else if (arr[mid - 1] > arr[mid])
                {
                    end = mid - 1;
                } else if (arr[mid + 1] > arr[mid])
                {
                    start = mid + 1;
                }
            } else
            {
                if (mid == 0)
                {
                    if (arr[0] > arr[1])
                    {
                        return 0;
                    } else
                    {
                        return 1;
                    }
                } else if (mid == n - 1)
                {
                    if (arr[n - 2] > arr[n - 1])
                    {
                        return n - 2;
                    } else
                    {
                        return n - 1;
                    }
                }
            }
        }
        return start;
    }
}
