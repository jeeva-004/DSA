class Main {
    static int removeDuplicates(int[] arr) {
        int slow = 0, fast = slow + 1;

        while (fast <= arr.length - 1) {
            if (arr[slow] == arr[fast])
                fast++;
            else {
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };

        System.out.print(removeDuplicates(arr));
    }

}