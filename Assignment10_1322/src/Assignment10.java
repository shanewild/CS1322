import java.util.Scanner;

class ColumnFull extends Exception{
    ColumnFull(String message){
        super(message);
    }
}
class ConnectFour{
char[][] myArray=new char[6][7];
String player;
char token;
ConnectFour(){
    token='R';
    player="Red";
for (int i=0; i<6; i++){
    for (int j=0; j<7; j++){
myArray[i][j]=' ';
    }
}
}

    public String getPlayer() {
        return player;
    }

    public char getToken() {
        return token;
    }

    void nextTurn(){
    if (player=="Red"){
        player="Yellow";
        token='Y';
    }
    else {
        player="Red";
        token='R';
    }
}
int nextAvailablePosition( int row, int column){
if (row==-1){
    return -1;
}
if(myArray[row][column]==' '){
return row;
}
else{
    return nextAvailablePosition(row-1, column);
}
}
void dropPiece(int column, char token) throws ColumnFull {
    int row=nextAvailablePosition(5,column);
    if(row==-1){
throw new ColumnFull("Column Full Try Again");
    }
    else{
        myArray[row][column]=token;
    }

}
    @Override
    public String toString() {
        String to_return="  0   1   2   3   4   5   6";
        for(int i=0;i<6;i++) {
            to_return+="\n-----------------------------\n";
            to_return+="| ";
            for(int j=0;j<7;j++) {
                to_return+=myArray[i][j]+" | ";
            }
        }
        to_return+="\n-----------------------------\n";
        return to_return;
    }

}
public class Assignment10 {
    public static void main(String[] Args){
        ConnectFour c1=new ConnectFour();
        Scanner scan=new Scanner(System.in);
        int userInput=0;
while(userInput!=9){
    System.out.println(c1.toString());
    System.out.println("Which column would "+c1.getPlayer()+" like to go in (9 to quit)");
    userInput=scan.nextInt();
    if (userInput>=0&&userInput<=6){
        try{
            c1.dropPiece(userInput,c1.getToken());
            c1.nextTurn();
        }
        catch (ColumnFull c){
            System.out.println(c.getMessage());
        }

    }
    else if (userInput!=9){

try{
    throw new Exception("Please pick a valid number");
}catch (Exception e){
    System.out.println(e.getMessage());
}
    }
}
    }
}
