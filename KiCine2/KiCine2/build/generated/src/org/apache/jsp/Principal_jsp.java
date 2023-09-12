package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <!--Import Google Icon Font-->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("        <!--Import materialize.css-->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\r\n");
      out.write("\r\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=*-width, initial-scale=1.0\"/>\r\n");
      out.write("        <title>KINE POLIS</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"cabecera\">\r\n");
      out.write("            <div class=\"anchocabecera\">\r\n");
      out.write("                <div class=\"imagen-principal\">\r\n");
      out.write("                    <img class=\"logo\" src=\"img/logoUser.png\">\r\n");
      out.write("                </div>\r\n");
      out.write("<!--                <div class=\"buscador\">\r\n");
      out.write("                    <select>\r\n");
      out.write("                        <option>Selecciona tu cine</option>\r\n");
      out.write("                        <option>Miraflores</option>\r\n");
      out.write("                        <option>Okland mall</option>\r\n");
      out.write("                        <option>Naranjo mall</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                    <input type=\"button\" value=\"Ver cartelera\" onclick=\"beforeImage()\">\r\n");
      out.write("                </div>-->\r\n");
      out.write("<!--                <div class=\"contacto\">\r\n");
      out.write("                    <input type=\"button\" value=\"Contacto\">\r\n");
      out.write("                </div>-->\r\n");
      out.write("                <nav class=\"menu\">\r\n");
      out.write("                        <a href=\"Controlador?menu=InicioSesion\">Cerrar Sesión</a>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <nav class=\"navegador\">\r\n");
      out.write("            <div class=\"anchonavegador\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Inicio</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Cartelera</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"Controlador?menu=EstrenoUsuario\" target=\"myFrame\">Estrenos</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Cines</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Comprar Tickets</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <ul>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"imagen-slider\">\r\n");
      out.write("            <div id=\"banners\">\r\n");
      out.write("                <img class=\"imagenes-banners\" src=\"img/banners/fnas.png\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"botonesSigAnt\">\r\n");
      out.write("                <button class=\"b-anterior\" onclick=\"beforeImage()\"><</button>\r\n");
      out.write("                <button class=\"b-siguiente\" onclick=\"nextImage()\">></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <script>\r\n");
      out.write("                var slider_content = document.getElementById('banners');\r\n");
      out.write("\r\n");
      out.write("                var image = [\"comosifueralaprimeravez\", \"habiaunavezenhollywood\", \"historiasmiedo\", \"it\", \"angrybirds\",\"fnas\"];\r\n");
      out.write("\r\n");
      out.write("                var i = image.length;\r\n");
      out.write("\r\n");
      out.write("                function nextImage() {\r\n");
      out.write("                    if (i < image.length) {\r\n");
      out.write("                        i = i + 1;\r\n");
      out.write("                        if (i == image.length) {\r\n");
      out.write("                            i = 1;\r\n");
      out.write("                        }\r\n");
      out.write("                    } else {\r\n");
      out.write("                        i = 1;\r\n");
      out.write("                    }\r\n");
      out.write("                    slider_content.innerHTML = \"<img class=\\\"imagenes-banners\\\" src=\\\"img/banners/\" + image[i] + \".png\\\">\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                function beforeImage() {\r\n");
      out.write("                    if (i < image.length + 1 && i > 1) {\r\n");
      out.write("                        i = i - 1;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        i = image.length;\r\n");
      out.write("                    }\r\n");
      out.write("                    slider_content.innerHTML = \"<img class=\\\"imagenes-banners\\\" src=img/banners/\" + image[i - 1] + \".png>\";\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"peliculas\">\r\n");
      out.write("            <h2>Películas</h2>\r\n");
      out.write("            <div class=\"listapeliculas\">\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/angrybirds.jpg\">\r\n");
      out.write("                    <p>Angry Birds </p>\r\n");
      out.write("                    <p>Duración: 120 min </p>\r\n");
      out.write("                    <p>Genero: Animada </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/dora.jpg\">\r\n");
      out.write("                    <p>Dora la exploradora</p>\r\n");
      out.write("                    <p>Duración: 120 min </p>\r\n");
      out.write("                    <p>Genero: Live action</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/historias.jpg\">\r\n");
      out.write("                    <p>Historias de miedo para contar en la oscuridad </p>\r\n");
      out.write("                    <p>Duración: 120 min</p>\r\n");
      out.write("                    <p>Genero: Terror </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/it.jpg\">\r\n");
      out.write("                    <p>IT 2 </p>\r\n");
      out.write("                    <p>Duración: 120 min</p>\r\n");
      out.write("                    <p>Genero: Terror </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/vidasecreta.jpg\">\r\n");
      out.write("                    <p>La vida secreta de tus mascotas </p>\r\n");
      out.write("                    <p>Duración: 120 min</p>\r\n");
      out.write("                    <p>Genero: Animada </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pelicula-info\">\r\n");
      out.write("                    <img src=\"img/peliculas/agente.jpg\">\r\n");
      out.write("                    <p>Agente bajo fuego </p>\r\n");
      out.write("                    <p>Duración: 120 min</p>\r\n");
      out.write("                    <p>Genero: Animada </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"pie\">\r\n");
      out.write("            <div class=\"pie-padre\">\r\n");
      out.write("                <div class=\"pie-izquierda\">\r\n");
      out.write("                    <h2>KinePolis</h2>\r\n");
      out.write("                    <p>Alv nosé que poner</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pie-centro\">\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pie-derecha\">\r\n");
      out.write("                    <h3>Siguenos mamahuevo</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"\"><img src=\"img/icons/Facebook_16px.png\"> Facebook</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"\"><img src=\"img/icons/Instagram_16px.png\"> Instagram</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"\"><img src=\"img/icons/Twitter_16px.png\"> Twitter</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        <script>\r\n");
      out.write("            setInterval('nextImage()', 3000);\r\n");
      out.write("        </script>\r\n");
      out.write("        <!--JavaScript at end of body for optimized loading-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
