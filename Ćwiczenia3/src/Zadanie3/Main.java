package Zadanie3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //korzystamy z poznanych na ostatnich zajęciach pakietów ArrayList oraz List
        List<String> lista = new ArrayList<>();

        //dodajemy podane ciągi znaków
        lista.add("Ala");
        lista.add("ma");
        lista.add("Kota");

        //wyświetlamy długość listy
        System.out.println("Dlugosc listy: " + lista.size());

        //wypisujemy zawartość całej listy
        for (String ciag_znakow : lista) {
            System.out.print(ciag_znakow + " ");
        }
    }
}
