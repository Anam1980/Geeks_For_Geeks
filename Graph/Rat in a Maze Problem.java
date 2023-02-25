/*Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). 
Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.*/


// m is the given matrix and n is the order of matrix
class Solution {
    
    public static void GetPaths(int[][] m, int i, int j, int n, String path, ArrayList<String>anslist, boolean[][]visited){
        if(i<0 || i>=n || j<0 || j>=n || m[i][j]==0 ||visited[i][j]==true){
            return;
        }
        
        if(i==n-1 && j==n-1){
            anslist.add(path);
            return;
        }
        
        //visit the path
        visited[i][j]=true;
        
        GetPaths(m, i-1, j, n, path+"U", anslist, visited);
        GetPaths(m, i+1, j, n, path+"D", anslist, visited);
        GetPaths(m, i, j-1, n, path+"L", anslist, visited);
        GetPaths(m, i, j+1, n, path+"R", anslist, visited);
        
        //make unvisted for more paths
        visited[i][j]=false;
        
        return;
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String>anslist=new ArrayList<>();
        
        boolean[][]visited=new boolean[n][n];
        
        GetPaths(m, 0, 0, n, "", anslist, visited);
        
        return anslist;
    }
}
