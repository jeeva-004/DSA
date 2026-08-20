public class Main {

    static int nextGreaterElement(int n) {
        if (n > Integer.MAX_VALUE || n < 10)
            return -1;

        int length = (int) Math.log10(n) + 1;

        int[] digits = new int[length];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }

        int right = digits.length - 2;

        while (right >= 0 && digits[right] >= digits[right + 1])
            right--;

        if (right < 0)
            return -1;

        int pivot = right, swapIndex = digits.length - 1;

        while (digits[pivot] >= digits[swapIndex])
            swapIndex--;

        int temp = digits[pivot];
        digits[pivot] = digits[swapIndex];
        digits[swapIndex] = temp;

        int start = pivot + 1, end = digits.length - 1;

        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }

        long result = 0;

        for (int num : digits) {
            result = result * 10 + num;
        }

        return result > Integer.MAX_VALUE ? -1 : (int) result;

    }

    public static void main(String[] args) {
        int n = 12;

        System.out.print(nextGreaterElement(n));
    }
}