package preparation.dynamicprogramming;

public class Test41MaxSumSuchThatNoTwoAdjacentElementsArePicked {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(findMaxSum(arr, arr.length, 0, 0, 0));
    }

    private static int findMaxSum(int[] arr, int length, int sumSoFar, int lengthSoFar, int index) {
        if (index >=length-1) {
            return sumSoFar;
        }

        int max = Integer.MIN_VALUE;

        for (int i = index; i < length; i = i + 2) {

            max = Math.max(max, findMaxSum(arr, length, arr[i] + sumSoFar, lengthSoFar + 1, index + 2));

        }

        return max;
    }
}
