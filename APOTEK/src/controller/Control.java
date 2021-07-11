/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Obat;
import view.*;

public class Control {
    Obat model;
    Lihat tampilView;
    Inputobat input;
    Edit edit;
    Kasir kasir;
    String tabel;
    
    public Control(Lihat tampilview, Obat modell, Inputobat inputk, Edit editt){
        this.model = modell;
        this.tampilView = tampilview;
        this.input = inputk;
        this.edit = editt;
        
        tabel = "obat";
        
        if(model.getBanyakData(tabel)!=0){
            String dataobat[][] = model.readContact(tabel);
            tampilView.tabel.setModel((new JTable(dataobat, tampilView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        input.bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nama_obat = input.getnama_obat();
                String jumlah = input.getjumlah();
                String harga =input.getharga();
                model.insert(nama_obat, jumlah, harga);
         
                String dataobat[][] = model.readContact(tabel);
                tampilView.tabel.setModel((new JTable(dataobat, tampilView.namaKolom)).getModel());
            }
        });
        
        input.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.dispose();
                Menu m = new Menu();
                   
            }
        });
         
        input.breset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.fnama_obat.setText(null);
                input.fjumlah.setText(null);  
                input.fharga.setText(null);
            }
        });
        
        edit.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.dispose();
                

            }
        });
        
        tampilView.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilView.dispose();

            }
        });
        
        edit.bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama_obat = edit.getnama_obat();
                String cek = edit.getCek();
                String jumlah = edit.getjumlah();
                String harga =edit.getharga();
                model.update(nama_obat,cek, jumlah, harga);
                edit.dispose();
            }
        });
        
        edit.bhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cek = edit.getCek();
                model.delete(cek);
                edit.dispose();
            }
        });
        
        tampilView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampilView.tabel.getSelectedRow();
                
                String id = tampilView.tabel.getValueAt(baris, 0).toString();
                String nama_obat = tampilView.tabel.getValueAt(baris, 1).toString();
                String jumlah = tampilView.tabel.getValueAt(baris, 2).toString();
                String harga = tampilView.tabel.getValueAt(baris, 3).toString();
                
                tampilView.dispose();
                Edit ed = new Edit();
                ed.fnama_obat.setText(nama_obat);
                ed.fcek.setText(id);
                ed.fjumlah.setText(jumlah);
                ed.fharga.setText(harga);
                Lihat lh = new Lihat();
                lh.dispose();
                Inputobat ik = new Inputobat();
                ik.dispose();
                Obat md = new Obat();
                Control ct = new Control(lh,md,ik,ed);
                System.out.println("");       
            }
        }
        );
    }

    public Control(Obat modell, Kasir kasirr){
        this.model = modell;
        this.kasir = kasirr;
        
        tabel = "beli"; 
        
        if(model.getBanyakData(tabel)!=0){
            String dataobat[][] = model.readContact(tabel);
            kasirr.tabel.setModel((new JTable(dataobat, kasirr.namaKolom)).getModel());
        }
        
        kasir.btambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cek = kasir.getCek();
                String jumlah = kasir.getJumlah();
                model.beli(cek,jumlah);
                
                //refresh tabel
                String dataobat[][] = model.readContact(tabel);
                kasirr.tabel.setModel((new JTable(dataobat, kasirr.namaKolom)).getModel());
                
                kasir.fcek.setText(null);
                kasir.fjml.setText(null);
            }
        });
        
        kasir.bcheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.checkout();
                //refresh tabel
                String dataobat[][] = model.readContact(tabel);
                kasirr.tabel.setModel((new JTable(dataobat, kasirr.namaKolom)).getModel());
            }
        });
        
        kasir.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kasir.dispose();
                Menu m = new Menu();
                   
            }
        });
    }
}

