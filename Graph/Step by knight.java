/*Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.*/

class Solution
{
    class Pair{
        int rowpos;
        int colpos;
        int moves;
        
        
        Pair(int m, int r, int c) {
            this.rowpos=r;
            this.colpos=c;
            this.moves=m;
        }
    }
    
    public boolean isValid(int r, int c, int n){
       if(r>=1 && r<=n && c>=1 && c<=n){
           return true;
       }
       return false;
    }
    
    int min;
    public int BFS(int[][]chess, int sr, int sc, int dr, int dc, int[][]direct, int n){
        
        Queue<Pair>que=new LinkedList<>();
        
        que.add(new Pair(0, sr, sc));
        
        while(que.size()>0){
            //remove
            Pair curr=que.poll();
            int moves=curr.moves;
            int currrow=curr.rowpos;
            int currcol=curr.colpos;
            
            //mark*
            if(chess[currrow][currcol]==1)continue;
            
            chess[currrow][currcol]=1;
            
            //work
            //min step taken by index who comes first at destination
            //As in a Bfs we traverse throudh the radiusi.e. width it increases step by step.
            if(currrow==dr && currcol==dc){
                return moves;
            }
            
            //add 
            for(int i=0; i<8; i++){
                int row=currrow + direct[i][0];
                int col=currcol + direct[i][1];
                
                if(isValid(row, col, n)==true){
                    if(chess[row][col]==0){
                        que.add(new Pair(moves+1, row, col));
                    }
                }
            }    
        }
        return -1;
    }    
        
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
       int[][]chess=new int[N+1][N+1];
       
       min=N*N;
       
       int dr=TargetPos[0];
       int dc=TargetPos[1];
       
       int sr=KnightPos[0];
       int sc=KnightPos[1];
       
       
       
      int direct[][]={ {-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2} }; 
       
       return BFS(chess,sr, sc, dr, dc, direct, N);
       
       
    }
}
