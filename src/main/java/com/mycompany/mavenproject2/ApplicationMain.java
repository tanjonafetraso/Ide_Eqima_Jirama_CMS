/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;


import java.io.IOException;
import jframes.*;
import javax.script.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
/**
 *
 * @author EQIMA
 */
public class ApplicationMain {
    
    public static void main(String[] args) throws Exception {

       AuthentificationJFrame.getInstance().showFrame();
       /* ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
             
            String script = "window.open('http://192.168.222.17/api/employe/fiche?m=103600&t=0')";
            WebDriver driver= new EdgeDriver();
           JavascriptExecutor js =(JavascriptExecutor)driver;
           js.executeScript(script);*/
	 
    }
       
    
}
