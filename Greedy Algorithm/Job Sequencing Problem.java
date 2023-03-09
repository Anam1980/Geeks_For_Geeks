/*Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.*/



class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       //sort the arr acc. to maximum profit
       Arrays.sort(arr, (a, b)->{return b.profit-a.profit;});
       
       int max=0;
       for(int i=0; i<n; i++){
           if(max < arr[i].deadline){
               max=arr[i].deadline;
           }
       }
       
       //create a boolean array to mark days
       boolean []visited=new boolean[max+1];
       
       int maxProfit=0;
       int cnt=0;
       
       for(int i=0; i<n; i++){
           int bestdays=arr[i].deadline;
           
           //find the day for work within deadline
           while(visited[bestdays]==true){
               bestdays--;
           }
           
           //if day is 0 the no job in day 0
           if(bestdays==0)continue;
           
           //now i have bestday to cmplt my work
           visited[bestdays]=true;
           
           cnt++;
           
           maxProfit+=arr[i].profit;
       }
       
       return new int[]{cnt, maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
