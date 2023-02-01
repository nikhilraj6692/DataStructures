package preparation.graph;

public class Test35ShortestDistanceFromSourceToDest {

    public static void main(String[] args) {
        System.out.println(new Solution1().reachNumber(-2));
    }
}

class Solution1 {
    public int reachNumber(int target) {
        int source = 0;
        int firstMove = 1;

        return findMinPath(source, firstMove, target, 1) - 1;
    }

    private int findMinPath(int source, int move, int target, int count){
        if(source == target)
            return count;
        if(source > 0 && source > target)
            return Integer.MAX_VALUE;
        if(source < 0 && source < -target)
            return Integer.MAX_VALUE;
        int[] safePositions = new int[]{move, -move};
        int min = Integer.MAX_VALUE;
        for(int safePosition : safePositions){
            if(isSafe(source, safePosition, target)){
                min = Math.min(min,findMinPath(source + safePosition, move + 1, target, count + 1));
            }
        }

        return min;
    }

    private boolean isSafe(int source, int move, int target){
        if(source >= 0){
            return source + move <= target;
        }
        return source + move <= target;
    }
}
