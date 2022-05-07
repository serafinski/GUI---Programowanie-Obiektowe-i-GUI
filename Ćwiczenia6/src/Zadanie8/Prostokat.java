package Zadanie8;

import java.awt.*;

//extends Shape -> by można było losować parametry
public class Prostokat extends Shape {
    //ustalenie pól
    int x;
    int y;
    int height;
    int width;
    Color color;

    //konstruktor
    Prostokat(){
        this.x = this.getRandomParameter();
        this.y= this.getRandomParameter();
        this.height = getRandomParameter();
        this.width = getRandomParameter();
        this.color = getRandomColor();
    }

    //przesłonięcie metody render (z klasy abstrakcyjnej Shape)
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
