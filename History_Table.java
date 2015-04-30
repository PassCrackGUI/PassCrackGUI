/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static toolkit.History.BooleanPrint;
import static toolkit.Interface.p_JTR;

/**
 *
 * @author root
 */
public class History_Table extends javax.swing.JPanel {

    /**
     * Creates new form History_Table
     */
    int RowNumber = 0 ;
    
    DefaultTableModel DTM = new DefaultTableModel(new String [] {"ID", "Day", "Time", "Name"}, 0);
    
    boolean search = false;
    Object[][] tableN = new Object[][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}};  

    public History_Table() {
        initComponents();
        
    }
    
    public class ListenerSearch implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            if(search){
                jTabbedPane1.setVisible(false);
                search = false;
            }else{
                jTabbedPane1.setVisible(true);
                search = true;
            }
        }
    } 
    
    
    
    public class ListenerClose implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            Interface.p_HistoryTable.setVisible(false);
        }
    }
    
    
    
    public class DocumentListenerSearchName implements DocumentListener {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String[] s ;
                String search_txt = Text_find.getText();
                //jTable1.setModel(DTM);
                for(int j=(DTM.getRowCount()-1);j>=0;j--){
                    DTM.removeRow(j);
                }
                for(int i=0; i< History.H_p.size();i++){
                    if(History.H_p.get(i).Name.contains(search_txt)){
                        s = History.H_p.get(i).Date.split("   ");
                        DTM.addRow(new Object[] {History.H_p.get(i).id,s[0],s[1],History.H_p.get(i).Name});
                    }
                }
                //jTable1.setModel(DTM);
            }
     
            @Override
            public void removeUpdate(DocumentEvent e) {
                String[] s ;
                String search_txt = Text_find.getText();
                //jTable1.setModel(DTM);
                for(int j=(DTM.getRowCount()-1);j>=0;j--){
                    DTM.removeRow(j);
                }
                for(int i=0; i< History.H_p.size();i++){
                    if(History.H_p.get(i).Name.contains(search_txt)){
                        s = History.H_p.get(i).Date.split("   ");
                        DTM.addRow(new Object[] {History.H_p.get(i).id,s[0],s[1],History.H_p.get(i).Name});
                    }
                }
                //jTable1.setModel(DTM);
            }   

            @Override
            public void changedUpdate(DocumentEvent e){
                /*String[] s ;
                int counter = 0;
                String search_txt = Text_find.getText(); 
                jTable1.setModel(new javax.swing.table.DefaultTableModel( tableN, new String [] {"ID", "Day", "Time", "Name"}));
                for(int i=0; i< History.H_p.size();i++){
                    if(History.H_p.get(i).Name.contains(search_txt)){
                        jTable1.setValueAt(History.H_p.get(i).id, counter, 0);
                        s = History.H_p.get(i).Date.split("   ");
                        jTable1.setValueAt(s[0], counter, 1);
                        jTable1.setValueAt(s[1], counter, 2);
                        jTable1.setValueAt(History.H_p.get(i).Name, counter, 3);
                        counter++;
                    }
                }*/
                String[] s ;
                String search_txt = Text_find.getText(); 
                //jTable1.setModel(DTM);
                for(int j=(DTM.getRowCount()-1);j>=0;j--){
                    DTM.removeRow(j);
                }
                for(int i=0; i< History.H_p.size();i++){
                    if(History.H_p.get(i).Name.contains(search_txt)){
                        s = History.H_p.get(i).Date.split("   ");
                        DTM.addRow(new Object[] {History.H_p.get(i).id,s[0],s[1],History.H_p.get(i).Name});
                    }
                }
                //jTable1.setModel(DTM);
            }   
     }
    
    
    
    
    public String ConvertBool (boolean bool){
        String output;
        if(bool){
            output = "YES";
        }
        else{
            output = "NO";
        }
        return output;
    }
    
    
    public void SelectHistory (){
        
        Interface.TxtFPathDictionary.setEnabled(false);
        Interface.Open.setEnabled(false);
        Interface.jLabel2.setEnabled(false);
        
        // JTR
        if (History.H_p.get(RowNumber).JTR){
            Interface.ButtonJohnTheRipper.setEnabled(true);
            Interface.Button_Edit_JTR.setEnabled(true);
            
            Interface.ButtonJohnTheRipper.setSelected(true);
            if(History.H_p.get(RowNumber).JTR_default){
                Interface.p_JTR.CB_JTR_Default.setSelected(true);
            }
            else{
                Interface.p_JTR.CB_JTR_Default.setSelected(false);
            }
            
            if(History.H_p.get(RowNumber).JTR_wordlist){
                Interface.p_JTR.CB_JTR_Dic.setSelected(true);
                Interface.TxtFPathDictionary.setEnabled(true);
                Interface.Open.setEnabled(true);
                Interface.jLabel2.setEnabled(true);
            }
            else{
                Interface.p_JTR.CB_JTR_Dic.setSelected(false);
            }
            
            if(History.H_p.get(RowNumber).JTR_BF){
                Interface.p_JTR.CB_JTR_BF.setSelected(true);
            }
            else{
                Interface.p_JTR.CB_JTR_BF.setSelected(false);
            }
        }else{
            Interface.Button_Edit_JTR.setEnabled(false);
            Interface.p_JTR.CB_JTR_Dic.setSelected(false);
            Interface.p_JTR.CB_JTR_BF.setSelected(false);
            Interface.p_JTR.CB_JTR_Default.setSelected(false);
            Interface.ButtonJohnTheRipper.setSelected(false);
        }
           
        // HASHCAT
        if (History.H_p.get(RowNumber).Hashcat){
            Interface.ButtonHashcat.setEnabled(true);
            Interface.Button_Edit_Hashcat.setEnabled(true);
            
            Interface.ButtonHashcat.setSelected(true);
            if(History.H_p.get(RowNumber).Hashcat_wordlist){
                Interface.p_Hashcat.CB_HASHCAT_Dic.setSelected(true);
                Interface.TxtFPathDictionary.setEnabled(true);
                Interface.Open.setEnabled(true);
                Interface.jLabel2.setEnabled(true);
            }
            else{
                Interface.p_Hashcat.CB_HASHCAT_Dic.setSelected(false);
            }
            
            if(History.H_p.get(RowNumber).Hashcat_BF){
                Interface.p_Hashcat.CB_HASHCAT_BF.setSelected(true);
            }
            else{
                Interface.p_Hashcat.CB_HASHCAT_BF.setSelected(false);
            }
        }else{
            Interface.Button_Edit_Hashcat.setEnabled(false);
            
            Interface.ButtonHashcat.setSelected(false);
            Interface.p_Hashcat.CB_HASHCAT_Dic.setSelected(false);
            Interface.p_Hashcat.CB_HASHCAT_BF.setSelected(false);
        }
        
        //RAINBOWCRACK
        if (History.H_p.get(RowNumber).RainbowCrack){
            Interface.ButtonRainbowCrack.setSelected(true);
            Interface.RainbowTableFile.setEnabled(true);
            Interface.jLabel4.setEnabled(true);
            Interface.Open2.setEnabled(true);
        }
        else{
            Interface.ButtonRainbowCrack.setSelected(false);
            Interface.RainbowTableFile.setEnabled(false);
            Interface.jLabel4.setEnabled(false);
            Interface.Open2.setEnabled(false);
        }
        
        //MASK
        if(History.H_p.get(RowNumber).Mask){
            Interface.CBox_Mask.setEnabled(true);
            Interface.CBox_SpecialC.setEnabled(true);
            Interface.CBox_UpperC.setEnabled(true);
            Interface.CBox_lowerC.setEnabled(true);
            Interface.CBox_digit.setEnabled(true);
            Interface.Spinner_MAX.setEnabled(true);
            
            Interface.CBox_Mask.setSelected(true);
            Interface.Spinner_MAX.setValue(History.H_p.get(RowNumber).Mask_Spinner);
            
            if (History.H_p.get(RowNumber).Mask_UC){
                Interface.CBox_UpperC.setSelected(true);
            }
            else{
                Interface.CBox_UpperC.setSelected(false);
            }
            
            if (History.H_p.get(RowNumber).Mask_lC){
                Interface.CBox_lowerC.setSelected(true);
            }
            else{
                Interface.CBox_lowerC.setSelected(false);
            }
            
            if (History.H_p.get(RowNumber).Mask_SC){
                Interface.CBox_SpecialC.setSelected(true);
            }
            else{
                Interface.CBox_SpecialC.setSelected(false);
            }
            
            if (History.H_p.get(RowNumber).Mask_digits){
                Interface.CBox_digit.setSelected(true);
            }
            else{
                Interface.CBox_digit.setSelected(false);
            }
            
            if(!History.H_p.get(RowNumber).Mask_SSC.equals("")){
                Interface.specialChar.setText(History.H_p.get(RowNumber).Mask_SSC);
                Interface.CBox_SomeSC.setSelected(true);
                Interface.CBox_SomeSC.setEnabled(true);               
                Interface.specialChar.setEnabled(true);
            }else{
                Interface.specialChar.setText("");
                Interface.CBox_SomeSC.setSelected(false);
                Interface.CBox_SomeSC.setEnabled(false);
                Interface.specialChar.setEnabled(false);
            }
            
        
        }else{
            Interface.CBox_Mask.setEnabled(false);
            Interface.CBox_SpecialC.setEnabled(false);
            Interface.CBox_UpperC.setEnabled(false);
            Interface.CBox_lowerC.setEnabled(false);
            Interface.CBox_digit.setEnabled(false);
            Interface.Spinner_MAX.setEnabled(false);
            Interface.CBox_SomeSC.setEnabled(false);
            Interface.specialChar.setEnabled(false);
            
            Interface.CBox_Mask.setSelected(false);
            Interface.Spinner_MAX.setValue(History.H_p.get(RowNumber).Mask_Spinner);
            Interface.CBox_UpperC.setSelected(false);
            Interface.CBox_lowerC.setSelected(false);
            Interface.CBox_SpecialC.setSelected(false);
            Interface.CBox_digit.setSelected(false);
            Interface.CBox_SomeSC.setText(History.H_p.get(RowNumber).Mask_SSC);
        }
        
        // WORDLIST
        if(!History.H_p.get(RowNumber).Wordlist.equals("")){
            Interface.TxtFPathDictionary.setText(History.H_p.get(RowNumber).Wordlist);
            
        }
        else{
            Interface.TxtFPathDictionary.setText(History.H_p.get(RowNumber).Wordlist);
        }
        
        // RAINBOWTABLE
        if(!History.H_p.get(RowNumber).RainbowTable.equals("")){
            Interface.RainbowTableFile.setText(History.H_p.get(RowNumber).RainbowTable);
            
        }else{
            Interface.RainbowTableFile.setText(History.H_p.get(RowNumber).RainbowTable);

        }
        
        Interface.p_HistoryTable.setVisible(false);
        
    }
    
    
    
    
    
   public void changeDetails(){
       
       
       if (jTable1.getSelectedRow() != -1){
           RowNumber = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
       }
       
       Day.setText(History.H_p.get(RowNumber).Date);
       jLabel7.setText(ConvertBool(History.H_p.get(RowNumber).JTR));
       if (jLabel7.getText().equals("YES")){jLabel7.setForeground(java.awt.Color.blue);} else {jLabel7.setForeground(java.awt.Color.red);}
       
       jLabel11.setText(ConvertBool(History.H_p.get(RowNumber).JTR_wordlist));
       if (jLabel11.getText().equals("YES")){jLabel11.setForeground(java.awt.Color.blue);} else {jLabel11.setForeground(java.awt.Color.red);}
       
       jLabel13.setText(ConvertBool(History.H_p.get(RowNumber).JTR_default));
       if (jLabel13.getText().equals("YES")){jLabel13.setForeground(java.awt.Color.blue);} else {jLabel13.setForeground(java.awt.Color.red);}
       
       jLabel15.setText(ConvertBool(History.H_p.get(RowNumber).JTR_BF));
       if (jLabel15.getText().equals("YES")){jLabel15.setForeground(java.awt.Color.blue);} else {jLabel15.setForeground(java.awt.Color.red);}
       
       jLabel8.setText(ConvertBool(History.H_p.get(RowNumber).Hashcat));
       if (jLabel8.getText().equals("YES")){jLabel8.setForeground(java.awt.Color.blue);} else {jLabel8.setForeground(java.awt.Color.red);}
       
       jLabel19.setText(ConvertBool(History.H_p.get(RowNumber).Hashcat_wordlist));
       if (jLabel19.getText().equals("YES")){jLabel19.setForeground(java.awt.Color.blue);} else {jLabel19.setForeground(java.awt.Color.red);}
      
       jLabel18.setText(ConvertBool(History.H_p.get(RowNumber).Hashcat_BF));
       if (jLabel18.getText().equals("YES")){jLabel18.setForeground(java.awt.Color.blue);} else {jLabel18.setForeground(java.awt.Color.red);}
       
       jLabel9.setText(ConvertBool(History.H_p.get(RowNumber).RainbowCrack));
       if (jLabel9.getText().equals("YES")){jLabel9.setForeground(java.awt.Color.blue);} else {jLabel9.setForeground(java.awt.Color.red);}
       
       jLabel21.setText(ConvertBool(History.H_p.get(RowNumber).Mask));
       if (jLabel21.getText().equals("YES")){jLabel21.setForeground(java.awt.Color.blue);} else {jLabel21.setForeground(java.awt.Color.red);}
       
       jLabel23.setText(ConvertBool(History.H_p.get(RowNumber).Mask_lC));
       if (jLabel23.getText().equals("YES")){jLabel23.setForeground(java.awt.Color.blue);} else {jLabel23.setForeground(java.awt.Color.red);}
       
       jLabel25.setText(ConvertBool(History.H_p.get(RowNumber).Mask_UC));
       if (jLabel25.getText().equals("YES")){jLabel25.setForeground(java.awt.Color.blue);} else {jLabel25.setForeground(java.awt.Color.red);}
       
       jLabel27.setText(ConvertBool(History.H_p.get(RowNumber).Mask_SC));
       if (jLabel27.getText().equals("YES")){jLabel27.setForeground(java.awt.Color.blue);} else {jLabel27.setForeground(java.awt.Color.red);}
       
       jLabel31.setText(ConvertBool(History.H_p.get(RowNumber).Mask_digits));
       if (jLabel31.getText().equals("YES")){jLabel31.setForeground(java.awt.Color.blue);} else {jLabel31.setForeground(java.awt.Color.red);}
       
       jLabel29.setText(History.H_p.get(RowNumber).Mask_SSC);
       jLabel3.setText(String.valueOf(History.H_p.get(RowNumber).Mask_Spinner));
       
       //jLabel33.setText(ConvertBool(History.H_p.get(RowNumber).RT));
       //if (jLabel33.getText().equals("YES")){jLabel33.setForeground(java.awt.Color.blue);} else {jLabel33.setForeground(java.awt.Color.red);}
       
       //String aux = "";
       //for (int i=0; i<(History.H_p.get(RowNumber).RT_Others.length); i++ ){
       //    aux = aux + History.H_p.get(RowNumber).RT_Others[i] + "   ";
       //}
       
       //jLabel34.setText(aux);
       jLabel36.setText(History.H_p.get(RowNumber).Wordlist);
       jLabel38.setText(History.H_p.get(RowNumber).RainbowTable);
       jLabel41.setText(History.H_p.get(RowNumber).Name);
       
   }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Details = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        Text_find = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Select = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Day = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        Cancel1 = new javax.swing.JButton();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if ((jTable1.getSelectedRow() > -1) && (jTable1.getValueAt(jTable1.getSelectedRow(), 0) != null)) {
                    Select.setEnabled(true);
                    changeDetails();
                }else{
                    Select.setEnabled(false);
                }
            }
        });
        jTable1.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jTable1.setModel(DTM);
        jScrollPane1.setViewportView(jTable1);
        History.GetHistory();
        changeDetails();
        String[] s ;

        for(int i=0; i< History.H_p.size();i++){
            s = History.H_p.get(i).Date.split("   ");
            DTM.addRow(new Object[] {History.H_p.get(i).id,s[0],s[1],History.H_p.get(i).Name});
        }

        jTabbedPane1.setVisible(false);
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel42.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Name");

        Text_find.getDocument().addDocumentListener(new DocumentListenerSearchName());

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(404, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Text_find)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addGap(3, 3, 3)
                .addComponent(Text_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search", jPanel4);

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new ListenerSearch());

        Cancel.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setPreferredSize(new java.awt.Dimension(80, 26));
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        Cancel.addActionListener(new ListenerClose());

        Select.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        Select.setText("Select");
        Select.setEnabled(false);
        Select.setPreferredSize(new java.awt.Dimension(80, 26));
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Details.addTab("HistoryTable", jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel10.setText("Wordlist:");

        jLabel7.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel4.setText("Use JohnTheRipper:");

        jLabel13.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel12.setText("Default:");

        jLabel14.setText("BF:");

        jLabel11.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(6, 6, 6))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel6.setText("Use RainbowCrack:");

        jLabel9.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6))
        );

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel5.setText("Use Hashcat:");

        jLabel18.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel16.setText("Wordlist:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel17.setText("BF:");

        jLabel19.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel19)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel40.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel40.setText("Name:");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Selected Options From:");

        Day.setText(History.H_p.get(0).Date);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Day)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(Day, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel21.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel26.setText("SpecialChar:");

        jLabel20.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel20.setText("Use Mask:");

        jLabel30.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel30.setText("Digits:");

        jLabel23.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel24.setText("UpperCases:");

        jLabel28.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel28.setText("SSpecialChar:");

        jLabel22.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel22.setText("LowerCases:");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 13)); // NOI18N
        jLabel2.setText("length:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.white));

        jLabel35.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel35.setText("Wordlist:");

        jLabel36.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));

        jLabel37.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel37.setText("RainbowTable:");

        jLabel38.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(null);

        jLabel39.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        jLabel39.setText("HISTORY DETAILS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel39)
                .addGap(198, 198, 198))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel39)
                .addGap(6, 6, 6))
        );

        Cancel1.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        Cancel1.setText("Cancel");
        Cancel1.setPreferredSize(new java.awt.Dimension(80, 26));
        Cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel1ActionPerformed(evt);
            }
        });
        Cancel1.addActionListener(new ListenerClose());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Details.addTab("Details", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Details)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Details, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
       
    }//GEN-LAST:event_CancelActionPerformed

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        System.out.println(jTable1.getSelectedRow());
        SelectHistory();
    }//GEN-LAST:event_SelectActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cancel1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Cancel1;
    private javax.swing.JLabel Day;
    private javax.swing.JTabbedPane Details;
    private javax.swing.JButton Select;
    private javax.swing.JTextField Text_find;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    }
