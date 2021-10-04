package preparation.dynamicprogramming;

/*
in this problem, we have to find minimum distance between two strings such that three operations may be possible,
i.e. insert a character in another string to make one string equal to another, replace characters in one string
with character in second string, third delete a character in a string

case 1: lets say that we have two strings:
s1 = abc
s2 = ""

in this case if one string is empty then obvious answer is that we have to do 3 insertions here. The rule applies
to vice versa also.

case 2:
str1 = add
str2 = abd

here, the last character of both are same, since we have to find out minimum operation so we will just have to
move one character left in both strings, and the string would shorted by ab and ad respectively

case 3:
str1 = adc
str2 = abd

if last character is not same, then we have to do three operations and see that what could be the minimum value of
the three operations

a) if we insert last character of one string in another, then two cases will form
    i) adc,abd -> adcd, abd (insertion of d in first string) -> it will now become case 2 as both characters at the
    end are same and since we just move to left in both strings in this case, so resulting strings would be
    adc,ab  ====> fn(s1,s2,x,y-1)
    ii) adc,abd -> adc, abcc (insertion of c in second string) -> it will now become case 2 as both characters at the
    end are same and since we just move to left in both strings in this case, so resulting strings would be
    ad,abc  ====> fn(s1,s2,x-1,y)

b) if we replace a character in first string into second or vice versa, again we have two cases
    i) adc, abd -> add, abd (case 2) -> ad,ab ===>fn(s1,s2,x-1,y-1)
    ii) adc,abd -> adc, abc (case 2) -> ad,ab ===>fn(s1,s2,x-1,y-1)

c) if we delete a character in first or vice versa, again we have two cases
    i) adc, abd -> ad, abd ===>fn(s1,s2,x-1,y)
    ii) adc,abd -> adc, ab ===>fn(s1,s2,x,y-1)


so we have total common functions which we have created are :
fn(s1,s2,x,y-1)
fn(s1,s2,x-1,y)
fn(s1,s2,x-1,y-1)
 */
public class Test35EditDistanceProblem {
    public static void main(String[] args) {
        System.out.print(minDistance("kitten","sitting"));
    }
    public static int minDistance(String A, String B) {
        int x = A.length();
        int y = B.length();
        int[][] dp = new int[x+1][y+1];

        for(int i=0;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                dp[i][j]=-1;
            }
        }

        int length = findSubSequence(A.toCharArray(), B.toCharArray(), x, y, dp);
        return length;
    }

    private static int findSubSequence(char[] a, char[] b, int x, int y, int[][] dp){
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        if(x==0)
            return y;
        else if(y==0)
            return x;

        if(a[x-1] == b[y-1]){
            dp[x][y] = findSubSequence(a, b, x-1, y-1, dp);
            return dp[x][y];
        }else{
            dp[x][y] = 1 + min(findSubSequence(a,b,x-1,y,dp), findSubSequence(a,b,x,y-1,dp),
                    findSubSequence(a,b,x-1,y-1,dp));
            return dp[x][y];
        }
    }

    private static int min(int a, int b, int c) {
        int min = Math.min(a,b);
        return Math.min(min, c);
    }
}
