/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Authentification;
import services.IDAO;



/**
 *
 * @author EQIMA
 */
public abstract class AuthentificationDAOImpl implements IDAO<Authentification>{
    
    public static final String TABLE_NAME = "authentifications";
    public static final String COL_ID = "id";
    public static final String COL_DATETIME = "datetime";
    public static final String COL_UTILISATEUR_ID = "utilisateur_id";
    public static final String COL_ADRESSE_ID = "adresse_id";
    
    public static final String INSERT = "INSERT INTO "+TABLE_NAME+"("+
            COL_DATETIME+", "+
            COL_UTILISATEUR_ID+", "+
            COL_ADRESSE_ID+") VALUES(?, ?, ?)";
    
    public static final String DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME;
    

    
    
}
