package Zadanie5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //pierwsza zmienna jest kluczem, druga wartością
        Map<String, Integer> mapa = new HashMap<>();

        //dodajemy klucze i wartości
        mapa.put("Styczen",31);
        mapa.put("Luty",28);
        mapa.put("Marzec",31);
        mapa.put("Kwiecien",30);
        mapa.put("Maj",31);
        mapa.put("Czerwiec",30);
        mapa.put("Lipiec",31);
        mapa.put("Sierpien",31);
        mapa.put("Wrzesien",30);
        mapa.put("Pazdziernik",31);
        mapa.put("Listopad",30);
        mapa.put("Grudzien",31);

        //wypisujemy liczbę dni dla marca
        System.out.println(mapa.get("Marzec"));

        //wypisujemy zawartość całej kolekcji
        System.out.println(mapa);
    }
}
