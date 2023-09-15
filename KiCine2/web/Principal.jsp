<%-- 
    Document   : Principal
    Created on : jul 21, 2023, 11:11:53 a.m.
    Author     : Windows 10
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link rel="stylesheet" href="css/stylePrincipal.css">
        <meta name="viewport" content="width=*-width, initial-scale=1.0"/>

        <!--Let browser know website is optimized for mobile-->

        <title>KINE POLIS</title>
    </head>

    <body>

        <div class="cabecera">
            <div class="anchocabecera">
                <div class="imagen-principal">
                    <img class="logo" src="img/logoUser.png">
                </div>
                <nav class="menu">
                    <a href="Controlador?menu=InicioSesion">Cerrar Sesión</a>
                </nav>
                <nav class="menu">

                    <button id="dropdown-btn">Usuario</button>
                    <div id="dropdown-content" class="hidden" style="margin-top: 40px;">
                        <ul>
                            <li><a href="Controlador?menu=usuario&accion=listarCod&codigo=${usuario.getIdUsuario()}">Ver Perfil</a></li>
                            <li><a href="Controlador?menu=usuario&accion=listarUser&contra=${usuario.getContrasena()}&user=${usuario.getCorreo_electronico()}">Configuración de Cuenta</a></li>
                            <li><a href="#">Salir</a></li>
                        </ul>
                    </div>


                </nav>
            </div>
        </div>
    </div>


    <nav class="navegador">
        <div class="anchonavegador">
            <ul>
                <li>
                    <a href="Controlador?menu=Comentario&accion=listar&cod=${usuario.getIdUsuario()}">Comentario</a>
                </li>
                <li>
                    <a href="Controlador?menu=Factura&accion=listar">Factura</a>
                </li>
                <li>
                    <a href="Controlador?menu=estrenoPrincipal&accion=listar">Estrenos</a>
                </li>
                <li>
                    <a href="Controlador?menu=promo&accion=listarPrincipal">Promociones</a>
                </li>
                <li>
                    <a href="Controlador?menu=cinesListar&accion=listar&cod=${usuario.getIdUsuario()}">Preventa</a>
                </li>
                <li>
                    <a href="Controlador?menu=funcionPrincipal&accion=listar">Funciones</a>
                </li>

            </ul>
            <ul>

            </ul>
        </div>
    </nav>


    <div class="imagen-slider">
        <div id="banners">
            <img class="imagenes-banners" src="img/banners/angrybirds.png" >


        </div>
        <div class="botonesSigAnt">
            <button class="b-anterior" onclick="beforeImage()">-</button>
            <button class="b-siguiente" onclick="nextImage()">+</button>
        </div>
        <script>
            var slider_content = document.getElementById('banners');

            var image = ["angrybirds", "comosifueralaprimeravez", "habiaunavezenhollywood", "historiasmiedo", "it", "angrybirds"];

            var i = image.length;

            function nextImage() {
                if (i < image.length) {
                    i = i + 1;
                    if (i == image.length) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                slider_content.innerHTML = "<img class=\"imagenes-banners\" src=\"img/banners/" + image[i] + ".png\">";
            }

            function beforeImage() {
                if (i < image.length + 1 && i > 1) {
                    i = i - 1;
                } else {
                    i = image.length;
                }
                slider_content.innerHTML = "<img class=\"imagenes-banners\" src=img/banners/" + image[i - 1] + ".png>";
            }
        </script>
    </div>


    <div class="peliculas">
        <h2>Películas</h2>
        <div class="listapeliculas">
            <c:forEach var="peli" items="${lista}">
                <div class="pelicula-info" >
                    <img src="ControllerIMG?id=${peli.getIdPelicula()}" style="width: 350px; height: 450px">

                    <p style="color: white"><b>${peli.getTitulo()}</b></p>
                    <p style="color: white"><b>${peli.getDuracion()} min</b></p>
                    <p style="color: white"><b>${peli.getGenero()}</b></p>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="pie">
        <div class="pie-padre">
            <div class="pie-izquierda">
                <h2>KinePolis</h2>
                <p>Vive una experiencia inolvidable</p>
            </div>
            <div class="pie-centro">

            </div>
            <div class="pie-derecha">
                <h3>Siguenos</h3>
                <ul>
                    <li>
                        <a href=""><img src="img/icons/Facebook_16px.png"> Facebook</a>
                    </li>
                    <li>
                        <a href=""><img src="img/icons/Instagram_16px.png"> Instagram</a>
                    </li>
                    <li>
                        <a href=""><img src="img/icons/Twitter_16px.png"> Twitter</a>
                    </li>
                </ul>



            </div>
        </div>

    </div>
    <script>
        setInterval('nextImage()', 3000);
    </script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const dropdownBtn = document.getElementById("dropdown-btn");
            const dropdownContent = document.getElementById("dropdown-content");

            dropdownBtn.addEventListener("click", function () {
                if (dropdownContent.classList.contains("hidden")) {
                    dropdownContent.classList.remove("hidden");
                } else {
                    dropdownContent.classList.add("hidden");
                }
            });
        });

    </script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>

</html>