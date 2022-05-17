import java.io.*;
import java.util.Scanner;

public class Lab1322 {
    public static void main(String[] args) {
        String userInput="", line="";
        String[] words=new String[]{};
        int linecount=0, charcount=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a filename: ");
        userInput=scan.nextLine();

        try {
            File file=new File(userInput);
            Scanner filescan=new Scanner(file);
            while(filescan.hasNextLine()){
                line+=filescan.nextLine();
                words = line.split(" ");
                linecount++;
                char[] charArray = line.toCharArray();
                for (int i=0;i<charArray.length;i++){
                    if (charArray[i]!=' '&&charArray[i]!=','&&charArray[i]!='.'){
                        charcount++;
                    }
                }
            }
            System.out.println("Words: "+words.length);
            System.out.println("Lines: "+linecount);
            System.out.println("Characters: " +charcount);



        }
        catch (Exception e){
            System.out.println("File error: "+userInput+"(No such file or directory)");
        }

    }
}
