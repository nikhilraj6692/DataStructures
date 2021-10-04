package preparation.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Test07LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        int length = longestUniqueSubsttr(s);
        System.out.println("The length of the longest non-repeating character substring is " + length);
    }

    /*
    same asbefore...the condition is with the value of current element. But it can also be done with map.size == j-i+1  and
    map.size < j-i+1
     */
    private static int longestUniqueSubsttr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int max = Integer.MIN_VALUE;

        while(j<s.length()){
            int val = 0;
            if(null == map.get(s.charAt(j))){
                val++;
                map.put(s.charAt(j), val);
            }else{
                val = map.get(s.charAt(j));
                map.put(s.charAt(j), ++val);
            }

            if(val == 1){
                j++;
            }else if (val > 1){
                max = Math.max(max, j-i);

                //now just make i = j and j++. also remove till i becomes j-1
                while(i!=j){
                    int val1 = map.get(s.charAt(i));
                    map.put(s.charAt(i), --val1);
                    i++;
                }

                j++;
            }
        }

        return max;
    }
}
