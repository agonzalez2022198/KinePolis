<%-- 
    Document   : MenuMaster
    Created on : sep 7, 2023, 8:25:02 a.m.
    Author     : Windows 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/menuDespegable.css">
        <title>Menu Principal</title>
    </head>
    <body >
        
        
        <nav class="navbar navbar-expand-lg nvbar-light " style="background-color: #242424">
        <div class="container-fluid position-relative nav-bar p-0">
            <!--<header class="header">-->
                <div class="container">
                    <div class="btn-menu">
                        <label for="btn-menu">☰</label>
                    </div>
                    <div class="logo">
                        <img style=" margin: 10px; height: 70px;" src="img/logoAdmin.png">
                    </div>
                    <nav class="menu">
                        <a href="MenuMaster.jsp">Inicio</a>
                        <a href="Controlador?menu=InicioSesion">Cerrar Sesión</a>
                    </nav>
                </div>
            <!--</header>-->
            <div class="capa"></div>
            <!--	--------------->
            <input type="checkbox" id="btn-menu">
            <div class="container-menu">
                <div class="cont-menu">
                    <nav>
                        <a href="Controlador?menu=Pelicula" target="myFrame">Pelicula</a>
                        <a href="Controlador?menu=Estreno&accion=listar" target="myFrame">Estreno </a>
                        <a href="Controlador?menu=Cine&accion=listar" target="myFrame">Cine</a>
                        <a href="#">Suscribirse</a>
                        <a href="#">Facebook</a>
                        <a href="#">Youtube</a>
                        <a href="#">Instagram</a>
                    </nav>
                    <label for="btn-menu">✖️</label>
                </div>
            </div>
        </div>
        </nav> 

        <div class="m-4" style="height: calc(100vh - 100px)">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none;">
                
            </iframe>
        </div>






  











        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>