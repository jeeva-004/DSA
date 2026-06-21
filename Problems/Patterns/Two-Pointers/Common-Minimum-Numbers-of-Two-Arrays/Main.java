import java.util.*;

class Main {
    static int commonMin(int[] arr1, int arr2[]) {
        if(arr1.length==0||arr2.length==0)
            return -1;

        HashSet<Integer> lookUpSet = new HashSet<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(arr1[0]==arr2[0])
            return arr1[0];

        for(int n: arr2)
            lookUpSet.add(n);

        for(int i = 0; i<arr1.length; i++)
            if(lookUpSet.contains(arr1[i]))
                return arr1[i];
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {  2, 3, 4 }, arr2 = { 1,3,4,6,7,};
        System.out.print(commonMin(arr1, arr2));
    }
}