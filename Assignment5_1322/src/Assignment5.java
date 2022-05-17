import java.util.Scanner;

class Environment{
    private int temp;
    Environment(){
        temp=0;
    }
    Environment(int temp){
       this.temp=temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}

class Cricket {
    int getChirpCount(Environment e1) {
        int chirp = 0;
        chirp = e1.getTemp()*4-40;
        return chirp;
    }
}

class ClemsonCricket extends Cricket {
    @Override
    int getChirpCount(Environment e1) {
        double chirp;
        chirp =(e1.getTemp()*4-40)*.8;
        return (int) chirp;
    }
}

public class Assignment5 {
    public static void main (String[] args){
        int temp=0;
        Environment e1=new Environment();
        Cricket c1=new Cricket();
        ClemsonCricket cc1=new ClemsonCricket();
        Scanner scan=new Scanner(System.in);
        do {
            System.out.println("What is the current temperature? (Enter -1 to exit)");
temp=scan.nextInt();
e1.setTemp(temp);
if (temp!=-1) {
    System.out.println("Normal cricket: " + e1.getTemp() + " degrees yields " + c1.getChirpCount(e1) + " chirps per minute");
    System.out.println("Clemson cricket: " + e1.getTemp() + " degrees yields " + cc1.getChirpCount(e1) + " chirps per minute");
}
        }while(temp!=-1);

    }
}
