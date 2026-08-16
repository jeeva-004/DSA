import java.util.*;

public class Main {

    static ArrayList<Integer> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> grids = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                li.add(grid[i][j]);
            
        k = k % (grid.length * grid[0].length);

        int[] primitiveArray = li.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int left = 0, right = primitiveArray.length - 1;
        while (left < right) {
            int temp = primitiveArray[left];

            primitiveArray[left] = primitiveArray[right];
            primitiveArray[right] = temp;
            right--;
            left++;
        }

        left = 0;
        right = k - 1;

        while (left < right) {
            int temp = primitiveArray[left];

            primitiveArray[left] = primitiveArray[right];
            primitiveArray[right] = temp;
            right--;
            left++;
        }

        left = k;
        right = primitiveArray.length - 1;

        while (left < right) {
            int temp = primitiveArray[left];

            primitiveArray[left] = primitiveArray[right];
            primitiveArray[right] = temp;
            right--;
            left++;
        }
        int pos = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> part = new ArrayList<>();

            for (int j = 0; j < grid[i].length; j++)
                part.add(primitiveArray[pos++]);

            grids.add(part);
        }
        System.out.println(grids);
        return li;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[][] grid = {{3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13}};

        shiftGrid(grid, 1);
    }
}