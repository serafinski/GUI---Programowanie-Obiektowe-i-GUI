package Zadanie1;

//NOWE PAKIETY!
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //nowe rzeczy — używamy pakietu List oraz ArrayList

        //tworzymy nową listę na obiekty klasy square
        List<Square> squareList = new ArrayList<>();

        for(int i=0; i<5;i++){
            //dodajemy losowe kwadraty do obiektu squareList za pomocą metody add z pakietu List
            squareList.add(new Square((int)(Math.random() *100 +10)));
        }

        //wypisz tablice przed posortowaniem
        System.out.println(squareList);

        // kolejny nowy pakiet — Collections -> użyjemy metody .sort do sortowania tablicy
        Collections.sort(squareList);

        //wypisz posortowaną tablice
        System.out.println(squareList);
    }
}
