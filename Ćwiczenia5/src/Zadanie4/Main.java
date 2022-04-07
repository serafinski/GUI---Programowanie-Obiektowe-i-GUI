package Zadanie4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        //bank ma mieć 2 konta -> w obu po 10 000 na start!
        bank.getPersonAccountHashMap().put(new Person("Tomasz","Serafiński",182),new Account(10000));
        bank.getPersonAccountHashMap().put(new Person("Jan","Kowalski",178),new Account(10000));

        //tworzymy wątek, w którym będzie wykonywana operacja
        Thread transakcja = new Thread(() -> {
            //pobranie liczby osób w banku
            int liczbaOsob = bank.getPersonAccountHashMap().keySet().size();

            //wybieramy 1 random'ową osobę z listy klientów banku
            int random1 = new Random().nextInt(liczbaOsob);
            Person os1 = (Person) bank.getPersonAccountHashMap().keySet().toArray()[random1];

            //wybieramy 2 random'ową osobę z listy klientów banku
            int random2;

            //NIE ROZUMIEM CO ROBI TU TEN WHILE...
            while ((random2 = new Random().nextInt(liczbaOsob)) == random1);

            Person os2 = (Person) bank.getPersonAccountHashMap().keySet().toArray()[random2];

            //próbujemy wykonać losową transakcję między osobami na random'ową kwotę do 5000
            try{
                bank.transakcja(os1, os2, new Random().nextInt(5000));

            }
            //jak się nie wykonać takiej transakcji — zwróć błąd
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        });

        //tworzymy listę wątków
        List<Thread> threads = new ArrayList<>();

        //tworzymy 8 wątków — zgodnie z poleceniem — one będą miały random'owe operacje
        for(int i=0;i<8;i++){
            threads.add(new Thread(transakcja));
        }

        //for loop na liście
        for (Thread t : threads){
            //startujemy wątki
            t.start();
        }

        //inicjujemy wartość, która sprawi, że będziemy czekać, aż wszystkie wątki się wykonają
        boolean czekaj;

        //wykonuj tak długo
        do{
            //pierwotnie inicjujemy jako false
            czekaj = false;

            //tak długo, jak wątki działają
            for(int i = 0; i < threads.size(); i++){
                if(threads.get(i).isAlive())
                    //czekaj ma być true
                    czekaj = true;
            }
        }
        //aż while jest równe true
        while (czekaj);

        //w banku na końcu powinno być i tak 20 000 zł — niezależnie od ilości operacji -> by tak było musi być zsynchronizowana metoda transakcja w klasie Bank

        //jak zwrócić Brak funduszy -> to była próba wykonania operacji, która była bez sensu
        System.out.println("\n Bank = " +bank.getSuma());
    }
}
