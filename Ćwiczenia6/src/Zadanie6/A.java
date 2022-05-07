package Zadanie6;

import javax.swing.*;
import java.awt.*;

public class A extends JFrame {

    //konstruktor
    A(){
        //stały rozmiar
        this.setSize(1024,768);
        //stały tytuł
        this.setTitle("Zadanie 6");
        //true by pojawiło się nam okienko — jak damy false to program się odpali, ale bez okna!
        this.setVisible(true);
        //dodanie tej linijki pozwala na zakończenie programu po zamknięciu okienka!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //funkcja służąca rysowaniu
    public void paint(Graphics g){
        //ROZWIĄZANIE PROBLEMU NR 1 -> średnie pod kątem dynamicznego odświeżania! (przy przesuwaniu znika i pojawia się po puszczeniu okna)

        //wywołanie metody paint z klasy nadrzędnej -> przed rysowaniem okręgu!
        //super.paint(g);

        //ROZWIĄZANIE PROBLEMU NR 2 -> umożliwia dynamiczne odświeżanie

        //użycie metody clearRect na obiekcie klasy Graphics
        g.clearRect(0,0,getWidth(),getHeight());

        // Ustawiamy kolor pisaka RGB
        g.setColor(new Color(0, 0, 255));

        int width = 100;
        int height = 100;

        //jak damy samo this.getWidth i samo this.getHeight -> to nic nam sie nie wyświetli

        //jak damy this.getWidth-width oraz this.getHeight-height -> to dostaniemy figure w dolnym rogu okienka

        //dzieląc powyższą instrukcję na 2 -> dostaniemy wyśrodkowaną figurę
        g.drawOval((this.getWidth()-width)/2,(this.getHeight()-height)/2,width, height);
    }

}
