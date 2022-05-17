import java.util.Scanner;

class BlueRayDisk{
String title, director;
int year;
double cost;
BlueRayDisk(){

}
BlueRayDisk(String title, String director, int year, double cost){
    this.title=title;
    this.director=director;
    this.year=year;
    this.cost=cost;
}
@Override
public String toString() {
    return "$"+cost+" "+year+" "+title+", "+director;
}
}
class node extends BlueRayDisk{
    node next;
    node(String title, String director, int year, double cost){
        this.title=title;
        this.director=director;
        this.year=year;
        this.cost=cost;
    }
}
class BlueRayCollection {
    private node top = null;
public void add(String title, String director, int year, double cost) {
    node n = new node(title, director, year, cost);
    node current=top;
    if (current == null) {
        top= n;
    } else {
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }
}
public void show_all(){
    node current= top;
    while(current!=null){
        System.out.println(current.toString());
        current=current.next;
    }
}
}
public class Lab14 {
    public static void main(String[] args) {
        int userInput=1;
        String title, director;
        int year;
        double cost;
        Scanner scan=new Scanner(System.in);
BlueRayCollection collection=new BlueRayCollection();
        while(userInput!=0){
        System.out.println("0. Quit\n" +
                "1. Add BlueRay to collection\n" +
                "2. See collection");
        userInput=scan.nextInt();
        scan.nextLine();
            if (userInput!=0){
                if(userInput==1){
                    System.out.println("What is the title?");
                    title=scan.nextLine();
                    System.out.println("What is the director");
                    director=scan.nextLine();
                    System.out.println("What is the year of the release?");
                    year=scan.nextInt();
                    System.out.println("What is the cost?");
                    cost=scan.nextDouble();
                    collection.add(title, director, year, cost);
                }
                if (userInput==2){
                    collection.show_all();
                }
            }
        }

    }
}
