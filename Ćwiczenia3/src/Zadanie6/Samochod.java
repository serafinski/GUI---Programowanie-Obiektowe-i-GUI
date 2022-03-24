package Zadanie6;

public class Samochod {
    private String marka;
    private String rejestracja;

    public Samochod(String rejestracja,String marka) {
        this.marka = marka;
        this.rejestracja = rejestracja;
    }

    public String getRejestracja() {
        return rejestracja;
    }

    //nadpisujemy by nie zwracało nam adresów a markę i rejestracje
    @Override
    public String toString(){
        return marka + " " + rejestracja;
    }
}
