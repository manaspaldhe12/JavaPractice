
package threadtest;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
 

class AlarmClock extends Thread
{

   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
   String alarmtime;
   public AlarmClock(String in){
       alarmtime=in;
   }


   @Override
   public void run(){
       while(true){
          Date date = new Date();
          if (dateFormat.format(date).equals(alarmtime)){
             System.out.println("ALARM");
             break;
          }       
       }
   }
}

public class ThreadTest
{
   public static void main(String [] args) throws java.lang.InterruptedException
   {
      AlarmClock a = new AlarmClock("2013/06/09 22:23");
      a.start();
      
   }
}
