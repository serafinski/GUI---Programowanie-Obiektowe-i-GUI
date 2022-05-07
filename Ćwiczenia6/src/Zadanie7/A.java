package Zadanie7;

import javax.swing.*;
import java.awt.*;

public class A extends JFrame {
    //pola zdefiniowanie zgodnie z poleceniem
    int x;
    int y;
    int radius;

    //konstruktor

    //w tym przypadku przyjmuje wartości dla okręgu, który ma być narysowany
    A(int x, int y, int radius){
        //stały rozmiar
        this.setSize(1024,768);
        //stały tytuł
        this.setTitle("Zadanie 6");
        //true by pojawiło się nam okienko — jak damy false to program się odpali, ale bez okna!
        this.setVisible(true);
        //dodanie tej linijki pozwala na zakończenie programu po zamknięciu okienka!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //typowo dla konstruktora
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //funkcja służąca rysowaniu
    public void paint(Graphics g){
        //o dziwo w tym przypadku lepiej działa super.paint, a nie drugi sposób!
        super.paint(g);

        // Ustawiamy kolor pisaka RGB
        g.setColor(new Color(0, 0, 255));

        //jeżeli podamy same współrzędne x i y -> to zrobi nam okrąg gdzieś poniżej środka

        //jeżeli damy x-radius i y-radius -> to zrobi nam gdzieś bliżej prawego boku
        g.drawOval(x-radius,y-radius,radius*2, radius*2);
    }

}
