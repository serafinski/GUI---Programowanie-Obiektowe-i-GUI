package Zadanie1;

public class MyThread extends Thread{

    //pozycja x
    private int x;

    //definiuje czy dodawać do x -> jako że startujemy z pozycji x = 0 to chcemy zacząć od dodawania do niego
    private boolean useAddMethod = true;

    //metoda zwracająca pozycje x
    public int getX(){
        return x;
    }

    //dodawanie do x
    public void addToX(){
        //dodajemy 1 do x
        this.x++;
        //jeżeli x miałoby być większe od 500 - przestajemy dodawać
        if(x>500)
            useAddMethod = false;
    }

    //odejmowanie od X
    public void subToX(){
        //odejmujemy 1 od x
        this.x--;
        //jeżeli x miałoby być mniejsze od 0 - zaczynamy dodawać
        if(x<0)
            useAddMethod = true;
    }


    //przesłonięcie metody run!
    @Override
    public void run(){
        //do momentu aż się da (ale zawsze się da — bo mamy nieskończony loop)
        while (true){
            try{
                //co 10 ms
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //w zależności od pola useAddMethod — które zaczyna z wartością true
            if(useAddMethod)
                //dodajemy do x
                this.addToX();
            //w przeciwnym wypadki (czyli kiedy useAddMethod = false)
            else
                //odejmujemy od x
                this.subToX();

            //wypisujemy pozycje dla x (w terminalu)
            System.out.println(this.getX());
        }
    }
}
