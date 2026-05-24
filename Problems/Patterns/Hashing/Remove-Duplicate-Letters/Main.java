import java.util.*;

class Main {
    static String removeDuplicateChars(String s) {

        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();   
        String removedString = "";

        for (char c : chars)
            set.add(c);
        int i = 0;
        for (char c : set)
            if (i % 2 == 0) {
                removedString += c;
                i++;
            }
        return removedString;
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";

        System.out.println(removeDuplicateChars(s));
    }
}
