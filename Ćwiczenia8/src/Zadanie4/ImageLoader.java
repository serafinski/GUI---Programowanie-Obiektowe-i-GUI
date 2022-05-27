package Zadanie4;

import java.awt.MediaTracker;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.ImageIcon;

public class ImageLoader implements Runnable {

    static public ImageIcon POISON_PILL = new ImageIcon();
    static public ImageIcon FILE_ERROR_POISON_PILL = new ImageIcon();
    public ImageIcon currentPicture =null;
    LinkedBlockingQueue<ImageIcon> pictureQueue = new LinkedBlockingQueue<>(3);
    File[] files;
    Thread clearGarbageCollector;
    public boolean close = false;

    public ImageLoader(File files[]) {
        this.files =files;
        clearGarbageCollector = new Thread(()->{
            while(!Thread.interrupted()){
                System.gc();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return ;
                }
            }
        });
    }

    public ImageIcon getNextImage() throws InterruptedException{
        return pictureQueue.take();
    }

    @Override
    public void run() {

        clearGarbageCollector.start();
        try {

            if(files.length==0)
                pictureQueue.put(FILE_ERROR_POISON_PILL);

            for(File p : files){
                ImageIcon picture = new ImageIcon(p.getPath());
                if(picture.getImageLoadStatus() == MediaTracker.COMPLETE)
                    pictureQueue.put(picture);
                else
                    pictureQueue.put(FILE_ERROR_POISON_PILL);
            }

            pictureQueue.put(POISON_PILL);


        }catch (InterruptedException e) {
            clearGarbageCollector.interrupt();
            return ;
        }

        clearGarbageCollector.interrupt();
    }

}