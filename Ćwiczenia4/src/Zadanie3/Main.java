package Zadanie3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//nowy pakiet -> odnosi się do strumieni!


public class Main {
    public static void main(String[] args) {

        //używamy Array.asList -> od razu możemy podać listę elementów wy specyfikowaną przez generyk
        List<Animal> animalList = Arrays.asList(
                new Animal("Giraffe",790,3,30),
                new Animal("Lion",250,3,50),
                new Animal("Dog",10,1,15)
        );

        //Podchodząc do tego w taki sposób, zyskujemy to, że jeżeli wykorzystujemy dany filtr wielokrotnie -> to musimy go tylko raz zmodyfikować — w jednym miejscu!
        //Dzięki temu nie musimy robić wszędzie "chamskiego" CTRL+C -> CTRL+V - wklejając to samo wyrażenie lambda X razy.
        Predicate<Animal> f1 = animal -> animal.getWeight() > 100;
        Predicate<Animal> f2 = animal -> animal.getTopSpeed() < 35;

        //zamienienie listy na strumień

        //metoda .stream() - na liście -> przedstawione inne podejście niż w przykładzie!!!
        animalList.stream()
                //Użycie filtrów z Predicate
                .filter(f1)
                .filter(f2)
                //metoda map() -> na strumieniu
                .map(animal -> animal.getName()) //.map(Animal::getName)
                //metoda forEach() -> na strumieniu
                .forEach(s -> System.out.println(s)); //.forEach(System.out::println);
    }
}
