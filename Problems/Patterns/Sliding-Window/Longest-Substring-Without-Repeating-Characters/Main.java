import java.util.*;

public class Main{
    static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<>();

        int left = 0, right = 0, maxlength = 0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxlength = Math.max(maxlength, set.size());
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
            }

        return maxlength;
    }
    
    public static void main(String[] args){
        String s = "bbbbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}