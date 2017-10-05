<%-- 
    Document   : listTransaksi
    Created on : Oct 5, 2017, 5:10:41 PM
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
        <h1>List Transaksi</h1>
        <table border="5">
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Pengunjung</td>
                    <td>Kode Buku</td>
                    <td>Nama Buku</td>
                    <td>Tanggal Pinjam</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listTransaksi}" var="t" varStatus="idx">
                <tr>
                    <td>${idx.count}</td>
                    <td>${t.pengunjung.nama}</td>
                    <td>${t.buku.id}</td>
                    <td>${t.buku.judulBuku}</td>
                    <td>${t.tanggalPinjam}</td>
                    <td>
                        <c:if test="${t.tanggalKembali != null}">
                            <c:out value="Sudah Dikembalikan"></c:out>
                        </c:if>
                        <c:if test="${t.tanggalKembali == null}">
                            <a href="${pageContext.servletContext.contextPath}/transaksi/kembali?kode=${t.id}">Kembalikan</a>
                        </c:if>
                    </td>
                </tr>                    
                </c:forEach>
            </tbody>
        </table>
        </center>
    </body>
</html>
