/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesImpl;

import models.Utilisateur;
import services.IDAO;

/**
 *
 * @author EQIMA
 */
public abstract class UtilisateurDAOImpl implements IDAO<Utilisateur> {

    public static final String TABLE_NAME = "utilisateurs";
    public static final String COL_ID = "id";
    public static final String COL_NOM_D_UTILISATEUR = "nom_d_utilisateur";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";
    public static final String COL_CODE_CMS = "code_Cms";
   // public static final String status = "actif";
    //public static final String statusa = "inactif";

    public static final String COL_ROLE = "role";

    //public static final String DELETE = "update " + TABLE_NAME + "  set status='" + statusa + "' WHERE " + COL_ID + "=?";

    //public static final String  INSERT = "INSERT INTO "+TABLE_NAME+"("+COL_NOM_UTILISATEUR+", "+COL_NOM+", "+COL_DATE_DE_NAISSANCE+") VALUES(?, ?, ?)";
    public static final String INSERT = "INSERT INTO " + TABLE_NAME + "("+COL_ID+"," + COL_NOM_D_UTILISATEUR + "," + COL_ROLE + ", " + COL_NOM + ","+COL_PRENOM+","+COL_CODE_CMS+") VALUES(?,?,?,?,?,?)";

    public static final String FIND = "SELECT * FROM " + TABLE_NAME + " WHERE  " + COL_ID + "=?";

    public static final String SIZE = "SELECT COUNT(*) AS nombre FROM " + TABLE_NAME ;

   // public static final String FIND_BY_USERN_PASS = "SELECT * FROM " + TABLE_NAME + " WHERE status='" + status + "'  and  " + COL_NOM_D_UTILISATEUR + "=? AND " + COL_MOT_DE_PASSE + "=sha1(?)";

    public static final String FIND_ALL = "SELECT * FROM " + TABLE_NAME + " ' ORDER BY " + COL_ID + " DESC ";

    //public static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_NOM_D_UTILISATEUR + "=?, " + COL_MOT_DE_PASSE + "=?, " + COL_ROLE + "=?  WHERE " + COL_ID + "=?";

    public static final String FIND_ALL_BY_ROLE = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ROLE + "=? ORDER BY " + COL_ID + " DESC ";

}
