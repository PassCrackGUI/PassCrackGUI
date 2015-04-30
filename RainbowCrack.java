/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import static toolkit.Toolkit.CommandsExecute;

/**
 *
 * @author root
 */
public class RainbowCrack {
   
    //Default File of RainbowTable ->/usr/share/rainbowcrack/sha1_loweralpha-numeric#1-4_0_3800x54432_0.rt
    
    public static String RainbowCrackFileAttack (String RainbowFile, String HashFile){
        
        String command = Interface.PATH_RC + " " + RainbowFile + " -l " +HashFile ; 
        String s = CommandsExecute(command);
        
        return s;
    }
    
    public static String GetC_RainbowCrackFileAttack (String RainbowFile, String HashFile){
        
        String command = Interface.PATH_RC + " " + RainbowFile + " -l " +HashFile ; 
        return command;
    }
    
    
    public static String RainbowCrackSingleHashAttack (String RainbowFile, String Hash){
        
        String command = Interface.PATH_RC + " " + RainbowFile + " -h " +Hash ; 
        String s = CommandsExecute(command);
        
        return s;
    } 
    
}
