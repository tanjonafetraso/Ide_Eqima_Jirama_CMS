/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframes;
import java.io.File;
import java.awt.Color;
import javax.swing.JOptionPane;
import zkfinger.ZKScanner;
import api.GetRequest;
import factory.DAOFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Collaborateur;
import zkfinger.ZKScanner;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import zkfinger.ZKScanner;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.io.InputStream;
import models.Empreinte;
import javax.swing.ImageIcon;
import models.Authentification;
import dao.RajoutDAO;
import models.Rajout;

/*-----------------------------------*/


/*------------------------------------*/




/**
 *
 * @author EQIMA
 */
public class MenuJFrame extends FrameModel {
    
    private static MenuJFrame instance;
    
    private int id_auth;

    public static MenuJFrame getInstance(int id){
    
        if (instance == null) {
            instance = new MenuJFrame(id);
        }
        
        return instance;
    } 

    public static MenuJFrame getInstance(){
    
        if (instance == null) {
            instance = new MenuJFrame();
        }
        
        return instance;
    } 

    /**
     * Creates new form MenuJFrame
     */
    public MenuJFrame(int id) {
        this.id_auth = id;
        initComponents();
        
        this.setResizable​(true);
    }

    public MenuJFrame() {
        initComponents();
        AuthentificationJFrame.getInstance().hideFrame();
       //  ZKScanner.getInstance().open();
       // JOptionPane.showMessageDialog(instance,, "Message", JOptionPane.WARNING_MESSAGE);
    }
    
    private void init(){
    
    
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbInscriptionViaApi = new javax.swing.JButton();
        jbIdentification = new javax.swing.JButton();
        jbMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IDEqima Identification Biométrique");
        jLabel2.setText("Version 1.0");
        jLabel3.setText("Version Sandbox");
        jLabel3.setForeground(Color.red);

        jbInscriptionViaApi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbInscriptionViaApi.setText("Inscription");
        jbInscriptionViaApi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscriptionViaApiActionPerformed(evt);
            }
        });

        jbIdentification.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbIdentification.setText("Identification");
        jbIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                File f=new File("fingerprint.bmp");
                f.delete();
                jbIdentificationActionPerformed(evt);
            }
        });

        jbMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbMenu.setText("Quitter");
        jbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbInscriptionViaApi, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                   // .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(135, 135, 135)
                .addComponent(jbInscriptionViaApi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
               // .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addComponent(jbMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInscriptionViaApiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscriptionViaApiActionPerformed
       
        MenuJFrame.getInstance().hideFrame();
        CollaborateurViaAPIJFrame.getInstance().showFrame();
    }//GEN-LAST:event_jbInscriptionViaApiActionPerformed

    private void jbIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIdentificationActionPerformed

        MenuJFrame.getInstance().hideFrame();
        RechercheJFrame.getInstance().showFrame();
        
    }//GEN-LAST:event_jbIdentificationActionPerformed

    private void jbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuActionPerformed

        MenuJFrame.getInstance().hideFrame();
        AuthentificationJFrame.getInstance().showFrame();
    }//GEN-LAST:event_jbMenuActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbIdentification;
    private javax.swing.JButton jbInscriptionViaApi;
    private javax.swing.JButton jbMenu;
    // End of variables declaration//GEN-END:variables

     public void showFrame(){
        this.setVisible(true);
    }
    
    public void hideFrame(){
        this.setVisible(false);
    }

}
