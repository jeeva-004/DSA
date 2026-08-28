import java.util.*;

public class Main{
    
    static boolean checkInclution(String s1, String s2){
        if(s1.length()>s2.length())
            return false;   
        
        int left = 0, windowSize = s1.length();
        char ch;
        HashMap<Character, Integer> forS1 = new HashMap<>();
        HashMap<Character, Integer> forS2 = new HashMap<>();

        //initialize hashMaps

        for(int i = 0; i<s1.length(); i++){
            ch = s1.charAt(i);
            forS1.put(ch, forS1.getOrDefault(ch, 0)+1);
            ch = s2.charAt(i);
            forS2.put(ch, forS2.getOrDefault(ch, 0)+1);
        }

        while(windowSize<s2.length()){
            if(forS1.equals(forS2))
                return true;
            
            ch = s2.charAt(windowSize);
            forS2.put(ch, forS2.getOrDefault(ch, 0)+1);
            
            ch = s2.charAt(left);
            if(forS2.get(ch)>1)
                forS2.put(ch, forS2.get(ch)-1);
            else
                forS2.remove(ch);
            left++;
            windowSize++;
        }

        return forS1.equals(forS2);    
    }

    public static void main(String[] args){
        String s1 = "ab", s2 = "eidbaooo";

        System.out.print(checkInclution(s1, s2));
    }
}