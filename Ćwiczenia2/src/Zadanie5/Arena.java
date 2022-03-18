package Zadanie5;

public class Arena {
    private IGamer gracz1;
    private IGamer gracz2;

    private double wynikGracz1;
    private double wynikGracz2;

    //getery do wyników
    public double getWynikGracz1() {
        return wynikGracz1;
    }

    public double getWynikGracz2() {
        return wynikGracz2;
    }

    //konstruktor dla Arena
    public Arena(IGamer gracz1, IGamer gracz2) {
        this.gracz1 = gracz1;
        this.gracz2 = gracz2;
    }

    //tak jak interface Comparable
    private int wynikWalki(int ruchGracz1, int ruchGracz2){

        //jak wyrzucą to samo
        if((ruchGracz1-ruchGracz2) == 0)
            //to remis
            return 0;

        //jak wygra
        else if((ruchGracz1 == 1 && ruchGracz2 == 3) || (ruchGracz1 == 2 && ruchGracz2 == 1) || (ruchGracz1 ==3 && ruchGracz2 ==2))
            //to zwycięstwo
            return 1;
        else
            //jak nie remis i zwycięstwo -> to przegrana
            return -1;
    }

    //sama walka -> w podanej liczbie rund
    public void fight(int liczbarund){
        for(int i=0; i<liczbarund; i++){
            // na podstawie powyższej metody wynikWalki
            switch (wynikWalki(gracz1.play(), gracz2.play())){
                //jak wygra gracz 1
                case (1):
                    wynikGracz1++;
                    break;

                //jak wygra gracz 2
                case (2):
                    wynikGracz2++;
                    break;

                //jak będzie remis
                default:
                    wynikGracz1 += 0.5;
                    wynikGracz2 =+ 0.5;
            }
        }
    }
}
