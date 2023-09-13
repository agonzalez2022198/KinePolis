package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AgregarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Define que el documento esta bajo el estandar de HTML 5 -->\r\n");
      out.write("<!doctype html>\r\n");
      out.write("\r\n");
      out.write("<!-- Representa la raíz de un documento HTML o XHTML. Todos los demás elementos deben ser descendientes de este elemento. -->\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("    \r\n");
      out.write("    <head>      \r\n");
      out.write("        <meta charset=\"utf-8\">      \r\n");
      out.write("        <title> Formulario de Acceso </title>           \r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">       \r\n");
      out.write("        <meta name=\"author\" content=\"Videojuegos & Desarrollo\">\r\n");
      out.write("        <meta name=\"description\" content=\"Muestra de un formulario de acceso en HTML y CSS\">\r\n");
      out.write("        <meta name=\"keywords\" content=\"Formulario Acceso, Formulario de LogIn\">\r\n");
      out.write("        \r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Nunito&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Overpass&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        \r\n");
      out.write("        <!-- Link hacia el archivo de estilos css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styleLogin.css\">        \r\n");
      out.write("        <style type=\"text/css\">           \r\n");
      out.write("        </style>       \r\n");
      out.write("        <script type=\"text/javascript\">        \r\n");
      out.write("        </script> \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"contenedor\">\r\n");
      out.write("            <div id=\"central\">\r\n");
      out.write("                <div id=\"login\">\r\n");
      out.write("                    <div class=\"titulo\">\r\n");
      out.write("                        Bienvenido\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form id=\"loginform\" action=\"Controlador?menu=usuario\" method=\"POST\">\r\n");
      out.write("                        \r\n");
      out.write("                        <input id=\"name\" type=\"text\" placeholder=\"Nombre\" name=\"nombre\" required>\r\n");
      out.write("                        \r\n");
      out.write("                        <input id=\"correo\" type=\"text\" placeholder=\"Apellido\" name=\"apellido\" required>\r\n");
      out.write("                        \r\n");
      out.write("                        <input id=\"correo\" type=\"text\" name=\"correo\" placeholder=\"correo\" required>\r\n");
      out.write("                        <label id=\"txtDoble\" style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${txtDoble}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\r\n");
      out.write("                        \r\n");
      out.write("                        <input id=\"password\" type=\"password\" placeholder=\"Contrasena\" name=\"contrasena\" required>\r\n");
      out.write("                        \r\n");
      out.write("                        <input\r\n");
      out.write("                            type=\"file\"\r\n");
      out.write("                            name=\"foto\"\r\n");
      out.write("                            id=\"foto\"\r\n");
      out.write("                            class=\"formbold-form-input formbold-mb-3\"\r\n");
      out.write("                            />\r\n");
      out.write("                        \r\n");
      out.write("                        <input type=\"submit\" name=\"accion\" value=\"agregar\" class=\"ntt\" >\r\n");
      out.write("                    </form>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"inferior\">\r\n");
      out.write("                    <a href=\"Controlador?menu=usuario&accion=login\">Volver</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <Script ></Script>\r\n");
      out.write("            \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
