package Zadanie2.Opcja1;

import javax.swing.*;
import java.awt.*;

//dziedziczy po JFrame i jednocześnie implementuje Runnable
public class MyWindow extends JFrame implements Runnable {
    //pozycja startowa x
    private int x = 100;

    //zmienna mówiąca o tym, czy dodawać do x, czy nie — na start chcemy dodawać więc true
    private boolean useAddX = true;

    //pozycja startowa y
    private int y = 250;

    //zmienna mówiąca o tym, czy dodawać do y, czy nie — na start chcemy dodawać więc true
    private boolean useAddY = true;

    //szerokość i długość kwadratu
    private int width = 30;
    private int height = width;

    //bazowy kolor, od którego będzie zaczynał kwadrat
    private Color color = new Color(255,0,0);

    public MyWindow(){
        //ustawiamy wielkość
        this.setSize(1024,768);
        //ustawiamy tytuł
        this.setTitle("Zadanie 2 - SwingTimerANDThread");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //stworzenie wątku
        Thread thread =  new Thread(this);

        //uruchomienie wątku
        thread.start();

        //ustawiamy widoczność okna
        setVisible(true);
    }
    public void paint(Graphics g){
        //ustawiłem clearRect — bo metoda z super nie nadąża z odświeżaniem przy mniejszej ilości ms
        g.clearRect(0,0,getWidth(), getHeight());
        //ustawiamy kolor kwadratu na bazowy zadeklarowany wyżej
        g.setColor(color);
        //zaczynamy z zadeklarowanej pozycji, mając ustaloną wielkość i wysokość kwadratu
        g.fillRect(x,y,width,height);
    }

    //metoda pozwalająca na losową zmianę koloru
    public void changeColor(){
        //wartości dla rgb
        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);

        //ustawienie nowego koloru
        color = new Color(r,g,b);
    }

    //ponieważ implementuje Runnable — trzeba nadpisać metodę run
    //tutaj kod pozwalający na odbijanie się kwadratu od boków okienka
    @Override
    public void run() {
        while (true){

            //jeżeli jest true na useAddX (a jest bazowo — bo od takiego stanu zaczynamy)
            if(this.useAddX)
                //dodaj do x+1
                this.x++;
            //w przeciwnym wypadku
            else
                //odejmij od x-1
                this.x--;

            //jeżeli jest true na useAddY (a jest bazowo — bo od takiego stanu zaczynamy)
            if(this.useAddY)
                //dodaj do y+1
                this.y++;
            //w przeciwnym wypadku
            else
                //odejmij od y-1
                this.y--;

            //jeżeli x dojdzie do maksymalnego rozmiaru (czyli de facto będzie przy prawym boku)
            if (this.getWidth() - width < x){
                //przestań dodawać do x
                this.useAddX = false;
                //zmień kolor kwadratu
                changeColor();
            }

            //jeżeli y dojdzie do maksymalnego rozmiaru (czyli de facto będzie przy dolnym boku)
            if(this.getHeight() - height < y){
                //przestań dodawać do y
                this.useAddY = false;
                //zmień kolor kwadratu
                changeColor();
            }

            //jeżeli x dojdzie do 0 (czyli de facto będzie przy lewym boku)
            if(x < 0){
                //zacznij dodawać do x+1
                this.useAddX = true;
                //zmień kolor kwadratu
                changeColor();
            }

            //jeżeli y dojdzie do 0 (czyli de facto będzie przy górnym boku)
            if(y<0){
                //zacznij dodawać do y+1
                this.useAddY = true;
                //zmień kolor kwadratu
                changeColor();
            }

            //wykonuj podaną sekwencje...
            try{
                //...co 10 ms
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}