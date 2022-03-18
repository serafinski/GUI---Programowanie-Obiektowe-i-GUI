package Zadanie5;

//jako następny ruch zagrywa to, co by go pokonało w poprzedniej rundzie

//Czyli np. jak najpierw zagra papierem to potem zagra nożycami
public class GamerZ implements IGamer{

    //default'owa wartość
    private int lastPlayedAgainst = 1;

    @Override
    public int play() {
        //switch w zależności od tego, co było ostatnie
        switch (lastPlayedAgainst){
            case (1):
                lastPlayedAgainst = 2;
                return 2;
            case (2):
                lastPlayedAgainst = 3;
                return 3;
            default:
                lastPlayedAgainst = 1;
                return  1;
        }
    }
}
