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

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=*-width, initial-scale=1.0"/>
        <style>
            .pelicula-item {
                height: 100px;
                margin-right: 20px; /* Ajusta el margen derecho según tu preferencia */
                margin-bottom: 20px; /* Ajusta el margen inferior según tu preferencia */
                display: inline-block; /* Para que los elementos se muestren en línea */
            }

            .pelicula-info {
                margin: 10px; /* Ajusta el margen según tu preferencia */
                display: inline-block; /* Para que los elementos se muestren en línea uno al lado del otro */
            }
            /*Nueevo css*/

            .menu {
                position: relative;
                display: inline-block;
                margin: 10px;
            }

            #dropdown-btn {
                background-color: #3498db;
                color: #fff;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
            }

            #dropdown-content {
                position: absolute;
                background-color: #fff;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            #dropdown-content ul {
                list-style: none;
                padding: 0;
                margin: 0;
            }

            #dropdown-content li {
                padding: 10px;
            }

            #dropdown-content a {
                text-decoration: none;
                color: #333;
                display: block;
            }

            #dropdown-content a:hover {
                background-color: #f1f1f1;
            }

            .hidden {
                display: none;
            }
        </style>
        <title>KINE POLIS</title>
    </head>

    <body>

        <div class="cabecera">
            <div class="anchocabecera">
                <div class="imagen-principal">
                    <img class="logo" src="img/logo.png">
                </div>
                <div class="buscador">
                    <select>
                        <option>Selecciona tu cine</option>
                        <option>Miraflores</option>
                        <option>Okland mall</option>
                        <option>Naranjo mall</option>
                    </select>
                    <input type="button" value="Ver cartelera" onclick="beforeImage()">
                </div>
                <div class="contacto">
                    <input type="button" value="Contacto">
                </div>
            </div>

        </div>
        <nav class="navegador">
            <div class="anchonavegador">
                <ul>
                    <li>
                        <div class="menu">
                            <button id="dropdown-btn">Usuario</button>
                            <div id="dropdown-content" class="hidden">
                                <ul>
                                    <li><a href="Controlador?menu=usuario&accion=listarCod&codigo=${usuario.getIdUsuario()}">Ver Perfil</a></li>
                                    <li><a href="#">Configuración</a></li>
                                    <li><a href="Controlador?menu=usuario&accion=listarUser&contra=${usuario.getContrasena()}&user=${usuario.getCorreo_electronico()}">Configuración de Cuenta</a></li>
                                    <li><a href="#">Salir</a></li>
                                </ul>
                            </div>
                            
                        </div>
                    </li>
                    <li>
                        <a href="">Inicio</a>
                    </li>
                    <li>
                        <a href="">Cartelera</a>
                    </li>
                    <li>
                        <a href="Controlador?menu=estrenoPrincipal&accion=listar">Estrenos</a>
                    </li>
                    <li>
                        <a href="Controlador?menu=promo&accion=listarPrincipal">Promociones</a>
                    </li>
                    <li>
                        <a href="Controlador?menu=preventaPrincipal&accion=listar">Preventa</a>
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
                <img class="imagenes-banners" src="img/banners/angrybirds.png">


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
                    <div class="pelicula-info">
                        <img src="ControllerIMG?id=${peli.getIdPelicula()}" style="width: 200px; height: 200px;">

                        <p>${peli.getTitulo()}</p>
                        <p>${peli.getDuracion()}MIN</p>
                        <p>${peli.getGenero()}</p>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="pie">
            <div class="pie-padre">
                <div class="pie-izquierda">
                    <h2>KinePolis</h2>
                    <p>Alv nosé que poner</p>
                </div>
                <div class="pie-centro">

                </div>
                <div class="pie-derecha">
                    <h3>Siguenos mamahuevo</h3>
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