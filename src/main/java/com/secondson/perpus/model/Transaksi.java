/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secondson.perpus.model;

import java.sql.Date;
import lombok.Data;
/**
 *
 * @author iyus
 */
@Data
public class Transaksi {
    private Integer id;
    private Buku buku;
    private Pengunjung pengunjung;
    private Date tanggalPinjam;
    private Date tanggalKembali; 
    
    
}
