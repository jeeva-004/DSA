import java.util.*;

class Main {

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> forS = new HashMap<>();
        HashMap<Character, Character> forT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (forS.containsKey(s.charAt(i))) {
                if (t.charAt(i) != forS.get(s.charAt(i)))
                    return false;
                else
                    forS.put(s.charAt(i), t.charAt(i));
            } else if (forT.containsKey(t.charAt(i))) {
                if (s.charAt(i) != forT.get(t.charAt(i)))
                    return false;
                else
                    forT.put(t.charAt(i), s.charAt(i));
            } else {
                forS.put(s.charAt(i), t.charAt(i));
                forT.put(t.charAt(i), s.charAt(i));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "title", t = "paper";

        System.out.println(isIsomorphic(s, t));
    }
}