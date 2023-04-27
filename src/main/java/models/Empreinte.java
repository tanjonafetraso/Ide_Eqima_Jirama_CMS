/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import factory.DAOFactory;
import java.sql.Blob;

/**
 *
 * @author EQIMA
 */
public class Empreinte {
    private int id;
    private String doigt;
    private int collaborateur_id;
    
    public static String getClasseName(){
    
        return "Empreint";
    
    }

    public Empreinte() {
    }

    public Empreinte(String doigt, int collaborateur_id) {
        this.doigt = doigt;
        this.collaborateur_id = collaborateur_id;
    }

    public Empreinte(int id, String doigt, int collaborateur_id) {
        this.id = id;
        this.doigt = doigt;
        this.collaborateur_id = collaborateur_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public Blob getImage(){
    
        return DAOFactory.getEmpreinteDAO().getImageByIdAndDoigt(collaborateur_id, doigt);
    
    }
}
