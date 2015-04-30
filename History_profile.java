/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

/**
 *
 * @author root
 */
public class History_profile {
    
    public int id;
    public String Date;
    public boolean Hashcat;
    public boolean Hashcat_wordlist;
    public boolean Hashcat_BF;
    public boolean JTR;
    public boolean JTR_default;
    public boolean JTR_wordlist;
    public boolean JTR_BF;
    public boolean RainbowCrack;
    public String Wordlist;
    public String RainbowTable;
    public String Name;
    public boolean Mask;
    public boolean Mask_UC;
    public boolean Mask_lC;
    public boolean Mask_digits;
    public boolean Mask_SC;
    public String Mask_SSC;
    public int Mask_Spinner;
    public boolean RT;
    public String[] RT_Others;
    

    public History_profile(int id, String Date, boolean Hashcat, boolean Hashcat_wordlist, boolean Hashcat_BF, boolean JTR, boolean JTR_default, boolean JTR_wordlist, boolean JTR_BF, boolean RainbowCrack, String Wordlist, String RainbowTable, String Name, boolean Mask, boolean Mask_UC, boolean Mask_lC, boolean Mask_digits, boolean Mask_SC, String Mask_SSC, int Mask_Spinner, boolean RT, String[] RT_Others) {
        this.id = id;
        this.Date = Date;
        this.Hashcat = Hashcat;
        this.Hashcat_wordlist = Hashcat_wordlist;
        this.Hashcat_BF = Hashcat_BF;
        this.JTR = JTR;
        this.JTR_default = JTR_default;
        this.JTR_wordlist = JTR_wordlist;
        this.JTR_BF = JTR_BF;
        this.RainbowCrack = RainbowCrack;
        this.Wordlist = Wordlist;
        this.RainbowTable = RainbowTable;
        this.Name = Name;
        this.Mask = Mask;
        this.Mask_UC = Mask_UC;
        this.Mask_lC = Mask_lC;
        this.Mask_digits = Mask_digits;
        this.Mask_SC = Mask_SC;
        this.Mask_SSC = Mask_SSC;
        this.Mask_Spinner = Mask_Spinner;
        this.RT = RT;
        this.RT_Others = RT_Others;
    }

    @Override
    public String toString() {
        return "History_profile{" + "id" + id + "Date=" + Date + ", Hashcat=" + Hashcat + ", Hashcat_wordlist=" + Hashcat_wordlist + ", Hashcat_BF=" + Hashcat_BF + ", JTR=" + JTR + ", JTR_default=" + JTR_default + ", JTR_wordlist=" + JTR_wordlist + ", JTR_BF=" + JTR_BF + ", RainbowCrack=" + RainbowCrack + ", Wordlist=" + Wordlist + ", RainbowTable=" + RainbowTable + ", Name=" + Name + ", Mask=" + Mask + ", Mask_UC=" + Mask_UC + ", Mask_lC=" + Mask_lC + ", Mask_digits=" + Mask_digits + ", Mask_SC=" + Mask_SC + ", Mask_SSC=" + Mask_SSC + ", Mask_Spinner=" + Mask_Spinner + ", RT=" + RT + ", RT_Others=" + RT_Others + '}';
    }
    
}
