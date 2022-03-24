package Zadanie1;

//Kontener<T> -> bo ma przyjmować typ generyczny
public class Kontener<T>{
    //deklarujemy pole podanego typu
    private T t;

    //konstruktor inicjujący pole
    public Kontener(T t){
        this.t = t;
    }

    //metoda wypisująca wartość pola
    void wypisz(){
        System.out.println(t);
    }
}
