package Zadanie4;


//de facto kopia klasy z poprzednich zajęć
public class Person {
    private String imie;
    private String nazwisko;
    private double wzrost;

    public Person(String imie, String nazwisko, double wzrost) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wzrost = wzrost;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getWzrost() {
        return wzrost;
    }

    public String toString(){
        return "Osoba{"+
                "imie=" + imie + ",nazwisko=" + nazwisko + ",wzrost=" + wzrost +
                "}";
    }
}
