/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converttointeger;

public class ConvertToInteger {

    public static int convertRomantoInt (int accumulator, int[] roman, int start, int length){
        if (start==length ){
            return accumulator;
        }
        else {
            int calculate_sub=convertRomantoInt(0, roman, start+1, length);
            if ((start+1 == length) || (roman[start] >= roman[start+1])){
                // add to accumulator
                //accumulator=accumulator+roman[start];
                //return convertRomantoInt(accumulator, roman, start+1, length);
                return roman[start]+calculate_sub;
            }
            else{
                //subtract the accumulator
                //accumulator=roman[start]-accumulator;
                //return convertRomantoInt(accumulator, roman, start+1, length);                
                return calculate_sub-roman[start];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] roman ={1000, 100, 100, 100, 10, 5 , 50, 1, 1};
        int length=8;
        System.out.println(convertRomantoInt(0, roman, 0, length));
    }
}
