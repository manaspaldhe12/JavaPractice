/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

public class Sorting {

 
    public static int[] insertIn (int new_element, int[] original_array ){
        int[] B = new int[original_array.length+1];
        for (int i=1; i<=original_array.length; i++){
            B[i]=original_array[i-1];
        }

        B[0]=new_element;
        int comparision=0;
        while (comparision < original_array.length){
            if (B[comparision] <= B[comparision+1]){
                break;
            }
            else{
                int temp=B[comparision];
                B[comparision]=B[comparision+1];
                B[comparision+1]=temp;
            }
            comparision++;
        }
        return B;
    }
    
    public static int[] insertionSort (int[] input_array){
        int[] sorted = new int[0];
        for (int i=0; i<input_array.length; i++){
            sorted = insertIn(input_array[i], sorted);
        }
        return sorted;        
    }
    
    public static void main(String[] args) {
        int[] A={1,5,3,2,63,34,76,25};
        int[] B= insertionSort(A);
        for (int i=0; i<B.length; i++){
            System.out.println(B[i]);
        }
    }
}