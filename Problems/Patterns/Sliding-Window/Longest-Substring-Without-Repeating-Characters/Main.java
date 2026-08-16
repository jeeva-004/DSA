import java.util.*;
public class Main{
    static int lengthOfLongestSubstring(String s) {
        //set a variables to trace and store positions, values

        int left = 0, right = 0, maxlength = 0;
        
        //declare a set to trace a current substring window size

        HashSet<Character> set = new HashSet<>();

        while (right<s.length()) {
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                maxlength = Math.max(maxlength, set.size());
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
    
    public static void main(String[] args){
        String s = "pwpdwp";

        System.out.println(lengthOfLongestSubstring(s));
    }
}