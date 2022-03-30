package Zadanie2;

public class Animal {
    //pola utworzone zgodnie z poleceniem
    private String name;
    private double weight;
    private double height;
    private double topSpeed;

    //zawsze konstruktor — pola muszą być czymś inicjowane
    public Animal(String name, double weight, double height, double topSpeed) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.topSpeed = topSpeed;
    }

    //gettery — potrzebne do filtrów w Main
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    //Nadpisanie metody toString — to akurat nie było potrzebne (prowadzący tego nie zrobił)
    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + name + '\'' +
                ", waga=" + weight +
                ", wzrost=" + height +
                ", predkosc=" + topSpeed +
                '}';
    }
}
