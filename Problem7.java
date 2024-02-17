// https://leetcode.com/problems/reverse-integer/description/
public class Problem7 {
    public static int reverse(int x) {
        int rev = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }

            rev = (rev * 10) + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}
