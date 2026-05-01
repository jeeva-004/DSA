import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {

    // 1. temporary array method (Time Complexity -O(n) , Space Complexity -O(n))

    static void reverseArray1(int arr[]) {
    int n = arr.length;
    int temp[] = new int[n];
    for(int i = 0; i<n; i++){
    temp[i] = arr[n-i-1];
    }
    for(int i = 0; i<n; i++){
    arr[i] = temp[i];
    }
    for(int num: arr){
    System.out.print(num);
    }
    }

    // 2. single pointer method (Time Complexity -O(n) , Space Complexity -O(1))

    static void reverseArray2(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
    if (i <= Math.floor((n - 1) / 2)) {
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
    }
    }
    for (int num : arr) {
    System.out.print(num);
    }
    }

    // 3. Two pointers method (Time Complexity -O(n) , Space Complexity -O(1))

    static void reverseArray3(int arr[]) {
    int n = arr.length, left = 0, right = n - 1;
    for (int i = 0; i < n; i++) {
    if (left < right) {
    int temp = arr[right];
    arr[right] = arr[left];
    arr[left] = temp;
    right--;
    left++;
    }
    }
    for (int num : arr) {
    System.out.print(num);
    }
    }

    // 4. Collection built-in method (Time Complexity -O(n) , Space Complexity
    // -O(1))

    static void reverseArray4(List<Integer> arr){
    Collections.reverse(arr);
    for(int n: arr){
    System.out.print(n);
    }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5));
        reverseArray4(arr);
    }
}