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
import models.Adresse;
import servicesImpl.AdresseDAOImpl;

/**
 *
 * @author EQIMA
 */
public class AdresseDAO extends AdresseDAOImpl{

    private static AdresseDAO instance;
    
    public static AdresseDAO getInstance(){
    
        if (instance == null) {
            instance = new AdresseDAO();
        }
        
        return instance;
    }

    public Adresse create(Adresse obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, obj.getAdresse_mac());
           
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

    public Adresse update(Adresse obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(UPDATE);
            
            statement.setString(1, obj.getAdresse_mac());
           
            statement.setInt(2, obj.getId());
            
            statement.executeUpdate();
                        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return obj;
    }

    public boolean delete(Adresse obj) {
        
       
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

    public Adresse get(int id) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Adresse(
                    rs.getInt(COL_ID),
                    rs.getString(COL_ADRESSE_MAC)
                    
                );
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;    
    }

    public List<Adresse> getAll() {
    
         ArrayList<Adresse> adresses = new ArrayList<>();
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL);
            
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                adresses.add(new Adresse(
                    rs.getInt(COL_ID),
                    rs.getString(COL_ADRESSE_MAC)
                    
                ));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return adresses;
    
    }

    public int size() {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(SIZE);
            
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return rs.getInt("nombre");
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public Adresse getbyAdresseMac(String mac) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_BY_ADRESSE_MAC);
            statement.setString(1, mac);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Adresse(
                    rs.getInt(COL_ID),
                    rs.getString(COL_ADRESSE_MAC)
                    
                );
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;  
    }

    
}
