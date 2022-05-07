package Zadanie3;

import javax.swing.*;

//potrzebne, by użyć graphics! -> to się doda jak podamy klasę Graphics
import java.awt.*;

public class A extends JFrame {

    //konstruktor
    A(){
        //stały rozmiar
        this.setSize(1024,768);
        //stały tytuł
        this.setTitle("Zadanie 3");
        //true by pojawiło się nam okienko — jak damy false to program się odpali, ale bez okna!
        this.setVisible(true);
        //dodanie tej linijki pozwala na zakończenie programu po zamknięciu okienka!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //funkcja służąca rysowaniu
    public void paint(Graphics g){
        // Ustawiamy kolor pisaka RGB
        g.setColor(new Color(0, 0, 255));
        // W punkcie (512 , 512) rysujemy elipsę o wymiarach 40 x 40
        // Uwaga: punkt (0,0) znajduje się w górnym, lewym punkcie okna g.drawOval(512, 512, 40, 40)
        g.drawOval(512, 512,40, 40);

        //Biorąc pod uwagę, że wartości są ustawione "na sztywno" -> koło nie będzie się przemieszczać wraz ze zmianą wielkości okna.
        //Co za tym idzie — nie będzie bugów -> które będą występować w zadaniu 4/5
    }

}
