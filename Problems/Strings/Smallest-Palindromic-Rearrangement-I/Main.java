import java.util.*;

public class Main {
    static String smallestPalindrome(String s) {

        if (s.length() == 1)
            return s;

        HashMap<Character, Integer> frequencies = new HashMap<>();
        StringBuilder leftHalf = new StringBuilder();
        String midChar = "";

        for (int ch = 0; ch < s.length(); ch++)
            frequencies.put(s.charAt(ch), frequencies.getOrDefault(s.charAt(ch), 0) + 1);

        for (char c = 'a'; c <= 'z'; c++) {
            if (frequencies.containsKey(c)) {
                int count = frequencies.get(c);
                if (count % 2 != 0)
                    midChar = c + "";
                for (int i = 0; i < count / 2; i++)
                    leftHalf.append(c);
            }
        }

        return leftHalf.toString() + midChar + reverse(leftHalf.toString());
    }

    static String reverse(String s) {
        if (s.length() <= 1)
            return s;

        char[] chars = s.toCharArray();

        int l = 0, r = chars.length - 1;

        while (l <= r) {
            char c = chars[l];
            chars[l++] = chars[r];
            chars[r--] = c;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "babab";

        System.out.println(smallestPalindrome(s));

    }
}