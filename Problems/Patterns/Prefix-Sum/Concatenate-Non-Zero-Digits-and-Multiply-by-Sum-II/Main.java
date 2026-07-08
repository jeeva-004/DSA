import java.math.BigInteger;
import java.util.*;;

public class Main {

    static int[] sumAndMultiply(String s, int[][] queries) {

        int[] result = new int[queries.length];
        int[] prefixSum = new int[s.length()];

        // 1. Define the modulo constant as a BigInteger
        BigInteger MAD = BigInteger.valueOf(1_000_000_007L);

        // Make a prefix sum
        prefixSum[0] = Character.getNumericValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int n = Character.getNumericValue(s.charAt(i));
            prefixSum[i] = prefixSum[i - 1] + n;
        }

        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            String numStr = s.substring(query[0], query[1] + 1).replaceAll("0", "");

            if (!numStr.isEmpty()) {
                // 2. Parse the massive string safely as a BigInteger
                BigInteger num = new BigInteger(numStr);

                // Calculate the prefix sum for this window
                int sum = (query[0] == 0) ? prefixSum[query[1]] : prefixSum[query[1]] - prefixSum[query[0] - 1];

                // 3. Convert the sum to a BigInteger to perform safe multiplication
                BigInteger bigSum = BigInteger.valueOf(sum);

                // 4. Multiply them together inside BigInteger space
                BigInteger product = num.multiply(bigSum);

                // 5. Apply the modulo to shrink the massive number down before converting to
                // int
                result[j] = product.mod(MAD).intValue();
            } else {
                // If the substring was only zeros, the product is 0
                result[j] = 0;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String s = "9876543210";
        int[][] queries = { { 0, 9 } };
        System.out.println(Arrays.toString(sumAndMultiply(s, queries)));
    }
}
