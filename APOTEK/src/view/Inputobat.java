/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Inputobat extends JFrame {
    JLabel ljudul = new JLabel("Input Obat");
    
    JLabel lnama_obat = new JLabel("Nama Obat");
    public final JTextField fnama_obat = new JTextField(10);
    
    JLabel ljumlah = new JLabel("Jumlah");
    public final JTextField fjumlah= new JTextField(10);
    
    JLabel lharga = new JLabel("Harga");
    public final JTextField fharga = new JTextField(10);
    
    public JButton bsubmit = new JButton("Submit");
    public JButton breset = new JButton("Reset");
    
    public JButton bkembali = new JButton("Kembali");
    
     public Inputobat(){
        setTitle("Input Obat");
        setSize(350,230);
        setLayout(null);
        add(ljudul);
        add(lnama_obat);
        add(fnama_obat);
        add(ljumlah);
        add(fjumlah);
        add(lharga);
        add(fharga);  
        add(bsubmit);
        add(breset); 
        add(bkembali);
        
        ljudul.setBounds(15,5,200,20);
        lnama_obat.setBounds(15,30,100,20);
        fnama_obat.setBounds(115,30,200,20);
        
        ljumlah.setBounds(15,60,100,20);
        fjumlah.setBounds(115,60,200,20);
        
        lharga.setBounds(15,90,100,20);
        fharga.setBounds(115,90,200,20);
        
        bsubmit.setBounds(55,130,90,20);
        breset.setBounds(155,130,90,20);
        bkembali.setBounds(15,165,250,20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }

    public String getnama_obat(){
        return fnama_obat.getText();
    }
    
    public String getjumlah(){
        return fjumlah.getText();
    }
    
    public String getharga(){
        return fharga.getText();
    }
}
    

