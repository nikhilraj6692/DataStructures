package preparation.binarysearch;

/*
it is a very interesting problem. we have to find minimum number of pages which can be assigned
to m number of students such that
the pages allocated to the students must be continuous, i.e. S1 can get 12, s2 can get 34+67+90
or s1 can get 12+34 and s2 can get
67+90, s1 can get 12+34+67, s2 can get 90. It cant be possible that s1 gets 12,67 and s2 gets 34,
90. Second condition is that
one student should get at least one book. Third condition is that all the books should be
distributed in exact 'm' number of
students. We have to minimize the maximum number of pages allocated in each set. like in set1 if
S1 gets 12, s2 gets 34+67+90=191,
then max is 191. For set 2, max would be max(12+34, 67+90) = 157. for set 3, max would be 113.
So, the answer would be minimum of
all three, i.e. 113.

To solve this we add up all the elements and find end. Now find mid and find total number of
students needed to read mid.
increment count for student as and when sum of pages exceeds mid. if the number of students
exceeds 'm', then search in right
part of array, otherwise search in left part of array. Since we have to minimize, we will update
min value when left part of array
 is traversed

 */
public class Test191AllocateMinimumPagesOfBooks
{

    public static void main(String[] args)
    {
        //Number of pages in books
        int arr[] = {12, 34, 67, 90};

        int m = 2; //No. of students

        System.out.println("Minimum number of pages = " +
            findPages(arr, arr.length, m));
    }

    private static int findPages(int[] arr, int length, int m)
    {
        int end = 0;
        int start = 0;

        //calculate end by summing all the pages
        for (int i = 0; i < length; i++)
        {
            end += arr[i];
        }

        int minPages = -1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (isPossibleAlocation(arr, length, m, mid))
            {
                minPages = mid;
                end = mid - 1;
            } else
            {
                start = mid + 1;
            }
        }

        return minPages;
    }

    private static boolean isPossibleAlocation(int[] arr, int length, int m, int mid)
    {
        int count = 1;
        int pagesAllocatedToStudent = 0;

        for (int i = 0; i < length; i++)
        {
            if (pagesAllocatedToStudent + arr[i] > mid)
            {
                count++;
                pagesAllocatedToStudent = arr[i];
            } else
            {
                pagesAllocatedToStudent += arr[i];
            }
        }

        if (count == m)
        {
            return true;
        }
        return false;
    }
}
