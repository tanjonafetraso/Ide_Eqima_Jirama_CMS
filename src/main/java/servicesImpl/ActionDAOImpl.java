/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Action;
import services.IDAO;


/**
 *
 * @author EQIMA
 */
public abstract class ActionDAOImpl implements IDAO<Action>{
    

    
    protected static final String TABLE_NAME = "actions";
    protected static final String COL_ID = "id";
    
    protected static final String COL_DATETIME = "datetime";
    protected static final String COL_CLASSE_NAME = "classe_name";
    protected static final String COL_CLASSE_ID = "classe_id";
    protected static final String COL_MESSAGE = "message";
    protected static final String COL_AUTHETIFICATION_ID = "authentification_id";
    
    public static final String DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    //public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_MATRICULE+", "+COL_NOM+", "+COL_DATE_DE_NAISSANCE+") VALUES(?, ?, ?)";
    public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+
            COL_DATETIME+", "+
            COL_CLASSE_NAME+", "+
            COL_CLASSE_ID+", "+
            COL_MESSAGE+""+
            COL_AUTHETIFICATION_ID+") "
            + "VALUES(?, ?, ?, ?, ?)";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+COL_ID+" DESC ";
    
    public static final String SIZE = "SELECT COUNT(*) AS nombre FROM "+TABLE_NAME;
    
    
    
    
}
