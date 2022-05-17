class Circle{
    private double radius;
Circle(double radius){
    this.radius=radius;
}
public double circumference() {
    double circumference=2*Math.PI*radius;
return circumference;
}
public double area(){
    double area=Math.PI*Math.pow(radius,2);
    return area;
}

    @Override
    public String toString() {
        return "Circle has radius= " + radius +" area= " +area()+" circumference= "+circumference();
    }
}
class Triangle{
    private double side1, side2, side3;
    Triangle(){
        side1=3;
        side2=4;
        side3=5;
    }
    Triangle(double side1, double side2, double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public double perimiter(){
        double perimiter=side1+side2+side3;
        return perimiter;
    }
    public double area(){
        double p=(side1+side2+side3)/2;
        double area=Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return area;
    }
public double height(){
        double height=0;
    if (side1<side2&&side1<side3){
        height=area()*2/side1;
    }
    else if (side2<side1&&side2<side3){
        height=area()*2/side2;
    }
    else if (side3<side2&&side3<side1){
        height=area()*2/side1;
    }
      return height;
}

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    public String toString() {
        return "Triangle has " + "side1=" + side1 + " side2=" + side2 + " side3=" + side3 +" area="+area()+" height of "+height()+" and a perimeter of "+perimiter();
    }
}
class Rectangle{
    double height,width;
    Rectangle(double height, double width){
        this.height=height;
        this.width=width;
    }
    public double perimiter(){
        double perimiter=2*height+2*width;
        return perimiter;
    }
    public double area(){
        double area=height*width;
        return area;
    }

    @Override
    public String toString() {
        return "rectangle has height=" + height + " width=" + width +" perimeter="+perimiter()+" area="+area();
    }
}
public class Assignment1 {
    public static void main(String[]Args){
        for (int i=1; i<=10;i++){
            Circle circle=new Circle(i);
            System.out.println(circle.toString());
        }
        for (int i=1;i<=3;i++){
            for (int j=1; j<=3;j++){
                Rectangle rectangle =new Rectangle(i,j);
                System.out.println(rectangle.toString());
            }
        }
        Triangle t1=new Triangle(18,30,24);
        System.out.println(t1.toString());
        Triangle t2=new Triangle();
        System.out.println(t2.toString());
    }

}
