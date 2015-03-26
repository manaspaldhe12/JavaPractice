/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;
import java.util.ArrayList;
/**
 *
 * @author mpaldhe
 */
public class Recursion {

    public static ArrayList<ArrayList<Integer>> getSubsets (ArrayList<Integer> input_set){
        ArrayList<ArrayList<Integer>> output=new ArrayList<ArrayList<Integer>>();
        
        if (input_set.isEmpty()){
            ArrayList<Integer> this_subset=new ArrayList<Integer>();
            output.add(this_subset);
        }      
        else if (input_set.size()==1){
            ArrayList<Integer> empty_subset=new ArrayList<Integer>();
            output.add(input_set);
            output.add(empty_subset);
        }
        else{
            int first_element=input_set.remove(0);
            ArrayList<ArrayList<Integer>> included = getSubsets(new ArrayList<Integer>(input_set));
            ArrayList<ArrayList<Integer>> not_included = getSubsets(new ArrayList<Integer>(input_set));
            
            while (included.size()>0){
                ArrayList<Integer> temp =included.remove(0);
                temp.add(first_element);
                output.add(temp);
            }
            while (not_included.size()>0){
                output.add(not_included.remove(0));
            }
        }
        return output;
    }
    
    public static ArrayList<String> getPermutations (String input){
        ArrayList<String> output = new ArrayList<String>();
        if (input.length()==0){
            return output;
        }
        else if (input.length()==1){
            output.add(input);
            return output;
        }
        else{
            for (int i=0; i<input.length(); i++){
                char first_char = input.charAt(i);
                ArrayList<String> sub_permutations = getPermutations(input.substring(0, i)+input.substring(i+1));
                while(sub_permutations.size()>0){
                    output.add(first_char+sub_permutations.remove(0));
                }
            }
            return output;
        }
    }
    
    public static ArrayList<String> allPairsofParanthesis (int left_remaining, int right_remaining, String current){
        ArrayList<String> out= new ArrayList<String>();
        if (left_remaining==0){
            while (right_remaining>0){
                current=current+")";
                right_remaining--;
            }
            out.add(current);
        }
        else if (left_remaining == right_remaining){
            current=current+"(";
            out=allPairsofParanthesis(left_remaining-1, right_remaining, current);
        }
        else if (left_remaining < right_remaining){
            ArrayList<String> sub_answers= new ArrayList<String>();
            out=allPairsofParanthesis(left_remaining-1, right_remaining, current+"(");
            sub_answers=allPairsofParanthesis(left_remaining, right_remaining-1, current+")");
            while (!sub_answers.isEmpty()){
                out.add(sub_answers.remove(0));
            }
        }
        else{
            System.out.println("ERROR");
        }
        return out;
    }
    
    
    public static void main(String[] args) {
        int n=3;
        System.out.println(allPairsofParanthesis(n,n,""));
        System.out.println(allPairsofParanthesis(n,n,"").size());
        //System.out.println(getPermutations("abcd"));
        /*
        ArrayList<Integer> test= new ArrayList<Integer> ();
        test.add(4);
        test.add(3);
        test.add(2);
        test.add(1);
        System.out.print(getSubsets(test));
        */
    }
}
