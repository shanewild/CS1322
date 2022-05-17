import java.util.Scanner;

public class Lab11 {
    public static int  SecondSinceMidnight(String time) throws Exception {
        int seconds=0;
        String[] str= time.split(":",3);
        if (str.length!=3){
throw new Exception("Time format not valid");
        }
            int hr = Integer.parseInt(str[0]);
        if (hr>23) {
            throw new Exception("Hour must be below 24.");
        }
        int min = Integer.parseInt(str[1]);
        if (min>59) {
            throw new Exception("minute must be below 60.");
        }
        int sec = Integer.parseInt(str[2]);
        if (sec>59) {
            throw new Exception("second must be below 60.");
        }
        seconds=(hr*60*60) + (min*60) + sec;
return seconds;
    }
public static void main(String[] Args) {
        int time1,time2;
        String  num1, num2;
    try{
        System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
        Scanner scan=new Scanner(System.in);
        num1=scan.nextLine();
        time1=SecondSinceMidnight(num1);
        
        System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
        num2=scan.nextLine();
        time2=SecondSinceMidnight(num2);
        System.out.println("Difference in seconds: "+ (time2-time1));
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }


}
}
