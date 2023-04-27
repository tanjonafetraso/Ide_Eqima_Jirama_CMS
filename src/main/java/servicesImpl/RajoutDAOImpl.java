/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Utilisateur;
import services.IDAO;



/**
 *
 * @author EQIMA
 */
public abstract class RajoutDAOImpl {
    
    public static final String TABLE_NAME = "responsable_ajout";
    public static final String COL_ID = "id";
public static final String COL_SCORE = "score";
    public static final String COL_ID_EMPREINTES = "id_empreintes";
    public static final String COL_ID_AUTHENTIFICATIONS = "id_authentifications";
  public static final String COL_type = "type_action";
    
   
    public static final String DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    //public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_NOM_UTILISATEUR+", "+COL_NOM+", "+COL_DATE_DE_NAISSANCE+") VALUES(?, ?, ?)";
    public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_ID_EMPREINTES+", "+COL_ID_AUTHENTIFICATIONS+","+COL_SCORE+","+COL_type+") VALUES(?, ?, ?, ?)";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String SIZE = "SELECT COUNT(*) AS nombre FROM "+TABLE_NAME;
    
    
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+COL_ID+" DESC ";
    
}
