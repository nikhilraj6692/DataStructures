package preparation.dynamicprogramming;

/*
we have to check if second string is a scrambled version of other. if we look closely, this is a partitioning problem and
we can recursively check for two conditions :

a) substring of 0 to k for s1 is equal to substring for 0 to k for s2 &&
   substring of k to n for s1 is equal to substring for k to n for s2
b) substring of 0 to k for s1 is equal to substring for n-k to n for s2 &&
   substring of n-k to n for s1 is equal to substring for 0 to k for s2
   ex: abcd cabd,
   at i=1, s1 will be a|bcd && s2 will be c|bad => does not match => recursively a and c would be compared and give false,
   so bcd and abd would not be compared for condition one. for second condition, a and bad are of diff lengths so will give
   false
   at i=2, s1 will be ab|cd && s2 will be cb|ad => does not match...it will go recursively for ab and ad which will not match
   for any condition and return false
   at i=2, s1 will be abc|d && s2 will be cba|d => d and d will match...for abc and cba, it will break like ab|c and c|ba. with
   second condition c and c will match. for ab and ba, it will match with second condition as a|b and b|a and return true

   more example:

        coder
       /    \
      co    der
     / \    /  \
    c   o  d   er
               / \
              e   r
    To scramble the string, we may choose any non-leaf node and swap its two children.
    Suppose, we choose the node “co” and swap its two children, it produces a scrambled string “ocder”.


        ocder
       /    \
      oc    der
     / \    /  \
    o   c  d   er
               / \
              e   r
    Thus, “ocder” is a scrambled string of “coder”.
    Similarly, if we continue to swap the children of nodes “der” and “er”, it produces a scrambled string “ocred”.


        ocred
       /    \
      oc    red
     / \    /  \
    o   c  re  d
           / \
          r   e
    Thus, “ocred” is a scrambled string of “coder”.

 */
public class Test28ScrambledString {
    public static void main(String[] args) {
        String S1 = "abcd";
        String S2 = "cbad";

        if (isScramble(S1, S2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2))
            return true;

        int n = s1.length();
        //scrambled strings can have empty length
        if (n == 0)
            return true;


        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i,n), s2.substring(i,n)))
            return true;

            if (isScramble(s1.substring(0, i), s2.substring(n-i)) &&
                    isScramble(s1.substring(n-i), s2.substring(0, i)))
                return true;
        }

        return false;
    }
}
