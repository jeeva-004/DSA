import java.util.HashMap;

public class Main{
    static String minWindow(String s, String t) {
        
        if(s.length()<t.length())
            return "";
        HashMap<Character, Integer> forT = new HashMap<>();
        for(int i = 0; i<t.length(); i++)
            forT.put(t.charAt(i), forT.getOrDefault(t.charAt(i),0)+1);
        System.out.println(forT);
        String minSubStr = "", currSubStr = "";
        int left = 0, right = 0;

        while(right<s.length()){
            
        }


        return minSubStr;
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s, t));
    }
}