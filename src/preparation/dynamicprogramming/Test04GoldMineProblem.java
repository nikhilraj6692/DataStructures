package preparation.dynamicprogramming;


import java.util.LinkedList;
import java.util.Queue;

public class Test04GoldMineProblem {
    public static void main(String[] args) {
        int gold[][]= { {1, 3, 10, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2} };

        int m = 4, n = 4;

        for(int i=0; i<m; i++) {
            int j=0;
            int cost =0;
            getMaxGold(gold, m, n, i, j, cost);
        }

        System.out.println(max);

        boolean[][] visited = new boolean[m][n];
        int max= Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max = Math.max(max, getMaxGoldWithQueue(gold, m, n, visited,i, 0));}
        System.out.println(max);

        /*
        very easy way..start from last column and iterate each column for all rows. For each row, replace gold[row][column] with
        max of right, right up and right down of gold[row][column]. Finally find max of all the rows at 0th column
         if no point exists for right,right up or right down, replace cost by 0;
         */
        System.out.print(getMaxGoldByDP(gold, m, n));
    }

    private static int getMaxGoldByDP(int[][] gold, int m, int n) {
        for(int col=n-1; col>=0; col--){
            for(int row=0; row<m;row++){
                int r = col+1>=0 && col+1<n?gold[row][col+1]:0;
                int ru = row-1>=0 && row-1<m && col+1>=0 && col+1<n?gold[row-1][col+1]:0;
                int rd = row+1>=0 && row+1<m && col+1>=0 && col+1<n?gold[row+1][col+1]:0;
                gold[row][col] = gold[row][col] + Math.max(r,Math.max(ru, rd));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max = Math.max(max, gold[i][0]);
        }

        return max;
    }

    private static int getMaxGoldWithQueue(int[][] gold, int m, int n, boolean[][] visited, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, gold[r][c]));
        visited[r][c] = true;
        int max= 0;

        while(!q.isEmpty()){
            Point point = q.poll();

            int[] xPositions = new int[]{point.x, point.x-1, point.x+1};
            int[] yPositions = new int[]{point.y+1, point.y+1, point.y+1};

            for(int k=0;k<xPositions.length;k++){
                if(isValid(xPositions[k], m) && isValid(yPositions[k], n)){
                    //if(!visited[xPositions[k]][yPositions[k]]){
                        //visited[xPositions[k]][yPositions[k]] = true;
                        q.add(new Point(xPositions[k], yPositions[k], point.cost + gold[xPositions[k]][yPositions[k]]));
                    //}

                }
            }

            max = Math.max(max, point.cost);

        }
        return max;
    }

    private static int max = 0;

    /*
    without queue;
     */
    private static int getMaxGold(int[][] gold, int m, int n, int x, int y, int cost){

        int initial = gold[x][y];
        cost+= initial;

        boolean positionsValid = false;
        if(x>=0 && x<m && y>=0 && y<n) {
            int[] xValidPos = new int[]{x - 1 , x + 1, x};
            int[] yValidPos = new int[]{y + 1, y + 1, y+1};


            for (int k = 0; k < xValidPos.length; k++) {
                if (isValid(xValidPos[k], m) && isValid(yValidPos[k], n)) {
                    positionsValid = true;
                    x = xValidPos[k];
                    y = yValidPos[k];
                    getMaxGold(gold, m, n, x, y , cost);
                }
            }
        }

        if(!positionsValid){
            max= Math.max(cost,max);
        }
        return cost;

    }

    private static boolean isValid(int c, int num) {
        return c>=0 && c<num;
    }
}

class Point{
    public int x;
    public int y;
    public int cost;

    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}