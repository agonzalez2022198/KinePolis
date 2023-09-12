<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Factura de Cine</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>

        <style>
            body {
                font-family: Arial, sans-serif;
            }

            .invoice {
                width: 80%;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                background-color: #fff;
            }

            .invoice h1 {
                text-align: center;
            }

            .invoice .header {
                display: flex;
                justify-content: space-between;
                margin-bottom: 20px;
            }

            .invoice .header-left {
                font-size: 14px;
            }

            .invoice .header-right {
                font-size: 12px;
            }

            .invoice .details table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .invoice .details table th,
            .invoice .details table td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: left;
            }

            .invoice .total {
                margin-top: 20px;
                text-align: right;
                font-weight: bold;
            }
        </style>

    </head>
    <body>
            <br></br>
            <c:forEach var="factura" items="${factura}">
            <div id="factura">
                <div class="invoice">
                    <h1 class="mt-5">Factura Administración KinePolis</h1>
                    <div class="header">
                        <div class="header-left">
                            <p>Empresa: KinePolis</p>
                            <p>Dirección: 6A Avenida 13-54, Cdad. de Guatemala</p>
                            <p>Teléfono: 5421-7175</p>
                        </div>
                        <div class="header-right">
                            <p>Fecha de emisión: <td>${factura.getFechaEmision()}</td>
                            <p>ID Factura: <td>${factura.getIdFactura()}</td>
                        </div>
                    </div>
                    <center>


                        <div class="details">
                                 <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Fecha de emisión</th>
                                        <th>Nombre Usuario</th>
                                        <th>Cine</th>
                                        <th>Entrada</th>
                                        <th>SubTotal</th>
                                    </tr>
                                </thead>
                                <tbody id="facturaBody">
                                </tbody>
                            
                            
                          
                                    <thead>
                                        <tr>
                                            <td>${factura.getFechaEmision()}</td>
                                            <td>${factura.getUsuario_id()}</td>
                                            <td></td>
                                            <td></td>
                                            <td>${factura.getSubTotal()}</td>
                                        </tr>
                                    </thead>
                                    <tbody id="facturaBody">
                                    </tbody>
                                </table>
                            </c:forEach>
                        </div>
                </div>

            </div>
            <center>
                <button onclick="convertirAPDF()" class="btn btn-success">Facturar</button>
            </center>

    </body>
</center>
</html>