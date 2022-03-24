package Zadanie7;

public class Lion extends ACarnivore{

    public Lion(String name, Group group) {
        super(name, group);
    }

    //przesłonięcie metody abstrakcyjnej z ACarnivore
    @Override
    public boolean isScarvenger() {
        return false;
    }
}
