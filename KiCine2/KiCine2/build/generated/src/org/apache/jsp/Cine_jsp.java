package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cine_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\r\n");
      out.write("        <title>Cines</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;\">\r\n");
      out.write("        <br>\r\n");
      out.write("        <div class=\"d-flex\">\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"card\" style=\"background-color: #F8F8F8; border: none; border-radius: 3%\">\r\n");
      out.write("                    <form action=\"Controlador?menu=Cine\" method=\"POST\" onsubmit=\"return validarCampos()\">\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Cine:</strong></label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group d-flex\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-sm-6\">\r\n");
      out.write("                                    <input style=\"border: none; background: transparent; border-bottom: 1px solid gray;\" type=\"text\" name=\"txtNombre\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"Nombre\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group d-flex\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-sm-6\">\r\n");
      out.write("                                    <input style=\"border: none; background: transparent; border-bottom: 1px solid gray;\" type=\"text\" id=\"start\" name=\"txtUbicacion\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getUbicacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"Ubicacion\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group d-flex\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-sm-6\">\r\n");
      out.write("                                    <input style=\"border: none; background: transparent; border-bottom: 1px solid gray;\" type=\"text\" id=\"start\" name=\"txtTelefono\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getTelefono()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"Telefono\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- AGREGAR REGISTRO-->\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <button style=\"margin: 5px;\" type=\"submit\" name=\"accion\" value=\"agregar\" class=\"btn btn-info\" >Agregar Cine</button>\r\n");
      out.write("                                    <button style=\"margin: 5px;\" type=\"submit\" name=\"accion\" value=\"actualizar\" class=\"btn btn-dark\">Actualizar</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-7\">\r\n");
      out.write("                <div class=\"card\" style=\"background-color: #F8F8F8; border: none; border-radius: 3%\">\r\n");
      out.write("                    <div class=\"card-body\" >\r\n");
      out.write("\r\n");
      out.write("                        <table class=\"table table-hover\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>CODIGO </th>\r\n");
      out.write("                                    <th>CINE</th>\r\n");
      out.write("                                    <th>UBICACION</th>\r\n");
      out.write("                                    <th>TELEFONO</th>\r\n");
      out.write("                                    <th>   ACCIONES</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                                 <script>\r\n");
      out.write("\r\n");
      out.write("            function validarCampos() {\r\n");
      out.write("                // Obtén los valores de los campos de entrada\r\n");
      out.write("                var nombre = document.getElementsByName(\"txtNombre\")[0].value;\r\n");
      out.write("                var ubicacion = document.getElementsByName(\"txtUbicacion\")[0].value;\r\n");
      out.write("                var telefono = document.getElementsByName(\"txtTelefono\")[0].value;\r\n");
      out.write("\r\n");
      out.write("                // Verifica si alguno de los campos está vacío\r\n");
      out.write("                if (nombre === \"\" || ubicacion === \"\" || telefono === \"\") {\r\n");
      out.write("                    // Muestra una alerta\r\n");
      out.write("                    alert(\"La accion no es valida, llene todos los campos.\");\r\n");
      out.write("                    // Detén el envío del formulario\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // Si todos los campos están llenos, permite que el formulario se envíe\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("list");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cine}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <tr>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdCine()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getUbicacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getTelefono()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\r\n");
          out.write("                                    <td class=\"d-flex\">\r\n");
          out.write("                                        <a class=\"btn btn-warning\" href=\"Controlador?menu=Cine&accion=editar&codigoCine=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdCine()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"margin: 5px;\" >Editar</a>\r\n");
          out.write("                                        <a class=\"btn btn-danger\" href=\"Controlador?menu=Cine&accion=eliminar&codigoCine=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdCine()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"margin: 5px;\" onclick=\"return confirm('¿Esta seguro que quiere eliminar el dato?')\" >Eliminar </a>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                </tr>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
