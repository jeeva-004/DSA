import java.util.*;

public class Main{
    static int maxSubArrayWithTwoOccurance(String s){
        int left = 0, right = 0, maxLength = 0;
        char ch, c;
        HashMap<Character, Integer> freq = new HashMap<>();

        for(right = 0; right<s.length(); right++){
            ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
            while(freq.containsKey(ch) && freq.get(ch)>2){
                c = s.charAt(left);
                freq.put(c, freq.get(c)-1);
                left++;
            }

            maxLength = maxLength<right-left+1?right-left+1:maxLength;
        }

        return maxLength;
    }
    public static void main(String[] args){
        String s = "bcbbbcba";
        System.out.print(maxSubArrayWithTwoOccurance(s));
    }
}