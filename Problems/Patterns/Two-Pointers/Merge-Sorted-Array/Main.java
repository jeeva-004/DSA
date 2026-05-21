import java.util.*;

public class Main {
    
    static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] tempArr = new int[m+n];
        int i = 0, j = 0, k = 0;
        
        while(i<m&&j<n&&k<tempArr.length){
            if(nums1[i]<nums2[j])
                tempArr[k++] = nums1[i++];
            else
                tempArr[k++] = nums2[j++];
        }

        while(i<m){
            if(k<tempArr.length)
                tempArr[k++] = nums1[i++];
        }
        while(j<n){
            if(k<tempArr.length)
                tempArr[k++] = nums2[j++];
        }
        i = 0;
        for(int num: tempArr)
            nums1[i++] = num;

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args){
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n = 1;

        merge(nums1, m, nums2, n);
    }    
}
