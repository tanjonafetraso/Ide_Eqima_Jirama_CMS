/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import models.Collaborateur;
import models.Utilisateur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import services.LoginService;

/**
 *
 * @author eqima
 */
public class PostRequestLogin {
    // private static final String URL_DEFEAULT = "http://192.168.222.17/api/employe/jde?q=";

    public static LoginService Post_One_Login(String username, String passeword) {
        LoginService logS = null;

        // ArrayList<LoginService> LoginSrvc = new ArrayList<>();
        try {

            URL url = new URL("http://192.168.222.17/api/login?username=" + username + "&password=" + passeword + "");
            System.out.println("URL:" + url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();
            String inline = "";
            String res = "";
            if (responsecode != 200) {
                System.out.println("erreur detecter");
                throw new RuntimeException("HttpResponseCode: " + responsecode);

            } else {
                //open the stream and put it into BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((inline = br.readLine()) != null) {
                    res += inline;
                    System.out.println(inline);
                }
                br.close();

                System.out.println("Done");

            }

            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(res);
            String test = data_obj.get("success").toString().trim();
            if (!"true".equals(test)) {
                logS = new LoginService(data_obj.get("success").toString().trim());
            } else {
                String id = "";
                String nameUser = "";
                String nom = "";
                String prenom = "";
                String codeCms = "";
                String role = "";
                String user = data_obj.get("user").toString().trim();
                JSONObject data_obj_User = (JSONObject) parse.parse(user);

                if (data_obj_User.get("firstname") == null) {
                    nom = "null";
                } else {
                    nom = data_obj_User.get("firstname").toString().trim();
                }
                if (data_obj_User.get("lastname") == null) {
                    prenom = "null";
                } else {
                    prenom = data_obj_User.get("lastname").toString().trim();
                }
                if (data_obj_User.get("codeCms") == null) {
                    codeCms = "null";
                } else {
                    codeCms = data_obj_User.get("codeCms").toString().trim();
                }
                if (data_obj_User.get("role") == null) {
                    role = "null";
                } else {
                    role = data_obj_User.get("role").toString().trim();
                }
                id = data_obj_User.get("id").toString().trim();
                nameUser = data_obj_User.get("username").toString().trim();

               
                Utilisateur userlog = new Utilisateur(Integer.valueOf(id), nameUser, nom, prenom, codeCms, role);
                logS = new LoginService(data_obj.get("success").toString().trim(), userlog);

            }
            System.out.println(res);

//            for (int i = 0; i < array_obj.size(); i++) {
//                JSONObject objectResult = (JSONObject) array_obj.get(i);
//
//                LoginSrvc.add(
//                        new LoginService(
//                                objectResult.get("success").toString().trim()
//                        )
//                );
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return logS;
    }

}
