import java.util.*;

class Main {

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> forS = new HashMap<>();
        HashMap<Character, Character> forT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            forS.put(s.charAt(i), t.charAt(i));
            forT.put(t.charAt(i), s.charAt(i));
        }

        for(int i = 0; i<t.length(); i++){
            
        }

        System.out.println(forS);
        System.out.println(forT);

        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";

        System.out.println(isIsomorphic(s, t));
    }
}