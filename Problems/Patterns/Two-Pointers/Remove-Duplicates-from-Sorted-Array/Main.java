class Main {
    static int removeDuplicates(int[] arr) {
        int slow = 0, fast = slow + 1, count = 1;

        while (fast <= arr.length - 1) {
            if (arr[slow] == arr[fast])
                fast++;
            else {
                count++;
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };

        System.out.print(removeDuplicates(arr));
    }

}