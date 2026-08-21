public class Main {

    static int noOfNiceSubArrays(int[] nums, int k) {
        return noOfSubArrays(nums, k) - noOfSubArrays(nums, k - 1);
    }

    static int noOfSubArrays(int[] nums, int k) {
        int subArrays = 0, left = 0, right = 0, mostK = 0, removed = 0;

        while (right < nums.length) {

            mostK += nums[right] % 2 != 0 ? 1 : 0;

            while (mostK > k) {
                removed = nums[left];
                mostK -= removed % 2 != 0 ? 1 : 0;
                left++;
            }
            subArrays += right - left + 1;
            right++;
        }

        return subArrays;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 2 };
        int k = 1;

        System.out.print(noOfNiceSubArrays(nums, k));
    }
}