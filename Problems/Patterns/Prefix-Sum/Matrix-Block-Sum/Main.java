import java.util.*;
public class Main{
    
    static void matrixBlockSum(int[][] matrix, int k){
        int row = matrix.length, col = matrix[0].length;
        int[][] prefixSum = new int[row][col];
        int top = 0, left = 0, sum = 0, i = 0, j = 0;

        //build prefix sum
        for(i = 0; i<row; i++){
            for(j = 0; j<col; j++){
                sum = matrix[i][j];
                if(i>0){
                    sum+=prefixSum[i-1][j];
                }

                if(j>0){
                    sum+=prefixSum[i][j-1];
                }

                if(i>0 && j>0){
                    sum-=prefixSum[i-1][j-1];
                }

                prefixSum[i][j] = sum;
            }
        }

        int[][] result = new int[row][col];

        for(i = 0; i<row; i++){
            for(j = 0; j<col; j++){
                int row1 = Math.max(0, i-k);
                int col1 = Math.max(0, j-k);
                int row2 = Math.min(row-1, i+k);
                int col2 = Math.min(col-1, j+k);

                sum = prefixSum[row2][col2];

                if(row1>0){
                    sum-=prefixSum[row1-1][col2];
                }

                if(col1>0){
                    sum-=prefixSum[row2][col1-1];
                }

                if(row1>0 && col1>0){
                    sum+=prefixSum[row1-1][col1-1];
                }

                result[i][j] = sum;
            }
        }

        // for(int[] arr: result)
        //     System.out.print(Arrays.toString(arr) +" ");

        return result;

    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        matrixBlockSum(matrix, k);
    }
}