/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author mpaldhe
 */
class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;    
    
    BinaryTree(int newdata){
        data=newdata;
        left=null;
        right=null;
    }
    
    int getDepth(){
        if ((left==null)&&(right==null)){
            return 1;
        }
        else{
            int left_depth;//=left.getDepth();
            int right_depth;//=right.getDepth();
            if (left==null){
                left_depth=-1;
            }
            else{
                left_depth=left.getDepth();
            }
            if (right==null){
                right_depth=-1;
            }
            else{
                right_depth=right.getDepth();
            }
            if (left_depth>right_depth){
                return left_depth+1;
            }
            else{
                return right_depth+1;
            }
        }
    }
    
    boolean checkBalance(){
        if ((left==null)&&(right==null)){
            return true;
        }
        else{
            int left_depth=left.getDepth();
            int right_depth=right.getDepth();
            if (Math.abs(left_depth-right_depth)>1){
                return false;                
            }
            else{
                return true;
            }
        }
        
    }
    
    void printLayer (){        
    }
    
    
}

public class Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree test= new BinaryTree(1);
        
        test.left=new BinaryTree(2);
        test.right=new BinaryTree(4);

        test.left.left=new BinaryTree(5);
        test.left.right=new BinaryTree(7);
        
        test.left.left.left=new BinaryTree(5);
        
        System.out.println(test.checkBalance());
        System.out.println(test.getDepth());
    }
}
