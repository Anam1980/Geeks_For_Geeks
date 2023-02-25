class Solution {
    
    void dfs(int node, ArrayList<Integer>anslist, boolean[]mark, ArrayList<ArrayList<Integer>> graph){
        //mark
        mark[node]=true;
        
        //work
        anslist.add(node);
        
        //go to neighbours
        for(int nbr : graph.get(node)){
            if(mark[nbr]==false){
                dfs(nbr, anslist, mark, graph);
            }
        }
        
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
      ArrayList<Integer>anslist=new ArrayList<>();
      
      boolean[]mark=new boolean[V];
      
      dfs(0, anslist, mark, adj);
      
      return anslist;
    }
}
