<%-- 
Document   : tambahBuku
Created on : Oct 4, 2017, 4:31:06 PM
Author     : iyus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <center>
    <h1>Edit Buku</h1>
    <form action="${pageContext.servletContext.contextPath}/buku/edit" method="post">
        <input type="hidden" name="idBuku" value="${buku.id}"/>
        <div>
            <label for="judulBuku"><b>Judul Buku :</b></label><br>
            <input type="text" name="judulBuku" id="judulBuku" value="${buku.judulBuku}"/>
        </div><br>
        <div>
            <label for="tahunTerbit"><b>Tahun Terbit :</b></label><br>
            <input type="number" name="tahunTerbit" id="tahunTerbit" value="${buku.tahunTerbit}"/>
        </div><br>
        <div>
            <label for="pengarang"><b>Pengarang :</b></label><br>
            <input type="text" name="pengarang" id="pengarang" value="${buku.pengarang}"/>
        </div><br>
        <div>
            <label for="jumlahBuku"><b>Jumlah Buku :</b></label><br>
            <input type="number" name="jumlahBuku" id="jumlahBuku" value="${buku.jumlahBuku}"/>
        </div><br>
        <div>
            <button type="submit">Kirim</button>
            <button type="reset">Reset</button>
        </div>
    </form>
    </center>
</body>
</html>
