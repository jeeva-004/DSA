
class Main {

    static boolean isHere(int[][] matrix, int target) {

        int s = 0, col = matrix[0].length, e = (matrix.length*col)-1;
        
        while(s<=e){
            int mid = (s+e)/2, row = mid/col, column = mid%col;

            if(matrix[row][column]<target)
                s = mid+1;
            else if(matrix[row][column]>target)
                e = mid-1;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.print(isHere(matrix, 16));
    }
}