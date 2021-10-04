package preparation.stack;

import java.util.Stack;

/*
in this problem, there would be a given matrix of set of people. like in below example, 4 people are there. if A knows B, then A
can't be a celebrity and if A does not know B, then B can't be a celebrity because if B would have been a celebrity then A would
have known  B. This way we have to find who is celebrity in least time complexity
 */
public class Test14CelebrityProblem {
    public static void main(String[] args) {
        int MATRIX[][] = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

        /*
        no celebrity
        { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
         */

        int n = 4;
        int id = Celebrity(n,MATRIX);
        if (id == -1) {
            System.out.println("No celebrity");
        }
        else {
            System.out.println("Celebrity ID " + id);
        }

        System.out.print("\n================================\n");
        id = CelebrityByGraph(n,MATRIX);
        if (id == -1) {
            System.out.println("No celebrity");
        }
        else {
            System.out.println("Celebrity ID " + id);
        }

        System.out.print("\n================================\n");
        id = CelebrityByStack(n,MATRIX);
        if (id == -1) {
            System.out.println("No celebrity");
        }
        else {
            System.out.println("Celebrity ID " + id);
        }
    }

    /*
    create a stack of all the elements. take two elements from stack, lets say A and B. if A knows B, then A can't be a celebrity
    so add only B back to stack as there is a chance that B is a celebrity. Similarly, if A does not know B, then B can't be a
    celebrity because if B would have been a celebrity then A would have known  B but there is a chance that A is a celebrity,
    so push A back to stack. repeat this until the elements in the stack is > 1. If by chance stack is empty then return -1 (no
    celebrity) but if not, then check for last element of stack and check if it is a celebrity by going from 0 to n. Also note
    that for i = celebrity id, dont check as it is the same person
     */
    private static int CelebrityByStack(int n, int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            stack.push(i);
        }

        while(stack.size()>1){
            int A = stack.pop();
            int B = stack.pop();

            if(knows(A,B, matrix)){
                stack.push(B);
            }else{
                stack.push(A);
            }
        }

        if(stack.isEmpty()){
            return  -1;
        }

        //last element
        int last = stack.pop();

        for(int i=0;i<n;i++){
            if(i!=last && knows(i,last, matrix) && !knows(last, i, matrix)){
                return (last+1);
            }
        }

        return -1;
    }

    private static boolean knows(int a, int b, int[][] matrix) {
        if(matrix[a][b] == 1)
            return true;
        return false;
    }

    /*
    if there is a celebrity then there would be a link from one person to other person. If the indegree of a node is N-1 and
    outdegree is 0, then that is a celebrity
     */
    private static int CelebrityByGraph(int n, int[][] matrix) {
        int[] outdegree = new int[n];
        int[] indegree = new int[n];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] != 0){
                    outdegree[i]+= 1;
                    indegree[j]+= 1;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return (i+1);
        }

        return -1;
    }

    /*
    one way is to do by matrix iteration. for each row check if the value corres to column is 0 or not...if not, then the index
    cant be a celebrity.
     */
    private static int Celebrity(int n, int[][] MATRIX) {
        boolean found;
        for(int i=0;i<MATRIX.length;i++){
            found = true;
            for(int j=0;j<MATRIX[i].length;j++){
                if(MATRIX[i][j] != 0)
                    found = false;
            }

            if(found == true){
                return (i+1);
            }
        }
        return -1;
    }
}
