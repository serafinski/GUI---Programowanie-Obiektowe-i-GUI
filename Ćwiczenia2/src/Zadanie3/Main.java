package Zadanie3;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto();
        Boat boat = new Boat();
        Amphibious amphibious = new Amphibious();

        //sprawdzamy, czy metody działają
        System.out.println("Auto");
        auto.move();
        System.out.println();

        System.out.println("Boat");
        boat.move();
        System.out.println();


        System.out.println("Amphibious");
        //poruszanie jak nie jest w wodzie
        amphibious.move();

        //zmieniamy, że jest w wodzie
        amphibious.setInWater(true);

        //poruszanie w wodzie
        amphibious.move();
    }
}
