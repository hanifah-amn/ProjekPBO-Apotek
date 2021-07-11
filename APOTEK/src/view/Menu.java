/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Obat;

public class Menu extends JFrame implements ActionListener{
    
    JLabel ljudul = new JLabel("MAIN MENU");
    
    JButton btambah = new JButton("Tambah Obat");
    JButton blihat = new JButton("Lihat Obat");
    JButton bkasir = new JButton("Kasir");
    
    public Menu(){
        setSize(160,150);
        setLayout(null);
        add(ljudul);
        add(blihat);
        add(btambah);
        add(bkasir);
        
        ljudul.setBounds(35,5,200,20);
        
        btambah.setBounds(5,25,150,20);
        blihat.setBounds(5,45,150,20);
        bkasir.setBounds(5,75,150,20);
        
        btambah.addActionListener(this);
        blihat.addActionListener(this);
        bkasir.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btambah){
           Lihat lh = new Lihat();
           lh.dispose();
           dispose();
           Inputobat ik = new Inputobat();
           Edit ed = new Edit();
           ed.dispose();
          Obat md = new Obat();
           Control ct = new Control(lh, md,ik,ed);
        }
        
        if(e.getSource() == blihat){
           Lihat lh = new Lihat();
           Inputobat ik = new Inputobat();
           ik.dispose();
           Edit ed = new Edit();
           ed.dispose();
           Obat md = new Obat();
           Control ct = new Control(lh, md,ik,ed);
        }
        
        if(e.getSource() == bkasir){
           Kasir k = new Kasir();
           Obat md = new Obat();
           Control ct = new Control(md,k);
        }
    }
}  

