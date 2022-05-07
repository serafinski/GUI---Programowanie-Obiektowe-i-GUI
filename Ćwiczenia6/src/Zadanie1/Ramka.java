package Zadanie1;

//bez zaimportowania swing nie będzie JFrame (to się doda z reguły samo)
import javax.swing.*;

//zgodnie z zadaniem dziedziczy po JFrame
public class Ramka extends JFrame {

    // konstruktor Ramka
    public Ramka(){
        //stały rozmiar
        this.setSize(1024,768);
        //stały tytuł
        this.setTitle("Zadanie 1");
        //true by pojawiło się nam okienko — jak damy false to program się odpali, ale bez okna!
        this.setVisible(true);
    }
}
