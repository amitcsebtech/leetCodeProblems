class Solution {
    private void shift(int[][] grid, int[][] temp, int rows, int cols){

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){

                if(i == rows-1 && j == cols-1){
                    temp[0][0] = grid[i][j];
                }
                else if(j == cols-1){
                    temp[i+1][0] = grid[i][j];
                }
                else{
                    temp[i][j+1] = grid[i][j];
                }

            }
        }


    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        if(rows == 1 && cols == 1){
            ans.add(List.of(grid[0][0]));
            return ans;
        }
        int cells = rows*cols;
        k = k%cells;

        int[][] temp = new int[rows][cols];

        for(int i=1; i<=k; i++){
            if(i%2 == 0){
                shift(temp,grid,rows,cols);
            }
            else{
                shift(grid,temp,rows,cols);
            }
        }

        if(k%2 == 0){
            for(int i=0; i<rows; i++){
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<cols; j++){
                    list.add(grid[i][j]);
                }
                ans.add(list);
            }
        }
        else{
            for(int i=0; i<rows; i++){
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<cols; j++){
                    list.add(temp[i][j]);
                }
                ans.add(list);
            }
        }

        return ans;

    }
}