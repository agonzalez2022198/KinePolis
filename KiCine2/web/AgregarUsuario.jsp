<%-- 
    Document   : index
    Created on : jul 21, 2023, 7:17:01 a.m.
    Author     : Windows 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Define que el documento esta bajo el estandar de HTML 5 -->
<!doctype html>

<!-- Representa la raíz de un documento HTML o XHTML. Todos los demás elementos deben ser descendientes de este elemento. -->
<html lang="es">
    
    <head>      
        <meta charset="utf-8">      
        <title> Formulario de Acceso </title>           
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
        <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">
        
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">
        
        <!-- Link hacia el archivo de estilos css -->
        <link rel="stylesheet" href="css/styleLogin.css">        
        <style type="text/css">           
        </style>       
        <script type="text/javascript">        
        </script> 
    </head>
    <body>
        <div id="contenedor">
            <div id="central">
                <div id="login">
                    <div class="titulo">
                        Bienvenido
                    </div>
                    <form id="loginform" action="Controlador?menu=usuario" method="POST">
                        
                        <input id="name" type="text" placeholder="Nombre" name="nombre" required>
                        
                        <input id="correo" type="text" placeholder="Apellido" name="apellido" required>
                        
                        <input id="correo" type="text" name="correo" placeholder="correo" required>
                        
                        <input id="password" type="password" placeholder="Contrasena" name="contrasena" required>
                        
                        <input type="submit" name="accion" value="agregar" class="ntt" >
                    </form>
                    </div>
                
                <div class="inferior">
                    <a href="Controlador?menu=InicioSesion">Volver</a>
                </div>
            </div>
        </div>
        <Script ></Script>
            
    </body>
</html>