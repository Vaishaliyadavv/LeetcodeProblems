package problems;

public class Problem6 {
    public static String convert(String s, int numRows) {
        int n = s.length();

        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer(); // this will create numRows String elements and then we will append to each of
                                         // the element and the we will make a string of all the string elements
        }

        int i = 0;
        while (i < n) {
            // vertically downwards

            for (int j = 0; j < numRows && i < n; j++) {
                arr[j].append(s.charAt(i++));
            }
            // bent upwards

            for (int j = numRows - 2; j > 0 && i < n; j--) {
                arr[j].append(s.charAt(i++));
            }
        }

        StringBuffer result = new StringBuffer();
        for (StringBuffer a : arr) {
            result.append(a);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
