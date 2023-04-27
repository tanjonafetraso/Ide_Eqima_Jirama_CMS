/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Adresse;
import services.IDAO;



/**
 *
 * @author EQIMA
 */
public abstract class AdresseDAOImpl implements IDAO<Adresse>{
   
    public static final String TABLE_NAME = "adresses";
    public static final String COL_ID = "id";
    public static final String COL_ADRESSE_MAC = "adresse_mac";
    public static final String status= "actif";
    
    public static final String INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_ADRESSE_MAC+") VALUES(?)";
    
    public static final String DELETE = "update "+TABLE_NAME+"  set status='inactif' WHERE "+COL_ID+"=?";
    
    public static final String FIND = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+"=?";
    
    public static final String FIND_BY_ADRESSE_MAC = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ADRESSE_MAC+"=?";
    
    public static final String FIND_ALL = "SELECT * FROM "+TABLE_NAME +" where status='"+status+"'";
    
    public static final String UPDATE = "UPDATE "+TABLE_NAME+" SET "+COL_ADRESSE_MAC+"=?  WHERE "+COL_ID+"=?";
    
    public static final String SIZE = "SELECT COUNT(*) AS nombre FROM "+TABLE_NAME;
    


    
}
