package Zadanie4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


public class Main {

    public static void main(String[] args) {
        String dirPath = choseFile();
        int screenTimeInSeconds = 5;
        int fontSize = 200;

        File pictures[] = new File(dirPath).listFiles( (File pathname)-> {
            if(pathname.isFile()){
                if(pathname.getName().endsWith(".png") || pathname.getName().endsWith(".gif") || pathname.getName().endsWith(".jpg"))
                    return true;
                else
                    return false;
            }else
                return false;
        });

        JFrame window = new JFrame();

        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageLoader il = new ImageLoader(pictures);
        Thread loader = new Thread(il);
        loader.start();

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loader.interrupt();
                System.out.println();
                il.close=true;
            }
        });

        JPanel panel = new JPanel(){
            private static final long serialVersionUID = -3925801683629764730L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Serif", Font.BOLD, fontSize));
                if(il.currentPicture != ImageLoader.POISON_PILL){
                    if(il.currentPicture != ImageLoader.FILE_ERROR_POISON_PILL)
                        g.drawImage(il.currentPicture.getImage(),0,0,getWidth(),getHeight(),this);
                    else		//tekst wyśrodkowany względem baseline
                        g.drawString("No picture", getWidth()/2-g.getFontMetrics().stringWidth("No picture")/2, this.getHeight()/2);
                }else
                    g.drawString("End of slideshow", getWidth()/2-g.getFontMetrics().stringWidth("End of slideshow")/2, this.getHeight()/2 );
            }
        };

        window.getContentPane().add(panel);
        int width = 2000;
        int height = 500;

        while(!il.close){
            try {
                il.currentPicture = il.getNextImage();

                if(il.currentPicture != ImageLoader.POISON_PILL){
                    if(il.currentPicture != ImageLoader.FILE_ERROR_POISON_PILL){
                        width = il.currentPicture.getIconWidth();
                        height = il.currentPicture.getIconHeight();
                        int width_screen = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                        int height_screen = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                        // Rescalowanie po proporcjach obrazu w stosunku do rozdzielczości ekranu
                        if(width+window.getInsets().left+window.getInsets().right>width_screen){
                            double proporcja = (double)width_screen/width;
                            width = width_screen-window.getInsets().left-window.getInsets().right;
                            height = (int)(height*proporcja);
                        }

                        if(height+window.getInsets().bottom+window.getInsets().top>height_screen){
                            double proporcja = (double)height_screen/height;
                            height = height_screen-window.getInsets().bottom-window.getInsets().top;
                            width = (int)(width*proporcja);
                        }

                        panel.setPreferredSize(new Dimension(width, height));
                        panel.revalidate();
                        panel.repaint();
                        window.pack();
                        window.setLocationRelativeTo(null);
                        window.setVisible(true);
                        Thread.sleep(screenTimeInSeconds*1000);
                    }else{
                        // Błąd odczytu/brak obrazka
                        if((int)panel.getPreferredSize().getHeight() < height || (int)panel.getPreferredSize().getWidth() < width)
                            panel.setPreferredSize(new Dimension(width, height));
                        panel.revalidate();
                        panel.repaint();
                        window.pack();
                        window.setLocationRelativeTo(null);
                        window.setVisible(true);
                        Thread.sleep(screenTimeInSeconds*1000);
                    }
                }else{
                    panel.repaint();
                    break;
                }
            } catch (InterruptedException e) {
                return;
            }

        }

    }

    private static String choseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        }
        throw new RuntimeException("Wrong file path");
    }
}
