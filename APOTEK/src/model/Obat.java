/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

public class Obat {

    Koneksi koneksi = new Koneksi();
    
    public String[][] readContact(String tabel){
        try{
            int jumlah = 0;
            
            String data[][] = new String[getBanyakData(tabel)][4]; 
            
            String query = "Select * from "+tabel; 
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlah][0] = resultSet.getString("id"); 
                data[jumlah][1] = resultSet.getString("nama_obat");                
                data[jumlah][2] = resultSet.getString("jumlah");
                data[jumlah][3] = resultSet.getString("harga");
                jumlah++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public int getBanyakData(String tabel){
        int jmlData = 0;
        try{
            koneksi.statement = koneksi.koneksi.createStatement();
            String query = "Select * from "+tabel;
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
     
    public void insert(String nama_obat, String jumlah, String harga){
        int jml=0;
        try {
           String query = "Select * from obat"; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jml++;
            }
                query = "INSERT INTO obat VALUES('0','"+nama_obat+"','"+jumlah+"','"+harga+"')";
                
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
         catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
       public void update(String nama_obat, String cek, String jumlah, String harga){
        int jml=0;
         try {
           String query = "Select * from obat WHERE id=" + cek; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jml++;
            }
           
             if (jml==1) {
                query = "UPDATE obat SET id='" + cek + "', nama_obat='" + nama_obat + "', jumlah='" + jumlah + "', harga='" + harga + "' WHERE id=" + cek;
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void delete (String cek) {
        try{
            String query = "DELETE FROM obat WHERE id = '"+cek+"'";
            koneksi.statement = koneksi.koneksi.createStatement();
            koneksi.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    public void beli(String cek, String jumlah){
        int jml=0;
        
         try {
           String query = "Select * FROM obat WHERE id = '"+cek+"'"; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
            while (resultSet.next()){ 
                //menyalin baris tabel obat ke tabel beli dengan jumlah beli obat
                query = "INSERT INTO beli(id,nama_obat,jumlah,harga) SELECT id,nama_obat,"+jumlah+",harga FROM obat WHERE obat.id="+cek;
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query);
                jml++;
            }
           
             if (jml==0) {
                JOptionPane.showMessageDialog(null, "Data tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void checkout(){
         try {
            String query = "SELECT SUM(jumlah*harga) FROM beli"; 
            ResultSet resultSet = koneksi.statement.executeQuery(query);
           
            while (resultSet.next()){ 
                String total = resultSet.getString("SUM(jumlah*harga)"); 
                JOptionPane.showMessageDialog(null, "Total Harga: "+total);
            }
            
            
            //update jumlah obat pada tabel obat
            query = "SELECT * FROM beli"; 
            ResultSet row = koneksi.statement.executeQuery(query);
            while (row.next()){
                String query2 = "UPDATE obat o, beli b SET o.jumlah=(o.jumlah-b.jumlah) WHERE o.id=b.id";
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query2);
            }
            
            //menghapus semua baris pada tabel beli
            query = "DELETE FROM beli";
            koneksi.statement = koneksi.koneksi.createStatement();
            koneksi.statement.executeUpdate(query);
            
         }
        catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
            }
    }
}
