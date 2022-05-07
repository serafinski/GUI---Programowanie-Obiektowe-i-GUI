package Zadanie8;

import java.awt.*;

//klasa musi być abstrakcyjna, by zapewnić implementacje dla wszystkich kształtów!

//implementacja Renderable -> będzie renderować wszystkie elementy
public abstract class Shape implements Renderable {
    //losowy parametr (używamy tego dla x i y)
    public int getRandomParameter(){
        //losujemy dowolny zakres od 0 do 500 powiększony o 50
        return (int)((Math.random() * 500)+50);
    }

    //ustalenie losowych wartości dla R (red), G (green) oraz B (blue) -> dostaniemy losowy kolor
    public Color getRandomColor(){
        int r = (int)(Math.random()* 255);
        int g = (int)(Math.random()* 255);
        int b = (int)(Math.random()* 255);
        return new Color(r,g,b);
    }
}
