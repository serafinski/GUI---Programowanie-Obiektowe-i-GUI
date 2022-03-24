package Zadanie7;

import java.util.ArrayList;
import java.util.List;

//ta klasa ma pozwolić na przechowywanie zwierząt w klatkach

//Parametryzacja T na AAnimal -> klatka, która może przechowywać zwierzęta.
//Parametryzacja w tym wypadku jest ważna -> bo pozwala uniknąć możliwości dodania pracownika do klatki za pomocą metody addAnimalToEnclosure
public class Enclosure<T extends AAnimal>{

    //tworzenie listy dowolnego typu
    private List<T> enclosure = new ArrayList<>();

    //dodawanie elementu do listy
    public void addAnimalToEnclosure(T animal){
        enclosure.add(animal);
    }

    //zwierzęta przechowywane w danej klatce -> będą przechowywane na liście

    // zwracanie listy -> to pozwala na dodanie również pracownika do klatki! -> BO NIE JEST ZPARAMETRYZOWANA!
    public List<T> getEnclosure(){
        return enclosure;
    }
}
