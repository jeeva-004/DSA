import java.util.*;

class Main {

    static int numberOfSpecialChars(String s) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++)
            set.add(s.charAt(i));
        s = "";
        for (char c : set)
            s += c + "";
        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        set.clear();
        for (Map.Entry<Character, Integer> m : map.entrySet())
            if(m.getValue()>1)
                set.add(m.getKey());
        return set.size();
    }

    public static void main(String[] args) {
        String s = "abBCab";

        System.out.println(numberOfSpecialChars(s));
    }
}