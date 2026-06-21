import java.util.Arrays;

class Main {

    static void duplicateZeros(int[] arr) {
        int len = arr.length - 1, zeros = 0;

        // counting zeros and finding boundries

        for (int left = 0; left <= len - zeros; left++) {
            if (arr[left] == 0) {
                // check if the digit end of the list
                if (left == len - zeros) {
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                zeros++;
            }
        }

        // to modify the array with duplicate inplacement
        len = len - zeros;

        for (int right = len; right >= 0; right--) {
            if (arr[right] == 0) {
                arr[right + zeros] = 0;
                zeros--;
                arr[right + zeros] = 0;
            } else
                arr[right + zeros] = arr[right];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, 0, 4, 5, 0 };
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}