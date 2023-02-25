
/*Complete the function below*/

class Solution {
    
    public boolean dfs(int curr, boolean[]mark,  boolean[] path, ArrayList<ArrayList<Integer>> adj){
        //mark
        mark[curr]=true;
        path[curr]=true;
        
        for(int nbr : adj.get(curr)){
            
            if(mark[nbr] && path[nbr])return true;
            
            if(!mark[nbr]){
                boolean check=dfs(nbr, mark, path, adj);
                
                if(check)return true;
            }
        }
        path[curr]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean[]mark=new boolean[V];
      boolean[]path=new boolean[V];
      
      for(int i=0; i<V; i++){
          if(dfs(i, mark, path, adj))return true;
      }
      
      return false;
      
    }
}
