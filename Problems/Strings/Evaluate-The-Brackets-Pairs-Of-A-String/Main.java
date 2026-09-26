import java.util.*;

public class Main{

    static String evalute(String s, String[][] knowledge){
        HashMap<String, String> lookUpMap = new HashMap<>();

        for (String[] k : knowledge)
            lookUpMap.put(k[0], k[1]);

        int i = 0, j = 0;
        boolean hitBrackets = false;
        String result = "", word = " ";

        while (i < s.length()) {
            hitBrackets = false;
            if (s.charAt(i) == '(') {
                i++;
                j = i;
                hitBrackets = true;
                word = "";
                while (j < s.length() && s.charAt(j) != ')') {
                    word += s.charAt(j);
                    j++;
                    i++;
                }
                i++;
            }

            if (hitBrackets && lookUpMap.containsKey(word))
                result += lookUpMap.get(word);

            if (hitBrackets && !lookUpMap.containsKey(word))
                result += "?";

            if (!hitBrackets && i < s.length())
                result += s.charAt(i) + "";

            if (!hitBrackets)
                i++;
        }

        // System.out.print(result);

        return result;
    }

    public static void main(String[] args){

        String[][] knowledge = {{"name", "bob"}, {"age", "two"}};
        String s = "bobistwoyearsold";

        System.out.print(evalute(s, knowledge));
    }
}