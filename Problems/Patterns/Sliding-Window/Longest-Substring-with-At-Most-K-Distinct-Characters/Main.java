import java.util.*;

public class Main{
    
    static int longestSubArray(String s, int k){
        if(k>s.length())
            return -1;
        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0, longestSubArr = -1;
        char ch;
        while(right<s.length()){
            ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

            while(freq.size()>k){
                ch = s.charAt(left);
                if(freq.get(ch)>1)
                    freq.put(ch, freq.get(ch)-1);
                else
                    freq.remove(ch);
                left++;
            }

            if(freq.size()==k)
                longestSubArr = longestSubArr<right-left+1?right-left+1:longestSubArr;

            right++;
        }

        return longestSubArr;
    }

    public static void main(String[] args){
        String s = "ssss";
        int k = 2;

        System.out.print(longestSubArray(s, k));
    }
}