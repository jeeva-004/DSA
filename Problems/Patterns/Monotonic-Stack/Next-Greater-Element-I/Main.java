import java.util.*;

public class Main{

    static int[] nextGreatestElementList(int[] nums1, int[] nums2){
        int[] nextGreatestElementList = new int[nums1.length];
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for(int n: nums2){

            while(!stack.isEmpty() && stack.peek()<n){
                pairs.put(stack.peek(), n);
                stack.pop();
            }

            stack.push(n);
        }

        for(int n: nums1){
            if(pairs.containsKey(n))
                nextGreatestElementList[i++] = pairs.get(n);
            else
                nextGreatestElementList[i++] = -1;
        }

        return nextGreatestElementList;
    }

    public static void main(String[] args){

    }
}