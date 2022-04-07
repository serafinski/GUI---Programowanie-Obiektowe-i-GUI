package Zadanie1;

public class Main {
    public static void main(String[] args) {

        //tworzymy nowy wątek za pomocą lambda wyrażenia
        Thread thread1 = new Thread(() -> {
            //wykonanie pętli 20x - zgodnie z poleceniem
            for(int j =0; j<=20;j++) {
                //liczby od 0 do 9 - zgodnie z poleceniem
                for (int i = 0; i <= 9; i++) {
                    //wypisane za pomocą out.print
                    System.out.print(i);
                }
            }
        });

        //tworzymy nowy wątek za pomocą lambda wyrażenia
        Thread thread2 = new Thread(() -> {
            //wykonanie pętli 20x - zgodnie z poleceniem
            for(int j=0; j<=20;j++) {
                //liczby od 0 do 9 - zgodnie z poleceniem
                for (int i = 0; i <= 9; i++) {
                    //wypisane za pomocą err.print
                    System.err.print(i);
                }
            }
        });

        //wystartowanie wątku
        thread1.start();
        thread2.start();
    }
}
