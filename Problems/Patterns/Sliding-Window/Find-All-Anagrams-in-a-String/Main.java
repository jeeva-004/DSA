import java.util.*;

public class Main {

    static List<Integer> findAnagrams(String s, String p) {
        
        if(s.length()<p.length())
            return new ArrayList<>(0);
        
        List<Integer> anagrams = new ArrayList<>();

        //create a map to count p string chars occurace
        HashMap<Character, Integer> pm = new HashMap<>();
        for(int i = 0; i<p.length(); i++)
            pm.put(p.charAt(i), pm.getOrDefault(p.charAt(i), 0)+1);

        //set a starting and window size, build a initial window map
        int start = 0, windowSize = p.length()-1;
        HashMap<Character, Integer> sm = new HashMap<>();

        for(int i = 0; i<=windowSize; i++)
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0)+1);

        while(windowSize < s.length()-1){
            if(sm.equals(pm))
                anagrams.add(start);
            start++;
            windowSize++;
            sm.put(s.charAt(windowSize), sm.getOrDefault(s.charAt(windowSize), 0)+1);
            if(sm.get(s.charAt(start-1))>1)
                sm.put(s.charAt(start-1), sm.get(s.charAt(start-1))-1);
            else
                sm.remove(s.charAt(start-1));
        }

        //the while loop ends before to check the sm map is equals or not so after finish the loop to explicity check if the sm equals pm add the start position to the anagrams
        
        if(sm.equals(pm))
            anagrams.add(start);

        return anagrams;

    }

    public static void main(String[] args) {
        String s = "cbaebabacdabc", p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}