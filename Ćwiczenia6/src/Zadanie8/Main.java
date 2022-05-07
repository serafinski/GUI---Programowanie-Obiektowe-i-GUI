package Zadanie8;

public class Main {
    public static void main(String[] args) {
        ShapesWindow window = new ShapesWindow();

        //dodanie 20 figur do listy -> zgodnie z poleceniem
        for (int i=0; i < 20; i++){
            if (i<10){
                window.addShape(new Kolo());
            }
            else if(i<15){
                window.addShape(new Prostokat());
            }
            else
                window.addShape(new Trojkat());
        }
    }
}
