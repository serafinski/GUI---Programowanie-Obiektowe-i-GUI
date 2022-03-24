package Zadanie5;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;

public class Rozwiazanie_Cwiczeniowca {
    public static void main(String[] args) {
        //pierwsza zmienna jest kluczem, druga wartością
        HashMap<String, Integer> hashMap = new HashMap<>();

        //LocalDate -> wypisuje bieżący miesiąc
        //TekstStyle -> wypisuje całą nazwę miesiąca w sposób sformatowany (nie capslock), bo został użyty parametr FULL
        //Locale -> wypisuje nazwę miesiąca w języku angielskim

        System.out.println(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        for (int i = 1; i <=12 ; i++) {
            //obiekt LocalDate -> LocalDate.of -> pozwala wpisać rok, miesiąc -> w tym przypadku i, oraz dzień
            LocalDate localDate = LocalDate.of(LocalDate.now().getYear(), i, 1);
            //wpisuje do HashMapy klucz — czyli miesiąc i ilość dni (maksymalną ilość dni w tym miesiącu) - czyli wartość
            hashMap.put(localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH), localDate.getMonth().maxLength());
        }

        //wypisuje HashMapę
        System.out.println(hashMap);
        //wypisuje ile dni jest dla Marca
        System.out.println(hashMap.get("March"));

    }
}
