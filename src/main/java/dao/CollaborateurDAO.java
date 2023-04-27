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
import models.Collaborateur;
import servicesImpl.CollaborateurDAOImpl;


/**
 *
 * @author EQIMA
 */
public class CollaborateurDAO extends CollaborateurDAOImpl{
    
    private static CollaborateurDAO instance;
    
    public static CollaborateurDAO getInstance(){
    
        if (instance == null) {
            instance = new CollaborateurDAO();
        }
        
        return instance;
    }

    public Collaborateur create(Collaborateur obj) {
         try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
           
            statement.setString(1, obj.getMatricule());
            statement.setString(2, obj.getNom());
            statement.setString(3, obj.getDate_de_naissance());
            statement.setString(4, obj.getType());
            
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

    public Collaborateur update(Collaborateur obj) {
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(UPDATE);
            
            statement.setString(1, obj.getMatricule());
            statement.setString(2, obj.getNom());
            statement.setString(3, obj.getDate_de_naissance());
            statement.setString(4, obj.getType());
            statement.setInt(5, obj.getId());
            
            statement.executeUpdate();
                        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return obj;
        
    }
    public Collaborateur isthere(Collaborateur obj) {
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(ISTHERE);
            
            statement.setString(1, obj.getMatricule());
            statement.setString(2, obj.getNom());
            statement.setString(3, obj.getDate_de_naissance());
            statement.setString(4, obj.getType());
            
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                  obj.setId(rs.getInt(1));   
                  return obj;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return null;
    }


    public boolean delete(Collaborateur obj) {
        
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(DELETE);
            statement.setInt(1, obj.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
             return  false;

        }

        
    }

    public Collaborateur get(int id) {
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Collaborateur(
                    rs.getInt(COL_ID),
                    rs.getString(COL_MATRICULE),
                    rs.getString(COL_NOM),
                    rs.getString(COL_DATE_DE_NAISSANCE),
                    rs.getString(COL_TYPE));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    
    }

    public List<Collaborateur> getAll() {
        
        ArrayList<Collaborateur> personnes = new ArrayList<>();
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL);
            
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                personnes.add(new Collaborateur(
                    rs.getInt(COL_ID),
                    rs.getString(COL_MATRICULE),
                    rs.getString(COL_NOM),
                    rs.getString(COL_DATE_DE_NAISSANCE),
                    rs.getString(COL_TYPE)));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personnes;
    
        
    }
    
    public Collaborateur getByMatType(String matricule, String type) {
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_BY_MATRICULE_TYPE);
            statement.setString(1, matricule);
            statement.setString(2, type);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Collaborateur(
                    rs.getInt(COL_ID),
                    rs.getString(COL_MATRICULE),
                    rs.getString(COL_NOM),
                    rs.getString(COL_DATE_DE_NAISSANCE),
                    rs.getString(COL_TYPE));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    
    }

    public List<Collaborateur> getByMat(String matricule) {
        List<Collaborateur> rep = new ArrayList();
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_BY_MATRICULE);
            statement.setString(1, matricule);
            ResultSet rs =  statement.executeQuery();
            
            
            while(rs.next()) {
                
                 rep.add(new Collaborateur(
                    rs.getInt(COL_ID),
                    rs.getString(COL_MATRICULE),
                    rs.getString(COL_NOM),
                    rs.getString(COL_DATE_DE_NAISSANCE),
                    rs.getString(COL_TYPE)));
                
            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     return rep;   
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
