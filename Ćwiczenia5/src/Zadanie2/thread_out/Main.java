package Zadanie2.thread_out;

public class Main {
    public static void main(String[] args) {
        //wątek za pomocą wyrażenia lambda
        Thread thread1 = new Thread(() -> {
            //pętla zgodnie z założeniem
            for(int i=0;i<=1000000;i+=2){
                //out.print
                System.out.print(i);
            }
        });
        //wątek za pomocą wyrażenia lambda
        Thread thread2 = new Thread(() -> {
            //pętla zgodnie z założeniem
            for(int i=1; i<=1000000;i+=2){
                //out.print
                System.out.print(i);
            }
        });
        //początek pomiaru
        long start = System.currentTimeMillis();

        //odpalenie wątków
        thread1.start();
        thread2.start();

        //nie przechodź dalej, póki wątki się nie skończą
        while (thread1.isAlive() || thread2.isAlive());

        //koniec pomiaru
        long end = System.currentTimeMillis();

        //wypisz pomiar
        System.out.println("\nCzas to: " + (end-start)+ "ms");

        //WINDOWS

        //POMIARY
        // 1) 2122 ms
        // 2) 2049 ms
        // 3) 3166 ms

        // Średnia: około 2446 ms

        //MAC

        // 1) 1822 ms
        // 2) 1726 ms
        // 3) 1824 ms

        // Średnia: około 1790 ms
    }
}
