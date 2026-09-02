public class Main{
    
    static boolean isUniformParity(int[] nums){
        int j  = 0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]%2!=0){
                while(j<nums.length){
                    if(j=i || nums[i]%2!=0){
                        j++;
                        continue;
                    }

                    if((nums[j]-nums[i])%2==0)
                        return false;

                    j++;

                }
                return true;
            }
        }
        
        return true;
    }

    public static void main(String[] args){
        
    }
}