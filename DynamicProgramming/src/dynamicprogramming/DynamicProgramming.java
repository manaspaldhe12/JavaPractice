/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;
import java.util.ArrayList;

/**
 *
 * @author mpaldhe
 */
public class DynamicProgramming {

    public static ArrayList<String> allPairsofParanthesis (int n){
        ArrayList<ArrayList<ArrayList<String>>> solutions= new ArrayList<ArrayList<ArrayList<String>>> ();
        
        for (int left_remaining=0; left_remaining<=n; left_remaining++){
            ArrayList<ArrayList<String>> column_solutions = new ArrayList<ArrayList<String>>();
            for (int right_remaining=0; right_remaining<=n; right_remaining++){
                ArrayList<String> given_square = new ArrayList<String>();

                if (left_remaining>right_remaining){
                    given_square.add("ERROR");
                }
                else if (left_remaining==0 && right_remaining==0){
                    given_square.add(" ");
                }
                else if (left_remaining==right_remaining){
                    ArrayList<String> given_square_recursive = solutions.get(left_remaining-1).get(right_remaining);
                    for (int k=0; k<given_square_recursive.size(); k++){
                        given_square.add("("+given_square_recursive.get(k));
                    }
                }
                else{
                    if (left_remaining==0){
                        String temp="";
                        for (int k=0; k<right_remaining; k++){
                            temp=temp+")";
                        }
                        given_square.add(temp);
                    }
                    else{
                        ArrayList<String> given_square_recursive = solutions.get(left_remaining-1).get(right_remaining);
                        for (int k=0; k<given_square_recursive.size(); k++){
                            given_square.add("("+given_square_recursive.get(k));
                        }
                        given_square_recursive = column_solutions.get(right_remaining-1);
                        for (int k=0; k<given_square_recursive.size(); k++){
                            given_square.add(given_square_recursive.get(k)+")");
                        }                        
                    }

                }
                column_solutions.add(given_square);
            }
            solutions.add(column_solutions) ;
        }
        return solutions.get(n).get(n);
        
    }

        public static void main(String[] args) {
            int n=13;
            //System.out.println(allPairsofParanthesis(n));
            System.out.println(allPairsofParanthesis(n).size());
       }
}
