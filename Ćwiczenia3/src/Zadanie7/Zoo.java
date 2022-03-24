package Zadanie7;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    //lista na klatki -> CO WAŻNE NIE JEST ZPARAMETRYZOWANA — przechowuje po prostu liczbę klatek -> spowoduje to dalej nieścisłości — bo powstaje raw typing!
    //jest to lista klatek, która będzie przechowywała po prostu jakieś zwierzęta
    private List<Enclosure> enclosureList = new ArrayList<>();

    //lista na pracowników
    private List<Worker> workerList = new ArrayList<>();

    //zwraca listę klatek
    public List<Enclosure> getEnclosureList() {
        return enclosureList;
    }

    //zwraca listę pracowników
    public List<Worker> getWorkerList() {
        return workerList;
    }

    //dodajemy klatkę do listy klatek
    public void addEnclosure(Enclosure enclosure){
        this.enclosureList.add(enclosure);
    }

    //dla każdej klatki wypisujemy wystąpienie każdego zwierzęcia w nim
    public void showAllAnimals(){
        for(Enclosure wystapienie : enclosureList){
            for(Object zwierze : wystapienie.getEnclosure()){
                System.out.println(zwierze);
            }
        }
    }

    //wypisujemy każdego pracownika na liście pracowników
    public void showAllWorkers(){
        for (Worker worker: this.workerList){
            System.out.println(worker);
        }
    }
}
