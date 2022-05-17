import java.util.Scanner;

class Account{
    private int accountNumber;
    static private int nextNumber=10000;
    private double balance;

    Account(){
        accountNumber=nextNumber;
        balance=0;
nextNumber++;
    }Account(double balance){
        accountNumber=nextNumber;
balance=balance;
        nextNumber++;
    }


    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
public void withdrawal(double amount){
        double temp=getBalance()-amount;
        setBalance(temp);
}
    public void deposit(double amount){
        double temp=getBalance()+amount;
        setBalance(temp);
    }
}
class Checking extends Account{
    @Override
    public void withdrawal(double amount) {
        super.withdrawal(amount);
        if(getBalance()<0){
            double temp=getBalance()-20;
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            setBalance(temp);
        }
    }
}
class Savings extends Account{
    @Override
    public void withdrawal(double amount) {
        super.withdrawal(amount);
        if(getBalance()<500) {
            double temp = getBalance() -10;
            System.out.println("“Charging a fee of $10 because you are below $500");
            setBalance(temp);
        }
    }

    @Override
    public void deposit(double amount) {
        //cant make this static for the life of me...
        int deposittimes=0;
        deposittimes++;
        super.deposit(amount);
        System.out.println("This is deposit "+deposittimes+" to this account");
        if (deposittimes>=6){
            setBalance(getBalance()-10);
            System.out.println("Charging a fee of $10");
        }

    }
    public void interest(){
        double temp=getBalance();
        double intamount=.015*temp;
        setBalance(temp+intamount);
        System.out.println("Customer earned "+intamount+" in interest");
    }

}

public class Lab4_1322 {

    public static void main(String[]Args){
        double amount=0;
        Scanner scan=new Scanner(System.in);
        Account a1=new Account();
        Checking c1=new Checking();
        Savings s1= new Savings();
        int userinput=0;
        do {
            System.out.println("1. Withdraw from Checking\n" +
                    "2. Withdraw from Savings\n" +
                    "3. Deposit to Checking\n" +
                    "4. Deposit to Savings\n" +
                    "5. Balance of Checking\n" +
                    "6. Balance of Savings\n" +
                    "7. Award Interest to Savings now\n" +
                    "8. Quit");
            userinput=scan.nextInt();
switch (userinput){

    case 1:
        System.out.println("How much would you like to withdraw from Checking?");
        amount=scan.nextInt();
c1.withdrawal(amount);
        break;
    case 2:
        System.out.println("How much would you like to withdraw from Savings?");
        amount=scan.nextInt();
s1.withdrawal(amount);
        break;
    case 3:
        System.out.println("How much would you like to deposit into Checking?");
        amount=scan.nextInt();
c1.deposit(amount);
        break;
    case 4:
        System.out.println("How much would you like to deposit into Savings?");
        amount=scan.nextInt();
s1.deposit(amount);
        break;
    case 5:
        System.out.println("Your balance for checking "+c1.getAccountNumber()+" is "+c1.getBalance());
        break;
    case 6:
        System.out.println("Your balance for savings "+s1.getAccountNumber()+" is "+s1.getBalance());
        break;
    case 7:
s1.interest();
        break;
}
        }while(userinput!=8);

    }
}
