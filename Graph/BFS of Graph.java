class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>anslist=new ArrayList<>();
        //represent in adjacency list
        //parent--->child
        Queue<Integer>que=new LinkedList<>();
        //add parent
        boolean[]mark=new boolean[V];
        
        //given that: The task is to do Breadth First Traversal of this graph starting from 0.
            que.add(0);
            
            while(que.size()>0){
                //remove
                int curr=que.poll();
                
                //mark
                if(mark[curr]==true)continue;
                mark[curr]=true;
                
                //work
                anslist.add(curr);
                
                //add unmarked
                for(int nbr : adj.get(curr)){
                    if(mark[nbr]==false){
                        que.add(nbr);
                    }
                }
                
            }
        
        
        return anslist;
            
        }
    }
