/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import factory.DAOFactory;
import models.Collaborateur;
import database.MysqlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Empreinte;
import servicesImpl.EmpreinteDAOImpl;

/**
 *
 * @author EQIMA
 */
public class EmpreinteDAO extends EmpreinteDAOImpl{
    
    private static EmpreinteDAO instance;
    
    public static EmpreinteDAO getInstance(){
    
        if (instance == null) {
            instance = new EmpreinteDAO();
        }
        
        return instance;
    }

    public Empreinte create(Empreinte obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, obj.getDoigt());
            statement.setBlob(2, new FileInputStream(new File("fingerprint.bmp")));
            statement.setInt(3, obj.getCollaborateur_id());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpreinteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return obj;
    }

    public Empreinte update(Empreinte obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(UPDATE);
            
            statement.setString(1, obj.getDoigt());
            statement.setBlob(2, new FileInputStream(new File("fingerprint.bmp")));
            statement.setInt(3, obj.getCollaborateur_id());
            
            statement.setInt(4, obj.getId());
            
            statement.executeUpdate();
                        
        } catch (SQLException e) {
            Logger.getLogger(EmpreinteDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpreinteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    
    }

    public boolean delete(Empreinte obj) {
         try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(DELETE);
            statement.setInt(1, obj.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpreinteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Empreinte get(int id) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Empreinte(
                    rs.getInt(COL_ID), 
                    rs.getString(COL_DOIGT),
                    rs.getInt(COL_COLLABORATEUR_ID));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(EmpreinteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Empreinte> getAll() {
        
        ArrayList<Empreinte> empreintes = new ArrayList<>();
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL);
            
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                empreintes.add(new Empreinte(
                    rs.getInt(COL_ID), 
                    rs.getString(COL_DOIGT),
                    rs.getInt(COL_COLLABORATEUR_ID)));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empreintes;
    }

    
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Empreinte getByPersonneIdAndDoigt(int id, String doigt) {
        
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_BY_PERSONNE_ID_DOIGT);
            statement.setInt(1, id);
            statement.setString(2, doigt);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return new Empreinte(
                    rs.getInt(COL_ID), 
                    rs.getString(COL_DOIGT),
                    rs.getInt(COL_COLLABORATEUR_ID));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    
        
    }
    
    public Blob getImageByIdAndDoigt(int personne_id, String doigt) {
        
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_IMAGE_BY_PERSONNE_ID_DOIGT);
            statement.setInt(1, personne_id);
            statement.setString(2, doigt);
            ResultSet rs =  statement.executeQuery();
            
            
            if (rs.next()) {
                
                return rs.getBlob("blobImg");
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    
        
    }
    
    public List<Empreinte> getAllByPersonneId(int personne_id) {
        
        ArrayList<Empreinte> empreintes = new ArrayList<>();
    
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL_BY_PESONNE_ID);
            
            statement.setInt(1, personne_id);
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                empreintes.add(new Empreinte(
                    rs.getInt(COL_ID), 
                    rs.getString(COL_DOIGT),
                    rs.getInt(COL_COLLABORATEUR_ID)));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empreintes;
        
    }
 public List<Empreinte> getAllEmpreinte(String matricule) {
        
        ArrayList<Empreinte> empreintes = new ArrayList<>();
        List<Collaborateur> allc = DAOFactory.getCollaborateurDAO().getByMat(matricule);
        try {
            for(int i=0;i<allc.size();i++) {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL_BY_PESONNE_ID);
            
            statement.setInt(1,allc.get(i).getId());
            ResultSet rs =  statement.executeQuery();
            
            
            while (rs.next()) {
                
                empreintes.add(new Empreinte(
                    rs.getInt(COL_ID), 
                    rs.getString(COL_DOIGT),
                    rs.getInt(COL_COLLABORATEUR_ID)));
                
            }
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empreintes;
        
    }
}
