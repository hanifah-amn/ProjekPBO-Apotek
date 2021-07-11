/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Lihat extends JFrame {
    
    public JTable tabel;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    public Object namaKolom[] = {"ID", "Nama Obat", "Jumlah", "Harga"};
    
    public JButton bkembali = new JButton("Kembali");
    
    public Lihat(){
        setTitle("Data Obat");
        setSize(750, 300);
        setLayout(null);
        add(bkembali);
        model = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(model);
        scrollPanel = new JScrollPane(tabel);
        
        scrollPanel = new JScrollPane(tabel);
        add(scrollPanel);
        
        scrollPanel.setBounds(15, 15, 700, 175);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        bkembali.setBounds(20, 200, 700, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

