/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

/**
 *
 * @author Rishanka
 */

class Heap{
    int maxsize=1000;
    int[] heap= new int[maxsize];
    int size=0;
    
    Heap(){        
    }
    
    void insert(int next){
        heap[size]=next;
        size++;
        int error_node=size-1;
        int parent=(error_node-1)/2;
        
        while ((error_node>0)&&(heap[parent]>heap[error_node])){
            int temp=heap[parent];
            heap[parent]=heap[error_node];
            heap[error_node]=temp;
            error_node=parent;
            parent=(error_node-1)/2;      
        }
    }
    
    void print (){
        int no_of_layers=(int) (Math.log10(size+2)/ Math.log10(2));

        for (int i=0; i<=no_of_layers; i++){
            for (int j=(int)Math.pow(2,i)-1; (j<size) && (j<Math.pow(2, i+1)-1); j++){
                System.out.print(heap[j]+",  " );
            }
            System.out.println();
        }
    }
    
    int remove(){
        int output=heap[0];
        size--;
        if (size==0){
            return output;
        }
        heap[0]=heap[size];
        int error_node=0;
        int left_child=error_node*2+1;
        int right_child=error_node*2+2;
        while ((left_child<size)){
            if(right_child<size){
                if (heap[right_child]<heap[left_child] && heap[right_child]<heap[error_node]){
                    int temp=heap[right_child];
                    heap[right_child]=heap[error_node];
                    heap[error_node]=temp;
                    error_node=right_child;
                    left_child=error_node*2+1;
                    right_child=left_child+1;
                }
                else if(heap[left_child]<heap[right_child] && heap[left_child]<heap[error_node]){
                    int temp=heap[left_child];
                    heap[left_child]=heap[error_node];
                    heap[error_node]=temp;
                    error_node=left_child;
                    left_child=error_node*2+1;
                    right_child=left_child+1;                
                }
                else{
                    break;
                }
            }
            else{
                if(heap[left_child]<heap[error_node]){
                    int temp=heap[left_child];
                    heap[left_child]=heap[error_node];
                    heap[error_node]=temp;
                    break;
                }
                else{
                    break;
                }
                
            }
        }
        
        return output;
    }
    
    int[] sortHeap (){
        int[] sorted= new int[size];
        Heap copy= new Heap();
        System.arraycopy(heap, 0, copy.heap, 0, heap.length);       
        copy.size=size;
        int i=0;
        while (copy.size>0){
            sorted[i]=copy.remove();
            i++;
        }
        return sorted;
    }
}

public class Heaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap test= new Heap();
        test.insert(0);
        test.insert(1);
        test.insert(2);
        test.insert(-1);
        test.insert(-5);
        test.insert(-7);        
        test.insert(-17);        
        test.insert(17);        
        test.insert(57);        
        test.insert(27);        
        test.insert(3);       
        test.insert(127);       
        test.insert(9);        
        test.print();
        
        int[] sorted = test.sortHeap();
        for (int i=0; i<sorted.length; i++){
            System.out.println(sorted[i]);
        }
        System.out.println("this");
        test.print();
    }
}