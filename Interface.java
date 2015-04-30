/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 *
 * @author root
 */

public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public String pathFileDictionary = "/usr/share/john/password.lst";
    public String pathFileRainbowTable = "/usr/share/rainbowcrack/sha1_loweralpha-numeric#1-4_0_3800x54432_0.rt";
    public static String pathNewWordlist = "";
    
    public String pathFileHash;
    public Vector hashtype = new Vector();
    public Vector hashSelect = new Vector();
    public static Vector Table = new Vector();
    
    public static String Commands_list = "";
    
    public static String Password_Cracked = "";
    
    public static String PATH_JTR ="" ;                   
    public static String PATH_Hashcat ="";                 
    public static String PATH_RC ="";                   
    public static String PATH_Crunch ="";  
    
    ArrayList Help_List = new ArrayList();
    
    public Interface() {
        Help_List.add("\t    Please, Select an Option:\n\n-> You can choose the first Option to introduce a password in Clean Text.\n-> The middle option to insert a text document with multiple hash's.\n->  You can also choose the bottom option to insert a single hash.\n");
        //interface.getContentPane().setBackground(Color.white);
        initComponents(); 
    }
    
    
    
    
    static W_EditCommands p_W_EC = new W_EditCommands() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class Listener_W_EC implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_W_EC.setOpaque(false);
            p_W_EC.setLayout(new GridBagLayout());
            setGlassPane(p_W_EC);
            p_W_EC.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_W_EC.setVisible(true);
            
        }
    }
    
    
    
    static NewWordlist p_NewWordlist = new NewWordlist() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
 

    
    static History_Save p_HistorySave = new History_Save() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class Listener_HistorySave implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_HistorySave.setOpaque(false);
            p_HistorySave.setLayout(new GridBagLayout());
            setGlassPane(p_HistorySave);
            p_HistorySave.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_HistorySave.setVisible(true);
        }
    }
    
    
    static Edit_Console p_EditConsole = new Edit_Console() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class Listener_EditConsole implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_EditConsole.setOpaque(false);
            p_EditConsole.setLayout(new GridBagLayout());
            setGlassPane(p_EditConsole);
            p_EditConsole.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_EditConsole.setVisible(true);
        }
    }
    
    
    
    static Path p_path = new Path() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class Listener_path implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_path.setOpaque(false);
            p_path.setLayout(new GridBagLayout());
            setGlassPane(p_path);
            p_path.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_path.setVisible(true);
        }
    }
    
    
    
    
    
    static History_Table p_HistoryTable = new History_Table() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class Listener_HistoryTable implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_HistoryTable.setOpaque(false);
            p_HistoryTable.setLayout(new GridBagLayout());
            setGlassPane(p_HistoryTable);
            p_HistoryTable.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_HistoryTable.setVisible(true);
        }
    }
    

    
    
    static JTR_Options p_JTR = new JTR_Options() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    
    public class ListenerOpenJTR_Options implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_JTR.setOpaque(false);
            p_JTR.setLayout(new GridBagLayout());
            setGlassPane(p_JTR);
            p_JTR.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_JTR.setVisible(true);
        }
    }
    





    
    static Hashcat_Options p_Hashcat = new Hashcat_Options() {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0,135));
            g.fillRect(0, 0, getWidth(), getHeight());    
        }
    };
    
    public class ListenerOpenHashcat_Options implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent ae) {
            p_Hashcat.setOpaque(false);
            p_Hashcat.setLayout(new GridBagLayout());
            setGlassPane(p_Hashcat);
            p_Hashcat.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });
            
            p_Hashcat.setVisible(true);
        }
    }
    
    
    
    
    public static class ListenerMask implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(JTR_Options.CB_JTR_BF.isSelected() || Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                CBox_Mask.setEnabled(true);
                if(CBox_Mask.isSelected()){
                    if(Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                        CBox_SomeSC.setEnabled(true);
                    }
                    else{
                        CBox_SomeSC.setEnabled(false);
                        CBox_SomeSC.setSelected(false);
                        specialChar.setEnabled(false);
                    }
                    Spinner_MAX.setEnabled(true);
                    CBox_digit.setEnabled(true);
                    CBox_lowerC.setEnabled(true);
                    CBox_UpperC.setEnabled(true);
                    CBox_SpecialC.setEnabled(true);
                    jLabel6.setEnabled(true);
                    
                    if(CBox_SomeSC.isSelected()){
                        specialChar.setEnabled(true);
                    }
                    else{
                        specialChar.setEnabled(false);
                    }
                }
            }
            else{
                CBox_Mask.setEnabled(false);
                Spinner_MAX.setEnabled(false);
                CBox_digit.setEnabled(false);
                CBox_lowerC.setEnabled(false);
                CBox_UpperC.setEnabled(false);
                CBox_SpecialC.setEnabled(false);
                CBox_SomeSC.setEnabled(false);
                jLabel6.setEnabled(false);
                specialChar.setEnabled(false);
            }
        }
    }
    
    
    public class ListenerHistoryButton implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()){
                HistoryButton.setEnabled(true);
                SaveButton.setEnabled(true);
            }
            else{
                HistoryButton.setEnabled(false);
                SaveButton.setEnabled(false);
            }
        }
    }
    
    
    
    public class ListenerSpecialChar implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(CBox_SomeSC.isSelected()){
                specialChar.setEnabled(true);
            }
            else{
                specialChar.setEnabled(false);
            }
        }
    }
    
    public class ListenerVerifyHash implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(jRadioButton1.isSelected() || jRadioButton2.isSelected()){
                jButton1.setEnabled(true);
            }
            else{
                jButton1.setEnabled(false);
            }
        }
    }
    
    
    
    
    public class ListenerJTR implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(ButtonJohnTheRipper.isSelected()){
                Button_Edit_JTR.setEnabled(true);
                JTR_Options.CB_JTR_Default.setSelected(true);
            }
            else {
                Button_Edit_JTR.setEnabled(false);
                JTR_Options.CB_JTR_Default.setSelected(false);
                JTR_Options.CB_JTR_BF.setSelected(false);
                JTR_Options.CB_JTR_Dic.setSelected(false);
            }
        }
    }
    
    public static class ListenerJTR_BOX implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(JTR_Options.CB_JTR_Default.isSelected() || JTR_Options.CB_JTR_Dic.isSelected() ||JTR_Options.CB_JTR_BF.isSelected()){
                ButtonJohnTheRipper.setSelected(true);
                Button_Edit_JTR.setEnabled(true);
            }
            else {
                Button_Edit_JTR.setEnabled(false);
                ButtonJohnTheRipper.setSelected(false);
                buttonGroup1.clearSelection();
                jLabel5.setEnabled(false);
                jComboBox3.setEnabled(false);
                Open1.setEnabled(false);
                jButton1.setEnabled(false);
                list_hash.setEnabled(false);
                list_hashSelect.setEnabled(false);
                jLabel7.setEnabled(false);
                button_hashtype.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                
            }
        }
    }
     
    
    
    public class ListenerHASHCAT implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(ButtonHashcat.isSelected()){
                Button_Edit_Hashcat.setEnabled(true);
                Hashcat_Options.CB_HASHCAT_Dic.setSelected(true);
            }
            else {
                Button_Edit_Hashcat.setEnabled(false);
                Hashcat_Options.CB_HASHCAT_BF.setSelected(false);
                Hashcat_Options.CB_HASHCAT_Dic.setSelected(false);
                
            }
        }
    }
    
    
    public static class ListenerHASHCAT_BOX implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(Hashcat_Options.CB_HASHCAT_Dic.isSelected() || Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                ButtonHashcat.setSelected(true);
                Button_Edit_Hashcat.setEnabled(true);
            }
            else {
                Button_Edit_Hashcat.setEnabled(false);
                ButtonHashcat.setSelected(false);
                buttonGroup1.clearSelection();
                jLabel5.setEnabled(false);
                jComboBox3.setEnabled(false);
                Open1.setEnabled(false);
                jButton1.setEnabled(false);
                list_hash.setEnabled(false);
                list_hashSelect.setEnabled(false);
                jLabel7.setEnabled(false);
                button_hashtype.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
            }
        }
    }
    
    public class ListenerProp_JTR implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(ButtonJohnTheRipper.isSelected()){
                Popup_JTH.setVisible(true);
            }
            else{
                specialChar.setVisible(false);
            }
        }
    }
    
    
    public class ListenerActiveHash implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()){
                ButtonJohnTheRipper.setEnabled(true);
                ButtonHashcat.setEnabled(true);
                ButtonRainbowCrack.setEnabled(true);

                        
            }
            else{
                ButtonJohnTheRipper.setEnabled(false);
                ButtonHashcat.setEnabled(false);
                ButtonRainbowCrack.setEnabled(false);
                CleanText.setEnabled(false);
                jLabel5.setEnabled(false);
                jComboBox3.setEnabled(false);
                buttonGroup1.clearSelection();
                Open1.setEnabled(false);
                jTextField1.setEnabled(false);
                jTextArea1.setEnabled(false);
                jButton1.setEnabled(false);
                list_hash.setEnabled(false);
                list_hashSelect.setEnabled(false);
                jLabel1.setEnabled(false);
                jLabel7.setEnabled(false);
                button_hashtype.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
            }
        }
    }
    
    
    public static class ListenerOpenDictionary implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(JTR_Options.CB_JTR_Dic.isSelected() || Hashcat_Options.CB_HASHCAT_Dic.isSelected()){
                Open.setEnabled(true);
                TxtFPathDictionary.setEnabled(true);
                jLabel2.setEnabled(true);
            }
            else{
                Open.setEnabled(false);
                jLabel2.setEnabled(false);
                TxtFPathDictionary.setEnabled(false);
                TxtFPathDictionary.setText("");
            }
        }
    }
    
    
    public class ListenerOpenRainbowTable implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(ButtonRainbowCrack.isSelected()){
                Open2.setEnabled(true);
                RainbowTableFile.setEnabled(true);
                jLabel4.setEnabled(true);
            }
            else{
                Open2.setEnabled(false);
                jLabel4.setEnabled(false);
                RainbowTableFile.setEnabled(false);
                RainbowTableFile.setText("");
            }
        }
    }
    
    
    public class ListenerEnabledVerifyHash implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(jRadioButton1.isSelected() || jRadioButton2.isSelected()){
                jTabbedPane1.setVisible(true);
            }
            else{
                jTabbedPane1.setVisible(false);
            }
        }
    }
    
    public class ListenerClear implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            jTabbedPane1.setVisible(false);
            list_hash.setEnabled(false);
            list_hashSelect.setEnabled(false);
            jLabel1.setEnabled(false);
            jLabel7.setEnabled(false);
            jButton1.setEnabled(false);
            button_hashtype.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            
            ButtonJohnTheRipper.setSelected(false);
            ButtonJohnTheRipper.setEnabled(false);
            Button_Edit_JTR.setEnabled(false);
            ButtonHashcat.setSelected(false);
            ButtonHashcat.setEnabled(false);
            Button_Edit_Hashcat.setEnabled(false);
            ButtonRainbowCrack.setEnabled(false);
            
            TxtFPathDictionary.setText("");
            TxtFPathDictionary.setEnabled(false);
            Open.setEnabled(false);
            jLabel2.setEnabled(false);
            
            RainbowTableFile.setText("");
            RainbowTableFile.setEnabled(false);
            Open2.setEnabled(false);
            jLabel4.setEnabled(false);
            
            CB_RT.setSelected(false);
            CB_RT.setEnabled(false);
            txt_char.setText("");
            txt_char.setEnabled(false);
            txt_rep.setText("");
            txt_rep.setEnabled(false);
            ButtonAdd.setEnabled(false);
            Buttondelete.setEnabled(false);
            List_table.setEnabled(false);
            jLabel16.setEnabled(false);
            jLabel14.setEnabled(false);
            jLabel15.setEnabled(false);
            
            
            CBox_Mask.setSelected(false);
            CBox_Mask.setEnabled(false);
            Spinner_MAX.setEnabled(false);
            Spinner_MAX.setValue(6);
            CBox_lowerC.setEnabled(false);
            CBox_lowerC.setSelected(false);
            CBox_UpperC.setEnabled(false);
            CBox_UpperC.setSelected(false);
            CBox_digit.setEnabled(false);
            CBox_digit.setSelected(false);
            CBox_SpecialC.setEnabled(false);
            CBox_SpecialC.setSelected(false);
            CBox_SomeSC.setEnabled(false);
            CBox_SomeSC.setSelected(false);
            specialChar.setText("");
            specialChar.setEnabled(false);
            jLabel6.setEnabled(false);
            
            cleanPassword.setText("");
            
            buttonGroup1.clearSelection();
            CleanText.setText("");
            CleanText.setEnabled(false);
            jComboBox3.setEnabled(false);
            jTextField1.setText("");
            jTextField1.setEnabled(false);
            Open1.setEnabled(false);
            jTextArea1.setEnabled(false);
                    
        }
    }
        
    
    
    public class ListenerUseMask implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(CBox_Mask.isSelected()){
                if(Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                    CBox_SomeSC.setEnabled(true);
                }
                else{
                    CBox_SomeSC.setEnabled(false);
                }
                Spinner_MAX.setEnabled(true);
                CBox_digit.setEnabled(true);
                CBox_lowerC.setEnabled(true);
                CBox_UpperC.setEnabled(true);
                CBox_SpecialC.setEnabled(true);
                jLabel6.setEnabled(true);
            }
            else{
                Spinner_MAX.setEnabled(false);
                CBox_digit.setEnabled(false);
                CBox_lowerC.setEnabled(false);
                CBox_UpperC.setEnabled(false);
                CBox_SpecialC.setEnabled(false);
                jLabel6.setEnabled(false);
            }
        }
    } 
    
    
    public static class ListenerUSEReplacementTable implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(( ButtonHashcat.isSelected() && Hashcat_Options.CB_HASHCAT_Dic.isSelected()) || (ButtonJohnTheRipper.isSelected() && JTR_Options.CB_JTR_Dic.isSelected())){
                CB_RT.setEnabled(true); 
            }
            else{
                CB_RT.setEnabled(false);
                jLabel14.setEnabled(false);
                jLabel15.setEnabled(false);
                jLabel16.setEnabled(false);
                txt_char.setEnabled(false);
                txt_rep.setEnabled(false);
                List_table.setEnabled(false);
                ButtonAdd.setEnabled(false);
                Buttondelete.setEnabled(false);
            }
        }
    } 
    
    
    public class ListenerCleanText implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(CleanText.getText().isEmpty()){
                }
                else{
                    try {
                        String text = Toolkit.CreateHash(CleanText.getText(),(String)jComboBox3.getSelectedItem());
                        jTextArea1.setText(text);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
    }
    
    
    public class ListenerReplacementTable implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(CB_RT.isSelected()){
                jLabel14.setEnabled(true);
                jLabel15.setEnabled(true);
                jLabel16.setEnabled(true);
                txt_char.setEnabled(true);
                txt_rep.setEnabled(true);
                List_table.setEnabled(true);
                ButtonAdd.setEnabled(true);
                Buttondelete.setEnabled(true);
            }
            else{
                jLabel14.setEnabled(false);
                jLabel15.setEnabled(false);
                jLabel16.setEnabled(false);
                txt_char.setEnabled(false);
                txt_rep.setEnabled(false);
                List_table.setEnabled(false);
                ButtonAdd.setEnabled(false);
                Buttondelete.setEnabled(false);
            }
        }
    }
    
    
    public class ListenerSelectHash implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
                if (list_hash.getSelectedValue().equals("")){
                    cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\n\nNO HASH TYPE SELECTED!!!!\n    Please, Select a hash type First!\n-------------------------------------------------------------------------\n\n\n");
                }
                else{
                    String type = Hashcat.HashcatHashType((String)list_hash.getSelectedValue());
                    String mes = null;  
                    if (type != "not found"){
                        mes = "NOTIFICATION:\n   ->The Hash code associate to the " + list_hash.getSelectedValue().toString()+ " is " +type+ " (to use in the Hashcat)";
                    }
                    else{
                        mes = "NOTIFICATION:\n   ->SORRY, But HASHCAT is not able to crack the " + list_hash.getSelectedValue().toString();
                    }
                    cleanPassword.setText(mes);
                }
	}
    }
    
    
    class DocumentListenerPATHFILE implements DocumentListener {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(TxtFPathDictionary.getText().isEmpty()){
                    exp_dictionary.setText("(If not select any file, will be use one by default)");
                    pathFileDictionary = "/usr/share/john/password.lst";
                }
                else{
                    String text = "The follow file '" + TxtFPathDictionary.getText() + "' will be use as a dictionary";
                    exp_dictionary.setText(text);
                    pathFileDictionary = TxtFPathDictionary.getText();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(TxtFPathDictionary.getText().isEmpty()){
                    exp_dictionary.setText("(If not select any file, will be use one by default)");
                    pathFileDictionary = "/usr/share/john/password.lst";
                }
                else{
                    String text = "The follow file '" + TxtFPathDictionary.getText() + "' will be use as a dictionary";
                    exp_dictionary.setText(text);
                    pathFileDictionary = TxtFPathDictionary.getText();
                }         
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(TxtFPathDictionary.getText().isEmpty()){
                    exp_dictionary.setText("(If not select any file, will be use one by default)");
                    pathFileDictionary = "/usr/share/john/password.lst";
                }
                else{
                    String text = "The follow file '" + TxtFPathDictionary.getText() + "' will be use as a dictionary";
                    exp_dictionary.setText(text);
                    pathFileDictionary = TxtFPathDictionary.getText();
                }
            }
     }
     
    
    class DocumentListenerRainbowTableFILE implements DocumentListener {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(RainbowTableFile.getText().isEmpty()){
                    //exp_RainbowTable.setText("(If not select any file, will be use one by default)");
                }
                else{
                    String text = "The follow file '" + RainbowTableFile.getText() + "' will be use as RainbowTable";
                    //exp_RainbowTable.setText(text);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(RainbowTableFile.getText().isEmpty()){
                    //exp_RainbowTable.setText("(If not select any file, will be use one by default)");
                }
                else{
                    String text = "The follow file '" + RainbowTableFile.getText() + "' will be use as RainbowTable";
                    //exp_RainbowTable.setText(text);
                }      
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(RainbowTableFile.getText().isEmpty()){
                    exp_RainbowTable.setText("(If not select any file, will be use one by default)");
                }
                else{
                    String text = "The follow file '" + RainbowTableFile.getText() + "' will be use as RainbowTable";
                    exp_RainbowTable.setText(text);
                }
            }
     }
     
    
    
    class DocumentListenerCleanText implements DocumentListener {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(CleanText.getText().isEmpty()){
                    //exp_RainbowTable.setText("(If not select any file, will be use one by default)");
                }
                else{
                    try {
                        String text = Toolkit.CreateHash(CleanText.getText(),(String)jComboBox3.getSelectedItem());
                        jTextArea1.setText(text);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(CleanText.getText().isEmpty()){
                    //exp_RainbowTable.setText("(If not select any file, will be use one by default)");
                }
                else{
                    try {
                        String text = Toolkit.CreateHash(CleanText.getText(),(String)jComboBox3.getSelectedItem());
                        jTextArea1.setText(text);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(CleanText.getText().isEmpty()){
                }
                else{
                    try {
                        String text = Toolkit.CreateHash(CleanText.getText(),(String)jComboBox3.getSelectedItem());
                        jTextArea1.setText(text);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
     }
    
    
    public class ListenerHashType implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
            if (jTextField1.isEnabled()){
                Vector s = new Vector();
                 try {
                     s = Toolkit.IdentificationHashFILE(jTextField1.getText());
                } catch (IOException ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
                list_hash.setEnabled(true);
                list_hashSelect.setEnabled(true);
                jLabel1.setEnabled(true);
                jLabel7.setEnabled(true);
                button_hashtype.setEnabled(true);
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                list_hash.setListData(s);
            }
            else{
                if (jTextArea1.isEnabled()){
                    Vector s = Toolkit.IdentificationHash(jTextArea1.getText());
                    list_hash.setEnabled(true);
                    list_hashSelect.setEnabled(true);
                    jLabel1.setEnabled(true);
                    jLabel7.setEnabled(true);
                    button_hashtype.setEnabled(true);
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(true);
                    list_hash.setListData(s);
                }
                
                else{
                    cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST INTRODUCE A HASH FIRST! It can be a file or a single hash...\n-------------------------------------------------------------------------\n\n\n"); 
                    jPanel8.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        }
            
    }
    
    
    class NewWorker_Crack extends SwingWorker<String, Integer>{
        @Override
        public String doInBackground() throws Exception{
            Crack();
            return "";
        }
        @Override
        public void done(){
            try{
                get();
            }catch (InterruptedException | ExecutionException e){
            }
        }
    }
    
    
    
    public void Execute_Crack(){
        CrackButton.setEnabled(false);
        jMenuItem2.setEnabled(false);
        NewWorker_Clean NW_Clean = new NewWorker_Clean();
        NW_Clean.execute();
        NewWorker_Crack NWC = new NewWorker_Crack();
        NWC.execute();
        Toolkit.CreateFileHistory("HistoryFile", (History.PrintHistory()+ "Automatic" +"\n"));
        //cleanPassword.setText("\n\tNotification\n\n       Your Choises has been saved...\n\n");
        History.GetHistory();
        CrackButton.setEnabled(true);
        jMenuItem2.setEnabled(true);
    }
         
    
    
public void Crack(){
    Read_Path();
    String s = "";
    String Mask= "";
    int lenght_max=0;
    
    long startTime = System.currentTimeMillis();
        
        
        
    if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected())){
        s = s + "\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST INTRODUCE A HASH! It can be a file or a single hash...\n-------------------------------------------------------------------------\n\n\n";             
    }
    else{
        
        
        if(jRadioButton2.isSelected() || jRadioButton3.isSelected()){
            pathFileHash = "HashToCrack";
            Toolkit.CreateFile(pathFileHash, jTextArea1.getText());
        }
        
        boolean Hashcat_BF  = Hashcat_Options.CB_HASHCAT_BF.isSelected(),
                Hashcat_Dic = Hashcat_Options.CB_HASHCAT_Dic.isSelected(),
                JTR_BF      = JTR_Options.CB_JTR_BF.isSelected(),
                JTR_Dic     = JTR_Options.CB_JTR_Dic.isSelected(),
                JTR_Default = JTR_Options.CB_JTR_Default.isSelected(),
                RC_Default  = ButtonRainbowCrack.isSelected();
        
        
        ListModel hash_select =  list_hashSelect.getModel();
        //System.out.println(hash_select.toString());
        
        if((list_hashSelect.getModel().getSize() == 0) && (!jRadioButton3.isSelected())){
            cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SELECT A TYPE OF HASH!\n-------------------------------------------------------------------------\n\n\n");
            list_hashSelect.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        else{
        
        if(CBox_Mask.isSelected() && CBox_Mask.isEnabled()){
            String D="0";
            String L="0";
            String U="0";
            String S="0";
            
            lenght_max = (int) Spinner_MAX.getValue();
            
            if(CBox_digit.isSelected()){D="1";}
            if(CBox_lowerC.isSelected()){L="1";}
            if(CBox_UpperC.isSelected()){U="1";}
            if(CBox_SpecialC.isSelected()){S="1";}
        
            Mask = D+L+U+S;    
        }
            
            
        // IN CASE JOHNTHERIPPER IS SELECTED AND SOME ATTACK IS SELECTED 
        if(ButtonJohnTheRipper.isSelected() && (JTR_Options.CB_JTR_Dic.isSelected() || JTR_Options.CB_JTR_Default.isSelected() || JTR_Options.CB_JTR_BF.isSelected())){
            
            //JTR DICTIONARY ATTACK
            if(JTR_Options.CB_JTR_Dic.isSelected()){
                if(CB_RT.isSelected()){
                    if(Table.isEmpty()){
                        cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SINTRODUCE SOME CONDITIONS FIRST!\n-------------------------------------------------------------------------\n\n\n");
                    }
                    String tab = "";
                    
                    for(int i=0;i<Table.size();i++){
                        tab = tab + Table.get(i) + "\n";
                    }
                    
                    Toolkit.CreateFile("Table.tab", tab);
                    String newDict = Hashcat.TableLookup(pathFileDictionary,"Table.tab");   
                    Toolkit.CreateFile("newDictionary.txt", newDict);
                    
                    pathFileDictionary = "newDictionary.txt"; 
                }
                s= s + "\n\nJohnTheRipper -> DICTIONARY ATTACK\n";
                s = s + JohnTheRipper.JohnRipperDictionary (pathFileDictionary, pathFileHash) + "\n";
            }
            
            //JTR DEFAULT ATTACK
            if(JTR_Options.CB_JTR_Default.isSelected()){
                s= s + "\n\nJohnTheRipper -> DEFAULT ATTACK\n";
                s = s + JohnTheRipper.JohnRipperCrack (pathFileHash) + "\n";
            }
            
            //JTR BRUTE FORCE ATTACK
            if(JTR_Options.CB_JTR_BF.isSelected()){
                if (Mask.equals("0000")){
                    s = s + "     ---- WARNING----  \nNO PARAMETERS INTRODUCED  IN 'USE MASK'"; 
                }
                else{
                    s= s + "\n\nJohnTheRipper -> BRUTE FORCE ATTACK\n";
                    s = s + JohnTheRipper.JohnRipperBruteForce(JohnTheRipper.JohnRipperTipeChar(Mask),pathFileHash) + "\n";
                }
            }
        }
        
        // IN CASE HASHCAT IS SELECTED AND SOME ATTACK IS SELECTED
        if(ButtonHashcat.isSelected() && (Hashcat_Options.CB_HASHCAT_Dic.isSelected()||Hashcat_Options.CB_HASHCAT_BF.isSelected())){

            //HASHCAT DICTIONARY ATTACK
            if(Hashcat_Options.CB_HASHCAT_Dic.isSelected()){
                if(CB_RT.isSelected()){
                    if(Table.isEmpty()){
                        cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SINTRODUCE SOME CONDITIONS FIRST!\n-------------------------------------------------------------------------\n\n\n");
                    }
                    String tab = "";
                    
                    for(int i=0;i<Table.size();i++){
                        tab = tab + Table.get(i) + "\n";
                    }
                    
                    Toolkit.CreateFile("Table.tab", tab);
                    String newDict = Hashcat.TableLookup(pathFileDictionary,"Table.tab");   
                    Toolkit.CreateFile("newDictionary.txt", newDict);
                    
                    pathFileDictionary = "newDictionary.txt"; 
                }
                s= s + "\n\nHASHCAT -> DICTIONARY ATTACK\n";
                if(jRadioButton3.isSelected()){
                    s = s + " FOR " + (String) jComboBox3.getSelectedItem()+ "\n\n" + Hashcat.HashcatWordlistAttacak ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())), pathFileHash, pathFileDictionary);
                }
                else{
                    for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                        s = s + " FOR " + (String) hash_select.getElementAt(i)+ "\n\n" + Hashcat.HashcatWordlistAttacak ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))), pathFileHash, pathFileDictionary);
                    }
                }
            }
            
            //HASHCAT BRUTE FORCE ATTACK
            if(Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                String someSC = "";
                if(CBox_SomeSC.isSelected()){
                    someSC = specialChar.getText();
                }
                    
                    if (Mask.equals("0000")){
                        if(CBox_SomeSC.isSelected()){
                            if(jRadioButton3.isSelected()){
                                s = s + " FOR" + (String) jComboBox3.getSelectedItem()+ "\n\n" + Hashcat.HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC);
                            }
                            else{
                                for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                                    s = s + " FOR" + (String) hash_select.getElementAt(i)+ "\n\n" + Hashcat.HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC);
                                }
                            }
                        }    
                        else{
                            s = s + "     ---- WARNING----  \nNO PARAMETERS INTRODUCED  IN 'USE MASK'"; 
                        }
                    }
                    else{
                        s = s + "\n\nHASHCAT -> BRUTE FORCE ATTACK\n";
                        if(jRadioButton3.isSelected()){
                            s = s + " FOR" + (String) jComboBox3.getSelectedItem()+ "\n\n" + Hashcat.HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC);
                        }
                        else{
                            for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                                s = s + " FOR" + (String) hash_select.getElementAt(i)+ "\n\n" + Hashcat.HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC); 
                            }
                        }
                    }
            }    
            
        }
        
        // IN CASE RAIBOWCRACK IS SELECTED AND SOME ATTACK IS SELECTED
        if(ButtonRainbowCrack.isSelected()){
            s = s + "\n\nRAINBOWCRACK -> DEFAULT ATTACK\n"; 
            if (!(RainbowTableFile.equals(""))){
                pathFileRainbowTable = RainbowTableFile.getText();
            }
            s = s + RainbowCrack.RainbowCrackFileAttack(pathFileRainbowTable,pathFileHash) + "\n";
            
        }
        
        //PRINTING THE SELECTED HASH TYPES
        String aux = "";
        
        for(int i=0;i<hash_select.getSize();i++){
            aux = aux + "-> " + hash_select.getElementAt(i) +" \n";
        }
        
        s = "--------------------------------------------\nHASH Types Selected:\n" + aux + "--------------------------------------------\n" + s  ;
        
    }
    long stopTime = System.currentTimeMillis();
    long Time = stopTime - startTime;
    String type_Time= "ms";
    long sec = 1000;
    long min = 60;
    if(Time > 1000){Time = Time/sec;type_Time = "seconds";}
    if(Time > 60) {Time = Time/min; type_Time = "minutes";}
    
    s = s + "\n\n-------------------------------------------\n  Execution Time: " + (Time) + "  " + type_Time + "\n-------------------------------------------\n";
    
    s = s + "\n\n\n-----------------------------------------\n Clean_Text_Passwords\n" + Password_Cracked + "\n-----------------------------------------\n";
    cleanPassword.setText(s);
    Password_Cracked= "";
    }
}

    

public void Generate_Cto_Crack() throws IOException{
        Read_Path();
        String s = "";
        String Mask= "";
        int lenght_max=0;
        
        
        
    if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected())){
        s = s + "\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST INTRODUCE A HASH! It can be a file or a single hash...\n-------------------------------------------------------------------------\n\n\n";             
    }
    else{
        
        
        if(jRadioButton2.isSelected() || jRadioButton3.isSelected()){
            pathFileHash = "HashToCrack";
            Toolkit.CreateFile(pathFileHash, jTextArea1.getText());
        }
        
        boolean Hashcat_BF  = Hashcat_Options.CB_HASHCAT_BF.isSelected(),
                Hashcat_Dic = Hashcat_Options.CB_HASHCAT_Dic.isSelected(),
                JTR_BF      = JTR_Options.CB_JTR_BF.isSelected(),
                JTR_Dic     = JTR_Options.CB_JTR_Dic.isSelected(),
                JTR_Default = JTR_Options.CB_JTR_Default.isSelected(),
                RC_Default  = ButtonRainbowCrack.isSelected();
        
        
        ListModel hash_select =  list_hashSelect.getModel();
        
        if((list_hashSelect.getModel().getSize() == 0) && (!jRadioButton3.isSelected())){
            cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SELECT A TYPE OF HASH!\n-------------------------------------------------------------------------\n\n\n");
            list_hashSelect.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        else{
        
        if(CBox_Mask.isSelected() && CBox_Mask.isEnabled()){
            String D="0";
            String L="0";
            String U="0";
            String S="0";
            
            lenght_max = (int) Spinner_MAX.getValue();
            
            if(CBox_digit.isSelected()){D="1";}
            if(CBox_lowerC.isSelected()){L="1";}
            if(CBox_UpperC.isSelected()){U="1";}
            if(CBox_SpecialC.isSelected()){S="1";}
        
            Mask = D+L+U+S;    
        }
            
            
        // IN CASE JOHNTHERIPPER IS SELECTED AND SOME ATTACK IS SELECTED 
        if(ButtonJohnTheRipper.isSelected() && (JTR_Options.CB_JTR_Dic.isSelected() || JTR_Options.CB_JTR_Default.isSelected() || JTR_Options.CB_JTR_BF.isSelected())){
            
            //JTR DICTIONARY ATTACK
            if(JTR_Options.CB_JTR_Dic.isSelected()){
                if(CB_RT.isSelected()){
                    if(Table.isEmpty()){
                        cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SINTRODUCE SOME CONDITIONS FIRST!\n-------------------------------------------------------------------------\n\n\n");
                    }
                    String tab = "";
                    
                    for(int i=0;i<Table.size();i++){
                        tab = tab + Table.get(i) + "\n";
                    }
                    
                    Toolkit.CreateFile("Table.tab", tab);
                    String newDict = Hashcat.TableLookup(pathFileDictionary,"Table.tab");   
                    Toolkit.CreateFile("newDictionary.txt", newDict);
                    
                    pathFileDictionary = "newDictionary.txt"; 
                }
                s = s + JohnTheRipper.GetC_JohnRipperDictionary (pathFileDictionary, pathFileHash) + "\n";
            }
            
            //JTR DEFAULT ATTACK
            if(JTR_Options.CB_JTR_Default.isSelected()){
                s = s + JohnTheRipper.GetC_JohnRipperCrack (pathFileHash) + "\n";
            }
            
            //JTR BRUTE FORCE ATTACK
            if(JTR_Options.CB_JTR_BF.isSelected()){
                if (Mask.equals("0000")){
                }
                else{   
                    s = s + JohnTheRipper.GetC_JohnRipperBruteForce(JohnTheRipper.JohnRipperTipeChar(Mask),pathFileHash) + "\n";
                }
            }
        }
        
        // IN CASE HASHCAT IS SELECTED AND SOME ATTACK IS SELECTED
        if(ButtonHashcat.isSelected() && (Hashcat_Options.CB_HASHCAT_Dic.isSelected()||Hashcat_Options.CB_HASHCAT_BF.isSelected())){

            //HASHCAT DICTIONARY ATTACK
            if(Hashcat_Options.CB_HASHCAT_Dic.isSelected()){
                if(CB_RT.isSelected()){
                    if(Table.isEmpty()){
                        cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SINTRODUCE SOME CONDITIONS FIRST!\n-------------------------------------------------------------------------\n\n\n");
                    }
                    String tab = "";
                    
                    for(int i=0;i<Table.size();i++){
                        tab = tab + Table.get(i) + "\n";
                    }
                    
                    Toolkit.CreateFile("Table.tab", tab);
                    String newDict = Hashcat.TableLookup(pathFileDictionary,"Table.tab");   
                    Toolkit.CreateFile("newDictionary.txt", newDict);
                    
                    pathFileDictionary = "newDictionary.txt"; 
                }
                if(jRadioButton3.isSelected()){
                    s = s + Hashcat.GetC_HashcatWordlistAttacak ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())), pathFileHash, pathFileDictionary) + "\n";
                }
                else{
                    for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                        s = s + Hashcat.GetC_HashcatWordlistAttacak ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))), pathFileHash, pathFileDictionary) + "\n";
                    }
                }
            }
            
            //HASHCAT BRUTE FORCE ATTACK
            if(Hashcat_Options.CB_HASHCAT_BF.isSelected()){
                String someSC = "";
                if(CBox_SomeSC.isSelected()){
                    someSC = specialChar.getText();
                }
                    
                    if (Mask.equals("0000")){
                        if(CBox_SomeSC.isSelected()){
                            if(jRadioButton3.isSelected()){
                                s = s + Hashcat.GetC_HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC) + "\n";
                            }
                            else{
                                for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                                    s = s + Hashcat.GetC_HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC) + "\n";
                                }
                            }
                        }    
                        else{
                            s = s + "     ---- WARNING----  \nNO PARAMETERS INTRODUCED  IN 'USE MASK'"; 
                        }
                    }
                    else{
                        if(jRadioButton3.isSelected()){
                            s = s+ Hashcat.GetC_HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) jComboBox3.getSelectedItem())),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC) + "\n";
                        }
                        else{
                            for(int i =0; i<list_hashSelect.getModel().getSize();i++){
                                s = s+ Hashcat.GetC_HashcatBruteForceAttack ((Hashcat.HashcatHashType((String) hash_select.getElementAt(i))),((String) Hashcat.HashcatTipeChar(Mask)),lenght_max, pathFileHash,someSC) + "\n";
                            }
                        }
                    }
            }    
            
        }
        
        // IN CASE RAIBOWCRACK IS SELECTED AND SOME ATTACK IS SELECTED
        if(ButtonRainbowCrack.isSelected()){
            if (!(RainbowTableFile.equals(""))){
                pathFileRainbowTable = RainbowTableFile.getText();
            }
            s = s + RainbowCrack.GetC_RainbowCrackFileAttack(pathFileRainbowTable,pathFileHash) + "\n";
            
        }
    }
    TP.setSelectedIndex(0);
    jTextArea2.setText(s);
    }
}

    
    class NewWorker_Clean extends SwingWorker<String, Integer>{
        @Override
        public String doInBackground() throws Exception{    
            return "\n\n\n\n\n\n\n\n\n\n\t\t RUNNING...";
        }
        @Override
        public void done(){
            try{
                Interface.cleanPassword.setText(get());
            }catch (InterruptedException | ExecutionException e){
            }
        }
    }





    boolean done = false;

    class NewWorker_ExecuteCommands extends SwingWorker<String, Integer>{
        @Override
        public String doInBackground() throws Exception{
            String[] commands = jTextArea2.getText().split("\n");
            String s="";
            for(int i=0;i<commands.length;i++){
                 s = s + Toolkit.CommandsExecute(commands[i]);
            }
            s = s + "\n\n\n-----------------------------------------\n Clean_Text_Passwords\n" + Password_Cracked + "\n-----------------------------------------\n";
        return (s);
        }
        
        /*public void propertyChange(PropertyChangeEvent evt) {
            if (!done) {
                int progress = NW1.getProgress();
                jProgressBar1.setValue(progress);
            }
        }*/
        
        @Override
        public void done(){
            try{
                done=true;
                Interface.cleanPassword.setText(get());
            }catch (InterruptedException | ExecutionException e){
            }
        }
    }

    
    NewWorker_ExecuteCommands NW1 = new NewWorker_ExecuteCommands();


    public void Execute_Commands() {
        CrackButton.setEnabled(false);
        jMenuItem2.setEnabled(false);
        NewWorker_Clean NWC = new NewWorker_Clean();
        NWC.execute();
        //jProgressBar1.setValue(21);
        NW1.execute();
        Toolkit.CreateFileHistory("HistoryFile", (History.PrintHistory() + "Automatic" + "\n"));
        cleanPassword.setText("\n\tNotification\n\n       Your Choises has been saved...\n\n");
        History.GetHistory();
        CrackButton.setEnabled(true);
        jMenuItem2.setEnabled(true);
    }
    
    
    public static void Change_Path(){
    
        String content="";
        
        content = "jtr=" + PATH_JTR +"\n" + 
                "hashcat=" + PATH_Hashcat +"\n"+ 
                "rc=" + PATH_RC +"\n" + 
                "crunch=" + PATH_Crunch +"\n"; 
        
        Toolkit.CreateFile("path", content);
        
    }
    
    
    
    
    
    public static void Read_Path(){
    
        try {
            File file = new File("path");
            if(file.exists()){
             
                BufferedReader input = new BufferedReader(new FileReader(file));
                
                String content="";
                String line="";
                int cont=0;
                
                while((line = input.readLine())!= null){      
                    content = content + line + "::"  ;               
                }            
                    String[] vectorContent = content.split("::");
                    
                    String[] jtr = vectorContent[0].split("=");
                         PATH_JTR = jtr[1]; 
                    String[] hsct = vectorContent[1].split("=");
                         PATH_Hashcat = hsct[1];
                    String[] rc = vectorContent[2].split("=");
                        PATH_RC =rc[1];
                    String[] crch = vectorContent[3].split("=");
                         PATH_Crunch =crch[1];
            }        
        } catch ( IOException e ) { System.out.println(e);}
    }


   

   

   

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filechooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Popup_JTH = new javax.swing.JPopupMenu();
        JTR_Default = new javax.swing.JCheckBoxMenuItem();
        JTR_BF = new javax.swing.JCheckBoxMenuItem();
        JTR_Dictionary = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtFPathDictionary = new javax.swing.JTextField();
        Open = new javax.swing.JButton();
        exp_dictionary = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        RainbowTableFile = new javax.swing.JTextField();
        Open2 = new javax.swing.JButton();
        exp_RainbowTable = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        CB_RT = new javax.swing.JCheckBox();
        txt_char = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_rep = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        List_table = new javax.swing.JList();
        ButtonAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        Buttondelete = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CBox_Mask = new javax.swing.JCheckBox();
        CBox_digit = new javax.swing.JCheckBox();
        CBox_lowerC = new javax.swing.JCheckBox();
        CBox_UpperC = new javax.swing.JCheckBox();
        Spinner_MAX = new javax.swing.JSpinner();
        CBox_SpecialC = new javax.swing.JCheckBox();
        specialChar = new javax.swing.JTextField();
        CBox_SomeSC = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        Button_GCommands = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cleanPassword = new javax.swing.JTextArea();
        TP = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        Button_RCommands = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        EditorPane_help = new javax.swing.JEditorPane();
        buttonCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        Open1 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton3 = new javax.swing.JRadioButton();
        CleanText = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_hash = new javax.swing.JList(hashtype);
        button_hashtype = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_hashSelect = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ButtonRainbowCrack = new javax.swing.JRadioButton();
        ButtonHashcat = new javax.swing.JRadioButton();
        ButtonJohnTheRipper = new javax.swing.JRadioButton();
        Button_Edit_JTR = new javax.swing.JButton();
        Button_Edit_Hashcat = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        ImageIcon icon = new ImageIcon("run.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIcon= new ImageIcon(newimg);
        CrackButton = new javax.swing.JButton();
        ImageIcon iconS = new ImageIcon("save.png");
        Image imgS = iconS.getImage();
        Image newimgS = imgS.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIconS= new ImageIcon(newimgS);
        SaveButton = new javax.swing.JButton();
        ImageIcon iconC = new ImageIcon("clear.png");
        Image imgC = iconC.getImage();
        Image newimgC = imgC.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIconC= new ImageIcon(newimgC);
        ClearButton = new javax.swing.JButton();
        ImageIcon iconH = new ImageIcon("history.png");
        Image imgH = iconH.getImage();
        Image newimgH = imgH.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIconH= new ImageIcon(newimgH);
        HistoryButton = new javax.swing.JButton();
        ImageIcon iconNW = new ImageIcon("add.png");
        Image imgNW = iconNW.getImage();
        Image newimgNW = imgNW.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIconNW= new ImageIcon(newimgNW);
        NewWordlistButton = new javax.swing.JButton();
        ImageIcon iconCD = new ImageIcon("open.png");
        Image imgCD = iconCD.getImage();
        Image newimgCD = imgCD.getScaledInstance(28, 28,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon newIconCD= new ImageIcon(newimgCD);
        ChangeDirectory = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        filechooser.setFileFilter(new MyCustomFilter());

        Popup_JTH.setBackground(java.awt.Color.gray);
        Popup_JTH.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Popup_JTH.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.gray));
        Popup_JTH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JTR_Default.setBackground(java.awt.Color.gray);
        JTR_Default.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        JTR_Default.setSelected(true);
        JTR_Default.setText("Use Default Attack");
        Popup_JTH.add(JTR_Default);

        JTR_BF.setBackground(java.awt.Color.gray);
        JTR_BF.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        JTR_BF.setText("Use Brute Force Attack");
        Popup_JTH.add(JTR_BF);

        JTR_Dictionary.setBackground(java.awt.Color.gray);
        JTR_Dictionary.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        JTR_Dictionary.setText("Use Dictionary Attack");
        Popup_JTH.add(JTR_Dictionary);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cracking Toolkit");
        setBackground(java.awt.Color.black);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(null);
        jPanel1.setForeground(java.awt.Color.lightGray);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel2.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        jLabel2.setText("Select Dictionary File");
        jLabel2.setEnabled(false);

        TxtFPathDictionary.getDocument().addDocumentListener(new DocumentListenerPATHFILE());
        TxtFPathDictionary.setBackground(java.awt.Color.lightGray);
        TxtFPathDictionary.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        TxtFPathDictionary.setEnabled(false);
        TxtFPathDictionary.setMinimumSize(new java.awt.Dimension(10, 20));
        TxtFPathDictionary.setPreferredSize(new java.awt.Dimension(10, 20));
        TxtFPathDictionary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFPathDictionaryActionPerformed(evt);
            }
        });
        TxtFPathDictionary.setEnabled(false);

        Open.setBackground(java.awt.Color.gray);
        Open.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Open.setText("Open File");
        Open.setToolTipText("");
        Open.setActionCommand("OpenFile");
        Open.setEnabled(false);
        Open.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });

        exp_dictionary.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N
        exp_dictionary.setForeground(java.awt.Color.gray);
        exp_dictionary.setText("(If not select any file, will be use one by default)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtFPathDictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Open))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(exp_dictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(TxtFPathDictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exp_dictionary, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jPanel6.setPreferredSize(new java.awt.Dimension(360, 105));

        jLabel4.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        jLabel4.setText("Select Rainbow Table File");
        jLabel4.setEnabled(false);

        RainbowTableFile.getDocument().addDocumentListener(new DocumentListenerRainbowTableFILE());
        RainbowTableFile.setBackground(java.awt.Color.lightGray);
        RainbowTableFile.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        RainbowTableFile.setEnabled(false);

        Open2.setBackground(java.awt.Color.gray);
        Open2.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Open2.setText("Open File");
        Open2.setToolTipText("");
        Open2.setActionCommand("OpenFile");
        Open2.setEnabled(false);
        Open2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Open2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Open2ActionPerformed(evt);
            }
        });

        exp_RainbowTable.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N
        exp_RainbowTable.setForeground(java.awt.Color.gray);
        exp_RainbowTable.setText("(If not select any file, will be use one by default)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(RainbowTableFile, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Open2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(exp_RainbowTable)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Open2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RainbowTableFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exp_RainbowTable, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jPanel14.setEnabled(false);

        CB_RT.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        CB_RT.setText("Use Replacement Tables");
        CB_RT.addActionListener(new ListenerReplacementTable());
        CB_RT.setEnabled(false);

        txt_char.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        txt_char.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel14.setText("Replace to");
        jLabel14.setEnabled(false);

        txt_rep.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        txt_rep.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        jLabel15.setText("(Exemple: Character 'a' Replace to '4')");
        jLabel15.setEnabled(false);

        List_table.setBackground(java.awt.Color.lightGray);
        List_table.setEnabled(false);
        jScrollPane5.setViewportView(List_table);

        ButtonAdd.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ButtonAdd.setText("Add");
        ButtonAdd.setEnabled(false);
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel16.setText("Character");
        jLabel16.setEnabled(false);

        Buttondelete.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Buttondelete.setText("Delete");
        Buttondelete.setEnabled(false);
        Buttondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtondeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CB_RT)
                    .addComponent(jLabel15)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(10, 10, 10)
                        .addComponent(txt_char, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(10, 10, 10)
                        .addComponent(txt_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buttondelete, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(CB_RT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_char, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(ButtonAdd))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(Buttondelete))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel6.setText("Select the Word Max Lenght:");
        jLabel6.setEnabled(false);

        CBox_Mask.addActionListener(new ListenerUseMask());
        CBox_Mask.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        CBox_Mask.setText("Use Masks");
        CBox_Mask.setEnabled(false);

        CBox_digit.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CBox_digit.setText("Use Digits");
        CBox_digit.setEnabled(false);

        CBox_lowerC.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CBox_lowerC.setText("Use Lower Cases");
        CBox_lowerC.setEnabled(false);
        CBox_lowerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBox_lowerCActionPerformed(evt);
            }
        });

        CBox_UpperC.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CBox_UpperC.setText("Use Upper Cases");
        CBox_UpperC.setEnabled(false);

        Spinner_MAX.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Spinner_MAX.setModel(new javax.swing.SpinnerNumberModel(6, 1, 12, 1));
        Spinner_MAX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Spinner_MAX.setDoubleBuffered(true);
        Spinner_MAX.setEnabled(false);

        CBox_SpecialC.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CBox_SpecialC.setText("Use Special Characters");
        CBox_SpecialC.setEnabled(false);

        specialChar.setBackground(java.awt.Color.lightGray);
        specialChar.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        specialChar.setEnabled(false);
        specialChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialCharActionPerformed(evt);
            }
        });

        CBox_SomeSC.addActionListener(new ListenerSpecialChar());
        CBox_SomeSC.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CBox_SomeSC.setText("Choose Special Characters");
        CBox_SomeSC.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(CBox_SpecialC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBox_UpperC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBox_digit))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(CBox_Mask))
                        .addGap(18, 18, 18)
                        .addComponent(Spinner_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(CBox_lowerC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBox_SomeSC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialChar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CBox_Mask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spinner_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBox_SomeSC)
                    .addComponent(specialChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBox_lowerC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBox_SpecialC)
                    .addComponent(CBox_UpperC)
                    .addComponent(CBox_digit))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        Button_GCommands.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        Button_GCommands.setText("Generate Commands");
        Button_GCommands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_GCommandsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_GCommands, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Button_GCommands)
                .addGap(19, 19, 19))
        );

        jPanel4.setBorder(null);

        cleanPassword.setBackground(java.awt.Color.black);
        cleanPassword.setColumns(20);
        cleanPassword.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        cleanPassword.setForeground(java.awt.Color.cyan);
        cleanPassword.setLineWrap(true);
        cleanPassword.setRows(5);
        cleanPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cleanPassword.setCaretColor(java.awt.Color.darkGray);
        cleanPassword.setDisabledTextColor(java.awt.Color.yellow);
        cleanPassword.setFocusable(false);
        cleanPassword.setName("Command Box "); // NOI18N
        jScrollPane2.setViewportView(cleanPassword);
        //cleanPassword.setEnabled(false);
        cleanPassword.setHighlighter(null);

        TP.setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray, 1, true));
        TP.setToolTipText("");
        TP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TP.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        TP.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        //TP.addTab("java2s.com", new History_Table());

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(java.awt.Color.black);
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(java.awt.Color.cyan);
        jTextArea2.setRows(5);
        jScrollPane8.setViewportView(jTextArea2);

        jButton4.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jButton4.setText("Edit Commands");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addActionListener(new Listener_W_EC());

        Button_RCommands.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        Button_RCommands.setText("Run Commands");
        Button_RCommands.setEnabled(false);
        Button_RCommands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RCommandsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(Button_RCommands, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(Button_RCommands))
                .addContainerGap())
        );

        TP.addTab("Commands List", jPanel12);

        EditorPane_help.setEditable(false);
        EditorPane_help.setBorder(null);
        EditorPane_help.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        EditorPane_help.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(EditorPane_help);
        EditorPane_help.setText(String.valueOf(Help_List.get(0)));
        EditorPane_help.setSelectionStart(1);

        TP.addTab("Help", jScrollPane6);

        buttonCancel.setBackground(java.awt.Color.gray);
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(buttonCancel))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(null);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jTextField1.setBackground(java.awt.Color.lightGray);
        jTextField1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jTextField1.setAlignmentY(0.1F);
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setEnabled(false);

        jRadioButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Open1.setEnabled(true);
                jTextField1.setEnabled(true);
                jTextArea1.setEnabled(false);
                jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
                CleanText.setEnabled(false);
                jLabel5.setEnabled(false);
                jComboBox3.setEnabled(false);
            }
        });
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jRadioButton1.setText("Select a File to Crack");
        jRadioButton1.addActionListener(new ListenerVerifyHash());
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jRadioButton1.addActionListener(new ListenerActiveHash());
        jRadioButton1.addActionListener(new ListenerEnabledVerifyHash());
        jRadioButton1.addActionListener(new ListenerHistoryButton());

        Open1.setBackground(java.awt.Color.gray);
        Open1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Open1.setText("Open File");
        Open1.setToolTipText("");
        Open1.setActionCommand("OpenFile");
        Open1.setEnabled(false);
        Open1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Open1ActionPerformed(evt);
            }
        });
        Open1.setEnabled(false);

        jRadioButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setEnabled(true);
                jTextField1.setEnabled(false);
                Open1.setEnabled(false);
                CleanText.setEnabled(false);
                jLabel5.setEnabled(false);
                jComboBox3.setEnabled(false);
                jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
            }
        });
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jRadioButton2.setText("Insert Hash to Crack");
        jRadioButton2.addActionListener(new ListenerVerifyHash());
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jRadioButton2.addActionListener(new ListenerActiveHash());
        jRadioButton2.addActionListener(new ListenerEnabledVerifyHash());
        jRadioButton2.addActionListener(new ListenerHistoryButton());

        jTextArea1.setBackground(java.awt.Color.lightGray);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setEnabled(false);

        jRadioButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CleanText.setEnabled(true);
                jLabel5.setEnabled(true);
                jComboBox3.setEnabled(true);
                jTextArea1.setEnabled(false);
                jTextField1.setEnabled(false);
                Open1.setEnabled(false);
            }
        });
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jRadioButton3.setText("Insert Clean Text");
        jRadioButton3.addActionListener(new ListenerActiveHash());
        jRadioButton3.addActionListener(new ListenerEnabledVerifyHash());
        jRadioButton3.addActionListener(new ListenerHistoryButton());

        CleanText.getDocument().addDocumentListener(new DocumentListenerCleanText());
        CleanText.setBackground(java.awt.Color.lightGray);
        CleanText.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CleanText.setEnabled(false);
        CleanText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanTextActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new ListenerCleanText());
        jComboBox3.setBackground(java.awt.Color.lightGray);
        jComboBox3.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHA-1", "SHA-256", "MD5" }));
        jComboBox3.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        jLabel5.setText("Select Hash Type");
        jLabel5.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CleanText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Open1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CleanText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Open1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray, 1, true));
        jTabbedPane1.setVisible(false);

        jPanel9.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        jLabel1.setText("Possibles Hash Type");
        jLabel1.setEnabled(false);

        list_hash.setBackground(java.awt.Color.lightGray);
        list_hash.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        list_hash.setEnabled(false);
        list_hash.setSelectionBackground(java.awt.Color.darkGray);
        list_hash.setSelectionForeground(java.awt.Color.lightGray);
        jScrollPane3.setViewportView(list_hash);

        button_hashtype.addActionListener(new ListenerSelectHash());
        button_hashtype.setBackground(java.awt.Color.gray);
        button_hashtype.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        button_hashtype.setText("INFO");
        button_hashtype.setEnabled(false);
        button_hashtype.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_hashtype.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        button_hashtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hashtypeActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.gray);
        jButton2.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jButton2.setText(">");
        jButton2.setEnabled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(java.awt.Color.gray);
        jButton3.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jButton3.setText("<");
        jButton3.setEnabled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        list_hashSelect.setBackground(java.awt.Color.lightGray);
        list_hashSelect.setBorder(null);
        list_hashSelect.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        list_hashSelect.setEnabled(false);
        list_hashSelect.setSelectionBackground(java.awt.Color.darkGray);
        list_hashSelect.setSelectionForeground(java.awt.Color.lightGray);
        jScrollPane4.setViewportView(list_hashSelect);

        jLabel7.setBackground(java.awt.Color.lightGray);
        jLabel7.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N
        jLabel7.setText("(Hash Type(s) Selected)");
        jLabel7.setEnabled(false);

        jButton1.addActionListener(new ListenerHashType());
        jButton1.setBackground(java.awt.Color.gray);
        jButton1.setText("Verify Hash");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button_hashtype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(26, 26, 26))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 330, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(button_hashtype, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Verify Hash Type", jPanel9);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel3MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 3, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("Select Tools");

        ButtonRainbowCrack.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ButtonRainbowCrack.addActionListener(new ListenerOpenRainbowTable());
        ButtonRainbowCrack.setText("RainbowCrack");
        ButtonRainbowCrack.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        ButtonRainbowCrack.setEnabled(false);
        ButtonRainbowCrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRainbowCrackActionPerformed(evt);
            }
        });

        ButtonHashcat.addActionListener(new ListenerMask());
        ButtonHashcat.addActionListener(new ListenerOpenDictionary());
        ButtonHashcat.addActionListener(new ListenerUSEReplacementTable());
        ButtonHashcat.addActionListener(new ListenerHASHCAT());
        ButtonHashcat.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ButtonHashcat.setText("Hashcat");
        ButtonHashcat.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        ButtonHashcat.setEnabled(false);
        ButtonHashcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHashcatActionPerformed(evt);
            }
        });

        ButtonJohnTheRipper.addActionListener(new ListenerMask());
        ButtonJohnTheRipper.addActionListener(new ListenerOpenDictionary());
        ButtonJohnTheRipper.addActionListener(new ListenerJTR());
        ButtonJohnTheRipper.addActionListener(new ListenerUSEReplacementTable());
        ButtonJohnTheRipper.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ButtonJohnTheRipper.setText("John The Ripper");
        ButtonJohnTheRipper.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        ButtonJohnTheRipper.setEnabled(false);
        ButtonJohnTheRipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJohnTheRipperActionPerformed(evt);
            }
        });

        Button_Edit_JTR.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Button_Edit_JTR.setText("Preferences");
        Button_Edit_JTR.setEnabled(false);
        Button_Edit_JTR.addActionListener(new ListenerOpenJTR_Options());
        Button_Edit_JTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Edit_JTRActionPerformed(evt);
            }
        });

        Button_Edit_Hashcat.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        Button_Edit_Hashcat.addActionListener(new ListenerOpenHashcat_Options());
        Button_Edit_Hashcat.setText("Preferences");
        Button_Edit_Hashcat.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(ButtonRainbowCrack, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(ButtonJohnTheRipper, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(ButtonHashcat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Button_Edit_JTR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_Edit_Hashcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(62, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJohnTheRipper)
                    .addComponent(Button_Edit_JTR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonHashcat)
                    .addComponent(Button_Edit_Hashcat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRainbowCrack)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel11.setBorder(null);
        jPanel11.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jToolBar1.setRollover(true);

        CrackButton.setIcon(newIcon);
        CrackButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        CrackButton.setHorizontalTextPosition(SwingConstants.CENTER);
        CrackButton.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        CrackButton.setText("Crack");
        CrackButton.setBorder(null);
        CrackButton.setBorderPainted(false);
        CrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrackButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(CrackButton);

        SaveButton.setIcon(newIconS);
        SaveButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        SaveButton.setHorizontalTextPosition(SwingConstants.CENTER);
        SaveButton.addActionListener(new Listener_HistorySave ());
        SaveButton.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        SaveButton.setText(" Save ");
        SaveButton.setBorder(null);
        SaveButton.setBorderPainted(false);
        SaveButton.setEnabled(false);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(SaveButton);

        ClearButton.setIcon(newIconC);
        ClearButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ClearButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ClearButton.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ClearButton.setText(" Clear ");
        ClearButton.setBorder(null);
        ClearButton.setBorderPainted(false);
        ClearButton.setFocusable(false);
        ClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ClearButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ClearButton);
        ClearButton.addActionListener(new ListenerHistoryButton());
        ClearButton.addActionListener(new ListenerClear());
        //ClearButton.addActionListener(new ListenerHistoryButton());

        HistoryButton.setIcon(newIconH);
        HistoryButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        HistoryButton.setHorizontalTextPosition(SwingConstants.CENTER);
        HistoryButton.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        HistoryButton.setText("History");
        HistoryButton.setBorder(null);
        HistoryButton.setBorderPainted(false);
        HistoryButton.setEnabled(false);
        HistoryButton.setFocusable(false);
        HistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        HistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(HistoryButton);
        HistoryButton.addActionListener(new Listener_HistoryTable());

        NewWordlistButton.setIcon(newIconNW);
        NewWordlistButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        NewWordlistButton.setHorizontalTextPosition(SwingConstants.CENTER);
        NewWordlistButton.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        NewWordlistButton.setText("New Wordlist");
        NewWordlistButton.setFocusable(false);
        NewWordlistButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewWordlistButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NewWordlistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewWordlistButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(NewWordlistButton);

        ChangeDirectory.setIcon(newIconCD);
        ChangeDirectory.setVerticalTextPosition(SwingConstants.BOTTOM);
        ChangeDirectory.setHorizontalTextPosition(SwingConstants.CENTER);
        ChangeDirectory.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        ChangeDirectory.setText("Change Directory");
        ChangeDirectory.setFocusable(false);
        ChangeDirectory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChangeDirectory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ChangeDirectory);
        ChangeDirectory.addActionListener(new Listener_path());

        jPanel11.add(jToolBar1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, javax.swing.UIManager.getDefaults().getColor("Button.background"), javax.swing.UIManager.getDefaults().getColor("Button.background"), javax.swing.UIManager.getDefaults().getColor("Button.background"), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        jMenuBar1.setAlignmentX(0.0F);
        jMenuBar1.setFocusTraversalPolicyProvider(true);
        jMenuBar1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        jMenu1.setText("Toolkit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Crack");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Enable Help");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Console");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Edit Colours");
        jMenuItem3.addActionListener(new Listener_EditConsole());
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void CrackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrackButtonActionPerformed
       Execute_Crack();  
    }//GEN-LAST:event_CrackButtonActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //if(list_hashSelect.getSelectedValue() != ""){
        //    cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SELECT A TYPE OF HASH!\n-------------------------------------------------------------------------\n\n\n");
       // }
       // else{
            if (hashSelect.contains(list_hashSelect.getSelectedValue())){
                hashSelect.remove(list_hashSelect.getSelectedValue());
            }
            list_hashSelect.setListData(hashSelect);
       // }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(list_hash.isSelectionEmpty()){
            cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SELECT A TYPE OF HASH!\n-------------------------------------------------------------------------\n\n\n");
        }
        
        else{
            if (list_hash.getSelectedValue().equals(" Not Found.")){
               cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nNot Found is not a type os Hash, it only means, that wasn't found Valids hash types\n-------------------------------------------------------------------------\n\n\n");
            }
            else{
                if(!(hashSelect.contains(list_hash.getSelectedValue()))){
                    hashSelect .add(0, list_hash.getSelectedValue());
                }
                list_hashSelect.setListData(hashSelect);
                list_hashSelect.setBorder(null);
                }
            }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button_hashtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hashtypeActionPerformed

    }//GEN-LAST:event_button_hashtypeActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
 
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void Open1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Open1ActionPerformed
        // TODO add your handling code here:
        int returnVal = filechooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            pathFileHash = file.getAbsolutePath();
        }
        jTextField1.setText(pathFileHash);
    }//GEN-LAST:event_Open1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        int returnVal = filechooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            pathFileDictionary = file.getAbsolutePath();
            TxtFPathDictionary.setText(pathFileDictionary);
            TxtFPathDictionary.setEnabled(true);
            String text = "The follow file '" +pathFileDictionary + "' will be use as dictionary";
            exp_dictionary.setText(text);
        } else {
            System.out.println("File access cancelled by user.");
        }

    }//GEN-LAST:event_OpenActionPerformed

    private void TxtFPathDictionaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFPathDictionaryActionPerformed
                
    }//GEN-LAST:event_TxtFPathDictionaryActionPerformed

    private void Open2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Open2ActionPerformed
        // TODO add your handling code here:
        int returnVal = filechooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            pathFileRainbowTable = file.getAbsolutePath();
            RainbowTableFile.setText(pathFileRainbowTable);
            RainbowTableFile.setEnabled(true);
            //String text = "The follow file '" +pathFileRainbowTable + "' will be use as RainbowTable";
            //exp_RainbowTable.setText(text);
            
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_Open2ActionPerformed

    private void CBox_lowerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBox_lowerCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBox_lowerCActionPerformed

    private void ButtonRainbowCrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRainbowCrackActionPerformed
        
        if(ButtonRainbowCrack.isSelected()){
            Open2.setEnabled(true);
        }
        else{
            Open2.setEnabled(false);
            RainbowTableFile.setEditable(false);
            RainbowTableFile.setText("");
        }
    }//GEN-LAST:event_ButtonRainbowCrackActionPerformed

    private void jPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseReleased
 
    }//GEN-LAST:event_jPanel3MouseReleased

    private void ButtonHashcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHashcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonHashcatActionPerformed

    private void ButtonJohnTheRipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJohnTheRipperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonJohnTheRipperActionPerformed

    private void ButtondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtondeleteActionPerformed
        
        if(List_table.isSelectionEmpty()){
            cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST SELECT A CONDITION FIRST!\n-------------------------------------------------------------------------\n\n\n");
        }
        else{
            Table.remove(List_table.getSelectedValue());
            List_table.setListData(Table);
        }
    }//GEN-LAST:event_ButtondeleteActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
    
        if (txt_char.getText().isEmpty() || txt_rep.getText().isEmpty()){
            cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU MUST INTRODUCE VALUES IN THE TEXT FIELDS!\n-------------------------------------------------------------------------\n\n\n");
        }
        else{
            if ((txt_char.getText().length() == 1) && (txt_rep.getText().length() == 1) ){
                
                if (Table.contains((txt_char.getText()+"="+txt_rep.getText()))){
                    cleanPassword.setText("\n> -------------------------ATENTION, WARNING!------------------------\nTHAT CONDITIONS ALREADY EXIST, PLEASE CHOOSE ANOTHER ONE!\n-------------------------------------------------------------------------\n\n\n");
                }
                else{
                    Table.add(0, (txt_char.getText()+"="+txt_rep.getText()));
                    List_table.setListData(Table);
                }
            }
            else{
                cleanPassword.setText("\n> -------------------------ATENTION, ERROR!------------------------\nYOU HAVE MORE THEN ONE CHARACTER IN THE TEXT FIELDS!\n-------------------------------------------------------------------------\n\n\n");
            }
        }
        
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void Button_Edit_JTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Edit_JTRActionPerformed

        
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_Edit_JTRActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void HistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryButtonActionPerformed

        
    }//GEN-LAST:event_HistoryButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if (jCheckBoxMenuItem1.isSelected()){
            TP.remove(1);
        }
        else{
            TP.add(new javax.swing.JTextArea("Help"));
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void specialCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialCharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specialCharActionPerformed

    private void NewWordlistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewWordlistButtonActionPerformed
        int fileC = filechooser.showSaveDialog(this);
        if (fileC == JFileChooser.APPROVE_OPTION) {
            pathNewWordlist = (filechooser.getSelectedFile().getAbsolutePath());
            p_NewWordlist.setOpaque(false);
            p_NewWordlist.setLayout(new GridBagLayout());
            setGlassPane(p_NewWordlist);
            p_NewWordlist.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent me){
                me.consume();
                }
            });

            p_NewWordlist.setVisible(true);
        }
    }//GEN-LAST:event_NewWordlistButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Button_GCommandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GCommandsActionPerformed
        try {
            Generate_Cto_Crack();
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(jTextArea2.getText().equals("")){
           Button_RCommands.setEnabled(false);
       }else{
           Button_RCommands.setEnabled(true);
       }
    }//GEN-LAST:event_Button_GCommandsActionPerformed

    private void Button_RCommandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RCommandsActionPerformed
        Execute_Commands();
    }//GEN-LAST:event_Button_RCommandsActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Execute_Crack(); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void CleanTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CleanTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Interface inter = new Interface();
                        inter.getContentPane().setBackground(Color.DARK_GRAY);
                        inter.setVisible(true);
            }
            
        });
    }

    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonAdd;
    public static javax.swing.JRadioButton ButtonHashcat;
    public static javax.swing.JRadioButton ButtonJohnTheRipper;
    public static javax.swing.JRadioButton ButtonRainbowCrack;
    public static javax.swing.JButton Button_Edit_Hashcat;
    public static javax.swing.JButton Button_Edit_JTR;
    private javax.swing.JButton Button_GCommands;
    private javax.swing.JButton Button_RCommands;
    public static javax.swing.JButton Buttondelete;
    public static javax.swing.JCheckBox CB_RT;
    public static javax.swing.JCheckBox CBox_Mask;
    public static javax.swing.JCheckBox CBox_SomeSC;
    public static javax.swing.JCheckBox CBox_SpecialC;
    public static javax.swing.JCheckBox CBox_UpperC;
    public static javax.swing.JCheckBox CBox_digit;
    public static javax.swing.JCheckBox CBox_lowerC;
    private javax.swing.JButton ChangeDirectory;
    private static javax.swing.JTextField CleanText;
    private javax.swing.JButton ClearButton;
    public static javax.swing.JButton CrackButton;
    private javax.swing.JEditorPane EditorPane_help;
    private javax.swing.JButton HistoryButton;
    private javax.swing.JCheckBoxMenuItem JTR_BF;
    private javax.swing.JCheckBoxMenuItem JTR_Default;
    private javax.swing.JCheckBoxMenuItem JTR_Dictionary;
    public static javax.swing.JList List_table;
    private javax.swing.JButton NewWordlistButton;
    public static javax.swing.JButton Open;
    private static javax.swing.JButton Open1;
    public static javax.swing.JButton Open2;
    private javax.swing.JPopupMenu Popup_JTH;
    public static javax.swing.JTextField RainbowTableFile;
    private javax.swing.JButton SaveButton;
    public static javax.swing.JSpinner Spinner_MAX;
    private javax.swing.JTabbedPane TP;
    public static javax.swing.JTextField TxtFPathDictionary;
    private javax.swing.JButton buttonCancel;
    private static javax.swing.ButtonGroup buttonGroup1;
    private static javax.swing.JButton button_hashtype;
    public static javax.swing.JTextArea cleanPassword;
    private javax.swing.JLabel exp_RainbowTable;
    public static javax.swing.JLabel exp_dictionary;
    private javax.swing.JFileChooser filechooser;
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private static javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private static javax.swing.JRadioButton jRadioButton1;
    private static javax.swing.JRadioButton jRadioButton2;
    private static javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    static javax.swing.JList list_hash;
    private static javax.swing.JList list_hashSelect;
    public static javax.swing.JTextField specialChar;
    public static javax.swing.JTextField txt_char;
    public static javax.swing.JTextField txt_rep;
    // End of variables declaration//GEN-END:variables

            
}