<%-- 
    Document   : Comentario
    Created on : 21/07/2023, 11:06:39 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
        <title>Comentario</title>
        <style>
            .header {
                background-color: #333;
                color: #fff;
                padding: 20px 0;
                text-align: center;
            }

            .header h1 {
                font-size: 36px;
            }

            .card {
                background-color: #386b8f;
                border-radius: 10px;
                color: white;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                padding: 20px;
                text-align: center;
                width: auto;
                height: auto;
            }


        </style>
    </head>
    <body style="background-image: url('img/fondoAdm.png'); background-color: gray; background-size: cover; background-repeat: no-repeat;">
        <header class="header">
            <h1>Comentario</h1>
        </header>
        <div  class="card">
            <div class="col-sm-15">
                <div class="">
                    <form action="Controlador?menu=Comentario" method="POST">
                        <div class="card-body" style="background-color: #F8F8F8; border: none; border-radius: 3%">



                            <div class="col-sm-11">
                                <!--<label>Comentario:</label>-->
                                <input type="text"  name="txtComentario" class="form-control"><br>
                                <input type="hidden" value="${cod}" name="txtUsuario_id" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <div>
                                    <button type="submit"  name="accion" value="Agregar" class="btn btn-outline-info">Agregar Comentario</button>
                                </div>
                            </div>
                            <!------------------------------------------------  Editar     -------------------------------------------------------------------------------------------------------------------->
                            <br>
                        </div>
                    </form>
                </div>
            </div>


        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>