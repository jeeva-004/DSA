import java.util.*;

class Main {
    static int[] searchRange(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;

        for(int n: nums){
            if(!map.containsKey(n))
                map.put(n, i);
            i++;
        }
        
        if(!map.containsKey(target))
            return new int[] {-1, -1};

        int[] indexs = new int[2];
        indexs[0] = map.get(target);
        i = map.get(target)+1;
        indexs[1] = map.get(target);
        while(i<nums.length){
            if(nums[i]==target)
                indexs[1] = i;
            i++;
        }

        return indexs;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3};
        
        System.out.println(Arrays.toString(searchRange(arr, 3)));
    }
}