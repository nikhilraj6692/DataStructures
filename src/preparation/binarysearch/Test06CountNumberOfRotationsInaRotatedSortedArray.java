package preparation.binarysearch;

public class Test06CountNumberOfRotationsInaRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {2,5,6,8,11,12,15};
        int n = arr.length;

        System.out.print(countRotations(arr, n));

        System.out.print("\n==========================\n");
        arr = new int[] {15, 18, 2, 3, 6, 12, 13};
        n = arr.length;

        System.out.print(countRotations(arr, n));

        System.out.print("\n==========================\n");
        arr = new int[] {15, 18, 19, 20, 2, 3};
        n = arr.length;

        System.out.println(countRotations(arr, n));
    }

    //{15, 18, 19, 20, 2, 3};
    /*
    in this also we have to check if mid is less than prev and next. If yes, then the element before it is not sorted and the index
    is the answer. but we check that if start <= mid then surely left is sorted, we have to go to right and vice versa
     */
    private static int countRotations(int[] arr, int n) {
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            //since the array is rotated and can be rotated from n-1 to 0, so doing modulo
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;

            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                return mid;
            } else if(arr[start] <= arr[mid]){
                //means left is sorted, check in right
                start = mid + 1;
            }else if(arr[start] >= arr[mid]){
                //means right is sorted, check in left
                end = mid - 1;
            }
        }
        return 0;
    }
}
