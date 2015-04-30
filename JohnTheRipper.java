/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static toolkit.Toolkit.CommandsExecute;

/**
 *
 * @author root
 */
public class JohnTheRipper {
    
    
    public static String JohnRipperTipeChar (String type_char) {
        
        String s = null;
        
        switch (type_char) {
            case "1000":  s = "digits";
                     break;
            case "0010": s= "alpha";
                    break;
            case "0100": s= "alpha";
                    break;
            case "0001": s= "?s";
                    break;
            case "1111": s= "all";
                    break;
            case "0110":  s = "alpha";
                     break;    
            case "1010": s= "all";
                    break;
            case "1100": s= "all";
                    break;
            case "0011": s= "all";
                    break;
            case "0101": s= "all";
                    break;
            case "1001": s= "all";
                    break;
            case "1110": s= "all";
                    break;
            case "0111": s= "all";
                    break;
            case "1011": s= "all";
                    break;
            case "1101": s= "all";
                    break;
            
            default : s="invalid";
                break;               
        }
        
        return s;
    }
 
    
    
    public static String JohnRipperCrack (String file_to_crack) {

        String s = "";
        
        try {
            File file = new File(file_to_crack);
            BufferedReader input = new BufferedReader(new FileReader(file));
            
            String command_Crack = "";
            String line;
            
            while((line = input.readLine())!= null){ 
                Toolkit.CreateFile("crackTemp", line);
                command_Crack =  Interface.PATH_JTR + " " + "crackTemp";
                s = s + CommandsExecute (command_Crack);
                Interface.Password_Cracked = Interface.Password_Cracked + line + "  ->" + JohnRipperShow("crackTemp") + "\n";
            }
        } catch ( IOException e ) { System.out.println(e);}
        
        return s;
    }
    
    public static String GetC_JohnRipperCrack (String file_to_crack) {
        
        String command= Interface.PATH_JTR + " " +file_to_crack;
        
        return command;
    }
    
    
    public static String JohnRipperDictionary (String wordlist, String file_to_crack) {
        
        String s = "";
        
        try {
            File file = new File(file_to_crack);
            BufferedReader input = new BufferedReader(new FileReader(file));
            
            String command_Crack = "";
            String line;
            
            while((line = input.readLine())!= null){ 
                Toolkit.CreateFile("crackTemp", line);
                command_Crack =  Interface.PATH_JTR + " " + "--wordlist=" + wordlist +" " + "crackTemp";
                s = s + CommandsExecute (command_Crack);
                Interface.Password_Cracked = Interface.Password_Cracked + line + "  ->" + JohnRipperShow("crackTemp") + "\n";
            }
        } catch ( IOException e ) { System.out.println(e);}
        
        return s;
    }
    
    public static String GetC_JohnRipperDictionary (String wordlist, String file_to_crack) throws IOException {

        String command= Interface.PATH_JTR + " " + "--wordlist=" +wordlist +" " +file_to_crack;
        
        return command;
    }
    
    
    public static String JohnRipperShow(String file){
    
        String command_Show =Interface.PATH_JTR + " "  + "--show " +file;
        String s = CommandsExecute(command_Show);
    
        return s;
    }
    
    
    public static String JohnRipperBruteForce (String tipe_char, String file_to_crack){
        
        String s = "";
        
        try {
            File file = new File(file_to_crack);
            BufferedReader input = new BufferedReader(new FileReader(file));
            
            String command_Crack = "";
            String line;
            
            while((line = input.readLine())!= null){ 
                Toolkit.CreateFile("crackTemp", line);
                command_Crack = Interface.PATH_JTR + " " + "--incremental=" +tipe_char + " " + "crackTemp";
                s = s + CommandsExecute (command_Crack);
                Interface.Password_Cracked = Interface.Password_Cracked + line + "  ->" + JohnRipperShow("crackTemp") + "\n";
            }
        } catch ( IOException e ) { System.out.println(e);}
        
        return s;
    }
    
    public static String GetC_JohnRipperBruteForce (String tipe_char, String file_to_crack){
    
        String command = Interface.PATH_JTR + " " + "--incremental=" +tipe_char + " " + file_to_crack;
        
        return command;
    }
    
    
    
    public static String JohnRipperSingle (String tipe_char, String file_to_crack){
        String s = "";
        String command_SingleAttack =Interface.PATH_JTR + " "  + "--single " +file_to_crack;
        s = s + CommandsExecute(command_SingleAttack);
        
        Interface.Password_Cracked = Interface.Password_Cracked + JohnRipperShow(file_to_crack) + "\n";
        
        return s;
    }
}
