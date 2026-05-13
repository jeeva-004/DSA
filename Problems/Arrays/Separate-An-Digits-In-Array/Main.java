import java.util.*;

class Main {
    static int[] separateDigits(int[] nums) {
        ArrayList<Integer> seperatedArray = new ArrayList<>();
        ArrayList<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 10) {
                int temp = nums[i];
                while (temp > 10) {
                    int remainder = temp % 10;
                    temp = temp / 10;
                    tempArray.add(remainder);
                }
            } else
                tempArray.add(nums[i]);
        }
        for(int i = tempArray.size()-1; 0<=i; i--){
            System.out.print(tempArray.get(i)+" ");
        }
        tempArray.clear();

        int[] finalArray = new int[seperatedArray.size()];
        // for (int k = 0; k < seperatedArray.size(); k++) {
        //     finalArray[k] = seperatedArray.get(k);
        // }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = { 1, 23, 247, 3, 6 };
        System.err.println(separateDigits(arr));
    }
}