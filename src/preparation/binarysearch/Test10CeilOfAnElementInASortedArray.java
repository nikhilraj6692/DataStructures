package preparation.binarysearch;

/*
same as prev ques....just reverse the conditions
 */
public class Test10CeilOfAnElementInASortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x = 19;
        int index = ceilSearch(arr, 0, n-1, x);
        if(index == -1)
            System.out.println("Ceiling of "+x+" doesn't exist in array");
        else
            System.out.println("ceiling of "+x+" is "+arr[index]);
    }

    public static int ceilSearch(int[] arr, int start, int end, int key) {
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == key)
                return mid;

            if(arr[mid] < key){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }
}
