package com.secondson.perpus.dao;

import com.secondson.perpus.KoneksiDatabase;
import com.secondson.perpus.model.Buku;
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
    
    public void delete(Integer idBuku) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql = "delete from perpus.buku where id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, idBuku);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
        
    }
    
    public List<Buku> findAll() throws SQLException{
        List<Buku> listBuku = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql = "select id, judul_buku, tahun_terbit, pengarang, jumlah_buku from perpus.buku";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()){
            Buku buku = new Buku();
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku")); //ini mengambil dari Field "judul_buku" tabel database
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));
            
            listBuku.add(buku);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listBuku;
    }
    
    public Buku findById(Integer idBuku){
        return null;
    }
}
