package Zadanie5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ponownie jak w zadaniu 1 -> korzystamy z pakietu List i ArrayList
        List<IGamer> gamerList = new ArrayList<>();

        //dodajemy do listy wszystkich graczy
        gamerList.add(new GamerKamien());
        gamerList.add(new GamerPapier());
        gamerList.add(new GamerKamien());
        gamerList.add(new GamerRandom());
        gamerList.add(new GamerZ());

        //wybieramy z indeksów tablicy naszych graczy

        //GamerZ
        int gracz1 = 4;

        //GamerPapier
        int gracz2 = 1;

        //tworzymy nową arenę

        //graczy z listy wybieramy za pomocą metod .get
        Arena arena = new Arena(gamerList.get(gracz1), gamerList.get(gracz2));

        //chcemy by walczyli przez 100 rund
        arena.fight(100);

        //wyniki

        //gracz1
        System.out.println(gamerList.get(gracz1).name() + " " + arena.getWynikGracz1());

        //gracz2
        System.out.println(gamerList.get(gracz2).name() + " "+ arena.getWynikGracz2());

        //wypisanie, jaki to gracz + jego adres w tablicy
        System.out.println(gamerList.get(1));

    }
}
