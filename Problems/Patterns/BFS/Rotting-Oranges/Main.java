import java.util.*;

public class Main{    
    /*
        0 - empty
        1 - Fresh
        2 - Rotted
    */
    static int orangeRotting(int[][] grid){
        int freshOranges = 0, minutes = 0;
        int row = grid.length, col = grid[0].length; 
        
        Queue<int[]> coordinates = new LinkedList<>();

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1)
                    freshOranges++;
                if(grid[i][j]==2)
                    coordinates.add(new int[] {i, j});
            }
        }

        if(freshOranges==0 || coordinates.isEmpty())
            return 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(freshOranges>0 && !coordinates.isEmpty()){
            int size = coordinates.size();
for(int i = 0; i<size; i++){
                int[] coordinate = coordinates.poll();
                int r = coordinate[0], c = coordinate[1];
            for(int j = 0; j<4; j++){
                int newRow = dr[j]+r;
                int newCol = dc[j]+c;
                if(newRow>row-1 || newRow<0 || newCol>col-1 || newCol<0 || grid[newRow][newCol]!=1)
                    continue;
                
                freshOranges--;
                coordinates.add(new int[]{newRow, newCol});
                grid[newRow][newCol] = 2;

            }
}

            minutes++;
        }

        return freshOranges>0?-1:minutes;
    }

    public static void main(String[] args){
        int[][] grids = {{2,1,1}, {1,1,0}, {0,1,1}};

        System.out.print(orangeRotting(grids));
    }
}