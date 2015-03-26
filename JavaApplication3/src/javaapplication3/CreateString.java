/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 * we have given a char array like “a1b2c3″ we have to convert this array to array like this “abbccc” .This has to be done in place as we have given that array has just enough space to hold the expanded array.

example:

1)input: a1b1c1

output:abc

length of array will be shortened.

2)input: a2b2c2

output:aabbcc

length of array will be equal to given array.

3)input: a3b4

output:aaabbbb

length of array will be greater than given array.
 * @author mpaldhe
 */
public class CreateString {

    public static String updateString (String  original, String repeating_string, int repeat ){
        for (int adder=0; adder<repeat; adder++){
            original= original+repeating_string;
        }
        return original;
    }

    public static boolean isNumeric (char givenchar){
        if ( (givenchar=='0')
           ||(givenchar=='1')
           ||(givenchar=='2')
           ||(givenchar=='3')
           ||(givenchar=='4')
           ||(givenchar=='5')
           ||(givenchar=='6')
           ||(givenchar=='7')
           ||(givenchar=='8')
           ||(givenchar=='9')){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String getFirstRepeatString (String original){
        int i=0;
        for (i=0; i<original.length(); i++){
            if (isNumeric(original.charAt(i))==true){
               i--;
               break;
            }
        }
        return original.substring(0,i+1);
    }
    
    public static int getFirstRepeatValue (String original){
       int start=0;
       for ( start=0; start<original.length(); start++){
            if (isNumeric(original.charAt(start))==true){
               start--;
               break;
            }
       }// 0 to start is now the string
       
       int end=start+1;
       for (end=start+1; end<original.length(); end++ ){
            if (isNumeric(original.charAt(end))==false){
               break;
            }
        }
       end--;

       return Integer.parseInt(original.substring(start+1, end+1));
    }
    
    public static int getFirstRepeatIndex (String original){
       int start=0;
       for ( start=0; start<original.length(); start++){
            if (isNumeric(original.charAt(start))==true){
               start--;
               break;
            }
       }// 0 to start is now the string
       
       int end=start+1;
       for (end=start+1; end<original.length(); end++ ){
            if (isNumeric(original.charAt(end))==false){
               break;
            }
        }
       end--;
        return end;
    }
    
    
    public static void main(String[] args) {
        String original ="purval2subashish1rishanka12manas3";
        String final_string ="";
        
        while (!(getFirstRepeatIndex(original)==0)){
            String repeated = getFirstRepeatString(original);
            int repetitions = getFirstRepeatValue(original);
            final_string =  updateString(final_string, repeated, repetitions);
            int index = getFirstRepeatIndex (original);
            original=original.substring(index+1);
        }
        System.out.println(final_string);
    }
}
