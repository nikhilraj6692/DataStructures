package preparation.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test03CountOccurencesOFAnagrams {
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(text, word));

        System.out.print("\n=============================\n");
        System.out.print(countAnagramsWithoutCountingAnagrams(text, word));
    }

    /*
    the algorithm:
    first create a map of each character of pattern and maintain its count...now start checking like prev pattern. If value at
    j is not null, then decrement count(map.size()) and decrement the character count in map. go on till you hit window size.
    if count is equal to 0, meaning that you have hit all the characters. Now its turn to reverse. Increment for the character
    which is moving out of the window. Also, increment count and i and j and complete the loop....
     */
    private static int countAnagramsWithoutCountingAnagrams(String text, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            map.compute(word.charAt(i), ((k,v)->(v==null)? 1 : v+1));
        }

        int w = word.length();
        int i=0, j=0;
        int count = map.size();
        int ans = 0;

        while(j<text.length()){
            Integer val = map.get(text.charAt(j));
            if(val!=null){
                map.put(text.charAt(j), val-1);
                //main step
                if(val == 1){
                    count--;
                }
            }


            if(j-i+1 < w){
                j++;
            }else if(j-i+1 == w){
                if(count==0) {
                    ans++;
                }

                Integer val1 = map.get(text.charAt(i));
                if(val1!=null){
                    map.put(text.charAt(i), val1+1);
                    //main step
                    if(val1==0)
                        count++;
                }

                i++;
                j++;

            }
        }

        return ans;
    }

    private static int countAnagrams(String text, String word) {
        int i=0, j=0;
        int n = text.length();
        int w = word.length();

        List<String> anagrams = new ArrayList<>();
        findAnagram(word, anagrams, "");

        StringBuilder builder = new StringBuilder();
        int count = 0;

        while(j<n){
            builder.append(text.charAt(j));

            if(j-i+1 < w){
                j++;
            }else if(j-i+1 == w){
                if(anagrams.contains(builder.toString())){
                    count++;
                }
                builder.deleteCharAt(0);
                i++;
                j++;

            }
        }

        return count;
    }

    private static void findAnagram(String text, List<String> list, String prefix) {
        if(text.length() == 0){
            list.add(prefix);
            return;
        }

        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            findAnagram(text.substring(0,i) + text.substring(i+1), list, prefix + ch);
        }
    }
}
