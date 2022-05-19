package Zadanie2.Opcja3_Bonusowa;

public class Main {
    public static void main(String[] args) {
        //tworzymy okno
        MyWindow myWindow = new MyWindow();

        //do momentu aż się da (ale zawsze się da — bo mamy nieskończony loop) - ŚREDNI POMYSŁ!
        while (true){
            try{
                //co podaną liczbę ms...
                Thread.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            //...namaluj ponownie kwadracik
            myWindow.repaint();
        }
    }
}
