/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EQIMA
 */
public class MysqlConnection {

    private static Connection instance;

    public static Connection getInstance() {
        if (instance == null) {
            try {
                String DataConfig = DatabaseConfig.getInstance().readFile();
                System.out.println("Data config===="+DataConfig);
                if (!DataConfig.equals("")) {
                    String[] Config = DataConfig.split(";");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    instance = DriverManager.getConnection(
                            // "jdbc:mysql://192.168.222.17:3306/biodb2021",
                            //"jdbc:mysql://192.168.222.17:3306/testbiodb",
                            "jdbc:mysql://"+Config[0]+":"+Config[1]+"/"+Config[2]+"",
                            Config[3],
//                            "userbio",
                            Config[4]);
//                            "lbiometrique2021@Jirama!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return instance;

    }

    public static void close() throws Exception {

        if (instance != null) {
            instance.close();
        }

    }

}
