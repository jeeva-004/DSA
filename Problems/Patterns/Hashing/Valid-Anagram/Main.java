import java.util.HashMap;

public class Main {
    static boolean isValid(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> lookUpMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            if (lookUpMap.containsKey(s1.charAt(i)))
                lookUpMap.put(s1.charAt(i), lookUpMap.get(s1.charAt(i) + 1));
            else
                lookUpMap.put(s1.charAt(i), 1);

        for (int j = 0; j < s2.length(); j++)
            if (lookUpMap.containsKey(s2.charAt(j)))
                lookUpMap.put(s1.charAt(j), lookUpMap.get(s2.charAt(j) + 1));
            else
                return false;

        return true;
    }

    public static void main(String[] args) {
        String s1 = "car", s2 = "rat";

        System.out.println(isValid(s1, s2));
    }
}
