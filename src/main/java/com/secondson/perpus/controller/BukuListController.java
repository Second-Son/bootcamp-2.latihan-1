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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns={"/buku/list","/buku/"})
public class BukuListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Buku> listBuku = null;
        try {
            listBuku = new BukuDao().findAll();
        } catch (SQLException ex) {
            Logger.getLogger(BukuListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        req.setAttribute("listBuku", listBuku);
        req.getRequestDispatcher("/pages/buku/tambahBuku/listBuku.jsp").forward(req, resp); //Forward untuk membawa nilai dari req.setAttribute("listBuku", listBuku)
    }
    
}
