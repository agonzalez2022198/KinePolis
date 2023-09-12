package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Compra1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styleCompra.css\">\n");
      out.write("        <title>Compra de Boletos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"cabecera\">\n");
      out.write("            <div class=\"anchocabecera\">\n");
      out.write("                <div class=\"imagen-principal\">\n");
      out.write("                    <img class=\"logo\" src=\"img/logoUser.png\">\n");
      out.write("                </div>\n");
      out.write("                <nav class=\"menu\">\n");
      out.write("                    <a href=\"Controlador?menu=InicioSesion\">Cerrar Sesión</a>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"capa\"></div>\n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("\n");
      out.write("            <h1 class=\"tituloPelicula\">Five Nights At Seba's</h1>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"card\" >\n");
      out.write("                <h1 class=\"instrucciones\">Seleccione una fecha.</h1>\n");
      out.write("                <select class=\"formSelect\">\n");
      out.write("                    <option selected>Hoy</option>\n");
      out.write("                    <option value=\"1\">Mañana</option>\n");
      out.write("                    <option value=\"2\">20-09</option>\n");
      out.write("                    <option value=\"3\">15-10</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card\" >\n");
      out.write("                <h1 class=\"instrucciones\">Seleccione un Cine.</h1>\n");
      out.write("                <select class=\"formSelect\">\n");
      out.write("                    <option selected>AQUI</option>\n");
      out.write("                    <option value=\"1\">ALLA</option>\n");
      out.write("                    <option value=\"2\">SI</option>\n");
      out.write("                    <option value=\"3\">CABAL</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card\" >\n");
      out.write("                <h1 class=\"instrucciones\">Seleccione un horario.</h1>\n");
      out.write("                <div id=\"botones-container\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"boton-aceptar\">ASDFSD </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Supongamos que tienes un arreglo de elementos\n");
      out.write("            var elementos = [\"20:30\", \"23:10\", \"27:14\", \"14:00\"];\n");
      out.write("\n");
      out.write("            // Obtén el contenedor donde deseas colocar los botones\n");
      out.write("            var contenedor = document.getElementById(\"botones-container\");\n");
      out.write("\n");
      out.write("            // Función para mostrar la confirmación con el valor seleccionado\n");
      out.write("            function mostrarConfirmacion(valor) {\n");
      out.write("                var confirmacion = confirm(\"¿Desea seleccionar el horario: \" + valor );\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Itera sobre el arreglo y crea botones para cada elemento\n");
      out.write("            elementos.forEach(function (elemento) {\n");
      out.write("                var boton = document.createElement(\"button\"); // Crea un elemento de botón\n");
      out.write("                boton.textContent = elemento; // Establece el texto del botón\n");
      out.write("                boton.className = \"boton-personalizado\"; // Aplica la clase de estilo\n");
      out.write("                boton.onclick = function () {\n");
      out.write("                    var valorSeleccionado = this.textContent; // Obtiene el texto del botón\n");
      out.write("                    mostrarConfirmacion(valorSeleccionado);\n");
      out.write("                };\n");
      out.write("                contenedor.appendChild(boton); // Agrega el botón al contenedor\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
