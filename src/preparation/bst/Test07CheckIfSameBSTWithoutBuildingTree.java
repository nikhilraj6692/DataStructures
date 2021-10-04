package preparation.bst;

public class Test07CheckIfSameBSTWithoutBuildingTree {
    public static void main(String[] args) {
        int[] X = { 15, 25, 20, 22, 30, 18, 10, 8, 9, 12, 6 };
        int[] Y = { 15, 10, 12, 8, 25, 30, 6, 20, 18, 9, 22 };

        if(X.length == Y.length && isSameBST(X, Y, X.length)){
            System.out.println("Is same bst");
        }else{
            System.out.println("Is not same bst");
        }
    }

    /*
    it checks if the first element of both arrays is same or not. If same, then it compares all the elements of both arrays with its
    corresponding first element. If it is smaller, then put it in the left subarray else right subarray of corresponding arrays.
    finally check if generated left subarray length of both arrays is same or not. Similarly for right subarray. And finally
    call these subarrays recursively with the subarray length.

    Return false, if any of the above case fails
     */
    private static boolean isSameBST(int[] x, int[] y, int length) {
        if(length == 0)
            return true;

        if(x[0]!=y[0])
            return false;

        int[] leftSubArrayX = new int[length-1];
        int[] rightSubArrayX = new int[length-1];
        int[] leftSubArrayY = new int[length-1];
        int[] rightSubArrayY = new int[length-1];
        int lX=0, rX=0, lY=0, rY=0;

        for(int i=1;i<length;i++){
            if(x[i]<x[0]){
                leftSubArrayX[lX++] = x[i];
            }else{
                rightSubArrayX[rX++] = x[i];
            }

            if(y[i]<y[0]){
                leftSubArrayY[lY++] = y[i];
            }else{
                rightSubArrayY[rY++] = y[i];
            }
        }

        if(lX!=lY)
            return false;
        if(rX!=rY)
            return false;

        return isSameBST(leftSubArrayX, leftSubArrayY, lX) && isSameBST(rightSubArrayX, rightSubArrayY, rX);
    }
}
