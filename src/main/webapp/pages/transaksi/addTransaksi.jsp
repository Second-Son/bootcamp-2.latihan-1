<%-- 
    Document   : addTransaksi
    Created on : Oct 5, 2017, 2:25:40 PM
    Author     : iyus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>Tambah Peminjaman Buku</h1>
        <form method="post" action="${pageContext.servletContext.contextPath}/transaksi/pinjam">
        <div>
            <label for="bukuId"><b>Pilih Buku</b></label><br>
            <select name="bukuId" id="bukuId">
                <c:forEach items="${listBuku}" var="b">
                    <option value="${b.id}">${b.judulBuku} (${b.jumlahBuku})</option>
                </c:forEach>
            </select>
        </div><br>
        <div>
            <label for="pengunjungId"><b>Pilih Pengunjung</b></label><br>
            <select name="pengunjungId" id="pengunjungId">
                <c:forEach items="${listPengunjung}" var="p">
                    <option value="${p.id}">${p.nama}</option>
                </c:forEach>
            </select>
        </div><br>
        <div>
            <button type="submit">Kirim</button>
            <button type="reset">Reset</button>
        </div>
    </form>
        </center>
    </body>
</html>
