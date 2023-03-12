/*Given a binary matrix (containing only 0 and 1) of order NxN. All rows are sorted already,
We need to find the row number with the maximum number of 1s. Also, find the number of 1s in that row.
Note:

1. In case of a tie, print the smaller row number.
2. Row number should start from 0th index.*/

//TC:O(N) SC:O(1)
class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        int max=0;
        
        int ans=0;
        
        for(int row=0; row<N; row++){
            int col=0;
            while(col<N && mat[row][col]!=1){
                col++;
            }
            int size=N-col;
            if(max<size){
                max=size;
                ans=row;
               
            }
        }
        
        int[]res=new int[]{ans, max};
        return res;
    }
};
