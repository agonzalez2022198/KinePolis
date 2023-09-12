<%-- 
    Document   : Principal
    Created on : jul 21, 2023, 11:11:53 a.m.
    Author     : Windows 10
--%>

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
        <title>KINE POLIS</title>
    </head>

    <body>
        <div class="cabecera">
            <div class="anchocabecera">
                <div class="imagen-principal">
                    <img class="logo" src="img/logoUser.png">
                </div>
<!--                <div class="buscador">
                    <select>
                        <option>Selecciona tu cine</option>
                        <option>Miraflores</option>
                        <option>Okland mall</option>
                        <option>Naranjo mall</option>
                    </select>
                    <input type="button" value="Ver cartelera" onclick="beforeImage()">
                </div>-->
<!--                <div class="contacto">
                    <input type="button" value="Contacto">
                </div>-->
                <nav class="menu">
                        <a href="Controlador?menu=InicioSesion">Cerrar Sesión</a>
                </nav>
            </div>
        </div>
        <nav class="navegador">
            <div class="anchonavegador">
                <ul>
                    <li>
                        <a href="">Inicio</a>
                    </li>
                    <li>
                        <a href="">Cartelera</a>
                    </li>
                    <li>
                        <a href="Controlador?menu=EstrenoUsuario" target="myFrame">Estrenos</a>
                    </li>
                    <li>
                        <a href="">Cines</a>
                    </li>
                    <li>
                        <a href="">Comprar Tickets</a>
                    </li>
                </ul>
                <ul>

                </ul>
            </div>
        </nav>
        <div class="imagen-slider">
            <div id="banners">
                <img class="imagenes-banners" src="img/banners/fnas.png">


            </div>
            <div class="botonesSigAnt">
                <button class="b-anterior" onclick="beforeImage()">-</button>
                <button class="b-siguiente" onclick="nextImage()">+</button>
            </div>
            <script>
                var slider_content = document.getElementById('banners');

                var image = ["comosifueralaprimeravez", "habiaunavezenhollywood", "historiasmiedo", "it", "angrybirds","fnas"];

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
                <div class="pelicula-info">
                    <img src="img/peliculas/angrybirds.jpg">
                    <p>Angry Birds </p>
                    <p>Duración: 120 min </p>
                    <p>Genero: Animada </p>
                </div>
                <div class="pelicula-info">
                    <img src="img/peliculas/dora.jpg">
                    <p>Dora la exploradora</p>
                    <p>Duración: 120 min </p>
                    <p>Genero: Live action</p>
                </div>
                <div class="pelicula-info">
                    <img src="img/peliculas/historias.jpg">
                    <p>Historias de miedo para contar en la oscuridad </p>
                    <p>Duración: 120 min</p>
                    <p>Genero: Terror </p>
                </div>
                <div class="pelicula-info">
                    <img src="img/peliculas/it.jpg">
                    <p>IT 2 </p>
                    <p>Duración: 120 min</p>
                    <p>Genero: Terror </p>
                </div>
                <div class="pelicula-info">
                    <img src="img/peliculas/vidasecreta.jpg">
                    <p>La vida secreta de tus mascotas </p>
                    <p>Duración: 120 min</p>
                    <p>Genero: Animada </p>
                </div>
                <div class="pelicula-info">
                    <img src="img/peliculas/agente.jpg">
                    <p>Agente bajo fuego </p>
                    <p>Duración: 120 min</p>
                    <p>Genero: Animada </p>
                </div>
                
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
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>

</html>