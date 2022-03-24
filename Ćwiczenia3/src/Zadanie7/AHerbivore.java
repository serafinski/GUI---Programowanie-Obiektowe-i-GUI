package Zadanie7;

//Klasa opisująca roślinożercę
public abstract class AHerbivore extends AAnimal{

    //musi mieć konstruktor, bo dziedziczy po AAnimal
    public AHerbivore(String name, Group group) {
        super(name, group);
    }
}
