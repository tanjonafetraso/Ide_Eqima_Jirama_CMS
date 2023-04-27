/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author EQIMA
 */
public class Adresse {
    
    private int id;
    private String adresse_mac;
    
    public static String getClasseName(){
    
        return "Adresse";
    
    }

    public Adresse() {
    }

    public Adresse(String adresse_mac) {
        this.id = 0;
        this.adresse_mac = adresse_mac;
    }

    public Adresse(int id, String adresse_mac) {
        this.id = id;
        this.adresse_mac = adresse_mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getAdresse_mac() {
        return adresse_mac;
    }

    public void setAdresse_mac(String adresse_mac) {
        this.adresse_mac = adresse_mac;
    }
    
    public static String getCurrentAdressseMac(){    
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
              
            
            return sb.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
