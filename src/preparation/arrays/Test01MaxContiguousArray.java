package preparation.arrays;

/*
based on kadane's algo...where we have a max and max ending so far, if the sum comes out to be negative, certainly
the addition of the positive and negative number to it will result in a number less than the negative number, so
in this case make max_So_far as 0 and try updating max as same time...think of [-500], here max_ending_here will
become 0 but max will be -500 only
 */
public class Test01MaxContiguousArray {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int l=0, r=-1, lmax = -1;

        for(int i=0;i<A.length;i++){
            maxEndingHere+= A[i];

            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                lmax = l;
                r = i;
            }
            if(maxEndingHere<0) {
                l = i+1;
                maxEndingHere = 0;
            }



        }

        System.out.println(lmax + " " + r);

        System.out.print(maxSoFar);
    }
}
