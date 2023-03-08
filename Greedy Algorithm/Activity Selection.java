/*Given N activities with their start and finish day given in array start[ ] and end[ ]. 
Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.*/

class Solution
{  
    static class Activity{
        int start;
        int end;
        int pos;
        
        Activity(int s, int e, int w){
            this.start=s;
            this.end=e;
            this.pos=w;
        }
    }
    
    static class comparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2){
            if(o1.end<o2.end){
                return -1;
            }
            else if(o1.end>o2.end){
                return 1;
            }
            else if(o1.pos < o2.pos){
                return -1;
            }
            return 1;
        }
    }
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
       ArrayList<Activity> act = new ArrayList<>();
       
       for(int i=0; i<n; i++){
           act.add(new Activity(start[i], end[i], i+1));
       }
       
       Collections.sort(act, new comparator());
       
       int limit=0;
       
       int cnt=0;
       
       for(int i=0; i<n; i++){
           
           if(act.get(i).start > limit){
               cnt++;
               
               limit=act.get(i).end;
           }
       }
       
       return cnt;
    }
}
