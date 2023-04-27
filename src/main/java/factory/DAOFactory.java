/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.ActionDAO;
import dao.AdresseDAO;
import dao.AuthentificationDAO;
import dao.CollaborateurDAO;
import dao.EmpreinteDAO;
import dao.UtilisateurDAO;


/**
 *
 * @author EQIMA
 */
public class DAOFactory {
    
    public static ActionDAO getActionCollabDAO(){
    
        return ActionDAO.getInstance();
    
    }
    

    
    public static AdresseDAO getAdresseDAO(){
    
        return AdresseDAO.getInstance();
    
    }
    
    public static AuthentificationDAO getAuthentificationDAO(){
    
        return AuthentificationDAO.getInstance();
    
    }
    
    public static CollaborateurDAO getCollaborateurDAO(){
    
        return CollaborateurDAO.getInstance();
    
    }
    
    public static EmpreinteDAO getEmpreinteDAO(){
    
        return EmpreinteDAO.getInstance();
    
    }
    
    public static UtilisateurDAO getUtilisateurDAO(){
    
        return UtilisateurDAO.getInstance();
    
    }
    
}
