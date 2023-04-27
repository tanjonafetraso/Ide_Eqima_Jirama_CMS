/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Empreinte;
import services.IDAO;



/**
 *
 * @author EQIMA
 */
public abstract class EmpreinteDAOImpl implements IDAO<Empreinte>{
    
    public static final String TABLE_NAME = "empreintes";
    public static final String COL_ID = "id";
    public static final String COL_DOIGT = "doigt";
    public static final String COL_IMAGE = "image";
    public static final String COL_COLLABORATEUR_ID = "collaborateur_id";
    
    public static final String INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_DOIGT+", "+COL_IMAGE+", "+COL_COLLABORATEUR_ID+") VALUES(?,AES_ENCRYPT(?,'key'), ?)";
    
    public static final String DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND_BY_PERSONNE_ID_DOIGT = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_COLLABORATEUR_ID+"=? AND "+COL_DOIGT+"=?";
    
    public static final String FIND_IMAGE_BY_PERSONNE_ID_DOIGT = "SELECT AES_DECRYPT("+COL_IMAGE+",'key')as blobImg FROM "+TABLE_NAME+" WHERE "+COL_COLLABORATEUR_ID+"=? AND "+COL_DOIGT+"=?";
        
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME;
    
    public static final String FIND_ALL_BY_PESONNE_ID= "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_COLLABORATEUR_ID+"=?";
    
    public static final String UPDATE = "UPDATE "+TABLE_NAME+" SET "+COL_DOIGT+"=?, "+COL_IMAGE+"=?, "+COL_COLLABORATEUR_ID+"=?,  WHERE "+COL_ID+"=?";


    
}
