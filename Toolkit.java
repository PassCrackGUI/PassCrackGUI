/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.io.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Vector;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





/**
 *
 * @author RICARDO SANTOS - UNIVERSIDADE DA BEIRA INTERIOR
 * 
 * *** PLEASE DO NOT USE THIS CODE WITHOUT PROPER REFERENCE TO THE @author****
 * 
 */

public class Toolkit {


    
    /**
     * @param args the command line arguments
     *  
     * @throws java.io.IOException
     */
     
    
    
    public static String CreateHash (String clean_text, String type) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    
        MessageDigest digest = MessageDigest.getInstance(type);

        byte[] hashedBytes = digest.digest(clean_text.getBytes("UTF-8"));
        
        return convertByteArrayToHexString(hashedBytes); 
    }
    
    
    private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return stringBuffer.toString();
	}
    
    
    
    public static Vector IdentificationHashFILE (String File) throws FileNotFoundException, IOException{
    
        Vector auxiliar = new Vector();
        
        FileInputStream stream = new FileInputStream(File);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        
        String line = br.readLine();
        
        while(line != null) {        
            String command = "python " + "Hash_ID_v1.1.py " + line;
            Vector s = CommandsExecute_HASHTYPE(command);
            for(int i=0;i<s.size();i++){
                if(!(auxiliar.contains(s.get(i)))){
                    auxiliar.add(0, s.get(i));
                }
            }
            line = br.readLine();   
        }
        
        
        
        
        return auxiliar;
    }
    
       
    public static Vector IdentificationHash (String Hash){
        
        String command = "python " + "Hash_ID_v1.1.py " + Hash;
        Vector s = CommandsExecute_HASHTYPE(command);
        
        return s;
    }
    
    
    public static String CommandsExecuteTL (String command){
        
        String s = "";
        String all = "";
        
                
        try { 
 
            Process p = Runtime.getRuntime().exec(command);
             
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                    all = all + "\n" + s;
            }
             
        }
        catch (IOException e) {
            System.out.println("----ATENTION----:ERROR:  ");
            System.exit(-1);
        }
        return all;
    }
    
    
    
    public static String CommandsExecute (String command){
        
        String s = "";
        String all = "";
        
                
        try { 
 
            Process p = Runtime.getRuntime().exec(command);
             
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
   
            
            // read the output from the command
            // Here is the standard output of the command
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                    all = all + "\n" + s;
            }
                   
            // read any errors from the attempted command
           //Here is the standard error of the command (if any)
           //
            while ((s = stdError.readLine()) != null) {
                System.out.println(s); 
                    all = all + "\n" + s;             
            }
            
             
        }
        catch (IOException e) {
            System.out.println("----ATENTION----:ERROR:  ");
            System.exit(-1);
        }
        return all;
    }
   
    public static void CreateFile(String filepath, String content){

        try {
          File file = new File(filepath);
          if(file.exists()){
              file.delete();
              file = new File(filepath);
          }
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(content);
          output.close();
            
        } catch ( IOException e ) { System.out.println(e);}
    }
 
    
    public static void CreateFileHistory(String filepath, String content){

        try {
          File file = new File(filepath);
          
          BufferedReader input = new BufferedReader(new FileReader(file));
          
          String line="";
          String read = "";
          while((line = input.readLine())!= null){
            read = read + line + "\n";
          }
          //System.out.println(read);
          
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(read);
          output.write(content);
          input.close();
          output.close();
            
        } catch ( IOException e ) { System.out.println(e);}
    }
    
    
    public static Vector CommandsExecute_HASHTYPE (String command){
        
        String s = null;
        Vector all = new Vector();
        
                
        try { 
 
            Process p = Runtime.getRuntime().exec(command);
             
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
    
            
            // read the output from the command
            // Here is the standard output of the command
            int i=0;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                    all.add(i, s);
                    i++;
            }
                   
             
        }
        catch (IOException e) {
            System.out.println("----ATENTION----:ERROR:  ");
            System.exit(-1);
        }
        return all;
    }
    
    
}
