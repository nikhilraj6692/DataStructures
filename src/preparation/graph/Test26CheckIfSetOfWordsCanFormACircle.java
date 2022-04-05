package preparation.graph;

import preparation.util.Graph;

/*
Consider the following set of words:

[ANT, OSTRICH, DEER, TURKEY, KANGAROO, TIGER, RABBIT, RAT, TOAD, YAK, HYENA]


The words can be rearranged as follows to form a circle. Note that, for any pair of consecutive
words (X → Y) in the circle, the last character of the word X is the same as the first character
of the word Y.

    ANT → TIGER → RABBIT → TOAD
     ↑                      ↓
   HYENA                   DEER
     ↑                      ↓
  OSTRICH                  RAT
     ↑                      ↓
  KANGAROO   ←  YAK   ←   TURKEY
 */
public class Test26CheckIfSetOfWordsCanFormACircle
{

    public static final int CHAR_SIZE = 128;

    public static void main(String[] args)
    {
        String[] words = {
            "ANT", "OSTRICH", "DEER", "TURKEY", "KANGAROO",
            "TIGER", "RABBIT", "RAT", "TOAD", "YAK", "HYENA"
        };

        /*
        can be done through checking a eurelian circuit ina directed graph. to do that we will
        have to create a graph out of words.
        the edges can be formed with first and last letter of the word
         */
        if (checkArrangement(words))
        {
            System.out.println("The given words can be rearranged");
        } else
        {
            System.out.println("The given words cannot be rearranged");
        }
    }

    private static boolean checkArrangement(String[] words)
    {
        Graph graph = new Graph(CHAR_SIZE);
        for (int i = 0; i < words.length; i++)
        {
            int src = words[i].charAt(0);
            int dest = words[i].charAt(words[i].length() - 1);

            graph.adjList.get(src).add(dest);
        }

        if (Test24EurelianCyleInDirectedGraph.hasEulerianCycle(graph, CHAR_SIZE))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
