package Zadanie5;

public class Main {
    public static void main(String[] args) {

        //deklaracja zegara
        Clock clock = new Clock();

        //utworzenie i uruchomienie wątku dla zegara
        (new Thread(clock)).start();

        //utworzenie JFrame'a z zegarem
        new MyWindow(clock);
    }
}
