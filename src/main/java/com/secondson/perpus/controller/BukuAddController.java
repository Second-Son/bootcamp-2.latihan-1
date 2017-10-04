/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secondson.perpus.controller;

import com.secondson.perpus.dao.BukuDao;
import com.secondson.perpus.model.Buku;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iyus
 */
@WebServlet(urlPatterns={"/buku/new"})
public class BukuAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/buku/tambahBuku/tambahBuku.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Buku buku = new Buku();
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
        //System.out.println(buku.toString());
        
        BukuDao bukuDao = new BukuDao();
        try {
            bukuDao.save(buku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
