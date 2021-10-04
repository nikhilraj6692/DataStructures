package preparation.graph;

public class Test10FloydWarshallAlgorithm {
    final static int I = Integer.MAX_VALUE;
    public static void main(String[] args) {
        final int N = 4;

        // given adjacency representation of the matrix
        int[][] adjMatrix = new int[][]
                {
                        { 0, I, -2, I },
                        { 4, 0, 3, I },
                        { I, I, 0, 2 },
                        { I, -1, I, 0 }
                };

        /*
        below matrix causes negative weight cycle
         */
        /*int[][] adjMatrix =
                {
                        { 0,    I, -2, I },
                        { 4,    0,    -3, I },
                        { I, I, 0,    2 },
                        { I, -1, I, 0 }
                };*/

        // Run Floyd–Warshall algorithm
        /*
        In this algorithm, we iterate a loop of k as each vertex and puts it as an intermediate vertex between i and j vertices
        of adjacency matrix. If by change, the sum of distance[i][k] and distance[k][j] sum comes to be smaller than direct
        distance between i and j, i.e distance[i][j], then update the distance matrix. To determine the path, we create a path matrix
         */
        floydWarshall(adjMatrix, N);
    }

    private static void floydWarshall(int[][] adjMatrix, int n) {
        int[][] distanceMatrix = new int[n][n];
        int[][] pathMatrix = new int[n][n];
        //create a distance matrix same as adj matrix
        for(int i=0; i< n; i++){
            for(int j=0; j< n ; j++){
                distanceMatrix[i][j] = adjMatrix[i][j];

                if(i==j)
                    pathMatrix[i][j] = 0;
                else if (adjMatrix[i][j]==I)
                    pathMatrix[i][j] = -1;
                else
                    //doing this because lets say that a shortest path exists between two vertex 0 and 1 as 0->1, then when we go to
                    //find path [0][1], it would give source vertex i.e. 0 and we can print 0->1
                    pathMatrix[i][j] = i;
            }
        }

        /*
        start with intermediate vertex here
         */
        for(int k=0; k < n ; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distanceMatrix[i][k] != Integer.MAX_VALUE
                            && distanceMatrix[k][j] != Integer.MAX_VALUE &&
                            distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        pathMatrix[i][j] = pathMatrix[k][j];
                    }

                }

                /*
                    use case for negative weight cycle
                     */
                if(distanceMatrix[i][i] < 0){
                    System.out.println("Negative weight cycle is found");
                    return;
                }
            }
        }

        //print distance matrix
        for(int i=0; i< distanceMatrix.length; i++){
            for(int j=0; j<distanceMatrix[i].length ; j++){
                if(distanceMatrix[i][j] == I){
                    System.out.print("I  ");
                }
                else{
                    System.out.print(distanceMatrix[i][j] + "  ");
                }
            }
            System.out.println();
        }

        System.out.print("\n---------------------------\n");

        //print path matrix
        for(int i=0; i< n; i++){
            for(int j=0; j< n ; j++){
                    System.out.print(pathMatrix[i][j] + "  ");
                }
            System.out.println();
        }

        //print path from one vertex to another
        System.out.print("\n---------------------------\n");
        printPath(pathMatrix, n);
    }

    private static void printPath(int[][] pathMatrix, int n) {
        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                if(i!=j && pathMatrix[i][j] !=-1){
                    System.out.print("Path from " + i + " to " + j + " ==> " + i + "->" );
                    findPath(pathMatrix, i, j);
                    System.out.println(j);
                }
            }
        }
    }

    private static void findPath(int[][] pathMatrix, int i, int j) {
        if(pathMatrix[i][j] == j || pathMatrix[i][j]==i)
            return;

        findPath(pathMatrix, i, pathMatrix[i][j]);
        System.out.print(pathMatrix[i][j] + "->");
    }
}
