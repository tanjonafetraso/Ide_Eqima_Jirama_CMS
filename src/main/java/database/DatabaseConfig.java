/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EQIMA
 */
public class DatabaseConfig {

    private String db_driver;
    private String db_url;
    private String db_name;
    private String db_user;
    private String db_password;

    private static DatabaseConfig instance;

    public static DatabaseConfig getInstance() {

        if (instance == null) {
            instance = new DatabaseConfig();
        }

        return instance;
    }

    public void init(String db_driver, String db_url, String db_name, String db_user, String db_password) {
        this.db_driver = db_driver;
        this.db_url = db_url;
        this.db_name = db_name;
        this.db_user = db_user;
        this.db_password = db_password;
    }

    public void loadProperty() throws FileNotFoundException, IOException {

        FileReader reader = new FileReader("database.properties");
        Properties p = new Properties();
        p.load(reader);

        db_driver = p.getProperty("db.driver");
        db_url = p.getProperty("db.url");
        db_name = p.getProperty("db.name");
        db_user = p.getProperty("db.user");
        db_password = p.getProperty("db.password");

    }

    public void saveProperty() throws FileNotFoundException, IOException {

        FileWriter writer = new FileWriter("database.properties");
        Properties p = new Properties();

        p.setProperty("db.driver", db_driver);
        p.setProperty("db.url", db_url);
        p.setProperty("db.name", db_name);
        p.setProperty("db.user", db_user);
        p.setProperty("db.password", db_password);

        p.store(writer, "Database Configuration");

    }

    public String getDb_driver() {
        return db_driver;
    }

    public void setDb_driver(String db_driver) {
        this.db_driver = db_driver;
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public void createFile(String ip,String port,String DBBname, String username, String password) {
        try {
            String str = ip+";"+port+";"+DBBname+";"+username+";"+password;
            BufferedWriter writer = new BufferedWriter(new FileWriter("DataConfig.txt"));
            writer.write(str);

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String readFile() {
         String data="";
        try {
            File myObj = new File("DataConfig.txt");
            try ( Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                     data = myReader.nextLine();
                    System.out.println(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return data;
    }
}
