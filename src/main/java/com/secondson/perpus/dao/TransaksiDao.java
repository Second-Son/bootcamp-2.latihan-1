/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secondson.perpus.dao;

import com.secondson.perpus.KoneksiDatabase;
import com.secondson.perpus.model.Buku;
import com.secondson.perpus.model.Pengunjung;
import com.secondson.perpus.model.Transaksi;
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
public class TransaksiDao {
    public void pinjamBuku(Transaksi x) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        
        String sql = "insert into perpus.transaksi (buku_id, pengunjung_id, tanggal_pinjam) values (?, ?, now())";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x.getBuku().getId());
        preparedStatement.setInt(2, x.getPengunjung().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        sql = "update perpus.buku set jumlah_buku = ? where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x.getBuku().getJumlahBuku() - 1);
        preparedStatement.setInt(2, x.getBuku().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        connection.commit();
        connection.close();
    }
    
    public List<Transaksi> daftarTransaksi() throws SQLException{
        
        String sql = "select b.id as buku_id, b.judul_buku as judul_buku, b.jumlah_buku as jumlah_buku, b.tahun_terbit as tahun_terbit, b.pengarang as nama_pengarang, p.id as id_pengunjung, p.nama as nama_pengunjung, p.alamat as alamat_pengunjung, t.id as id_transaksi, t.tanggal_pinjam as tanggal_pinjam, t.tanggal_kembali as tanggal_kembali from perpus.buku b join perpus.transaksi t ON b.id = t.buku_id join perpus.pengunjung p ON t.pengunjung_id = p.id";
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = koneksiDatabase.getDataSource();
        Connection connection = dataSource.getConnection();
        List<Transaksi> listTransaksi = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Transaksi transaksi = new Transaksi();
            
            transaksi.setBuku(new Buku(
                    resultSet.getInt("buku_id"),
                    resultSet.getString("judul_buku"),
                    resultSet.getInt("tahun_terbit"),
                    resultSet.getString("nama_pengarang"),
                    resultSet.getInt("jumlah_buku")
                    
            ));
            
            transaksi.setPengunjung(new Pengunjung(
                    resultSet.getInt("id_pengunjung"),
                    resultSet.getString("nama_pengunjung"),
                    resultSet.getString("alamat_pengunjung")
            ));
            
            transaksi.setId(resultSet.getInt("id_transaksi"));
            transaksi.setTanggalPinjam(resultSet.getDate("tanggal_pinjam"));
            transaksi.setTanggalKembali(resultSet.getDate("tanggal_kembali"));
            
            listTransaksi.add(transaksi);
        }
        return listTransaksi;
    }
}
