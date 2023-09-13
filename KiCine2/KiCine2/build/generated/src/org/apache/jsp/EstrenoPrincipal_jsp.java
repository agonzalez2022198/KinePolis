package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EstrenoPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Estrenos U</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background: linear-gradient(to right, salmon, skyblue);\n");
      out.write("                margin: 20px;\n");
      out.write("                position: relative;\n");
      out.write("                overflow: hidden; /* Para ocultar cualquier parte de la imagen que se extienda más allá del marco */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .frame {\n");
      out.write("                position: absolute;\n");
      out.write("                top: 0;\n");
      out.write("                left: 0;\n");
      out.write("                right: 0;\n");
      out.write("                bottom: 0;\n");
      out.write("                z-index: -1;\n");
      out.write("                pointer-events: none; /* Evita que las imágenes dentro del marco sean interactivas */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                width: 80%;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                background-color: #ccc;\n");
      out.write("                position: relative; /* Establece el contexto de apilamiento para el marco de imágenes */\n");
      out.write("                z-index: 1; /* Asegura que el contenido de la tabla esté sobre el marco */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th, td {\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                text-align: center;\n");
      out.write("                background-color: skyblue;\n");
      out.write("                color: skyblue;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th span {\n");
      out.write("                background-color: #015c91; \n");
      out.write("                padding: 5px 10px; \n");
      out.write("                border-radius: 5px; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr:hover {\n");
      out.write("                background-color: #cce5ff;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border: 1px solid #888;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"frame\">\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th><span class=\"nombre-columna\">Estreno</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Fecha</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Descripcion</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Imagen</span></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th><span class=\"nombre-columna\">Estreno</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Fecha</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Descripcion</span></th>\n");
      out.write("                    <th><span class=\"nombre-columna\">Imagen</span></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <img src=\"img/Marco.png\" alt=\"frame\" style=\"width: 20%; height: 500%; object-fit: cover;\">\n");
      out.write("    </body>\n");
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
