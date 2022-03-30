package Zadanie4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//nowy pakiet -> odnosi się do strumieni!


public class Main {
    public static void main(String[] args) {

        //używamy Array.asList -> od razu możemy podać listę elementów wy specyfikowaną przez generyk
        List<Animal> animalList = Arrays.asList(
                new Animal("Giraffe",790,3,30),
                new Animal("Lion",250,3,50),
                new Animal("Dog",10,1,15)
        );

        //INPUT UŻYTKOWNIKA

        //klasycznie Scanner z parametrem System.in
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj minimalny wzrost w cm: ");
        double wzrost = scanner.nextDouble();
        System.out.print("\nPodaj maksymalna prędkosc osiągalna przez zwierze: ");
        double predkosc = scanner.nextDouble();

        //zamienienie listy na strumień

        //metoda .stream() - na liście -> przedstawione inne podejście niż w przykładzie!!!
        animalList.stream()
                //metoda .filter() - na strumieniu

                //zamieniamy ustalone widełki na input od użytkownika!
                .filter(animal -> animal.getWeight() > wzrost)
                .filter(animal -> animal.getTopSpeed()<predkosc)
                //metoda map() -> na strumieniu
                .map(animal -> animal.getName()) //.map(Animal::getName)
                //metoda forEach() -> na strumieniu
                .forEach(s -> System.out.println("\n"+s)); //.forEach(System.out::println);
    }
}
