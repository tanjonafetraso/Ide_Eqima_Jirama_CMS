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
import models.Rajout;
import servicesImpl.RajoutDAOImpl;


/**
 *
 * @author EQIMA
 */
public class RajoutDAO extends RajoutDAOImpl{
    
    private static RajoutDAO instance;
    
    public static RajoutDAO getInstance(){
    
        if (instance == null) {
            instance = new RajoutDAO();
        }
        
        return instance;
    }

    public Rajout create(Rajout obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, obj.getId_empreintes());
            statement.setInt(2, obj.getId_authentifications());
            statement.setInt(3, obj.getScore());
            statement.setString(4, obj.getType_action());
            
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

}
