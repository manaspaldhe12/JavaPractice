/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author mpaldhe
 */
public class Fibonacci {


    public static int iterative (int n){
        int n_2=1;
        int n_1=1;
        if (n==0){ return 1;}
        else  if (n==1){ return 1;}
        else {
            for (int i=2; i<=n; i++){
                int temp=n_2;
                n_2=n_1;
                n_1=n_1+temp;
            }
        }
        return n_1;
        
    }
    
    public static int[] singleRecursive (int n){
        int [] ans = {1,-1};
        if (n==0){            
            return ans;
        }
        else if (n==1){
            ans[0]=1;
            ans[1]=1;
            return ans;
        }
        else {
            int[] ans_n_1 = singleRecursive(n-1);
            ans[0]= ans_n_1[0]+ans_n_1[1];
            ans[1]= ans_n_1[0];
            return ans;
        }
        
    }
    
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            int[] ans = singleRecursive (i);
            System.out.print(ans[0]);
            System.out.println(",        "+iterative(i));
        }
    }
}
