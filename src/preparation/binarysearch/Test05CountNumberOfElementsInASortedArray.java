package preparation.binarysearch;

/*
exactly similar to prev ques (first and last occurrence of an element). if we subtract
last-first+1 we get count
 */
public class Test05CountNumberOfElementsInASortedArray
{

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int n = arr.length;
        int x = 2;
        System.out.println(countOccurrences(arr, n, x));
    }

    /*
    can also be done by first finding the element in the binary search and then count left and
    right of the element index till
    left and right element is equal to the element to be found and return count. this way time
    complexity would be O(Log n + count)
     */
    private static int countOccurrences(int[] arr, int n, int x)
    {
        int first = Test04FirstAndLastOccurenceOfAnElement.first(arr, 0, n - 1, x, n);
        int last = Test04FirstAndLastOccurenceOfAnElement.last(arr, 0, n - 1, x, n);

        return last - first + 1;
    }
}
