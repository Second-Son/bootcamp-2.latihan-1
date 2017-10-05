<%-- 
    Document   : listBuku
    Created on : Oct 5, 2017, 9:38:07 AM
    Author     : iyus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Buku</title>
    </head>
    <body>
        <center>
        <h1>Daftar Buku</h1>
        <table border="5" cellpadding="5">
            <thead>
                <tr>
                    <td align=center><b>No</b></td>
                    <td align=center><b>Judul Buku</b></td>
                    <td align=center><b>Tahun Terbit</b></td>
                    <td align=center><b>Jumlah Buku</b></td>
                    <td align=center><b>Nama Pengarang</b></td>
                    <td align=center><b>Aksi</b></td>
                </tr>
            </thead>    
            </tbody>
            <c:forEach items="${listBuku}" var="sebuahBuku" varStatus="index">
                <tr> 
                    <td align=center>${index.count}</td>
                    <td align=center>${sebuahBuku.judulBuku}</td>
                    <td align=center>${sebuahBuku.tahunTerbit}</td>
                    <td align=center>${sebuahBuku.jumlahBuku}</td>
                    <td align=center>${sebuahBuku.pengarang}</td>
                    <td align=center>
                            <a href="${pageContext.servletContext.contextPath}/buku/edit?kodeBuku=${sebuahBuku.id}">Edit</a>
                        <a href="${pageContext.servletContext.contextPath}/buku/delete?kodeBuku=${sebuahBuku.id}">Hapus</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </center>
    </body>
</html>
