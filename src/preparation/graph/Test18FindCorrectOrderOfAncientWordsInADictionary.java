package preparation.graph;

import preparation.util.Graph;

import java.util.*;

public class Test18FindCorrectOrderOfAncientWordsInADictionary {
    public static void main(String[] args) {
        //¥€±, €±€, €±‰ð, ðß, ±±ð, ±ßß
        List<List<String>> dict = Arrays.asList(
                Arrays.asList("¥", "€", "±"),
                Arrays.asList("€", "±", "€"),
                Arrays.asList("€", "±", "‰", "ð"),
                Arrays.asList("ð", "ß"),
                Arrays.asList("±", "±", "ð"),
                Arrays.asList("±", "ß", "ß"));

        /*
        get number of vertices included in the graph
         */
        Map<String, Integer> characterMap = new HashMap<>();
        int k = 0;

        for(List<String> characterListInAWord : dict){
            for(int i=0; i< characterListInAWord.size(); i++){
                //k++ will assign a new digit to each character which will act as a vertex in a graph
                if(!characterMap.containsKey(characterListInAWord.get(i)))
                    characterMap.putIfAbsent(characterListInAWord.get(i), k++);
            }
        }

        //create a graph from k
        Graph graph = new Graph(k);

        /*
        now create edges. since it is a dictionary, so we can compare two words in the list. IF the character mismatches then it is certain that
        character in previous word would be smaller than character in the next word, so we create a directed edge out of both
        characters and then we have to break because we can't comment about next character. If both character matches then we have
        to move to next character
         */
        for(int i=1; i < dict.size(); i++){
            // previous word in the dictionary
            List<String> prev = dict.get(i - 1);

            // current word in the dictionary
            List<String> curr = dict.get(i);
            for(int j = 0; j < curr.size() && j < prev.size(); j++){
                if(!curr.get(j).equals(prev.get(j))){
                    graph.adjList.get(characterMap.get(prev.get(j)))
                            .add(characterMap.get(curr.get(j)));
                    break;
                }
            }
        }

        //do topological sorting
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[k];

        for(int i=0;i <k; i++) {
            if(!visited[i])
                performTopologicalSort(graph, visited, stack, i);
        }

        //reverse map as the digit will have to be mapped to character again
        Map<Integer, String> reversedCharacterMap = reverseMap(characterMap);

        while(!stack.isEmpty()){
            System.out.print(reversedCharacterMap.get(stack.pop()) + " ");
        }
    }

    private static <K,V> Map<V, K> reverseMap(Map<K, V> characterMap) {
        Map<V, K> inverse = new HashMap<>();
        for (Map.Entry<K, V> entry: characterMap.entrySet()) {
            inverse.put(entry.getValue(), entry.getKey());
        }
        return inverse;
    }

    private static void performTopologicalSort(Graph graph, boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;

        for(int dest : graph.adjList.get(src)){
            if(!visited[dest])
                performTopologicalSort(graph, visited, stack, dest);
        }

        stack.push(src);
    }
}
