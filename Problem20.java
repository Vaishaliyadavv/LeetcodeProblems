// https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class Problem20 {
    boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    boolean isMatching(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isOpening(curr)) {
                st.push(curr);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else if (!isMatching(st.peek(), curr)) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
