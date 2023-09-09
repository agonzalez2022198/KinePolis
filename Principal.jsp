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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
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
                    <div>
                    <input type="button" value="Contacto">
                    </div>
                    
                </div>
                <div class="contacto">
                        <form action="Validar" method="POST">
                            <input style="text-align: center" type="button" value="Salir" name="accion" name="Salir" class="dropdown-item" href="#">
                        </form>
                </div>
                
            </div>
        </div>
        <nav class="navegador">
            <div class="anchonavegador" text-align="center">
                
                        <ul>
                            <li>
                                <a style="margin-left: 10px; birder: none" class="btn btn-outline-success" href="Controlador?menu=MenuMaster&accion=listar" target="myFrame">Menu Master</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; birder: none" class="btn btn-outline-success" href="Controlador?menu=Cartelera&accion=listar" target="myFrame">Cartelera</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Estreno&accion=listar" target="myFrame">Estrenos</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Cine&accion=listar" target="myFrame">Cine</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; birder: none" class="btn btn-outline-success" href="Controlador?menu=SalaCine&accion=listar" target="myFrame">Sala de cine</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; birder: none" class="btn btn-outline-success" href="Controlador?menu=HorariosProyeccion&accion=listar" target="myFrame">Horarios de Proyeccion</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=FuncionEspecial&accion=listar">Funcion Especial</a>
                            </li>
                            <li>
                                <a style="margin-left: 10ox; border: none" class="btn btn-outline-success" href="Controlador?menu=Taquilla&accion=listar">Taquilla</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Reserva&accion=listar" target="myFrame">Reserva</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Pelicula&accion=listar" target="myFrame">Pelicula</a>
                            </li>
                            <li>
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Promocion&accion=listar">Promocion</a>
                            </li>
                            <li>
                                <a style="margin-left: 10ox; border: none" class="btn btn-outline-success" href="Controlador?menu=Comentario&accion=listar">Comentarios</a>
                            </li>
                            <li>
                                <a style="margin-left: 10ox; border: none" class="btn btn-outline-success" href="Controlador?menu=Factura&accion=listar">Factura</a>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>

</html>