class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        //initiliaze
        int end=str.length()-1;
        
        String rev="";
        
        while(end >= 0){
            //concate
            rev += str.charAt(end);
            
            //update pointer
            end--;
        }
        
        return rev;
    }
}
