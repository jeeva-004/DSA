public class Main {

    static int noOfSubStrings(String s) {
        int start = 0, end = 0, subStrings = 0, a = 0, b = 0, c = 0;
        char ch;

        while (end < s.length()) {

            ch = s.charAt(end);

            a += ch == 'a' ? 1 : 0;
            b += ch == 'b' ? 1 : 0;
            c += ch == 'c' ? 1 : 0;

            while (a > 0 && b > 0 && c > 0) {
                subStrings += s.length() - end;
                ch = s.charAt(start);
                a -= ch == 'a' ? 1 : 0;
                b -= ch == 'b' ? 1 : 0;
                c -= ch == 'c' ? 1 : 0;
                start++;
            }

            end++;
        }

        return subStrings;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.print(noOfSubStrings(s));
    }
}