import java.util.*;

class Main {

    static boolean isHere(int[][] matrix, int target) {
        ArrayList<Integer> flatArray = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    flatArray.add(matrix[i][j]);
            }
        }

        int[] arr = new int[flatArray.size()];
        for(int i = 0; i<flatArray.size(); i++)
            arr[i] = flatArray.get(i);
        int s = 0, e = arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(mid==target)
                return true;
            if(mid>target)
                s = mid+1;
            else if(mid<target)
                e = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.print(isHere(matrix, 3));
    }
}