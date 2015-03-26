/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findsum;

public class FindSum {

    /**
     * @param args the command line arguments
     */
    public static int sum=0;
    public static int sumRecursive (int[] A, int start){
        int n=A.length;
        sum=0;
        if (start==n){ return 0;}
        else
        {
            sum=A[start]+sumRecursive(A,start+1);
        }
            return sum;
    }

    public static int sumIterative (int[] A){
        int n=A.length;
        sum=0;
        for (int i=0;i<=n-1;i++)
        {
            sum=sum+A[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] A= {1,5,7,54,23,123,7,123,-1};
        sum= sumIterative(A);
        System.out.println(sum);
        sum= sumRecursive(A,0);
        System.out.println(sum);
        
    }
}
