package preparation.dynamicprogramming;

/*
this is a problem of unbounded knapsack where the same elements can be taken any number of times
 */
public class Test12RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = new int[] {2, 3, 7, 1, 9};
        int size = price.length;
        int length[] = new int[]{1,2,3,4,5};
        System.out.println("Maximum Obtainable Value is " +
                cutRod(price, size, length, size));

        System.out.print("\n--------------------------------------\n");
        System.out.print("Maximum Obtainable Value is " + cutRodAnotherWay(price, size));
        System.out.print("\n--------------------------------------\n");
        System.out.print("Maximum Obtainable Value is " + cutRodAnotherWayOptimized(price, size));

        System.out.print("\n--------------------------------------\n");
        System.out.print("Maximum Obtainable Value is " + cutRodAnotherWay(price, size,  0, 0));

        System.out.print("\n--------------------------------------\n");
        System.out.print(cutRodAnotherWay2(price, size,  0, 0, 0));
    }

    private static int cutRodAnotherWayOptimized(int[] price, int size) {
        int val[] = new int[size+1];
        val[0] = 0;



        for(int i=1;i<=size;i++){
            int max = Integer.MIN_VALUE;
            // divide the rod of length `i` into two rods of length `j`
            // and `i-j` each and take maximum
            for(int j=0;j<i;j++){
                max = Math.max(max, price[j] + val[i-j-1]);
            }

            val[i] = max;
        }

        return val[size];
    }

    /*
    here desired length is same as weight, length array is maintained to suffice for wt array, price is for value array and
    size is for n...it can be done similarly for dp so not including. only change is not to decrement size in cutRod(price,size
    , length, desiredLength[size-1]) because same rod can be taken more than once, leading to unbounded knapsack
     */
    private static int cutRod(int[] price, int size, int[] length, int desiredLength) {
        if(size == 0)
            return 0;

        if(length[size-1] <= desiredLength){
            return Math.max(price[size-1] + cutRod(price, size, length, desiredLength-length[size-1]),
                    cutRod(price,size-1, length, desiredLength));
        }else{
            return cutRod(price, size-1, length, desiredLength);
        }

    }
    private static int cutRodAnotherWay(int[] price, int size) {
        if (size <= 0)
            return 0;

        int max = Integer.MIN_VALUE;

        // one by one, partition the given rod of length `n` into two parts of
        // length (0,n), (1, n-1), (2, n-2), (3, n-3), … ,(n-1, 1), (n, 0) and
        // take maximum
        for(int i=0;i<size;i++){
            //System.out.println("i is " + i + " and size is " + size);
            max = Math.max(max, price[i] + cutRodAnotherWay(price, size-i-1));
            //System.out.println("Maximum at i = " +i + " and size at " + (size) + " is " + max);

        }

        return max;
    }

    private static int cutRodAnotherWay(int[] price, int size, int lengthTillNow, int priceTillNow) {
        if (lengthTillNow == size){
            return priceTillNow;
        }
        else if(lengthTillNow > size){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int j = 0; j<size && (j + 1 + lengthTillNow <= size); j++){
            //lengthTillNow+= j+1;
            //priceTillNow+= price[j];

            max = Math.max(max, cutRodAnotherWay(price, size, lengthTillNow + j + 1, priceTillNow + price[j]));

            //priceTillNow-= price[j];
            //lengthTillNow= lengthTillNow - (j + 1);
        }

        return max;
    }


    private static int cutRodAnotherWay2(int[] price, int size, int lengthTillNow, int priceTillNow, int max) {
        if (lengthTillNow == size){
            max = Math.max(max, priceTillNow);
            return max;
        }
        else if(lengthTillNow > size){
            return 0;
        }

        for(int j = 0; j<size; j++){
            //lengthTillNow+= j+1;
            //priceTillNow+= price[j];
            if(lengthTillNow+j+1<=size){
                max = Math.max(max, cutRodAnotherWay2(price, size, lengthTillNow + j + 1, priceTillNow + price[j], max));
            }


            //priceTillNow-= price[j];
            //lengthTillNow= lengthTillNow - (j + 1);
        }


        return max;
    }

}
