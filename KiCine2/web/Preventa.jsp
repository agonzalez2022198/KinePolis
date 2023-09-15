
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Clientes</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-image: url('img/fondoPreventa.png'); /* Ruta de la imagen de fondo */
                background-size: cover;
                background-repeat: no-repeat;
                background-attachment: fixed; /* Fija la imagen de fondo */
                
                margin: 0;
                padding: 0;
                color: #fff; /* Color de texto predeterminado en el fondo */
            }

            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }
            .header {
                background-color: #333;
                color: #fff;
                padding: 20px 0;
                text-align: center;
            }

            .header h1 {
                font-size: 36px;
            }
            .footer {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 20px 0;
            }
        </style>
    </head>
    <body>
        <header class="header">
            <h1>Preventa de Cine</h1>
        </header>
        <div class="d-flex">

            <div class="col-sm-8">
                <table class="table table-hober center-table">
                    <thead>
                        <tr>
                            <td>ID PREVENTA:</td>
                            <td>DESCRIPCION:</td>
                            <td>PRECIO PREVENTA:</td>
                            <td>PELICULA ID:</td>
                            <td>PELICULA:</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="preventa" items="${preventa}">
                            <tr>
                                <td>${preventa.getIdPreventa()}</td>
                                <td>${preventa.getDescripcion()}</td>
                                <td>${preventa.getPrecioPreventa()}</td>
                                <td>${preventa.getPelicula_id()}</td>

                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>  

        </div>
        <footer class="footer">
            © 2023 Preventa de Cine
        </footer>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    </body>
</html>

