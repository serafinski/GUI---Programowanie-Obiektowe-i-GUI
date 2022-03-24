package Zadanie6;

public class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    //nadpisujemy metodę toString() by nie wyświetlało nam adresów a imię i nazwisko!
    @Override
    public String toString(){
        return imie + " " + nazwisko;
    }
}
