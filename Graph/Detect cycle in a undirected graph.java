
class Solution {
    
    boolean dfs(int node, int parent, boolean[]mark, ArrayList<ArrayList<Integer>> adj){
        mark[node]=true;
        
        for(int nbr : adj.get(node)){
            if(mark[nbr]==false){
                boolean check=dfs(nbr, node, mark, adj);
                if(check)return true;
            }
            else if(mark[nbr]==true){
                if(parent != nbr)return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    
    
      boolean[]mark=new boolean[V];
      
      for(int i=0; i<V; i++){
          if(mark[i]==true)continue;
          
          if(dfs(i, -1, mark, adj))return true;
      }
      
      return false;
    }
}
