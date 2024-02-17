public class Problem8 {
    public static void main(String[] args) {
        // Example input string
        String input1 = "42";
        String input2 = "   -42";
        String input3 = "4193 with words";

        // Test cases
        System.out.println(myAtoi(input1)); // Output: 42
        System.out.println(myAtoi(input2)); // Output: -42
        System.out.println(myAtoi(input3)); // Output: 4193
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        int result = 0;

        // Step 1: Read and ignore leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for the sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        // Step 3: Read characters until a non-digit character is encountered
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';

            // Step 4: Check for overflow
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Step 5: Update the result
            result = result * 10 + digit;
        }

        // Apply the sign to the result
        return result * sign;
    }
}
