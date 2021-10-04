package preparation.binarysearch;

/*
we have to find the index in the array for which the difference between array value at a given index and the key is minimum...
just find the nearest number to the given number, i.e. find the floor and its index. Similarly find ceil and find diff of ceil with
key and floor with key and return minimum of two.
 */
public class Test14FindMinimumDifferenceElementInASortedArray {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 10, 12, 15 };
        int key = 8;
        System.out.println("Index = " +
                findMinDifferenceElement(arr, key));

        System.out.print("\n============================\n");
        System.out.println("Index = " +
                findMinDifferenceElementAnotherWay(arr, key));
    }

    /*
    another way is to just do a normal binary search. low and high would be floor and ceil or vice versa
     */
    private static int findMinDifferenceElementAnotherWay(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        //low would be floor and high would be ceil
        int diffValueFloor = Math.abs(arr[start] - key);
        int diffValueCeil = Math.abs(arr[end] - key);
        if(diffValueCeil > diffValueFloor){
            return start;
        }else{
            return end;
        }
    }

    private static int findMinDifferenceElement(int[] arr, int key) {
        int floorIndex = Test09FloorOfAnElementInASortedArray.floorSearchSimpler(arr, 0, arr.length-1, key);
        int ceilIndex = Test10CeilOfAnElementInASortedArray.ceilSearch(arr, 0, arr.length-1, key);
        int diffValueFloor = key - arr[floorIndex];
        int diffValueCeil = arr[ceilIndex] - key;
        if(diffValueCeil > diffValueFloor){
            return floorIndex;
        }else{
            return ceilIndex;
        }
    }
}
