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
public class Authentification {
    private int id;
    private String datetime;
    private int utilisateur_id;
    private int adresse_id;

    private static Authentification instance;
    
    public static String getClasseName(){
    
        return "Authentification";
    
    }
    
    public static Authentification getSession(){
        if (instance == null) {
            instance = new Authentification();
        }
        return instance;
    }
    
    public void setSession(Authentification auth){
        instance = auth;
    }
    
    public Authentification() {
    }

    public Authentification(String datetime, int utilisateur_id, int adresse_id) {
        this.datetime = datetime;
        this.utilisateur_id = utilisateur_id;
        this.adresse_id = adresse_id;
    }

    public Authentification(int id, String datetime, int utilisateur_id, int adresse_id) {
        this.id = id;
        this.datetime = datetime;
        this.utilisateur_id = utilisateur_id;
        this.adresse_id = adresse_id;
    }

    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }
    
    
    
}
