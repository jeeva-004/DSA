class Main {

    static int findJumps(int[] arr, int target) {
        int jumps = 0, temp = 0;
        for (int j = 1; j < arr.length; j++) {
            if (target == 0) {
                if (arr[j] - arr[temp] == 0) {
                    temp = j;
                    jumps++;
                }

            } else {
                if (-target <= (arr[j] - arr[temp]) && (arr[j] - arr[temp]) <= target) {
                    jumps++;
                    temp = j;
                } else
                    continue;
            }
        }
        if (jumps > 0)
            return jumps;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 4, 1, 2 };
        int target = 0;
        System.out.println(findJumps(arr, target));
    }
}