/*Given postorder traversal of a Binary Search Tree, you need to construct a BST from postorder traversal.
The output will be inorder traversal of the constructed BST.*/

/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    private static int idx;
    public static Node BuildTree(int[]post, int lb, int ub, int n){
        if(idx<0 || idx>=n || post[idx]<lb || post[idx]>ub)return null;
        
        Node node=new Node(post[idx--]);
        
        node.right=BuildTree(post, node.data, ub, n);
        node.left=BuildTree(post, lb, node.data, n);
        
        return node;
    }
    public static Node constructTree(int post[],int n)
    {
      //L R Root
      idx=n-1;
      
     return BuildTree(post, Integer.MIN_VALUE, Integer.MAX_VALUE, n);
      
    }
}
