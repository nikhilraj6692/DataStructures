package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
in this problem, we have to find out minimum number of coins in such as way that there are infinite number of coins
from 1 to infinity and we can make a change with only odd coins.
 */
public class Test15MinimumNumberOfCoinsInfiniteCase {
    public static void main(String[] args) {
        int N = 5;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        System.out.print(countWays(1,5));
    }

    private static int countWays(int index, int wt) {
        if(wt == 0)
            return 1; //empty set condition
        if(index>wt)
            return 0;

        if(index <= wt){
            return countWays(index, wt-index) + countWays(index+1,wt);
        }else{
            return countWays(index+1, wt);
        }
    }


}
