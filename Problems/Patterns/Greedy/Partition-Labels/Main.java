import java.util.*;

public class Main{
    
    static List<Integer> partitionLables(String s){
        List<Integer> partitions = new ArrayList<>();
        HashMap<Character, Integer> lookUpMap = new HashMap<>();
        
        int i = 0, needToCover = 0, left = Integer.MAX_VALUE; 
        char c;
        for(i = 0; i<s.length(); i++)
            lookUpMap.put(s.charAt(i), i);
        
        i = 0;

        while(i<s.length()){
            left = left>i?i:left;
            c = s.charAt(i);
            needToCover = needToCover<lookUpMap.get(c)?lookUpMap.get(c):needToCover;

            if(needToCover==i){
                partitions.add(needToCover - left + 1);
                left = Integer.MAX_VALUE;
                needToCover = 0;
            }
            i++;
        }

        return partitions;
    }

    public static void main(String[] args){
        System.out.print(partitionLables("ababcbacadefegdehijhklij"));
    }
}