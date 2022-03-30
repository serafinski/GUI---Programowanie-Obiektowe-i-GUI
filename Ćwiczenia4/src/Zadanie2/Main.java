package Zadanie2;

import java.util.Arrays;
import java.util.List;

//nowy pakiet -> odnosi się do strumieni!
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //używamy Array.asList -> od razu możemy podać listę elementów wy specyfikowaną przez generyk
        List<Animal> animalList = Arrays.asList(
                new Animal("Giraffe",790,3,30),
                new Animal("Lion",250,3,50),
                new Animal("Dog",10,1,15)
        );

        System.out.println("Option1\n");

        //for each + if -> pierwsze rozwiązanie zadane w poleceniu
        for (Animal animal : animalList) {
            if(animal.getWeight()>100 && animal.getTopSpeed() < 35)
                System.out.println(animal.getName());;
        }

        System.out.println("\nOption2\n");

        //zamienienie listy na strumień

        //metoda .stream() - na liście -> przedstawione inne podejście niż w przykładzie!!!
        animalList.stream()
                //metoda .filter() - na strumieniu
                .filter(animal -> animal.getWeight() > 100)
                .filter(animal -> animal.getTopSpeed()<35)
                //metoda map() -> na strumieniu
                .map(animal -> animal.getName()) //.map(Animal::getName)
                //metoda forEach() -> na strumieniu
                .forEach(s -> System.out.println(s)); //.forEach(System.out::println);
    }
}
