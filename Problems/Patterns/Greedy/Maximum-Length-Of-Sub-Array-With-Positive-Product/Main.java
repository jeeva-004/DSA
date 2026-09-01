import java.lang.*;
public class Main{
    
    static int longestSubArray(int[] nums){
        int longestSubArr = 0, i = 0, segmentStart = 0, segmentEnd = 0, start = 0, end = 0, opt1 = 0, opt2 = 0, negatives = 0;

        while(i<nums.length){
            negatives+=nums[i]<0?1:0;

            if(nums[i] == 0){
                segmentEnd = i-1;
                if(negatives%2==0){
                    longestSubArr = longestSubArr<i-segmentStart+1?i-segmentStart+1:longestSubArr;
                }
                else{
                    start = segmentStart;

                    while(start<=segmentEnd && nums[start]>0)
                        start++;
                    
                    opt1 = segmentEnd - start;

                    end = segmentEnd;
                    while(end>=segmentStart && nums[end]>0)
                        end--;
                    
                    opt2 = end - segmentStart;

                    longestSubArr = Math.max(Math.max(opt1, longestSubArr), opt2);

                    segmentStart = i+1;
                    negatives = 0;
                }
            }

            i++;
        }

                segmentEnd = i-1;
                if(negatives%2==0){
                    longestSubArr = longestSubArr<i-segmentStart+1?i-segmentStart+1:longestSubArr;
                }
                else{
                    start = segmentStart;

                    while(start<=segmentEnd && nums[start]>0)
                        start++;
                    
                    opt1 = segmentEnd - start;

                    end = segmentEnd;
                    while(end>=segmentStart && nums[end]>0)
                        end--;
                    
                    opt2 = end - segmentStart;

                    longestSubArr = Math.max(Math.max(opt1, longestSubArr), opt2);

                    segmentStart = i+1;
                    negatives = 0;
                }

        return longestSubArr;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, -2, -3, -4};
        System.out.print(longestSubArray(nums));
    }   
}