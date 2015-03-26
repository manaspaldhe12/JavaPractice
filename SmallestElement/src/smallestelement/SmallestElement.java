/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smallestelement;

/**
 *
 * @author mpaldhe
 */
public class SmallestElement {

    public static int recursive (int[] array, int start, int n){
        if (start>=n){
            return -1;
        }
        else if (start+1 == n ){
            return start;
        }
        else{
            int current = array[start];
            int index = recursive (array, start+1, n);
            if (current < array[index]){
                return start;
            }
            else {
                return index;
            }
        }
    }
    
    public static int iterative (int[] array){
        int min=array[0];
        if (array.length==0){
            return 0;
        }
        else{
            for (int i=1; i<array.length; i++){
                if (array[i]<min){
                    min=array[i];
                }
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        int[] A = {1,6,13,-3,76,123,9,0,1234,83};
        System.out.println(recursive(A, 0, A.length));
        System.out.println(A[recursive(A, 0, A.length)]);
        System.out.println(iterative(A));
    }
}
