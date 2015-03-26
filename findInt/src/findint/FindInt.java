/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findint;

public class FindInt {

    public static int[] A= {1,2,3,4,5,7,12,123,1123};
    public static int size=9;
    

    public static boolean linearSearch (int[] A, int x){
        for (int i=0;i<size;i++)
        {
         if (A[i]==x)
                 {
                  return true;   
                 }
         else {if (A[i]>x) {return false;}}
        } return false; 
        
    }

    public static boolean binarySearch (int[] A, int x, int start, int end){
        if (start>end)
        {
            return false;
        }
        else {
            if (start==end)
            {
                if (A[start]==x){return true;}
                else{return false;}
                              
            }
            
            else {
            
            int mid=(start+end)/2;
            if (x==A[mid])
            {return true;}
            else {
                if (x>A[mid])
                {return binarySearch(A,x,(mid+1),end);}
                else {return binarySearch(A,x,start,mid-1);}
            }
            
            }
            
        }
        
        
    }
    
    public static void main(String[] args) {
        int x=12;
        System.out.println(linearSearch(A,x));
        System.out.println(binarySearch(A,x,size-1,0));
        
    }
}