package jframes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class retourListener implements ActionListener{

    private EmpreinteJFrame emf;
   
    public retourListener(EmpreinteJFrame e) {
        emf=e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emf.dispose();
        File file = new File("fingerprint.bmp");
        file.delete();
        CollaborateurViaAPIJFrame f=new CollaborateurViaAPIJFrame();
         f.setVisible(true);
    }
    
}
