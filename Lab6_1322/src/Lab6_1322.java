import java.math.*;
import java.util.Scanner;

interface FindFib{
    int calculate_fib(int number);
}
class Fibiteration implements FindFib{
    @Override
    public int calculate_fib(int number) {
        int fib=0, temp1=1, temp2=0;
        for (int i=1; i<number; i++){
            fib=temp1+temp2;
            temp2=temp1;
            temp1=fib;

        }
        return fib;
    }

}
class FibFormula implements FindFib{

    @Override
    public int calculate_fib(int number) {
        double fib=0;
        fib= (Math.pow(((1+ Math.sqrt(5))/2),number) - (Math.pow((1-Math.sqrt(5))/2,number))) / Math.sqrt(5);
        // (((1+sqrt(5))/2)^n - ((1-sqrt(5))/2)^n) / sqrt(5)
        return (int)fib;
    }
}
public class Lab6_1322 {
    public static void main(String[]Args){
        int number;
        Fibiteration fi1=new Fibiteration();
      FibFormula ff1=new FibFormula();
        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        Scanner scan=new Scanner(System.in);
        number=scan.nextInt();
        System.out.println("Fib of "+number+" by iteration is: "+ fi1.calculate_fib(number));
        System.out.println("Fib of "+number+" by formula is: "+ ff1.calculate_fib(number));
    }
}
