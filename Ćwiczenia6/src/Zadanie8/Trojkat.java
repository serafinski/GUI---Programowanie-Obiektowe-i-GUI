package Zadanie8;

import java.awt.*;
import java.util.ArrayList;

//extends Shape -> by można było losować parametry
public class Trojkat extends Shape {

    //tworzenie listy punktów
    private ArrayList<Point> pointList = new ArrayList<>();

    //ustalenie pól
    private Color color;


    private class Point{
        //ustalenie pól
        private int x;
        private int y;

        //konstruktor
        public Point(int x, int y){
            this.x = x;
            this.y=y;
        }
    }

    //lista x
    public int [] getXList(){
        int[] result = new int [this.pointList.size()];

        for (int i = 0; i < this.pointList.size(); i++){
            result [i] = this.pointList.get(i).x;
        }
        return result;
    }

    //lista y
    public int [] getYList(){
        int [] result = new int[this.pointList.size()];

        for (int i = 0; i < this.pointList.size(); i++){
            result [i] = this.pointList.get(i).y;
        }
        return result;
    }

    //konstruktor
    Trojkat(){
        //losowy kolor trójkąta
        this.color = this.getRandomColor();

        //dodanie 3 współrzędnych x,y -> jako że przekazujemy 3 punkty to powstanie nam trójkąt
        pointList.add(new Point(this.getRandomParameter(), this.getRandomParameter()));
        pointList.add(new Point(this.getRandomParameter(), this.getRandomParameter()));
        pointList.add(new Point(this.getRandomParameter(), this.getRandomParameter()));
    }

    //przesłonienie metody render (z klasy abstrakcyjnej Shape)
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillPolygon(this.getXList(),this.getYList(),this.pointList.size());
    }
}
