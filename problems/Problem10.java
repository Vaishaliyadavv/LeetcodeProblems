package problems;

public class Problem10 {
    static int n;
    static int m;
    static int[][] cache;

    public static boolean isMatch(String s, String p) {

        n = s.length();
        m = p.length();

        cache = new int[n + 1][m]; // initialized to 0s

        return topDown(0, 0, s, p);
    }

    public static boolean topDown(int i, int j, String s, String p) {
        // base cases
        if (i >= n && j >= m) {
            return true;
        } else if (j >= m) {
            return false;
        }

        // look at cache and see if (i,j) has already been calculated
        if (cache[i][j] != 0) {
            if (cache[i][j] == -1) {
                return false;
            }
            return true;
        }

        // indicates if characters s[i] and s[j] match
        boolean charsMatch = i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // indicates if characters s[i:] and p[j:] match
        boolean isMatch;

        if (j < m - 1 && p.charAt(j + 1) == '*') {
            isMatch = ((charsMatch && topDown(i + 1, j, s, p)) || topDown(i, j + 2, s, p));
        } else {
            isMatch = charsMatch && topDown(i + 1, j + 1, s, p);
        }

        if (isMatch) {
            cache[i][j] = 1;
        } else {
            cache[i][j] = -1;
        }

        return isMatch;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));
    }

}
