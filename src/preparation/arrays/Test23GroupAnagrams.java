package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test23GroupAnagrams {

    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            String sortedString = sort(str);
            List<String> sortedStrings = map.get(sortedString);
            if(null == sortedStrings){
                sortedStrings = new ArrayList<>();
            }

            sortedStrings.add(str);
            map.put(sortedString, sortedStrings);

        }


        return map.entrySet().stream().map(entry->entry.getValue()).collect(Collectors.toList());
    }

    private String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
