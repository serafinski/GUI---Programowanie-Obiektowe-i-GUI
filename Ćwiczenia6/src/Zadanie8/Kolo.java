package Zadanie8;

import java.awt.*;

//extends Shape -> by można było losować parametry
public class Kolo extends Shape {
    //ustalenie pól
    int x;
    int y;
    int radius;
    Color color;

    //konstruktor
    Kolo(){
        this.x = this.getRandomParameter();
        this.y = this.getRandomParameter();
        this.radius = this.getRandomParameter();
        this.color = this.getRandomColor();
    }

    //przesłonięcie metody render (z klasy abstrakcyjnej Shape)
    @Override
    public void render(Graphics g) {
        //kolor będzie losowy
        g.setColor(this.getRandomColor());
        //wypełnienie będzie losowe -> natomiast nie zmieni się wielkość konkretnego koła (bo radius bez zmian)
        //co za tym idzie — resize okna -> nowa pozycja dla koła o nowym kolorze
        g.fillOval(this.getRandomParameter(), this.getRandomParameter(), radius, radius);

        /*
        g.setColor(color);
        g.fillOval(x,y,radius,radius);
         */
    }
}
