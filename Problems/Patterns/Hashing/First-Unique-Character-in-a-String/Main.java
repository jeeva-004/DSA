import java.util.*;

class Main {
    static int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        char[] charArr = s.toCharArray();

        for (char c : charArr)
            if (map.get(c) == 1)
                return s.indexOf(c);
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(firstUniqueChar(s));
    }
}