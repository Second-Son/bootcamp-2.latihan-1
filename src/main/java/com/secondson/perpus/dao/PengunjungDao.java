/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secondson.perpus.dao;

import com.secondson.perpus.KoneksiDatabase;
import com.secondson.perpus.model.Buku;
import com.secondson.perpus.model.Pengunjung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author iyus
 */
public class PengunjungDao {
    public List<Pengunjung> findAll() throws SQLException{
        List<Pengunjung> listPengunjung = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql = "select id, nama, alamat from perpus.pengunjung";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Pengunjung pengunjung = new Pengunjung();
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
            listPengunjung.add(pengunjung);
            
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listPengunjung;
    }
    
    public void save(Pengunjung x){
    
    }
    
    public void update(Pengunjung x){
    
    }
    
    public void hapus(Integer id){
    
    }

    public Pengunjung findById(Integer x) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql = "select id, nama, alamat from perpus.pengunjung where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, x);
        ResultSet resultSet = statement.executeQuery();
        Pengunjung pengunjung = new Pengunjung();
        if (resultSet.next()){
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("nama"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
            
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return pengunjung;
    }
}
