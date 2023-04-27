/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author eqima
 */
public class Identification {
    private int id_identification;
    private int id_auth;
    private String datetime;
    private int utilisateur_id;
    private int adresse_id;
    private int id_empreintes;
    private int score;
    private String doigt;
    private int collaborateur_id;
    private String nom_d_utilisateur;
    private String code_Cms;
    private String adresse_mac;
    public int  matricule;

    public Identification(int id_identification, int id_auth, String datetime, int utilisateur_id, int adresse_id, int id_empreintes, int score, String doigt, int collaborateur_id, String nom_d_utilisateur, String code_Cms, String adresse_mac, int  matricule) {
        this.id_identification = id_identification;
        this.id_auth = id_auth;
        this.datetime = datetime;
        this.utilisateur_id = utilisateur_id;
        this.adresse_id = adresse_id;
        this.id_empreintes = id_empreintes;
        this.score = score;
        this.doigt = doigt;
        this.collaborateur_id = collaborateur_id;
        this.nom_d_utilisateur = nom_d_utilisateur;
        this.code_Cms = code_Cms;
        this.adresse_mac = adresse_mac;
        this.matricule = matricule;
    }

    public int getId_identification() {
        return id_identification;
    }

    public void setId_identification(int id_identification) {
        this.id_identification = id_identification;
    }

    public int getId_auth() {
        return id_auth;
    }

    public void setId_auth(int id_auth) {
        this.id_auth = id_auth;
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

    public int getId_empreintes() {
        return id_empreintes;
    }

    public void setId_empreintes(int id_empreintes) {
        this.id_empreintes = id_empreintes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDoigt() {
        return doigt;
    }

    public void setDoigt(String doigt) {
        this.doigt = doigt;
    }

    public int getCollaborateur_id() {
        return collaborateur_id;
    }

    public void setCollaborateur_id(int collaborateur_id) {
        this.collaborateur_id = collaborateur_id;
    }

    public String getNom_d_utilisateur() {
        return nom_d_utilisateur;
    }

    public void setNom_d_utilisateur(String nom_d_utilisateur) {
        this.nom_d_utilisateur = nom_d_utilisateur;
    }

    public String getCode_Cms() {
        return code_Cms;
    }

    public void setCode_Cms(String code_Cms) {
        this.code_Cms = code_Cms;
    }

    public String getAdresse_mac() {
        return adresse_mac;
    }

    public void setAdresse_mac(String adresse_mac) {
        this.adresse_mac = adresse_mac;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int  matricule) {
        this.matricule = matricule;
    }
    
}
