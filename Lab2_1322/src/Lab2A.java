import java.util.Random;
import java.util.Scanner;
class StockItem {
    Scanner scan=new Scanner(System.in);
    private String description;
    private int quantity;
    private float price;
    private int id;
    StockItem() {
        description = "";
        id = Lab2A.randomid();
        quantity = 0;
        price = 0.00f;
    }
    StockItem(String d, int quantity, float p) {
        description = d;
        id = Lab2A.randomid();
        this.quantity = quantity;
        price = p;
    }
    //got an error when I tried to override toString
    public String toString(StockItem milk, StockItem bread) {
        return "Milk: Item number: "+milk.getId()+" is 1 Gallon of Milk has price "+milk.getPrice()+" we currently have "+milk.getQuantity()+" in stock\n" +
                "Bread: Item number:  "+bread.getId()+" is 1 Loaf of bread has "+bread.getPrice()+" we currently have "+bread.getQuantity()+" in stock";
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(float price) {
        this.price = price;
        if (price < 0) {
            System.out.println("error");
        }
    }
    public void raiseQuantity(int quantity) {
        this.quantity += quantity;
        if (quantity < 0) {
            System.out.println("error");
        }
    }
    public void lowerQuantity() {
        this.quantity -= 1;
        if (quantity < 0) {
            System.out.println("error");
        }
    }
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDescription() {
        return description;
    }
}
public class Lab2A {
    static int randomid() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
    public static void main(String[] Args) {
        int input = 0, quantity;
        float price;
        Scanner scan = new Scanner(System.in);
        StockItem milk = new StockItem("1 gallon of Milk", 15, 3.60f);
        StockItem bread = new StockItem("1 Loaf of Bread", 30, 1.98f);
        do {
            System.out.println("1. Sold One Milk\n" +
                    "2. Sold One Bread\n" +
                    "3. Change price of Milk\n" +
                    "4. Change price of Bread\n" +
                    "5. Add Milk to Inventory\n" +
                    "6. Add Bread to Inventory\n" +
                    "7. See Inventory\n" +
                    "8. Quit");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    milk.lowerQuantity();
                    break;
                case 2:
                    bread.lowerQuantity();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("What is the new price for Milk");
                    price = scan.nextFloat();
                    milk.setPrice(price);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("What is the new price for Bread");
                    price = scan.nextFloat();
                    bread.setPrice(price);
                    break;
                case 5:
                    System.out.println("How much milk did we get");
                    quantity = scan.nextInt();
                    milk.raiseQuantity(quantity);
                    break;
                case 6:
                    System.out.println("How many bread did we get");
                    quantity = scan.nextInt();
                    bread.raiseQuantity(quantity);
                    break;
                case 7:
                    System.out.println(milk.toString(milk, bread));
                    break;
            }
        } while (input != 8);
    }
}
