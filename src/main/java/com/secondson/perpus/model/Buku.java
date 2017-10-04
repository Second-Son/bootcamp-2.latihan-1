/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secondson.perpus.model;

import lombok.Data;

/**
 *
 * @author iyus
 */
@Data
public class Buku {
    private Integer id;
    private String judulBuku;
    private Integer tahunTerbit;
    private String pengarang;
    private Integer jumlahBuku;
    
}
