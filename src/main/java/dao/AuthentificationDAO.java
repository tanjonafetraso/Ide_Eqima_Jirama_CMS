/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.MysqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Authentification;
import servicesImpl.AuthentificationDAOImpl;


/**
 *
 * @author EQIMA
 */
public class AuthentificationDAO extends AuthentificationDAOImpl {
    private static AuthentificationDAO instance;
    
    public static AuthentificationDAO getInstance(){
    
        if (instance == null) {
            instance = new AuthentificationDAO();
        }
        
        return instance;
    }

    public Authentification create(Authentification obj) {
       try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, obj.getDatetime());
            statement.setInt(2, obj.getUtilisateur_id());            
            statement.setInt(3, obj.getAdresse_id());
           
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       
        return obj; 
    }

    public Authentification update(Authentification obj) {
       
        return obj;
    
    }

    public boolean delete(Authentification obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(DELETE);
            statement.setInt(1, obj.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        
         return  false;   
    }

    public Authentification get(int id) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Authentification(
                    rs.getInt(COL_ID),
                    rs.getString(COL_DATETIME),
                    rs.getInt(COL_UTILISATEUR_ID),
                    rs.getInt(COL_ADRESSE_ID)
                    
                );
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;  
    }

    public List<Authentification> getAll() {

        ArrayList<Authentification> adresses = new ArrayList<>();
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL);
            
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                adresses.add(new Authentification(
                    rs.getInt(COL_ID),
                    rs.getString(COL_DATETIME),
                    rs.getInt(COL_UTILISATEUR_ID),
                    rs.getInt(COL_ADRESSE_ID)
                    
                ));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return adresses;
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
