package Zadanie5;

import java.util.Arrays;
import java.util.List;


//nowy pakiet -> odnosi się do strumieni!


public class Main {
    public static void main(String[] args) {

        //używamy Array.asList -> od razu możemy podać listę elementów wy specyfikowaną przez generyk
        List<Animal> animalList = Arrays.asList(
                new Animal("Giraffe",790,3,30),
                new Animal("Lion",250,3,50),
                new Animal("Dog",10,1,15)
        );

        //wypisanie listy przed sortowaniem!
        System.out.println(animalList);

        //sortowanie listy

        //wykorzystanie Comperator -> jako wyrażenie Lambda
        //Lambda zrobi nam obiekt klasy anonimowej implementujący interfejs Comparator i od razu zdefiniuje funkcje compare w taki sposób, że przyjmie 2 parametry i zwróci różnice między nimi

        //musiałem zcastować do int -> bo nie przyjmie double!
        animalList.sort(((o1, o2) -> (int) (o1.getWeight() - o2.getWeight())));

        //wypisanie listy po sortowaniu
        System.out.println(animalList);
    }
}
