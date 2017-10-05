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
@WebServlet(urlPatterns="/buku/edit")
public class BukuUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer kodeBuku = Integer.valueOf(req.getParameter("kodeBuku"));
            Buku sebuahBuku = new BukuDao().findById(kodeBuku);
            req.setAttribute("buku", sebuahBuku);
            req.getRequestDispatcher("/pages/buku/tambahBuku/editBuku.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(BukuUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Buku buku = new Buku();
        buku.setId(Integer.valueOf(req.getParameter("idBuku")));
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
        //System.out.println(buku.toString());
        
        BukuDao bukuDao = new BukuDao();
        try {
            bukuDao.update(buku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/buku/"); //untuk me Redirect ke halaman buku atau listBuku.jsp
    }
}
