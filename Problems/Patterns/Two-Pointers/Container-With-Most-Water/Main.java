class Main{
    
    static int maxArea(int[] heights){
        
        int left = 0, right = heights.length-1, maxArea = Integer.MIN_VALUE ;        

        while(left!=right){
            int height = heights[left]<heights[right]?heights[left]:heights[right];
            int width = right-left;
            int currentArea = height*width;

            maxArea = Math.max(maxArea, currentArea);

            if(heights[left]<heights[right])
                left++;
            else if(heights[left]>heights[right])
                right--;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}