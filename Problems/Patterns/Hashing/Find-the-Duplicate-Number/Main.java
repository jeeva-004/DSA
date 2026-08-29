import java.util.*;

public class Main{
    
    static int findDuplicate(int[] nums){
        List<Integer> lookUpList = new ArrayList<>();

        for(int n: nums){
            if(lookUpList.contains(n))
                return n;
        
            lookUpList.add(n);
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 3, 4, 2, 2};
        System.out.print(findDuplicate(nums));
    }
}