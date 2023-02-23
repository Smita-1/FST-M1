package Activities_Java_Session_1;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    //constructor
    Car(){
        tyres = 4;
        doors = 4;
    }
    //Class Methods
    public void displayCharacterstics(){
        System.out.println("Color of car" + color);
        System.out.println("Make of car" + make);
        System.out.println("Transmission of car" + transmission);
        System.out.println("doors of car" + doors);
        System.out.println("tyres of car" + tyres);
    }
    public void accelerate(){
        System.out.println("Car is moving forward");
    }
    public void brake()
    {
        System.out.println("Car has Stopped");
    }
}
