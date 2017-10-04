package com.secondson.perpus.dao;

import com.secondson.perpus.KoneksiDatabase;
import com.secondson.perpus.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author iyus
 */
public class BukuDao {
    //File Untuk perintah SQL ke database Table Buku
    
    public void save(Buku buku) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
        
        //language=PostgreSQL
        String sql = "INSERT INTO perpus.buku (judul_buku, tahun_terbit, pengarang, jumlah_buku) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, buku.getJudulBuku());
        statement.setInt(2, buku.getTahunTerbit());
        statement.setString(3, buku.getPengarang());
        statement.setInt(4, buku.getJumlahBuku());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    
    public void update(){
    
    }
    
    public void delete(){}
    
    public List<Buku> findAll(){
        return null;
    }
    
    public Buku findById(Integer idBuku){
        return null;
    }
}
