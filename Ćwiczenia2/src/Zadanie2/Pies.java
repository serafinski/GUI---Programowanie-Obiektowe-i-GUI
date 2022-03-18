package Zadanie2;

public class Pies implements IAnimalBehaviors{
    //pola nie były wymagane w poleceniu, ale prowadzący je dodał — więc ja też dodaje
    private String name;
    private String breed;

    public Pies(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    //nadpisanie metod bo normalnie nic nie zwracają bo void
    @Override
    public void move() {
        System.out.println("Biegaj");
    }

    @Override
    public void speak() {
        System.out.println("Hał, hał!");
    }
}
