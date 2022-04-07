package Zadanie2.thread_err;

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
                //err.print !!!
                System.err.print(i);
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
        // 1) 945 ms
        // 2) 825 ms
        // 3) 1034 ms

        // Średnia: około 935 ms

        //MAC

        // 1) 1072 ms
        // 2) 1256 ms
        // 3) 1073 ms

        // Średnia: około 1134 ms
    }
}
