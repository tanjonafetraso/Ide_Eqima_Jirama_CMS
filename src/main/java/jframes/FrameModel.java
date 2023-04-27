/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jframes;
import javax.swing.JFrame;
import zkfinger.ZKScanner;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
/**
 *
 * @author eqima
 */
public class FrameModel extends javax.swing.JFrame {
    public MyThread thread;
    public javax.swing.JButton jbImage;
    public class MyThread extends Thread {

    
        @Override
        // End of variables declaration                 
        public void run() {
           
            super.run();
            while (!ZKScanner.getInstance().mbStop) {
                if (ZKScanner.getInstance().capture()) {

                    try {
                        jbImage.setIcon(new ImageIcon(ImageIO.read(new File("fingerprint.bmp"))));
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                }

            }

        }

    }
}
 