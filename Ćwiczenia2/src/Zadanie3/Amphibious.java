package Zadanie3;

public class Amphibious implements IAuto, IBoat{

    //zmienna sprawdzająca, czy jest w wodzie, czy nie
    private boolean inWater = false;

    //ustawia czy jest w wodzie, czy nie
    public void setInWater(boolean inWater){
        this.inWater = inWater;
    }

    //trzeba zająć się implementacją, bo może być zarówno w wodzie, jak i na lądzie
    @Override
    public void move() {

        //jeżeli jest w wodzie
        if(this.inWater)
            //to metoda move z IBoat
            IBoat.super.move();
        //jak nie jest w wodzie
        else
            //to metoda move z IAuto
            IAuto.super.move();
    }
}
