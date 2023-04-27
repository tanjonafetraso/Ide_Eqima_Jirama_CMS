 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Collaborateur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;

/**
 *
 * @author EQIMA
 */
public class GetRequest {

    private static final String URL_DEFEAULT = "http://192.168.222.17/api/employe/jde?q=";

    public static List<Collaborateur> GetRequestArray(String id) {
        
        ArrayList<Collaborateur> collaborateurs = new  ArrayList<>();
        
        try {

            URL url = new URL(URL_DEFEAULT+id);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();
            String inline = "";
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();
            }
            
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);
            
            JSONArray array_obj = (JSONArray) data_obj.get("results");

            for (int i = 0; i < array_obj.size(); i++) {
                JSONObject objectResult = (JSONObject) array_obj.get(i);
                
                collaborateurs.add(
                
                        new Collaborateur(
                                objectResult.get("matricule").toString().trim(),
                                objectResult.get("nom").toString().trim(),
                                objectResult.get("datenais").toString().trim(),
                                objectResult.get("typepat").toString().trim()
                                
                        )
                
                );
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return collaborateurs;
    }


    
}
