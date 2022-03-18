package Zadanie5;

import java.util.Random;

public class GamerRandom implements IGamer{
    @Override
    public int play() {
        //nowy pakiet -> Random — bo ma grać losowo
        Random r = new Random();

        //dodajemy 1 na końcu, bo nie może być 0 - bo żadna klasa tego nie zagrywa

        //nie do końca rozumiem czemu jest -> (3-1)+1
        return r.nextInt((3-1)+1)+1;
    }
}
