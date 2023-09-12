<%-- 
    Document   : Factura
    Created on : jul 21, 2023, 12:30:32 p.m.
    Author     : Windows 10
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Factura de Cine</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <h2 class="mb-3">Crear Factura</h2>
            <form id="formulario">
                <div class="form-group">
                    <label for="idFactura">ID Factura:</label>
                    <input type="number" id="idFactura" name="idFactura" class="form-control">
                </div>
                <div class="form-group">
                    <label for="fechaEmision">Fecha Emisión:</label>
                    <input type="date" id="fechaEmision" name="fechaEmision" />
                </div>
                <div class="form-group">
                    <label for="usuario_id">ID de Usuario:</label>
                    <input type="number" id="usuario_id" name="usuario_id" class="form-control">
                </div>
                <div class="form-group">
                    <label for="cine_id">ID de Cine:</label>
                    <input type="number" id="cine_id" name="cine_id" class="form-control">
                </div>
                <div class="form-group">
                    <label for="entrada_id">ID de Entrada:</label>
                    <input type="number" id="entrada_id" name="entrada_id" class="form-control">
                </div>
                <div class="form-group">
                    <label for="subTotal">SubTotal Venta:</label>
                    <input type="number" id="subTotal" name="subTotal" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Crear Factura</button>
            </form>

            <center> 
                <div id="factura">
                    <center>
                        <h2 class="mt-5">Factura KinePolis</h2>
                    </center>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID Factura</th>
                                <th>Fecha de emisión</th>
                                <th>ID de Usuario</th>
                                <th>ID de Cine</th>
                                <th>ID de Entrada</th>
                                <th>SubTotal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Los detalles de la factura se añadirán aquí -->
                        </tbody>
                    </table>
                </div>
                <button onclick="convertirAPDF()" class="btn btn-success">Facturar</button>
            </center>
        </div>

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

                const idFactura = Math.floor(Math.random() * 1000000); // Genera una ID de factura aleatoria
                const fechaEmision = new Date().toISOString().slice(0, 10); // Obtiene la fecha actual en formato YYYY-MM-DD
                const usuario_id = document.getElementById('usuario_id').value;
                const cine_id = document.getElementById('cine_id').value;
                const entrada_id = document.getElementById('entrada_id').value;
                const subTotal = document.getElementById('subTotal').value;

                const factura = new Factura(idFactura, fechaEmision, usuario_id, cine_id, entrada_id, subTotal);

                const tabla = document.getElementById('factura').getElementsByTagName('table')[0];
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
                html2pdf(elemento);
            }
        </script>
    </body>
</html>