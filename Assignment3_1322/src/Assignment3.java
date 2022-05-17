import java.util.ArrayList;
import java.util.Scanner;

class Vehicle{
    private String make, model, color;
    private int mileage, cost, rental;
    private boolean rented;
    Vehicle(){

    }
    Vehicle(String make, String model, String color, int mileage, int cost, int rental, boolean rented){
        this.make=make;
        this.model=model;
        this.color=color;
        this.mileage=mileage;
        this.cost=cost;
        this.rental=rental;
        this.rented=rented;
    }

    public int getCost() {
        return cost;
    }

    public int getMileage() {
        return mileage;
    }

    public int getRental() {
        return rental;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRental(int rental) {
        this.rental = rental;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        if (rented) {
            return "Rented: "+color + " " + make + " " + model + " with " + mileage + " miles";
        }
        else {
            return "Available: "+color + " " + make + " " + model + " with " + mileage + " miles";
        }
    }
}
class Economy_Car extends Vehicle{
    int daily_rental_rate;
    Economy_Car(String make, String model, String color, int mileage, int cost, int rental, boolean rented){
        setMake(make);
       setModel(model);
       setColor(color);
       setMileage(mileage);
       setCost(cost);
       daily_rental_rate=rental;
       setRented(rented);
    }
    @Override
    public String toString() {
       return "Economy Car: " + super.toString();
    }
}
class Midsize_Car extends Vehicle{
    int daily_rental_rate;
    Midsize_Car(String make, String model, String color, int mileage, int cost, int rental, boolean rented){
        setMake(make);
        setModel(model);
        setColor(color);
        setMileage(mileage);
        setCost(cost);
        daily_rental_rate=rental;
        setRented(rented);
    }
    @Override
    public String toString() {
        return "Midsized Car: " + super.toString();
    }
}
class SUV extends Vehicle{
    int daily_rental_rate;
    SUV(String make, String model, String color, int mileage, int cost, int rental, boolean rented){
        setMake(make);
        setModel(model);
        setColor(color);
        setMileage(mileage);
        setCost(cost);
        daily_rental_rate=rental;
        setRented(rented);
    }
    @Override
    public String toString() {
        return "SUV: " + super.toString();
    }
}
public class Assignment3 {
    public static void show_cars(ArrayList<Vehicle> cars){
        System.out.println("0. Return");
        int i=0;
        for (Vehicle x: cars) {

            i++;
            System.out.println(i+". "+x.toString());
        }

    }
    public static void main(String []Args){

        int userinput=0;
        Scanner scan=new Scanner(System.in);
        ArrayList<Vehicle> cars =new ArrayList<Vehicle>();
             Economy_Car c1= new Economy_Car("Nissan","Versa","Blue",105,14500,25,false);
             Economy_Car c2= new Economy_Car("Toyota","Yaris","White",8422,17500,25,false);
             Midsize_Car c3= new Midsize_Car("Dodge","Avenger","Green",15720,15000,45,false);
             Midsize_Car c4=new Midsize_Car("Ford","Focus","Yellow",2368,14500,45,false);
             SUV c5=new SUV("Toyota","Rav4","Silver",432,26150,80,false);
             cars.add(c1);
             cars.add(c2);
             cars.add(c3);
             cars.add(c4);
             cars.add(c5);
             do {
                 System.out.println("1. Rent cars\n" +
                         "2. Return cars\n" +
                         "3. Quit\n");
                 userinput=scan.nextInt();
                 switch (userinput){
                     case 1:
                     do {
                         System.out.println("Choose a car to rent:");
                         show_cars(cars);
                         userinput=scan.nextInt();
                         switch (userinput){
                             case 1:
                                 c1.setRented(true);
                                 break;
                             case 2:
                                 c2.setRented(true);
                                 break;
                             case 3:
                                 c3.setRented(true);
                                 break;
                             case 4:
                                 c4.setRented(true);
                                 break;
                             case 5:
                                 c5.setRented(true);
                                 break;
                         }
                     }while(userinput!=0);
                     break;
                     case 2:
                         do {
                             System.out.println("Choose a car to rent:");
                             show_cars(cars);
                             userinput=scan.nextInt();
                             switch (userinput){
                                 case 1:
                                     c1.setRented(false);
                                     break;
                                 case 2:
                                     c2.setRented(false);
                                     break;
                                 case 3:
                                     c3.setRented(false);
                                     break;
                                 case 4:
                                     c4.setRented(false);
                                     break;
                                 case 5:
                                     c5.setRented(false);
                                     break;
                             }
                         }while(userinput!=0);
                         break;
                 }

             }while (userinput!=3);
    }

}
