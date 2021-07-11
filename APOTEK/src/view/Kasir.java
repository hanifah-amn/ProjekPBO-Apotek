/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Kasir extends JFrame {
    JLabel ljudul = new JLabel("PEMBELIAN OBAT");
    JLabel lkode = new JLabel("Kode Obat");
    JLabel ljml = new JLabel("Jumlah Beli");
    public JTextField fcek = new JTextField(10);
    public JTextField fjml = new JTextField(10);
    
    public JTable tabel;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    public Object namaKolom[] = {"ID", "Nama Obat", "Jumlah", "Harga"};
    
    public JButton btambah = new JButton("Tambah");
    public JButton bcheckout = new JButton("Checkout");
    public JButton bkembali = new JButton("Kembali");
    
    public Kasir(){
        setTitle("Pembelian Obat");
        setSize(750, 450);
        setLayout(null);
        add(ljudul);
        add(lkode);
        add(ljml);
        add(fcek);
        add(fjml);
        add(btambah);
        add(bcheckout);
        add(bkembali);
        
        ljudul.setBounds(200, 5, 200, 20);
        lkode.setBounds(20, 35, 100, 20);
        fcek.setBounds(130, 35, 100, 20);
        ljml.setBounds(20, 65, 100, 20);
        fjml.setBounds(130, 65, 100, 20);
        btambah.setBounds(240, 65, 100, 20);
        
        //tabel
        model = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(model);
        scrollPanel = new JScrollPane(tabel);
        add(scrollPanel);
        scrollPanel.setBounds(15, 95, 700, 175);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        bcheckout.setBounds(20, 300, 200, 20);
        bkembali.setBounds(20, 350, 700, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public String getCek(){
        return fcek.getText();
    }
    
    public String getJumlah(){
        return fjml.getText();
    }
}
