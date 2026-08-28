import java.util.*;

public class Main{
    
    static boolean isNStraightHands(int[] hands, int groupSize){

        if(hands.length % groupSize !=0)
            return false;

        Arrays.sort(hands);
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int hand: hands){
            freq.put(hand, freq.getOrDefault(hand, 0)+1);
        }

        int startIndex = 0;

        while(!freq.isEmpty()){
            int size = 1;
            int start = hands[startIndex];

            if(freq.get(hands[startIndex])>1)
                freq.put(hands[startIndex], freq.get(hands[startIndex])-1);
            else
                freq.remove(hands[startIndex]);

            while(size<groupSize){
                if(freq.containsKey(start+1)){
                    start++;
                    size++;
                    if(freq.get(start)>1)
                        freq.put(start, freq.get(start)-1);
                    else
                        freq.remove(start);
                }
                else
                    return false;
            }

            
            //find starting position

            while(!freq.isEmpty() && !freq.containsKey(hands[startIndex]))
                startIndex++;
       
        }

        return true;
    }

    public static void main(String[] args){
        int[] hands = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        
        System.out.print(isNStraightHands(hands, groupSize));
    }
}