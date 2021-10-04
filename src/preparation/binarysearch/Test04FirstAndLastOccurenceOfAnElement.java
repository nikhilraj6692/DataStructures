package preparation.binarysearch;

public class Test04FirstAndLastOccurenceOfAnElement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int n = arr.length;
        int x = 2;
        System.out.println("First Occurrence = " + first(arr, 0, n - 1, x, n));
        System.out.println("Last Occurrence = " + last(arr, 0, n - 1, x, n));
    }

    /*
    in this algo, there is a chance that even after meeting the elem at mid pos, we can find more elements at the left (end = mid -1)
    for first occurrence and we can find more elements at the right ( start = mid + 1) for last occurrence
     */
    public static int last(int[] arr, int start, int end, int elem, int n) {
        int last = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == elem){
                //last = Math.max(last, mid);
                last = mid;
                /*if(mid < end && arr[mid+1] == arr[mid]){
                    start = mid+1;
                }else{
                    break;
                }*/
                start = mid + 1;
            }
            else if(arr[mid] > elem){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return last;
    }

    public static int first(int[] arr, int start, int end, int elem, int n) {
        int first = n;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == elem){
                //first = Math.min(first, mid);
                first = mid;
                //since first occurence can happen before so
                end = mid - 1;
                /*if(mid > start && arr[mid-1] == arr[mid]){
                    end = mid-1;
                }else{
                    break;
                }*/
            }else if(arr[mid] > elem){
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return first;
    }
}
