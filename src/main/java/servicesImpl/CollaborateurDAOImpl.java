/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Collaborateur;
import services.IDAO;



/**
 *
 * @author EQIMA
 */
public abstract class CollaborateurDAOImpl implements IDAO<Collaborateur>{
    
    public static final String TABLE_NAME = "collaborateurs";
    public static final String COL_ID = "id";
    public static final String COL_MATRICULE = "matricule";
    public static final String COL_NOM = "nom";
    public static final String COL_DATE_DE_NAISSANCE = "date_de_naissance";
    public static final String COL_TYPE = "type";
    
    public static final String DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_MATRICULE+", "+COL_NOM+", "+COL_DATE_DE_NAISSANCE+", "+COL_TYPE+") VALUES(?, ?, ?, ?)";
    //public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_ID+", "+COL_MATRICULE+", "+COL_NOM+", "+COL_DATE_DE_NAISSANCE+") VALUES(?, ?, ?, ?)";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND_BY_MATRICULE = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_MATRICULE+"=?";
    
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+COL_ID+" DESC ";
    
    public static final String UPDATE = "UPDATE "+TABLE_NAME+" SET "+COL_TYPE+"=?, "+COL_MATRICULE+"=?, "+COL_NOM+"=?, "+COL_DATE_DE_NAISSANCE+"=?  WHERE "+COL_ID+"=?";
   
    public static final String FIND_BY_MATRICULE_TYPE = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_MATRICULE+"=? AND "+COL_MATRICULE+"=?";
    public static final String ISTHERE =" select * from collaborateurs where matricule=? and nom=? and date_de_naissance=? and type=?";
   
}
