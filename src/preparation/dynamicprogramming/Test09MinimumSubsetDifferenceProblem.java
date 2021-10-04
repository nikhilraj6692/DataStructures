package preparation.dynamicprogramming;

public class Test09MinimumSubsetDifferenceProblem {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 15, 5, 25  };
        int n = arr.length;

        /*
        a variant of subset sum problem only...but here we have to find out the subset such that abs(sum of subset1 - sum of subset2)
        is minimum, like here {3,4} and {1,2,2,1}, diff is 1 which is minimum. s1 + s2 = range, or s2 = range -s1. we have to find
        min = abs(s2-s1) or abs(s1-s2), or min = abs(s1-(range-s1))
         */
        System.out.println("The minimum difference"
                + " between two sets is "
                + findMin(arr, n));

        /*
        there is a way via dp, where we try to check only those elements in the last index of n corresponding to the half of the
        total sum and then find minimum of range-2s1
         */
        System.out.print("The minimum difference"
                + " between two sets is "
                + findMinByDP(arr, n));
    }

    private static int findMinByDP(int[] arr, int n) {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
            sum+= arr[i];

        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0)
                    dp[i][j] = true;
                else if(i==0)
                    dp[i][j] = false;
                else if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        int min=Integer.MAX_VALUE;
        for(int j=1;j<=sum/2;j++){
            if(dp[n][j]){
                min = Math.min(min, sum-2*j);
            }
        }

        return min;
    }

    private static int findMin(int[] arr, int n) {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
            sum+= arr[i];

        return findRecursive(arr, n, sum, 0);
    }

    private static int findRecursive(int[] arr, int n, int sum, int sumTillNow) {
        if(n==0)
            return Math.abs(sumTillNow-(sum-sumTillNow));

        return Math.min(findRecursive(arr, n-1, sum, sumTillNow + arr[n-1]),
                    findRecursive(arr, n-1, sum, sumTillNow));

    }
}
