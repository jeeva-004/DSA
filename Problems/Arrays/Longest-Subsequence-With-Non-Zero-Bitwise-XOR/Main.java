public class Main {

    static int longestSubSequence(int[] nums) {
        int totalXors = 0;
        boolean hasZeros = true;

        for (int n : nums) {
            totalXors ^= n;
            hasZeros = n != 0 ? false : true;
        }

        if (hasZeros)
            return 0;

        return totalXors != 0 ? nums.length : nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(longestSubSequence(nums));
    }
}