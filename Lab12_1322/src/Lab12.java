import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab12 {


    public static void main(String[] args) {
        int line=0;
        File file1 = new File("C:\\Users\\Shane\\OneDrive\\Documents\\Note1.txt");
        File file2= new File("C:\\Users\\Shane\\OneDrive\\Documents\\Note2.txt");
        try {
            Scanner scan1=new Scanner(file1);
            Scanner scan2=new Scanner(file2);
            while(scan1.hasNextLine()&& scan2.hasNextLine()){
                line++;
                if (scan1.nextLine()!=scan2.nextLine()){
                    System.out.println("Line "+line);
                    System.out.println("< "+scan1.nextLine());
                    System.out.println("> "+scan2.nextLine());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
