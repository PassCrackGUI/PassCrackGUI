package toolkit;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
//import toolkit.Interface.ButtonJohnTheRipper;



public class History {
    
    public static ArrayList <History_profile> H_p = new ArrayList<History_profile> ();  

public static void GetHistory(){

    try {
        File file = new File("HistoryFile");
        if(!file.exists()){
           file = new File("HistoryFile");
            String content ="23-4-2015   15:28:35\n" +
                            "yes;yes;yes;yes\n" +
                            "yes;yes;no\n" +
                            "no\n" +
                            "no\n" +
                            "yes;10;yes;yes;yes;yes;no\n" +
                            "/root/Desktop/links_toolkit.txt\n" +
                            "\n" +
                            "Simple_test";
            Toolkit.CreateFile("HistoryFile", content);
        }
              
          
        BufferedReader input = new BufferedReader(new FileReader(file));
        
        String line;
        String Date;
        String JTRL;
        String HashcatL;
        String RainbowCrackL;
        String RTL;
        String MaskL;
        String wordlist;
        String RainbowTable;
        String Name;
           
        String[] JTR_Options;
        String[] Hashcat_Options;
        String[] RT_Options;
        String[] Mask_Options;
             
        boolean Hashcat;
        boolean Hashcat_wordlist;
        boolean Hashcat_BF;
        boolean JTR;
        boolean JTR_default;
        boolean JTR_wordlist;
        boolean JTR_BF;
        boolean RainbowCrack;
        boolean Mask;
        boolean Mask_UC;
        boolean Mask_lC;
        boolean Mask_digits;
        boolean Mask_SC;
        String Mask_SSC;
        int Mask_Spinner;
        boolean RT ;
        String[] RT_Others = null;
        String content = "";
        
        while((line = input.readLine())!= null){      
            content = content + line + ":::::";
        }
        
        String[] vectorContent  = content.split(":::::");
        System.out.println(vectorContent.length);
        
        for(int i=0; i < (vectorContent.length/9); i++){
            Date = vectorContent[(9*i)+0];
            JTRL = vectorContent[(9*i)+1];
            HashcatL = vectorContent[(9*i)+2];
            RainbowCrackL = vectorContent[(9*i)+3];
            RTL = vectorContent[(9*i)+4];
            MaskL = vectorContent[(9*i)+5];
            wordlist = vectorContent[(9*i)+6];
            RainbowTable = vectorContent[(9*i)+7];
            Name = vectorContent[(9*i)+8];
           
            JTR_Options = JTRL.split(";");
            Hashcat_Options = HashcatL.split(";");
            RT_Options = RTL.split(";");
            Mask_Options = MaskL.split(";");
             
            Hashcat = ConvertString_bool(Hashcat_Options[0]);
            Hashcat_wordlist = ConvertString_bool(Hashcat_Options[1]);
            Hashcat_BF = ConvertString_bool(Hashcat_Options[2]);
            JTR = ConvertString_bool(JTR_Options[0]);
            JTR_default = ConvertString_bool(JTR_Options[1]);
            JTR_wordlist = ConvertString_bool(JTR_Options[2]);
            JTR_BF = ConvertString_bool(JTR_Options[3]);
            RainbowCrack = ConvertString_bool(RainbowCrackL);
            Mask = ConvertString_bool(Mask_Options[0]);
            if (Mask){
                Mask_UC = ConvertString_bool(Mask_Options[3]);
                Mask_lC = ConvertString_bool(Mask_Options[4]);
                Mask_digits = ConvertString_bool(Mask_Options[2]);
                Mask_SC = ConvertString_bool(Mask_Options[5]);
                Mask_SSC = Mask_Options[6];
                Mask_Spinner = Integer.parseInt(Mask_Options[1]);
            }
            else{
                Mask_UC = false;
                Mask_lC = false;
                Mask_digits = false;
                Mask_SC = false;
                Mask_SSC = "";
                Mask_Spinner = 1;
            }
            
            
            RT =  ConvertString_bool(RT_Options[0]);
            if (RT){
                 RT_Others = RT_Options[1].split(":");
            }
            else{
                RT_Others = null;
            }

            H_p.add(new History_profile(i,Date, Hashcat, Hashcat_wordlist, Hashcat_BF, JTR, JTR_default, JTR_wordlist, JTR_BF, RainbowCrack, wordlist, RainbowTable, Name ,Mask, Mask_UC, Mask_lC, Mask_digits, Mask_SC, Mask_SSC, Mask_Spinner,RT,RT_Others));  
        }
    
    } catch ( IOException e ) { System.out.println(e);}
    
    
    
    
    
}
    
public static boolean ConvertString_bool(String s){

    boolean bool = false;
    
    if (s.equals("yes")){
        bool = true;
    }
    
    return bool;
}
    
    
    
public static String PrintHistory(){
     
        Date date = new Date();
        
        int day = date.getDate();
        int month = date.getMonth();
        int year = date.getYear() + 1900;
        
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
     
        String s = day +"-" +month +"-" +year +"   " +hour +":" +min +":" +sec + "\n";
        
        if (Interface.ButtonJohnTheRipper.isSelected()){
            s = s + "yes;";
            s = s + BooleanPrint(JTR_Options.CB_JTR_Default.isSelected()) + ";";   
            s = s + BooleanPrint(JTR_Options.CB_JTR_Dic.isSelected()) + ";"; 
            s = s + BooleanPrint(JTR_Options.CB_JTR_BF.isSelected()) + "\n"; 
        }else{
            s = s + "no;no;no;no\n"; 
        }
            
        if (Interface.ButtonHashcat.isSelected()){
            s = s + "yes;";
            s = s + BooleanPrint(Hashcat_Options.CB_HASHCAT_Dic.isSelected()) + ";";
            s = s + BooleanPrint(Hashcat_Options.CB_HASHCAT_BF.isSelected()) + "\n"; 
        }
        else{
            s = s + "no;no;no\n";
        }
        
        if (Interface.ButtonRainbowCrack.isSelected()){
            s = s + "yes\n";
        }
        else{
            s = s + "no\n";
        }
        
        if(Interface.CB_RT.isSelected()){
            String tab = "yes;";
            for(int i=0;i<Interface.Table.size();i++){
                tab = tab + Interface.Table.get(i) + ":";
            }
            s = s + tab + "\n";
        }else{
            s = s + "no\n"; 
        }
        
        if(Interface.CBox_Mask.isSelected()){
            s = s + "yes;";
            if(Interface.Spinner_MAX.isEnabled()){
                s = s + Interface.Spinner_MAX.getValue() + ";";
            }
            else{
                s = s + "0;";
            }
                s = s + BooleanPrint(Interface.CBox_digit.isSelected()) + ";";
                s = s + BooleanPrint(Interface.CBox_UpperC.isSelected()) + ";";
                s = s + BooleanPrint(Interface.CBox_lowerC.isSelected()) + ";";
                s = s + BooleanPrint(Interface.CBox_SpecialC.isSelected()) + ";";
                if (Interface.CBox_SomeSC.isSelected()){
                    s = s + Interface.specialChar.getText() +"\n";
                }else{
                        s = s+ "no\n";
                }
        }
        else{
            s = s + "no\n";
        }
        
        s = s + Interface.TxtFPathDictionary.getText() + "\n";
        s = s + Interface.RainbowTableFile.getText() + "\n";
        
        s = s + "";
        
        return s;
    }
    
    public static String BooleanPrint(boolean b){
        
        String s= "";
        
        if(b){
            s= "yes";
        }
        else{
            s="no";
        }
        
        return s;
    }   
}
