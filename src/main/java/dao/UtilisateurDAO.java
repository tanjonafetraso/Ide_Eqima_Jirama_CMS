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
import models.Utilisateur;
import servicesImpl.UtilisateurDAOImpl;

/**
 *
 * @author EQIMA
 */
public class UtilisateurDAO extends UtilisateurDAOImpl {

    private static UtilisateurDAO instance;

    public static UtilisateurDAO getInstance() {

        if (instance == null) {
            instance = new UtilisateurDAO();
        }

        return instance;
    }

    public Utilisateur create(Utilisateur obj) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getNom_d_utilisateur());
            statement.setString(3, obj.getRole());
            statement.setString(4, obj.getNom());
            statement.setString(5, obj.getPrenom());
            statement.setString(6, obj.getCode_Cms());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erreur ato e");
        }

        return obj;
    }

//    public Utilisateur update(Utilisateur obj) {
//        try {
//            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(UPDATE);
//
//            statement.setInt(0, obj.getId());
//            statement.setString(1, obj.getNom_d_utilisateur());
//            statement.setString(2, obj.getRole());
//            statement.setString(3, obj.getNom());
//            statement.setString(4, obj.getPrenom());
//            statement.setString(5, obj.getCode_Cms());
//
//            statement.setInt(4, obj.getId());
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return obj;
//    }

//    public boolean delete(Utilisateur obj) {
//        try {
//            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(DELETE);
//            statement.setInt(1, obj.getId());
//            statement.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//
//    }

    public Utilisateur get(int id) {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                return new Utilisateur(
                        rs.getInt(COL_ID),
                        rs.getString(COL_NOM_D_UTILISATEUR),
                        rs.getString(COL_NOM),
                        rs.getString(COL_PRENOM),
                        rs.getString(COL_CODE_CMS),
                        rs.getString(COL_ROLE));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<Utilisateur> getAll() {

        ArrayList<Utilisateur> personnes = new ArrayList<>();

        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                personnes.add(new Utilisateur(
                        rs.getInt(COL_ID),
                        rs.getString(COL_NOM_D_UTILISATEUR),
                        rs.getString(COL_NOM),
                        rs.getString(COL_PRENOM),
                        rs.getString(COL_CODE_CMS),
                        rs.getString(COL_ROLE)));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personnes;

    }

    public int size() {
        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(SIZE);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                return rs.getInt("nombre");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

//    public Utilisateur getByUsernameAndPassword(String username, String password) {
//        try {
//            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_BY_USERN_PASS);
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet rs = statement.executeQuery();
//
//            if (rs.next()) {
//
//                return new Utilisateur(
//                        rs.getInt(COL_ID),
//                        rs.getString(COL_NOM_D_UTILISATEUR),
//                        rs.getString(COL_NOM),
//                        rs.getString(COL_PRENOM),
//                        rs.getString(COL_CODE_CMS),
//                        rs.getString(COL_ROLE));
//
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }

    public List<Utilisateur> getAllByRole(String role) {

        ArrayList<Utilisateur> personnes = new ArrayList<>();

        try {
            PreparedStatement statement = MysqlConnection.getInstance().prepareStatement(FIND_ALL_BY_ROLE);

            statement.setString(1, role);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                personnes.add(new Utilisateur(
                        rs.getInt(COL_ID),
                        rs.getString(COL_NOM_D_UTILISATEUR),
                        rs.getString(COL_NOM),
                        rs.getString(COL_PRENOM),
                        rs.getString(COL_CODE_CMS),
                        rs.getString(COL_ROLE)));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personnes;

    }

    @Override
    public Utilisateur update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
