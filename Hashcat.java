/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import static toolkit.Toolkit.CommandsExecute;
import static toolkit.Toolkit.CommandsExecuteTL;

/**
 *
 * @author root
 */
public class Hashcat {
    
    
    public static String HashcatHashType (String hashtype){
    
        String s = null;
        
        switch (hashtype) {
            case "MD5":  s = "0";
                     break;
            case "SHA-1":  s = "100";
                     break;
            case "GOST R 34.11-94": s="6900";
                    break;
            case "Domain Cached Credentials - MD4(MD4(($pass)).(strtolower($username)))": s="1100";
                    break;
            case "MD5(Middle)": s="5100";
                    break;
            case "MD5(phpBB3)": s="400";
                    break;
            case "MD5(Unix)" : s ="500";
                    break;
            case "MD5(Wordpress)": s="400";
                    break;
            case "MD5(APR)": s="1600";
                break;
            case "MD4": s="900";
                break;
            case "NTLM": s="1000";
                break;
            case "RAdmin v2.x": s="9800";
                break;
            case "md5($pass.$salt)": s="10";
                break;
            case "md5($salt.$pass)": s="20";
                break;
            case "md5($salt.$pass.$salt)": s="3810";
                break;
            case "md5($salt.md5($pass))": s="3710";
                break; 
            case "md5($salt.md5($pass.$salt))": s="4110";
                break;
            case "md5($salt.md5($salt.$pass))": s="4010";
                break;
            case "md5($username.0.$pass)": s="4210";
                break; 
            case "md5(md5($pass).md5($salt))": s="3910";
                break;
            case "md5(md5($salt).$pass)": s="3610";
                break;
            case "md5(md5(md5($pass)))": s="3500";
                break;
            case "md5(sha1($pass))": s="4400";
                break;
            case "md5(strtoupper(md5($pass)))": s="4300";
                break; 
            case "SHA-1(HMAC)": s="7300";
                break;
            case "sha1($pass.$salt)": s="110";
                break;
            case "sha1($salt.$pass)": s="120";
                break;
            case "sha1(md5($pass))": s="4700";
                break;
            case "sha1(sha1(sha1($pass)))": s="4600";
                break;
            case "SHA-1(Django)": s="124";
                break;
            case "SHA-256": s="1400";
                break;
            case "SHA-256(Django)": s="10000";
                break;
            case "SHA-512": s="1700";
                break;
            case "MySQL": s="200";
                break;
            default : s="not found";
                break;

                
        }
        
        return s;
    }
    
    
    public static String HashcatTipeChar (String type_char) {
        
        String s = "";
        
        switch (type_char) {
            case "1000":  s = "?d";
                     break;
            case "0010": s= "?u";
                    break;
            case "0100": s= "?l";
                    break;
            case "0001": s= "?s";
                    break;
            case "1111": s= "?a";
                    break;
            case "0110":  s = "-1 ?l?u ?1";
                     break;    
            case "1010": s= "-1 ?u?d ?1";
                    break;
            case "1100": s= "-1 ?l?d ?1";
                    break;
            case "0011": s= "-1 ?u?s ?1";
                    break;
            case "0101": s= "-1 ?l?s ?1";
                    break;
            case "1001": s= "-1 ?d?s ?1";
                    break;
            case "1110": s= "-1 ?u?l?d ?1";
                    break;
            case "0111": s= "-1 ?u?l?s ?1";
                    break;
            case "1011": s= "-1 ?u?d?s ?1";
                    break;
            case "1101": s= "-1 ?l?d?s ?1";
                    break;
            case "0000": s = "-1  ?1";
                    break;
            
            default : s="invalid";
                break;               
        }
        
        return s;
    }
    
    
    public static String HashcatWordlistAttacak (String hashtype, String hashfile, String wordlist){
        String s="";
        
        String command= Interface.PATH_Hashcat + " "  + "-m" + hashtype + " " + hashfile + " " + wordlist;
        s = CommandsExecute(command);
        Interface.Password_Cracked = Interface.Password_Cracked + HashcatShow(hashfile,hashtype) + "\n";
        
        return s;
    }
    
    
    public static String GetC_HashcatWordlistAttacak (String hashtype, String hashfile, String wordlist){
        
        String command= Interface.PATH_Hashcat + " "  + "-m" + hashtype + " " + hashfile + " " + wordlist;
        
        return command;
    }
    
    
    
    public static String HashcatBruteForceAttack (String hashtype, String charformat, int Max_length, String hashfile, String someSC){
    
        String command = Interface.PATH_Hashcat + " "  + "-m" +hashtype + " -a3 "+hashfile + " ";
        String s = "";
       
        
        if (charformat.length()<3){
            if(someSC.length()!= 0){
                charformat = "?1 " + charformat + someSC + " ?1"; 
           
                 for(int i=0;i<Max_length;i++){
                    if(i==0){
                        command = command + charformat;
                    }
                    else{
                        command = command + "?1";
                    }
                }
            }
            else{
                for(int i=0;i<Max_length;i++){
                    command = command + charformat;
                }
            }
        }
        else{
            if(someSC.length()!= 0){
               charformat = charformat.replace(" ?1", someSC) + " ?1";
               s = s+ charformat;
            }
            for(int i=0;i<Max_length;i++){
                if(i==0){
                    command = command + charformat;
                }
                else{
                    command = command + "?1";
                }
            }
        }

        
        s = s + charformat + CommandsExecute(command);
        Interface.Password_Cracked = Interface.Password_Cracked + HashcatShow(hashfile,hashtype) + "\n";
        
        return s;
    }
    
    
    
    
    public static String GetC_HashcatBruteForceAttack (String hashtype, String charformat, int Max_length, String hashfile, String someSC){
    
        String command = Interface.PATH_Hashcat + " "  + "-m" +hashtype + " -a3 "+hashfile + " ";
        String s = "";
       
        
        if (charformat.length()<3){
            if(someSC.length()!= 0){
                charformat = "?1 " + charformat + someSC + " ?1"; 
           
                 for(int i=0;i<Max_length;i++){
                    if(i==0){
                        command = command + charformat;
                    }
                    else{
                        command = command + "?1";
                    }
                }
            }
            else{
                for(int i=0;i<Max_length;i++){
                    command = command + charformat;
                }
            }
        }
        else{
            if(someSC.length()!= 0){
               charformat = charformat.replace(" ?1", someSC) + " ?1";
               s = s+ charformat;
            }
            for(int i=0;i<Max_length;i++){
                if(i==0){
                    command = command + charformat;
                }
                else{
                    command = command + "?1";
                }
            }
        }
        
        return command;
    }
    
    
    
    
    public static String HashcatShow(String hashfile, String hashtype){
    
        String command = Interface.PATH_Hashcat + " "  + "-m" +hashtype + " --show " +hashfile;
        String s = CommandsExecute(command) + "\n\n";
        
        return s;
    }
    
    
    public static String TableLookup(String Dictionary, String Table){
    
        String command = Interface.PATH_Hashcat + " "  + "-a5 -t" + Table + " --stdout " + Dictionary ;
        String s = CommandsExecuteTL(command);
        
        return s;
    }
    
    
    public static String GetC_TableLookup(String Dictionary, String Table){
    
        String command = Interface.PATH_Hashcat + " "  + "-a5 -t" + Table + " --stdout " + Dictionary ;
        
        return command;
    }

}
