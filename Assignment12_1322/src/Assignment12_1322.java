import java.util.Random;

class Guesser extends Thread{
public int threadID;
public static int nextThreadID=1;
Guesser(){
    threadID=nextThreadID;
    nextThreadID++;

}
public void run(){
    Random r= new Random();
    int num=0,guess=0;
    while(num!=123456){
        guess++;
        num=r.nextInt(1000000);
    }
    if (num==123456){
        System.out.println("I’m thread "+threadID+", I just found the number on guess "+guess);
    }
}
}
public class Assignment12_1322 {
    public static void main(String[] args) {
        Thread[] mythread=new Thread[100];
for (int i=0; i<100;i++){
mythread[i]=new Guesser();
mythread[i].start();
}
    }
}
