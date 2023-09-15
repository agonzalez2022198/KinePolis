<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Factura de Cine</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>

    <div id="factura">
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
        <div class="invoice">
            <h1 class="mt-5">Factura KinePolis</h1>
            <div class="header">
                <div class="header-left">
                    <p>Empresa: KinePolis</p>
                    <p>Dirección: 6A Avenida 13-54, Cdad. de Guatemala</p>
                    <p>Teléfono: 5421-7175</p>
                </div>
            </div>
            <center>


                <div class="details">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID Factura</th>
                                <th>Fecha de emisión</th>
                                <th>ID de Entrada</th>
                                <th>SubTotal</th>
                            </tr>
                        </thead>
                        <tbody id="facturaBody">
                        </tbody>
                    <c:forEach var="facturas" items="${facturas}">
                        <tbody>
                            <tr>
                                <td>${facturas.getIdFactura()}</td>
                                <td>${facturas.getFecha_emision()}</td>
                                <td>${facturas.getUsuario_id()}</td>
                                <td>${facturas.getTotal_pago()}</td>
                            </tr>
                        </tbody>
                    </table>
                    </c:forEach>
                </div>
        </div>

</div><br>
<center>
    <button onclick="convertirAPDF()" class="btn btn-success">Facturar</button>
</center>

<script>
    class Factura {
        constructor(idFactura, fechaEmision, usuario_id, cine_id, entrada_id, subTotal) {
            this.idFactura = idFactura;
            this.fechaEmision = fechaEmision;
            this.usuario_id = usuario_id;
            this.cine_id = cine_id;
            this.entrada_id = entrada_id;
            this.subTotal = subTotal;
        }
    }

    document.getElementById('formulario').addEventListener('submit', function (event) {
        event.preventDefault();

        const idFactura = Math.floor(Math.random() * 1000000);
        const fechaEmision = new Date().toISOString().slice(0, 10);
        const usuario_id = document.getElementById('usuario_id').value;
        const cine_id = document.getElementById('cine_id').value;
        const entrada_id = document.getElementById('entrada_id').value;
        const subTotal = document.getElementById('subTotal').value;

        const factura = new Factura(idFactura, fechaEmision, usuario_id, cine_id, entrada_id, subTotal);

        const fila = document.createElement('tr');

        const cols = [
            document.createElement('td'),
            document.createElement('td'),
            document.createElement('td'),
            document.createElement('td'),
            document.createElement('td'),
            document.createElement('td')
        ];

        cols[0].innerText = factura.idFactura;
        cols[1].innerText = factura.fechaEmision;
        cols[2].innerText = factura.usuario_id;
        cols[3].innerText = factura.cine_id;
        cols[4].innerText = factura.entrada_id;
        cols[5].innerText = factura.subTotal;

        cols.forEach(function (col) {
            fila.appendChild(col);
        });

        tabla.appendChild(fila);
    });

    function convertirAPDF() {
        var elemento = document.getElementById('factura');
        html2pdf().from(elemento).save();
    }

</script>
</body>
</center>
</html>