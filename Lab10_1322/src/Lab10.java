import java.util.Scanner;

public class Lab10 {
    public static String repeatNTimes(String str, int n){
if (n==1){
    return str;
}
if (n==0){
    return "";
}
 return str+repeatNTimes(str, n-1);
    }
public static boolean isReverse(String str1, String str2) {
    String temp;
    if (str1.charAt(0) != str2.charAt(str2.length()-1)) {
return false;
    }
     else if (str1.equals("")||str2.equals("")){
        return true;
    }
        isReverse(str1.substring(1), str2.substring(1));
    return true;
}
    public static void main(String[]Args){
        String s1,s2;
        boolean output;
        System.out.println(repeatNTimes("I must study recursion until it makes sense \n",100));
        System.out.println("Enter the first string");
        Scanner scan=new Scanner(System.in);
        s1=scan.nextLine();
        System.out.println("Enter the second string");
        s2=scan.nextLine();
        output= isReverse(s1,s2);
        if (output){
            System.out.println(s1+" is the reverse of "+s2);
        }
        else {
            System.out.println(s1+" is not the reverse of "+s2);
        }

    }
}
