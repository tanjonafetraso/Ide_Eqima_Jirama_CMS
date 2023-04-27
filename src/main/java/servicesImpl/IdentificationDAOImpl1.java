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
public abstract class IdentificationDAOImpl1  {

    public static final String TABLE_NAME = "identification";
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
   // public static final String INSERT = "INSERT INTO Tbl_identification(id_tbl_identification,id_auth,datetime,utilisateur_id,adresse_id,id_empreintes,score,doigt,collaborateur_id,nom_d_utilisateur,code_cms,adresse_mac,matricule) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT = "INSERT INTO identifications(adresse_mac,empreinte_id,score,doigt,collaborateur_id,auth_id,user,code_cms,matricule,pourcentage)VALUES(?,?,?,?,?,?,?,?,?,?)";

    public static final String FIND = "SELECT max(id) as maxi FROM " + TABLE_NAME +"";

    public static final String SIZE = "SELECT COUNT(*) AS nombre FROM " + TABLE_NAME ;

   // public static final String FIND_BY_USERN_PASS = "SELECT * FROM " + TABLE_NAME + " WHERE status='" + status + "'  and  " + COL_NOM_D_UTILISATEUR + "=? AND " + COL_MOT_DE_PASSE + "=sha1(?)";

    public static final String FIND_ALL = "SELECT * FROM " + TABLE_NAME + " ";

    //public static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_NOM_D_UTILISATEUR + "=?, " + COL_MOT_DE_PASSE + "=?, " + COL_ROLE + "=?  WHERE " + COL_ID + "=?";

    public static final String FIND_ALL_BY_ROLE = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ROLE + "=? ORDER BY " + COL_ID + " DESC ";

}
