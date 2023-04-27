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
public class Collaborateur {
    
    private int id;
    private String matricule;
    private String nom;
    private String date_de_naissance;
    private String type;

    public static String getClasseName(){
    
        return "Collaborateur";
    
    }
    
    public Collaborateur() {
    }

    public Collaborateur(int id, String matricule, String nom, String date_de_naissance, String type) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.date_de_naissance = date_de_naissance;
        this.type = type;
    }

    public Collaborateur(String matricule, String nom, String date_de_naissance, String type) {
        this.matricule = matricule;
        this.nom = nom;
        this.date_de_naissance = date_de_naissance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  
    
   

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public boolean isthere() {
        return false;
    }
    
}
