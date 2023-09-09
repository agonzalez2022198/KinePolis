package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Promocion;
import modelo.Usuario;
import modeloDAO.PromocionDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Promocion promocion = new Promocion();
    PromocionDAO promocionDAO = new PromocionDAO();
    int codPromocion;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        } else if (menu.equals("Cartelera")) {
            request.getRequestDispatcher("Cartelera.jsp").forward(request, response);

        } else if (menu.equals("Cine")) {
            request.getRequestDispatcher("Cine.jsp").forward(request, response);

        } else if (menu.equals("Comentario")) {
            request.getRequestDispatcher("Comentario.jsp").forward(request, response);

        } else if (menu.equals("Estreno")) {
            request.getRequestDispatcher("Estreno.jsp").forward(request, response);

        } else if (menu.equals("Factura")) {
            request.getRequestDispatcher("Factura.jsp").forward(request, response);

        } else if (menu.equals("FuncionEspecial")) {
            request.getRequestDispatcher("FuncionEspecial.jsp").forward(request, response);

        } else if (menu.equals("HorariosProyeccion")) {
            request.getRequestDispatcher("HorariosProyeccion.jsp").forward(request, response);

        } else if (menu.equals("Pelicula")) {
            request.getRequestDispatcher("Pelicula.jsp").forward(request, response);
            

        } else if (menu.equals("usuario")) {

            if (accion.equals("agregar")) {

                String name = request.getParameter("nombre");
                String apell = request.getParameter("apellido");
                String email = request.getParameter("correo");
                String contra = request.getParameter("contrasena");

                usuario.setNombre(name);
                usuario.setApellido(apell);
                usuario.setCorreo_electronico(email);
                usuario.setContrasena(contra);
                usuarioDAO.agregar(usuario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (accion.equals("cuenta")) {
                request.getRequestDispatcher("AgregarUsuario.jsp").forward(request, response);
            } else if (menu.equals("Promocion")){
                switch(accion){
                    case "Agregar":
                        String nPromocion = request.getParameter("txtNombrePromocion");
                        String desc = request.getParameter("txtDescripcion");
                        String fValidez = request.getParameter("txtFechasValidez");
                        String precio = request.getParameter("txtPrecio");
                        String pId = request.getParameter("txtPelicula_id");
                        promocion.setNombrePromocion(nPromocion);
                        promocion.setDescripcion(desc);
                        promocion.setFechasValidez(fValidez);
                        promocion.setPrecio(Double.parseDouble(precio));
                        promocion.setPelicula_id(Integer.parseInt(pId));
                        promocionDAO.agregarPromocion(promocion);
                        request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                        break;
                    case "listar":
                        List listaPromocion = promocionDAO.listaPromocion();
                        System.out.println("size" + listaPromocion.size());
                        request.setAttribute("promocion", listaPromocion);
                        break;
                    case "Editar":
                        codPromocion = Integer.parseInt(request.getParameter("codigoPromocion"));
                        Promocion pr = promocionDAO.listarCodigoPromocion(codPromocion);
                        request.setAttribute("promocion", pr);
                        request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String aNombrePromocion = request.getParameter("txtNombrePromocion");
                        String aDesc = request.getParameter("txtDescripcion");
                        String aFechasValidez = request.getParameter("txtFechasValidez");
                        String aPrecio = request.getParameter("txtPrecio");
                        String aPromocion_id = request.getParameter("txtPromocion_id");
                        promocion.setNombrePromocion(aNombrePromocion);
                        promocion.setDescripcion(aDesc);
                        promocion.setFechasValidez(aFechasValidez);
                        promocion.setPrecio(Double.parseDouble(aPrecio));
                        promocion.setPelicula_id(Integer.parseInt(aPromocion_id));
                        request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                        break;
                    case "Eliminar":
                        String idPromocion = request.getParameter("codigo");
                        int codVerificacion = Integer.parseInt(idPromocion);
                        promocionDAO.eliminarPromocion(codVerificacion);
                        request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                        break;
                    default:
                }
                request.getRequestDispatcher("Promocion.jsp").forward(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
