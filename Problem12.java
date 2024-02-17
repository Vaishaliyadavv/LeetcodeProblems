// https://leetcode.com/problems/integer-to-roman/description/

public class Problem12 {
    public static String intToRoman(int num) {
        String Roman = "";
        String[] notations = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        for (int pos = 0; num > 0; pos++) {
            while (num >= value[pos]) {
                Roman += notations[pos];
                num -= value[pos];
            }
        }
        return Roman;
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
