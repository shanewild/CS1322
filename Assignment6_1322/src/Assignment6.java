import java.util.ArrayList;
import java.util.Scanner;

abstract class Ticket{
    protected static int nextticketnum=0;
    private int ticketnum;
    protected int price;
    Ticket(int price){
        this.price=price;
        ticketnum=nextticketnum;
        nextticketnum++;
    }

    @Override
    public String toString() {
        return "You sold: Ticket number "+ticketnum+" with a price of "+getPrice()+" for ";
    }

    abstract int getPrice();
}
class CurrentBooking extends Ticket{
    @Override
    public String toString() {
        return super.toString()+ "today's game";
    }
    CurrentBooking(){
        super(75);
    }

    @Override
    int getPrice() {
        return price;
    }

}
class AdvanceBooking extends Ticket{
    int daysuntil;
    AdvanceBooking(int daysuntil) {
        super(50);
        this.daysuntil=daysuntil;
        if (daysuntil >=15) {
        price=25;
        }
        else{
            price=50;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"a game in "+daysuntil+" days";
    }

    @Override
    int getPrice() {
        return price;
    }
}
class DiscountBooking extends Ticket{
    int daysuntil;
    DiscountBooking(int daysuntil){
        super(0);
        this.daysuntil=daysuntil;
        if (daysuntil==0){
            price=75;
        }
        else{
            price=10;
        }
    }

    @Override
    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString()+"a game in "+daysuntil+" days";
    }
}

public class Assignment6 {
    public static void main(String[] Args){
        ArrayList<Ticket> ticketlist =new ArrayList<Ticket>();
        int userinput=0;
        int daysuntil=0;
        Ticket t=new CurrentBooking();
        Scanner scan=new Scanner(System.in);
        do{
            System.out.println("Choose from the following:\n" +
                    "1. Sell a Ticket for a future game\n" +
                    "2. Sell a Ticket for today's game\n" +
                    "3. Sell a Discount Ticket\n" +
                    "4. Print All Tickets\n" +
                    "5. Exit");
userinput=scan.nextInt();
switch (userinput) {
    case 1:
        System.out.println("How many days until the game?");
        userinput = scan.nextInt();
        t = new AdvanceBooking(userinput);
        ticketlist.add(t);
        System.out.println(t.toString());
        break;
    case 2:
        t = new CurrentBooking();
        ticketlist.add(t);
        System.out.println(t.toString());
        break;
    case 3:
        System.out.println("How many days until the game?");
        daysuntil = scan.nextInt();
        t = new DiscountBooking(daysuntil);
        ticketlist.add(t);
        System.out.println(t.toString());;
        break;
    case 4:
        for (Ticket x : ticketlist) {
            System.out.println(x.toString());;
        }
        break;
    default:
        System.out.println("invalid voice");
        break;
}

        }while(userinput!=5);

    }
}
