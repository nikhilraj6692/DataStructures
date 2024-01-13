package preparation.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Test36CheapestFlightsFromSrcToDstWithAtMostKStops
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        //System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
        System.out.println(solution.findCheapestPriceBFS(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(solution.findCheapestPriceBFS(4, flights, 0, 3, 1));
    }
    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)   {
            //create an adjacency list
            List<List<Node>> adjacencyList = new ArrayList<>();
            for(int i=0;i<n;i++) {
                adjacencyList.add(new ArrayList<>());
            }

            for(int i=0;i<flights.length;i++) {
                int source = flights[i][0];
                int destination = flights[i][1];
                int weight = flights[i][2];

                List<Node> list = adjacencyList.get(source);
                list.add(new Node(destination, weight));

            }

            boolean[] visited = new boolean[n];
            return performMinimumCost(src,dst, 0, adjacencyList, visited, 0, k);
        }

        public int performMinimumCost(int src, int dest, int cost, List<List<Node>> adjacencyList, boolean[] visited, int kSoFar, int k) {
            if(kSoFar > k && src!=dest) {
                return Integer.MAX_VALUE;
            }else if(kSoFar <= k+1 && src == dest) {
                return cost;
            }

            int min = Integer.MAX_VALUE;
            for(Node node : adjacencyList.get(src)) {
                if(!visited[node.dest]) {
                    visited[node.dest] = true;
                    min = Math.min(min, performMinimumCost(node.dest, dest, cost + node.weight, adjacencyList, visited, kSoFar + 1, k));
                    visited[node.dest] = false;
                }
            }

            return min;
        }

        public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k)
        {
            //create an adjacency list
            List<List<Node>> adjacencyList = new ArrayList<>();
            for(int i=0;i<n;i++) {
                adjacencyList.add(new ArrayList<>());
            }

            for(int i=0;i<flights.length;i++) {
                int source = flights[i][0];
                int destination = flights[i][1];
                int weight = flights[i][2];

                List<Node> list = adjacencyList.get(source);
                list.add(new Node(destination, weight));

            }

            return performMinimumCostBFS(src, dst, adjacencyList, k);
        }

        private int performMinimumCostBFS(int src, int dst, List<List<Node>> adjacencyList, int k)
        {
            boolean[] visited = new boolean[adjacencyList.size()];
            int minCost = Integer.MAX_VALUE;
            Queue<Pair<Integer, Pair<Integer,Integer>>> q = new ArrayDeque<>();
            q.add(new Pair(src,new Pair(0,0)));

            while(!q.isEmpty()) {
                Pair<Integer, Pair<Integer,Integer>> p = q.poll();
                if(p.second.second > k && p.first!=dst) {
                    minCost = Math.min(minCost, Integer.MAX_VALUE);
                    continue;
                } else if(p.second.second <= k+1 && p.first == dst) {
                    minCost = Math.min(minCost, p.second.first);
                }

                for(Node node : adjacencyList.get(p.first)) {
                    if(!visited[node.dest]) {
                        q.add(new Pair<>(node.dest, new Pair<>(p.second.first + node.weight, p.second.second + 1)));

                    }
                }
            }
            return minCost;
        }
    }

    static class Pair<K,V> {
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Node {
        int dest;
        int weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }


}
