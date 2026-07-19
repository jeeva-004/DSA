import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 1. Create the Prefix Sum array using 'long' to prevent overflow
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        
        // 2. Start the modified Merge Sort process
        return mergeSortAndCount(prefixSums, 0, prefixSums.length - 1, lower, upper);
    }

    private int mergeSortAndCount(long[] prefixSums, int start, int end, int lower, int upper) {
        // Base Case: If the section has 1 or 0 elements, no pairs can be formed
        if (start >= end) {
            return 0;
        }

        // --- PHASE 1: DIVIDE ---
        int mid = start + (end - start) / 2;
        
        // Count valid pairs hidden inside the left half and right half independently
        int count = mergeSortAndCount(prefixSums, start, mid, lower, upper) + 
                    mergeSortAndCount(prefixSums, mid + 1, end, lower, upper);

        // --- PHASE 2: COUNT (The Two-Pointer Trick) ---
        // Both the Left Half [start...mid] and Right Half [mid+1...end] are now sorted.
        int lowPointer = start;
        int highPointer = start;

        // For each number in the right half, find its valid boundary window in the left half
        for (int j = mid + 1; j <= end; j++) {
            // Move lowPointer until prefixSums[j] - prefixSums[lowPointer] <= upper
            while (lowPointer <= mid && prefixSums[j] - prefixSums[lowPointer] > upper) {
                lowPointer++;
            }
            // Move highPointer until prefixSums[j] - prefixSums[highPointer] < lower
            while (highPointer <= mid && prefixSums[j] - prefixSums[highPointer] >= lower) {
                highPointer++;
            }
            // The number of valid past elements is the distance between the two pointers
            count += (highPointer - lowPointer);
        }

        // --- PHASE 3: MERGE (Standard Sorting) ---
        // Merge the two sorted halves together so the next level up can use them
        merge(prefixSums, start, mid, end);

        return count;
    }

    private void merge(long[] prefixSums, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int left = start;
        int right = mid + 1;
        int k = 0;

        // Standard merge sort combination logic
        while (left <= mid && right <= end) {
            if (prefixSums[left] <= prefixSums[right]) {
                temp[k++] = prefixSums[left++];
            } else {
                temp[k++] = prefixSums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = prefixSums[left++];
        }

        while (right <= end) {
            temp[k++] = prefixSums[right++];
        }

        // Copy back the sorted numbers into the original prefix sums array
        System.arraycopy(temp, 0, prefixSums, start, temp.length);
    }
}


public class Main {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        // System.out.println(rangeSum(nums, 1, 3));
    }
}