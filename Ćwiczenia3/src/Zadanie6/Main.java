package Zadanie6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");

        Samochod skoda1 = new Samochod("WA00001", "Skoda");
        Samochod skoda2 = new Samochod("SC36010", "Skoda");
        Samochod mazda1 = new Samochod("WA01234", "Mazda");
        Samochod mazda2 = new Samochod("DW01ASD", "Mazda");
        Samochod bmw = new Samochod("WA12690", "BMW");
        Samochod volvo = new Samochod("KR60606", "Volvo");

        /*
         * Jan Kowalski -> SKODA WA00001, BMW WA12690
         * Adam Nowak -> MAZDA DW01ASD
         * Bartosz Krawczyk -> VOLVO KR60606, MAZDA WA01234, SKODA SC36010
         * Kierownik Heniek -> [Brak samochodów]
         * Samochody, których numery rejestracyjne zaczynają się na WA:
         * SKODA WA00001 * BMW WA12690 * MAZDA WA01234 * */


        //jako klucz osoba, a jako wartość lista samochodów
        //musimy jako wartość dać listę samochodów -> bo jedna osoba może mieć więcej niż 1 auto
        HashMap<Osoba, List<Samochod>> mapaSamochodow = new HashMap<>();

        //najpierw tworzymy klucz z osoby i nowej listy samochodów
        mapaSamochodow.put(kowalski, new ArrayList<Samochod>());
        //następnie dodajemy kolejno samochody jako wartość do listy samochodów
        mapaSamochodow.get(kowalski).add(skoda1);
        mapaSamochodow.get(kowalski).add(bmw);

        //najpierw tworzymy klucz z osoby i nowej listy samochodów
        mapaSamochodow.put(nowak, new ArrayList<Samochod>());
        //następnie dodajemy kolejno samochody jako wartość do listy samochodów
        mapaSamochodow.get(nowak).add(mazda2);

        //najpierw tworzymy klucz z osoby i nowej listy samochodów
        mapaSamochodow.put(krawczyk,new ArrayList<Samochod>());
        //następnie dodajemy kolejno samochody jako wartość do listy samochodów
        mapaSamochodow.get(krawczyk).add(volvo);
        mapaSamochodow.get(krawczyk).add(mazda1);
        mapaSamochodow.get(krawczyk).add(skoda2);

        //najpierw tworzymy klucz z osoby i nowej listy samochodów
        //nie ma aut więc tylko tworzymy nową listę
        mapaSamochodow.put(heniek,new ArrayList<Samochod>());

        //pętla wypisująca kto ma ile pojazdów na liście

        for (Map.Entry <Osoba, List<Samochod>> wystapienie : mapaSamochodow.entrySet()) {
            System.out.println(wystapienie.getKey() + " posiada " + wystapienie.getValue().size() + " pojazd/y/ów");
            // np: Jan Kowalski posiada 3 pojazdy
        }

        System.out.println("\nPOJAZDY KTORYCH REJESTRACJA ZACZYNA SIE TYLKO NA WA!");
        System.out.println();

        //tak samo co do pojazdów na liście
        for(Map.Entry<Osoba,List<Samochod>> wystapienie : mapaSamochodow.entrySet()){
            //dla rejestracji
            for(Samochod samochod : wystapienie.getValue())
                //jeżeli rejestracja zaczyna się na WA
                if (samochod.getRejestracja().matches("WA.+"))
                    //wypisz rejestracje
                    System.out.println(samochod + ";");
        }
        System.out.println();

        //nie wiem, po co to jest, ale było w main
        System.out.println(mapaSamochodow.get(nowak).get(0)); // MAZDA DW01ASD
    }
}