package preparation.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Test2WordLadder {

    public static void main(String[] args) {
        //System.out.println(Solution.ladderLengthDFS("leet", "code", Arrays.asList("lest","leet","lose","code","lode","robe","lost")));
        System.out.println(Solution.ladderLengthBFS("leet", "code", Arrays.asList("lest","leet","lose","code","lode","robe","lost")));

    }

    static class Solution {

        static int minSoFar = Integer.MAX_VALUE;

        public static int ladderLengthDFS(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            Set<String> set = new HashSet<>();
            set.add(beginWord);
            findMinLadderLength(beginWord, endWord, wordList, 0, set);
            return minSoFar == Integer.MAX_VALUE ? 0 : minSoFar+1;
        }

        private static void findMinLadderLength(String beginWord, String endWord, List<String> wordList, int length,
            Set<String> set) {
            if (beginWord.equals(endWord)) {
                minSoFar = Math.min(minSoFar, length);
                return;
            }

            for (int i = 0; i < wordList.size(); i++) {
                if(set.contains(wordList.get(i))){
                    continue;
                }
                //find the word which all are just one character different
                int diff = findDiff(wordList.get(i), beginWord);
                if (diff == 1) {
                    set.add(wordList.get(i));
                    System.out.println(beginWord + " " + wordList.get(i) + " " + (length + 1));
                    findMinLadderLength(wordList.get(i), endWord, wordList, length + 1, set);
                }

                set.remove(wordList.get(i));
            }

        }

        private static int findDiff(String word1, String word2) {
            int diff = 0;
            for (int i = 0; i < word1.length(); i++) {
                if(word1.charAt(i)!=word2.charAt(i)){
                    diff++;
                }
                if (diff > 1) {
                    return -1;
                }
            }

            return 1;
        }

        public static int ladderLengthBFS(String beginWord, String endWord, List<String> wordsList) {
            if(!wordsList.contains(endWord))
                return 0;

            int minLength = 0;
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();

            visited.add(beginWord);
            queue.add(beginWord);

            while(!queue.isEmpty()){
                int size  = queue.size();
                while(size >0) {
                    String startWord = queue.poll();

                    if (startWord.equals(endWord)) {
                        return minLength==0?0:minLength+1;
                    }

                    for (String word : wordsList) {
                        if (!visited.contains(word)) {
                            int diff = findDiff(startWord, word);
                            if (diff == 1) {
                                System.out.println(startWord + " -> " + word + " (" + minLength + ")");
                                queue.add(word);
                                visited.add(word);

                            }
                        }
                    }
                    size--;
                }
                minLength++;
            }

            return 0 ;
        }
    }
}
