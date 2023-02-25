/*Convert Level Order Traversal to BST
MediumAccuracy: 71.16%Submissions: 17K+Points: 4
Lamp
Don't Miss Out on the Chance to Work with Leading Companies! Visit the GFG Job Fair Now!  

Given an array of size N containing level order traversal of a BST.
The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.*/

 class Pair{
        Node parent;
        int lb;
        int ub;
        
        Pair(){
            this.parent = null;
            this.lb = Integer.MIN_VALUE;
            this.ub = Integer.MAX_VALUE;
        }
        
        Pair(Node nn, int lb, int ub){
            this.parent = nn;
            this.lb = lb;
            this.ub = ub;
        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
       int idx=0;//traverse arr upto length
       
       Node root=null;//contruct root and return
       
       Queue<Pair>que=new LinkedList<>();
       
       que.add(new Pair());//add parent as null amd lb & ub
       
       while(que.size()>0 && idx<arr.length){
           
           Pair curr=que.poll();//remove parent
           
           int element=arr[idx];//get each ele
           
           if(element < curr.lb || element > curr.ub)continue;//if out of range 
           
           idx++;//update index
           
           Node node=new Node(element);//make a node
           
           if(curr.parent==null){
               //if node is first then update root
               root=node;
           }
           else{
               //if have parent
               //if node is less than parent the left node it is
               if(node.data < curr.parent.data){
                   curr.parent.left = node;
               }
               else{
                   curr.parent.right = node;
               }
               
           }
           
           //add parent as currNode and left range and right range for child
           que.add(new Pair(node, curr.lb, node.data));
           que.add(new Pair(node, node.data, curr.ub));
           
       }
       
       return root;
    }
