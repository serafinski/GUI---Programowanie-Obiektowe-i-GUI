package Zadanie1;

public class Main {
    public static void main(String[] args) {
        //Przy nazwie klasy Kontener musi być typ generyka, a nie przy tworzeniu samego obiektu

        //Jeżeli nie damy pustego <> przy new Kontener -> to będzie to widzieć jako raw typing
        Kontener<String> str = new Kontener<>("Tomasz");
        Kontener<Integer> in = new Kontener<>(22);

        //patrzymy czy metoda wypisz z klasy Kontener działa
        str.wypisz();
        in.wypisz();
    }
}
