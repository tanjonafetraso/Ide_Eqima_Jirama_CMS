/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import models.Utilisateur;

/**
 *
 * @author eqima
 */
public class LoginService {
private String Resultat;
private Utilisateur user;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public LoginService(String Resultat, Utilisateur user) {
        this.Resultat = Resultat;
        this.user = user;
    }

    public LoginService(String Resultat) {
        this.Resultat = Resultat;
    }

    public String getResultat() {
        return Resultat;
    }

    public void setResultat(String Resultat) {
        this.Resultat = Resultat;
    }


}
