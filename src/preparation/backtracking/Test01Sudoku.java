package preparation.backtracking;

public class Test01Sudoku {

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        System.out.println("    0 1 2 3 4 5 6 7 8 9");
        System.out.println("    ===================");
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        new Solution().solve(grid, 0, 0);
        System.out.println("-----------------------");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    static class Solution {

        public boolean solve(int[][] grid, int row, int col) {
            if (col == grid.length && row == grid.length - 1) {
                return true;
            }

            if (col == grid.length) {
                row++;
                col = 0;
            }

            if (grid[row][col] != 0) {
                return solve(grid, row, col + 1);
            } else {
                for (int num = 1; num <= 9; num++) {
                    if (isSafe(grid, num, row, col)) {
                        grid[row][col] = num;
                        if (solve(grid, row, col + 1)) {
                            return true;
                        }
                    }
                }
                grid[row][col] = 0;
            }

            return false;
        }

        private boolean isSafe(int[][] grid, int num, int row, int col) {
            for (int i = 0; i < grid.length; i++) {
                //if the number exists in the same row
                if (grid[row][i] != 0 && grid[row][i] == num) {
                    return false;
                }

                //if the number exists in the same column
                if (grid[i][col] != 0 && grid[i][col] == num) {
                    return false;
                }

            }
            //if the number is in any of the elements of the grid that is being considered
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (grid[i][j] != 0 && grid[i][j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}