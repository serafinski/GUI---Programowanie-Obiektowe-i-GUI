package Zadanie4;

public abstract class Spiewak {
    //układ pól podobny do tego z ZAD 1
    private String nazwisko;
    private int numer;
    private static int counter;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        //tak jak w ZAD1
        numer = counter++;
    }

    //ponieważ metoda jest abstrakt — nie posiada ciała -> należy je przesłonić
    public abstract String spiewaj();

    //ustawione tak by zgadzało się ze wzorcem podanym w zadaniu
    public String toString(){
        return "id="+numer+", name="+nazwisko;
    }

    //funkcja zwracająca ile dużych liter jest w zdaniu
    private int liczDuzeLitery(){
        //default'owa wartość
        int counter = 0;

        //długość pętli taka jak tego, co ma śpiewać
        for(int i=0; i< this.spiewaj().length(); i++){
            //jeżeli znak jest duży — tam gdzie jest i
            if(Character.isUpperCase(this.spiewaj().charAt(i)))
                //zwiększ counter
                counter++;
        }
        //zwróć na koniec counter
        return counter;
    }

    // sprawdzamy w tablicy śpiewaków — który ma najwięcej dużych liter w swoim tekście
    static Spiewak najgłosniej(Spiewak[] spiewakArray){
        //default'owa wartość
        Spiewak max = spiewakArray[0];

        //idziemy po tablicy
        for(int i=1; i< spiewakArray.length; i++){
            //metodą liczDużeLitery sprawdzamy -> ile jest dużych liter w tekście śpiewaka pod index i

            //jeżeli jest ich więcej niż w aktualnie ustalonym max
            if(spiewakArray[i].liczDuzeLitery()> max.liczDuzeLitery()){
                //nadpisz max by był nowym największym
                max = spiewakArray[i];
            }
        }
        //musimy zwrócić int -> index tego, który ma najwięcej dużych liter
        return max;
    }

}
