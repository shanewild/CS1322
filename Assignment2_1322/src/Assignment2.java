import java.util.ArrayList;
import java.util.Scanner;

class Caesar {
    ArrayList<Character> alphabet = new ArrayList<Character>();

    public Caesar() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.add(letter);
        }
    }

    public int position_of_char(char letter) {
        int charposition=0;
        for (int i=0; i<25;i++){
            if (letter==alphabet.get(i)){
                charposition=i;
            }
        }
        return charposition;
    }

    public char letter_at_pos(int number) {
            char letter=alphabet.get(number);
        return letter;
    }

    public char encrypt_char(char letter) {
        int number;
        number = position_of_char(letter);
        number += 3;
        if (number >= 26) {
            number =number- 26;
        }

        letter = letter_at_pos(number);
        return letter;
    }

    public char decrypt_char(char letter) {
        int number;
        number = position_of_char(letter);
        number -= 3;
        if (number < 0) {
            number += 26;
        }
        letter = letter_at_pos(number);
        return letter;
    }

    public String encrypt(String nonencrypted) {
        String ciphertext = "";
        char temp;
        for (int i = 0; i < nonencrypted.length(); i++) {
            temp = encrypt_char(nonencrypted.charAt(i));
            ciphertext += temp;

        }
        return ciphertext;
    }

    public String decrypt(String encrypted) {
        String nonecrypted = "";
        char temp;
        for (int i = 0; i < encrypted.length(); i++) {
            temp = decrypt_char(encrypted.charAt(i));
            nonecrypted+=temp;
        }
        return nonecrypted;
    }
}
public class Assignment2 {
public static void main(String []Args){
    int userInput=0;
    String message;
    Scanner scan= new Scanner(System.in);
    Caesar c1=new Caesar();
    do {
        System.out.println("1 Encrypt a message\n" +
                "2 Decrypt a message\n" +
                "3 Quit\n");
        userInput=scan.nextInt();
        scan.nextLine();
        if (userInput==1){
            System.out.println("What is the message to encrypt?\n");
message=scan.nextLine();
            System.out.println("Encrypted: "+c1.encrypt(message.toLowerCase()));
        }
        if (userInput==2){
            System.out.println("What is the message to decrypt?\n");
            message=scan.nextLine();
            System.out.println("Message is: "+c1.decrypt(message.toLowerCase()));
        }

    }while (userInput!=3);
}
}
