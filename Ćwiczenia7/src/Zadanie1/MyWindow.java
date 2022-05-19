package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    //deklaracja MyThread, by użyć go potem w konstruktorze MyWindow
    MyThread myThread;

    public MyWindow(){
        //ustawiamy wielkość
        this.setSize(1024,768);
        //ustawiamy tytuł
        this.setTitle("Zadanie 1");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //tworzymy nowy wątek
        myThread = new MyThread();
        //startujemy nowy wątek
        this.myThread.start();

        //ustawiamy widoczność okna
        setVisible(true);
    }
    public void paint(Graphics g){
        //ustawiłem clearRect — bo metoda z super nie nadąża z odświeżaniem przy mniejszej ilości ms
        g.clearRect(0,0,getWidth(), getHeight());
        //ustawiamy kolor kwadratu
        g.setColor(new Color(255,0,0));

        //ustalamy wymiary i pozycje (pozycja jest na bieżąco brana z myThread)

        //jako że zaczynamy z 0,0 i idziemy po przekątnej — to za x, jak i y podstawiamy to samo
        g.fillRect(myThread.getX(), myThread.getX(), 30, 30);
    }
}
