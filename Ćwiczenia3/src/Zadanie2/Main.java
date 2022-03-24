package Zadanie2;

public class Main {
    public static void main(String[] args) {
        //Przy nazwie klasy Kontener musi być typ generyka, a nie przy tworzeniu samego obiektu

        //Jeżeli nie damy pustego <> przy new Kontener -> to będzie to widzieć jako raw typing
        //kontener przyjmuje 2 zmienne
        KontenerZad2<String,Integer> str_in = new KontenerZad2<>("Tomasz",22);
        KontenerZad2<Integer, String> in_str = new KontenerZad2<>(22,"Tomasz");

        //patrzymy czy metoda wypisz z klasy Kontener działa
        str_in.wypisz();
        in_str.wypisz();
    }
}
