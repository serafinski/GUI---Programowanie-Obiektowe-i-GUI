package Zadanie7;

//Klasa opisująca mięsożercę
public abstract class ACarnivore extends AAnimal{

    //musi mieć konstruktor, bo dziedziczy po AAnimal
    public ACarnivore(String name, Group group) {
        super(name, group);
    }

    //metoda jest abstrakcyjna -> nie ma ciała — przesłaniamy w klasie docelowej
    abstract public boolean isScarvenger();
}
