import com.sun.source.tree.CaseTree;

import java.util.Scanner;

public class Lab9_1322 {
    public static int recursive_multiply(int constant, int num2){
if(num2==1){
   return constant;
}
else{
    num2=constant+recursive_multiply(constant, num2-1);
    return num2;
}
    }
    public static int recursive_divide(int numerator, int denominator){
    /*    int answer=0;
        answer++;
        if (numerator>denominator){
            return 0;
        }
        if (denominator==0){
            return -1;
        }
        if (numerator==denominator){
            return numerator;
        }
if (numerator<denominator){
    numerator=numerator-recursive_divide(numerator-denominator,denominator);
    answer++;
    return answer;
}

return answer;*/
        int count=0;
        count++;
        if (denominator==0)
            return -1;
        if (denominator>numerator){
            return 0;
        }
        if (denominator==numerator){
            return 1;
        }
        return recursive_divide(numerator-denominator, denominator)+count;

    }
    public static int recursive_mod(int numerator, int denominator){
        if (denominator==0)

        return -1;
        if (denominator>numerator){
            return numerator;
        }
        return recursive_mod(numerator-denominator, denominator);
    }

    public static void main(String[]Args){
        int userInput=1,num1,num2;

        Scanner scan=new Scanner(System.in);
        while(userInput!=0){
            System.out.println("Choose from the following:\n" +
                    "0. Quit\n" +
                    "1. Multiply 2 numbers\n" +
                    "2. Div 2 numbers\n" +
                    "3. Mod 2 numbers");
            switch (userInput){
                case 1:
                    userInput=scan.nextInt();
                    System.out.println("Enter first number");
                    num1=scan.nextInt();
                    System.out.println("Enter second number");
                    num2=scan.nextInt();
                    System.out.println(recursive_multiply(num1,num2));
                    break;
                case 2:
                    userInput=scan.nextInt();
                    System.out.println("Enter first number");
                    num1=scan.nextInt();
                    System.out.println("Enter second number");
                    num2=scan.nextInt();
                    System.out.println(recursive_divide(num1,num2));
                    break;
                case 3:
                    userInput=scan.nextInt();
                    System.out.println("Enter first number");
                    num1=scan.nextInt();
                    System.out.println("Enter second number");
                    num2=scan.nextInt();
                    System.out.println(recursive_mod(num1,num2));
                    break;
            }

        }
    }
}
