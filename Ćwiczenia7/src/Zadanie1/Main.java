package Zadanie1;

public class Main {
    public static void main(String[] args) {
        //tworzymy okno
        MyWindow myWindow = new MyWindow();

        //do momentu aż się da (ale zawsze się da — bo mamy nieskończony loop)
        while (true){
            try{
                //co podaną liczbę ms...
                Thread.sleep(3);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            //...namaluj ponownie kwadracik
            myWindow.repaint();
        }
    }
}
