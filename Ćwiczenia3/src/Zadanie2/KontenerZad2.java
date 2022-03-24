package Zadanie2;

//modyfikacja tak by Kontener posiadał kolejne pole typu generycznego
public class KontenerZad2<T,S>{
    //deklarujemy dwa pola zamiast 1
    private T t;
    private S s;

    //konstruktor inicjujący 2 pola
    public KontenerZad2(T t,S s){
        this.t = t;
        this.s = s;
    }

    //metoda wypisująca wartości pól
    void wypisz(){
        System.out.println("t= " + t + " s= " + s);
    }
}
