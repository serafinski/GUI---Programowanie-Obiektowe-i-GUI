package Zadanie2.Opcja2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//dziedziczy po JFrame i jednocześnie implementuje ActionListener
public class MyWindow extends JFrame implements ActionListener {
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

    //deklaracja timera
    Timer timer;

    //bazowy kolor, od którego będzie zaczynał kwadrat
    private Color color = new Color(255,0,0);

    public MyWindow(){
        //ustawiamy wielkość
        this.setSize(1024,768);
        //ustawiamy tytuł
        this.setTitle("Zadanie 2 - SwingTimer");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ustawiamy widoczność okna
        setVisible(true);

        //TO NIE CHCE ZADZIAŁAĆ BEZ LINIJEK PONIŻEJ — powstaje kwadrat, ale nie jest odświeżany, jeśli nie ruszamy oknem

        //ustawienie timera i podanie obiektu implementującego ActionListener
        //timer = new Timer(5,this::actionPerformed);
        //uruchomienie timer'a (bo jest w wątku dlatego .start())
        //timer.start();

        //implementacja timera w 1 linijce -> bo ActionListener jest interfejsem funkcyjnym (ma tylko 1 metodę!)
        //timer będzie co 5ms wyrysowywać ponownie okienko i od razu wystartuje ten wątek
        new Timer(5,(ActionListener) -> {this.repaint();}).start();
        //bez poniższej linijki nie zadziała — kwadrat będzie stał w miejscu
        (new Timer(5,this)).start();
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

    //ponieważ implementuje ActionListener — trzeba nadpisać metodę actionPerformed
    //tutaj kod pozwalający na odbijanie się kwadratu od boków okienka
    @Override
    public void actionPerformed(ActionEvent e) {
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
    }
}