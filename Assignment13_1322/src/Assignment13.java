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

    public String getTitle() {
        return title;
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
    public String search(String title) {
        node current = top;
        boolean isFound = false;
        while (current != null) {
            if (current.getTitle().equals(title)) {
                isFound = true;
                return current.toString();
            }
            current = current.next;
        }
        return "Not Found";
    }
    public boolean remove(String title){

        node current = top;
        node previous = current;
        if (current==null){
            return false;
        }
        if(current.title.equals(title))
        {
            top = current.next;
            return true;
        }
        while(current.title.equals(title)==false)
        {
            previous=current;
            current=current.next;
            if(current == null)
                return false;
        }
        previous.next=current.next;
        return true;
    }

}
public class Assignment13 {
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
                    "2. See collection\n" +
                    "3. Search collection\n" +
                    "4. Remove BlueRay from collection");
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
                if(userInput==3){
                    System.out.println("What title to search for?");
                    title=scan.nextLine();
                    System.out.println(collection.search(title));
                }
                if (userInput==4){
                    System.out.println("What title to delete?");
                    title=scan.nextLine();
                    boolean temp=collection.remove(title);
                    if (temp){
                        System.out.println(title+" deleted");
                    }
                    else{
                        System.out.println("Not found");
                    }
                }
            }
        }

    }
}

