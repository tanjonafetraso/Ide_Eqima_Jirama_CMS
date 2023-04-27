/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframes;

import factory.DAOFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Utilisateur;
import services.PassWordControl;
/**
 *
 * @author EQIMA
 */
public class UtilisateurJframe extends javax.swing.JFrame {

    private static UtilisateurJframe instance;
    
    public static UtilisateurJframe getInstance(){
    
        if (instance == null) {
            instance = new UtilisateurJframe();
        }
        
        return instance;
    } 
    
    public UtilisateurJframe() {
        initComponents();
        this.setResizable​(true);
        String [] roles = {"Administrateur", "Utilisateur"};
        jcRole.setModel(new DefaultComboBoxModel<>(roles));
        jcRole.setSelectedIndex(0);
        
        showData();
        
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
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNom_d_utilisateur = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpMot_de_passe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbEnregistrer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersonnes = new javax.swing.JTable();
        jbSupprimer = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        jbMenu = new javax.swing.JButton();
        jcRole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajout des Utilisateurs");
        jLabel6.setText("Version 1.0");

        jtId.setEditable(false);
        jtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nom d'Utilisateur");

        jtNom_d_utilisateur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtNom_d_utilisateur.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtNom_d_utilisateurInputMethodTextChanged(evt);
            }
        });
        jtNom_d_utilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNom_d_utilisateurActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mot de Passe");

        jpMot_de_passe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Rôle");

        jbEnregistrer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbEnregistrer.setText("Enregistrer");
        jbEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnregistrerActionPerformed(evt);
            }
        });

        jtPersonnes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom d'utilisiteur", "Rôle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPersonnes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonnesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersonnes);

        jbSupprimer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbSupprimer.setText("Supprimer");
        jbSupprimer.setEnabled(false);
        jbSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSupprimerActionPerformed(evt);
            }
        });

        jbReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbReset.setText("Reset");
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });

        jbMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbMenu.setText("Retour");
        jbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuActionPerformed(evt);
            }
        });

        jcRole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcRole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcRoleItemStateChanged(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpMot_de_passe)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtNom_d_utilisateur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtId, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                          //  .addComponent(jbReset, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 184, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNom_d_utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpMot_de_passe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEnregistrer)
                    .addComponent(jbSupprimer))
                .addGap(18, 18, 18)
              //  .addComponent(jbReset)
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(53, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbMenu))
                    .addComponent(jLabel6)
                    .addContainerGap()))
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

    private void jtNom_d_utilisateurInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtNom_d_utilisateurInputMethodTextChanged

    }//GEN-LAST:event_jtNom_d_utilisateurInputMethodTextChanged

    private void jbEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnregistrerActionPerformed
        
        if (jtNom_d_utilisateur.getText().trim().equals("") || jpMot_de_passe.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(instance, "Tous les champs doit être rempli ", "Message", JOptionPane.WARNING_MESSAGE);
                
        } 
        else {
            
            Utilisateur utilisateur = null;
            String message = null;
            
            if(PassWordControl.isValidPassword(jpMot_de_passe.getText().trim()))  {
            if (jtId.getText().isEmpty()) {
//                utilisateur = new Utilisateur(jtNom_d_utilisateur.getText().trim(), jpMot_de_passe.getText().trim(), (String) jcRole.getSelectedItem());
            
                utilisateur = DAOFactory.getUtilisateurDAO().create(utilisateur);
                
                message = "Utilisateur ajouté";
                
            } else {
                
//                utilisateur = new Utilisateur(Integer.valueOf(jtId.getText()) , jtNom_d_utilisateur.getText().trim(), jpMot_de_passe.getText().trim(), (String) jcRole.getSelectedItem());
            
               
                utilisateur = DAOFactory.getUtilisateurDAO().update(utilisateur);
                
                message = "Utilisateur modifié";
                
              
                
            }
            
            
            if (utilisateur == null) {
                JOptionPane.showMessageDialog(instance, "Erreur pendant la Enregistrement, veuillez réessayer ", "Message", JOptionPane.WARNING_MESSAGE);            
            } else {                                
                JOptionPane.showMessageDialog(instance, message, "Message", JOptionPane.WARNING_MESSAGE); 
                
                reset();
            }
            }
             else {     
             JOptionPane.showMessageDialog(instance, "Mot de passe doit contenir au moins un chiffre,un minuscule,un majuscule,un special symbole entre:@#$% et contenir entre 8 à 20 caractères", "Message", JOptionPane.WARNING_MESSAGE);            
        }
            showData();
      
        }
          
       
        
    }//GEN-LAST:event_jbEnregistrerActionPerformed

    private void jtPersonnesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonnesMouseClicked
       
        int index = jtPersonnes.getSelectedRow();
        TableModel model = jtPersonnes.getModel();
        
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        
        Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().get(id);
        
        jtId.setText(String.valueOf(utilisateur.getId()));
        jtNom_d_utilisateur.setText(utilisateur.getNom_d_utilisateur());
       // jpMot_de_passe.setText(utilisateur.getMot_de_passe());
        jcRole.setSelectedItem(utilisateur.getRole());
        
        jbSupprimer.setEnabled(true);
    }//GEN-LAST:event_jtPersonnesMouseClicked

    private void jbSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSupprimerActionPerformed
        
        if (jtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner la utilisateur a supprimé !", "Message", JOptionPane.WARNING_MESSAGE);
        } else {
            
            Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().get(Integer.parseInt(jtId.getText()));
            if (utilisateur == null) {
                
                JOptionPane.showMessageDialog(this, "l' ID :  " + jtId.getText() + " n'existe pas !", "Message", JOptionPane.WARNING_MESSAGE);
                
            } else {
                
                if (DAOFactory.getUtilisateurDAO().delete(utilisateur)) {
                    JOptionPane.showMessageDialog(this, utilisateur.toString() + " a été supprimé !");
                    showData();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Erreur pendant la suppression de " + utilisateur.toString(), "Message", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            
        }
        
    }//GEN-LAST:event_jbSupprimerActionPerformed

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        reset();
    }//GEN-LAST:event_jbResetActionPerformed

    private void jbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuActionPerformed

        MenuAdminJFrame.getInstance().showFrame();
        UtilisateurJframe.getInstance().hideFrame();

    }//GEN-LAST:event_jbMenuActionPerformed

    private void jtNom_d_utilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNom_d_utilisateurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNom_d_utilisateurActionPerformed

    private void jcRoleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcRoleItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcRoleItemStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEnregistrer;
    private javax.swing.JButton jbMenu;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbSupprimer;
    private javax.swing.JComboBox<String> jcRole;
    private javax.swing.JTextField jpMot_de_passe;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNom_d_utilisateur;
    private javax.swing.JTable jtPersonnes;
    // End of variables declaration//GEN-END:variables
    public void showFrame(){
        this.setVisible(true);
    }
    
    public void hideFrame(){
        this.setVisible(false);
    }
    
    private void showData(){
    
        DefaultTableModel model = (DefaultTableModel) jtPersonnes.getModel();
        
        model.setRowCount(0);
        
        Object [] row = new Object[4];
        
        for (Utilisateur utilisateur : DAOFactory.getUtilisateurDAO().getAll() ) {
            row [0] = utilisateur.getId();
            row [1] = utilisateur.getNom_d_utilisateur();
            row [2] = utilisateur.getRole();
            
             model.addRow(row);
        }
        
       
    
    }
    
    private void reset(){
    
        jtId.setText("");
        jtNom_d_utilisateur.setText("");
        jpMot_de_passe.setText("");
        jbSupprimer.setEnabled(false);
        
    }

}