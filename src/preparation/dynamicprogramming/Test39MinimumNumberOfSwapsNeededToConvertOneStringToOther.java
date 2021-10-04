package preparation.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
we wil use previous approach only. here we have two strings so we will keep first pointer at end of first string
and second pointer at end of second
 */
public class Test39MinimumNumberOfSwapsNeededToConvertOneStringToOther {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        int size = s2.length();
        // If both the strings are anagrams
        // of each other then only they
        // can be made equal
        if (isAnagram(s1, s2))
            System.out.println(CountSteps(s1.toCharArray(), s2.toCharArray(), size));
        else
            System.out.println(-1);

        System.out.println();

        //can be done more easily if i and j taken from start...same thing just we have to increment j and fix i, char at i and j are not same till char at i is equal to char
        //at any j...now that j is found, do a while of (i<j) and swap j with j-1 element. note that i does not change so outer while loop will work but for inner loop, we
        //will have to make j=i each time
        if (isAnagram(s1, s2))
            System.out.println(CountStepsStartingWay(s1.toCharArray(), s2.toCharArray(), size));
        else
            System.out.println(-1);
    }

    private static int CountStepsStartingWay(char[] a, char[] b, int n) {
        int i=0;
        int j;
        int count = 0;

        while(i<n){
            j=i;

            while(a[i]!=b[j]){
                j++;
            }

            while(i<j){
                char temp = b[j];
                b[j] = b[j-1];
                b[j-1] = temp;
                j--;
                count++;
            }

            i++;
        }

        return count;
    }

    private static int CountSteps(char[] toCharArray1, char[] toCharArray2, int n) {
        int initPointer = n-1;
        int count = 0;

        while(initPointer>=0){
            int p1= initPointer; int p2 = p1;
            if(toCharArray1[p1]==toCharArray2[p2]){
                p1--;
                p2--;
            }else{
                //now the characters are not same so find j such that value of char at j is equal to value of char
                //at i
                int cnt = p1-1;

                while(cnt>=0){
                    if(toCharArray1[p1] == toCharArray2[cnt]){
                        break;
                    }else{
                        cnt--;
                    }
                }

                //this will not happen as we have already checked that both strings are anagrams, so can be removed
                if(cnt<0)
                    return -1;
                else{
                    for(int k=cnt;k<p1;k++){
                        //swap adjaceent elements
                        char temp = toCharArray2[k];
                        toCharArray2[k] = toCharArray2[k+1];
                        toCharArray2[k+1] = temp;
                        count++;
                    }
                }
            }
            initPointer--;

        }
        return count;
    }

    private static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for(char c: s1Arr){
            map.compute(c, (k,v)->v==null?1:v+1);
        }

        for(char c:s2Arr){
            map.compute(c, (k,v)->v==1?null:v-1);
        }
        
        return map.size()==0;
    }
}
