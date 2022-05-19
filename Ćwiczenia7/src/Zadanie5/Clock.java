package Zadanie5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//implementuje Runnable
public class Clock implements Runnable{

    //zmienna przechowująca lokalny czas
    private LocalDateTime time;

    //String przechowujący format czasu — to nam posłuży do sformatowania czasu
    private String timeFormat;

    //konstruktor zegara
    public Clock(){
        //aktualny czas
        time = LocalDateTime.now();
        //format, jaki jest ustawiony jak uruchomimy program
        timeFormat = "hh:mm:ss";
    }

    //funkcja zwracać zmieniony format czasu
    public String getTimeInFormat(){
        //deklaracja formatora czasu — format czasu jest ustawiany na podstawie wybranego szablonu/pattern'u
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timeFormat);
        //zwrócenie formatora czasu
        return dtf.format(time);
    }

    //funkcja odpowiedzialna za zmianę formatu
    public void switchFormat(){
        //jeżeli spełnia regex
        if(timeFormat.matches("^H.+"))
            //format 12-godzinny
            timeFormat = "hh:mm:ss";
        //w przeciwnym wypadku
        else
            //format 24-godzinny
            timeFormat = "HH:mm:ss";
    }


    //nadpisanie metody run bo implementujemy Runnable
    @Override
    public void run() {
        //w nieskończoność...
        while (true){
            try {
                //...co sekundę...
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //...odświeżaj czas
            time = LocalDateTime.now();
            //wypisuj czas na konsoli
            System.out.println(getTimeInFormat());
        }
    }
}
