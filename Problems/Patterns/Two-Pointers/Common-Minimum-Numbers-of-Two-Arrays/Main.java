class Main {
    static int commonMin(int[] arr1, int arr2[]) {
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else
                return arr2[j];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { -1, 2, 3, 4 }, arr2 = { 5, 6 };
        System.out.print(commonMin(arr1, arr2));
    }
}