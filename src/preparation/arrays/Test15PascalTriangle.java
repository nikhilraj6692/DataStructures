package preparation.arrays;

public class Test15PascalTriangle
{

    public static void main(String[] args)
    {
        int[][] mat = solve(5);

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] solve(int A) {
        int mat[][] = new int[A][];
        for(int i=0;i<A;i++){
            mat[i] = new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    mat[i][j] = 1;
                }
                else{
                    mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
                }
            }
        }

        return mat;
    }

}
