/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import static toolkit.Hashcat.HashcatShow;
import static toolkit.Toolkit.CommandsExecute;

/**
 *
 * @author root
 */
public class Crunch {
    
    
    public static void CreateWordlist(String FileName, String char_list, int min, int max){
    
        String command= Interface.PATH_Crunch + " "  +  + min + " " + max + " "+  char_list + " -o " + FileName;
        CommandsExecute(command);

    }
    
}
