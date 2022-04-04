package preparation.arrays;

/*
Problem Description

You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to
    (x-1, y-1),
    (x-1, y)  ,
    (x-1, y+1),
    (x  , y-1),
    (x  , y+1),
    (x+1, y-1),
    (x+1, y)  ,
    (x+1, y+1)
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.



Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class Test16MinimumDistance
{

    /*
    Solution: If we think of a rectangle region between two points, then minimum distance to move from one point to other would
    be a diagonal from start point to the edge of rectangle region which would be min(x2-x1, y2-y1) and from that point to dest
    point, would be max(x2-x1, y2-y1) - min(x2-x1, y2-y1). Total would be max(x2-x1, y2-y1)
      |--->> diagonal distance which would be minimum
    |-|-/--|--.(y1-y2)
    | |/   |  |
    | /    |----->> max - min
    |/--------|
    . (x1,x2)
     */
    public static void main(String[] args)
    {
        System.out.println(coverPoints(new int[]{0, 1, 1}, new int[]{0, 1, 2}));
    }

    public static int coverPoints(int[] A, int[] B) {
        int[] validX = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] validY = new int[]{-1,0,1,-1,1,-1,0,1};

        int count = 0;

        for(int i=1;i<A.length;i++){
            int srcX = A[i-1];
            int srcY = B[i-1];
            int destX = A[i];
            int destY = B[i];


            int deltaX = Math.abs(srcX - destX);
            int deltaY = Math.abs(srcY - destY);

            count+= Math.max(deltaX, deltaY);
        }

        return count;
    }
}
