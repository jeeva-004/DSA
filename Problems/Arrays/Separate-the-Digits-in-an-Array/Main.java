import java.util.*;

public class Main {
       static int[] separateDigits(int[] nums) {
        
        ArrayList<Integer> separatedDigits = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            String s = String.valueOf(nums[i]);
            char[] digits = s.toCharArray();

            for(int j = 0; j<digits.length; j++)
                separatedDigits.add(Character.getNumericValue(digits[j]));
        }

        int[] digitsArray = separatedDigits.stream().mapToInt(Integer::intValue).toArray();

        return digitsArray;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,6   };

        System.out.print(Arrays.toString(separateDigits(nums)));
    }
}
