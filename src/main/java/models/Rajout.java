package models;

/**
 *
 * @author EQIMA
 */
public class Rajout {
   
    
    private int id;
    private int id_empreintes;
    private int id_authentifications;
    private int score;
    private String type_action;
  
    public Rajout() {
    }

    public Rajout(int n, int m,int r,int s,String ac) {
        this.id = n;
        this.id_empreintes = m;
        this.id_authentifications = r;
        this.score =s ;
        this.type_action = ac;
    }

   public Rajout( int m,int r,int s,String ac) {
     
        this.id_empreintes = m;
        this.id_authentifications = r;
        this.score =s ;
        this.type_action = ac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_action() {
        return type_action;
    }

    public void setType_action(String id) {
        this.type_action = id;
    }

public int getScore() {
        return score;
    }

    public void setScore(int id) {
        this.score= id;
    }

    public int getId_empreintes() {
        return id_empreintes;
    }

    public void setId_empreintes(int nom_d_utilisateur) {
        this.id_empreintes = nom_d_utilisateur;
    }

    public int getId_authentifications() {
        return id_authentifications;
    }

    public void setId_authentifications(int mot_de_passe) {
        this.id_authentifications = mot_de_passe;
    }
       
}