import java.util.*;

class Main {

    static char findDifference(String s, String t) {
        HashMap<Character, Integer> lookUpMap = new HashMap<>();

        for(char c = 0; c<s.length(); c++)
            if(lookUpMap.containsKey(s.charAt(c)))
                lookUpMap.put(s.charAt(c), lookUpMap.get(s.charAt(c))+1);
            else
                lookUpMap.put(s.charAt(c), 1);

        for(char c = 0; c<t.length(); c++)
            if(lookUpMap.containsKey(t.charAt(c))&&lookUpMap.get(t.charAt(c))>0)
                lookUpMap.put(t.charAt(c), lookUpMap.get(t.charAt(c))-1);
            else
                return t.charAt(c);
        return ' ';
    }

    public static void main(String[] args) {
        String s = "e", t = "ee";

        System.out.print(findDifference(s, t));
    }
}