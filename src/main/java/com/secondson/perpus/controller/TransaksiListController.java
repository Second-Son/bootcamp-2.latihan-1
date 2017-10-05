package com.secondson.perpus.controller;

import com.secondson.perpus.dao.TransaksiDao;
import com.secondson.perpus.model.Transaksi;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/transaksi/","/transaksi/list"})
public class TransaksiListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            List<Transaksi> listTransaksi = new TransaksiDao().daftarTransaksi();
            req.setAttribute("listTransaksi", listTransaksi);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.getRequestDispatcher("/pages/transaksi/listTransaksi.jsp").forward(req, resp);
        
    }
    
}
