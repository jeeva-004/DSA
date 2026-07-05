import java.util.*;

public class Main{
    static String minWindow(String s, String t) {

        if(s.length()<t.length())
            return "";

        HashMap<Character, Integer> strT = new HashMap<>();
        HashMap<Character, Integer> strS = new HashMap<>();

        for(int i = 0; i<t.length(); i++)
            strT.put(t.charAt(i), strT.getOrDefault(t.charAt(i), 0)+1);
        
        int requiredUnique = strT.size();
        int formedUnique = 0;

        int start = 0, traveller = 0;
        int minStart = 0, minLength = Integer.MAX_VALUE;

        while(traveller<s.length()){
            char c = s.charAt(traveller);
            strS.put(c, strS.getOrDefault(c,0)+1);

            if(strT.containsKey(c)&&strS.get(c).equals(strT.get(c)))
                formedUnique++;

            while(formedUnique==requiredUnique){
                if(traveller-start+1<minLength){
                    minStart = start;
                    minLength = traveller-start+1;
                }
                
                c = s.charAt(start);
                strS.put(c, strS.get(c)-1);

                if(strT.containsKey(c)&&strT.get(c)>strS.get(c))
                    formedUnique--;

                start++;
            }

            traveller++;
        }
        
        return minStart==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLength);
    }
        
    public static void main(String[] args){
        String s = "ADOBECODEBANC", t = "a";

        System.out.println(minWindow(s, t));
    }
}