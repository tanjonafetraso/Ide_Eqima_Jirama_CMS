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
public class Action {
    
    private int id;
    private String datetime;
    private String classe_name;
    private String classe_id;
    private String type;
    private String message;
    private int authentification_id;
    
    public static String getClasseName(){
    
        return "Action";
    
    }
    
    public Action() {
    }

    public Action(String datetime, String classe_name, String classe_id, String type, String message, int authentification_id) {
        this.id = 0;
        this.datetime = datetime;
        this.classe_name = classe_name;
        this.classe_id = classe_id;
        this.type = type;
        this.message = message;
        this.authentification_id = authentification_id;
    }

    public Action(int id, String datetime, String classe_name, String classe_id, String type, String message, int authentification_id) {
        this.id = id;
        this.datetime = datetime;
        this.classe_name = classe_name;
        this.classe_id = classe_id;
        this.type = type;
        this.message = message;
        this.authentification_id = authentification_id;
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

    public String getClasse_name() {
        return classe_name;
    }

    public void setClasse_name(String classe_name) {
        this.classe_name = classe_name;
    }

    public String getClasse_id() {
        return classe_id;
    }

    public void setClasse_id(String classe_id) {
        this.classe_id = classe_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAuthentification_id() {
        return authentification_id;
    }

    public void setAuthentification_id(int authentification_id) {
        this.authentification_id = authentification_id;
    }
  
}
