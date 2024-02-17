// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Problem2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String a = "";

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            String currentsubstring = "" + ch1;

            for (int j = i + 1; j < s.length(); j++) {
                char ch2 = s.charAt(j);

                if (!currentsubstring.contains(String.valueOf(ch2))) {
                    currentsubstring += ch2;
                } else {
                    break; // stopping the inner loop if ch2 is already in currentsubstring
                }
            }
            if (currentsubstring.length() > a.length()) {
                a = currentsubstring;
            }
        }
        System.out.println(a.length());
    }
}
