package preparation.graph;

public class Test34MaxRectangleArea {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0'},{'1','1'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == '1' && !visited[i][j]){
                    max = Math.max(max, findMaximalRectangle(matrix, r, c, i, j, visited));
                }
            }
        }

        return max;
    }

    private int findMaximalRectangle(char[][] matrix, int r, int c, int i, int j, boolean[][] visited){
        if(i>=0 && i<r && j>=0 && j<c && matrix[i][j] == '1' && !visited[i][j]){
            System.out.println(i +" " +j + " ");
            visited[i][j] = true;
            return 1 + findMaximalRectangle(matrix, r, c, i-1, j, visited) + findMaximalRectangle(matrix, r, c, i+1, j, visited)
                + findMaximalRectangle(matrix, r, c, i, j-1, visited) + findMaximalRectangle(matrix, r, c, i, j+1, visited);
        }
        return 0;
    }
}
