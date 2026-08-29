public class Main{
    
    static int trapRainWaters(int[] height){
        int left = 0, right = height.length-1, leftMax = height[left], rightMax = height[right], waterTraps = 0;

        while(left<right){
            if(height[left]<height[right]){
                waterTraps+=leftMax-height[left];
                left++;
                leftMax = height[left]>leftMax?height[left]:leftMax;
            }
            else{
                waterTraps+=rightMax-height[right];
                right--;
                rightMax = height[right]>rightMax?height[right]:rightMax;
            }
        }

        return waterTraps;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trapRainWaters(height));
    }
}