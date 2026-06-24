import java.util.HashMap;
import java.util.Map;

class Main{
    
    static int characterReplacement(String s, int k){
        if(s.isEmpty())
            return 0;
        int left = 0, right = 0, maxlength = Integer.MIN_VALUE;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxOccur = Integer.MIN_VALUE;
        
        while(right<s.length()){
            //check the current map length and max occurence difference affordable for a cost k
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);

            if(map.get(s.charAt(right))>maxOccur)
                maxOccur = map.get(s.charAt(right));

            int currentLength = right-left+1;
            int imposters = currentLength - maxOccur;

            if(imposters>k){
                if(map.get(s.charAt(left))>1)
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                else
                    map.remove(s.charAt(left));

                left++;
            }
            else if(imposters<=k)
                maxlength = Math.max(currentLength, maxlength);
            right++;

        }

        return maxlength;
    }
    
    public static void main(String[] args){
        String s = "AABABBA";

        System.out.print(characterReplacement(s, 1));
    }
}