/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author EQIMA
 */
public class Utilisateur {
    
    public static final String ADMINISTRATEUR = "ADMINISTRATEUR";
    public static final String UTILISATEUR = "UTILISATEUR";
    
    
    private int id;
    private String nom_d_utilisateur;
    private String nom;
    private String prenom;
    private String code_Cms;
    private String role;
    
    public static String getClasseName(){
    
        return "Utilistaeur";
    
    }
    

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom_d_utilisateur, String nom, String prenom, String code_Cms, String role) {
        this.id = id;
        this.nom_d_utilisateur = nom_d_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.code_Cms = code_Cms;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCode_Cms() {
        return code_Cms;
    }

    public void setCode_Cms(String code_Cms) {
        this.code_Cms = code_Cms;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_d_utilisateur() {
        return nom_d_utilisateur;
    }

    public void setNom_d_utilisateur(String nom_d_utilisateur) {
        this.nom_d_utilisateur = nom_d_utilisateur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
}
