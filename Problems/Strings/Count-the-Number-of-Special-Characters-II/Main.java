import java.util.*;

class Main {
    static int numberOfSpecialChars(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        String tempStr = "";
        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            set.add(s.charAt(i));

        for (char c : set)
            tempStr += c + "";

        tempStr = tempStr.toLowerCase();

        for (int i = 0; i < tempStr.length(); i++) {
            if (m.containsKey(tempStr.charAt(i)))
                m.put(tempStr.charAt(i), m.get(tempStr.charAt(i)) + 1);
            else
                m.put(tempStr.charAt(i), 1);
        }

        for (Map.Entry<Character, Integer> map : m.entrySet()) {
            if (map.getValue() > 1) {
                String a = map.getKey() + "";
                a = a.toUpperCase();
                if (s.lastIndexOf(map.getKey()) < s.indexOf(a))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaAbcBC";
        System.out.println(numberOfSpecialChars(s));
    }
}