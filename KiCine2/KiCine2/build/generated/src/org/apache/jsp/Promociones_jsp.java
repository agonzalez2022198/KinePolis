package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Promociones_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Promociones de Cine</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f0f0f0;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header {\n");
      out.write("                background-color:   black;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 20px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                font-size: 36px;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .promocion {\n");
      out.write("                width: 300px;\n");
      out.write("                margin: 20px;\n");
      out.write("                background-color: white;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .promocion img {\n");
      out.write("                max-width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .promocion h2 {\n");
      out.write("                font-size: 24px;\n");
      out.write("                margin: 10px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .promocion p {\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .comprar-button {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: white;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 18px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .comprar-button:hover {\n");
      out.write("                background-color: #555;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 10px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <h1>Promociones de Cine</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"promocion\">\n");
      out.write("            <img src=\"pelicula1.jpg\" alt=\"Película 1\">\n");
      out.write("            <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${promocion.getPelicula()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${promocion.getDescripcion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            <button class=\"comprar-button\">Adquirir</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            © 2023 KinePolis\n");
      out.write("        </footer>\n");
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
