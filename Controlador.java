/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Preventa;
import modelo.Usuario;
import modeloDAO.PreventaDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    Preventa preventa = new Preventa();
    PreventaDAO preventaDAO = new PreventaDAO();
    int codPreventa;
    
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
            
            
            

        } else if (menu.equals("Preventa")) {
            switch (accion) {

                case "listar":
                    List listaPre = preventaDAO.listar();
                    request.setAttribute("preventa", listaPre);
                    break;
                default:
                    break;
            }
            request.getRequestDispatcher("Preventa.jsp").forward(request, response);
            
            
        }else if (menu.equals("PreventaAdmin")) {
            switch (accion) {

                case "listar":
                    List listaPre = preventaDAO.listar();
                    request.setAttribute("preventa", listaPre);
                    break;
                
                case "Editar":
                    codPreventa = Integer.parseInt(request.getParameter("codigoPreventa"));
                    Preventa c = preventaDAO.listarCodigoPreventa(codPreventa);
                    request.setAttribute("preventas", c);
                    request.getRequestDispatcher("Controlador?menu=PreventaAdmin&accion=listar").forward(request, response);
                    break;
                case "BuscarPeventa":
                    int codPreventa = Integer.parseInt(request.getParameter("txtIdPreventa"));
                    preventa.setIdPreventa(codPreventa);
                    preventa = preventaDAO.listarCodigoPreventa(codPreventa);
                    request.setAttribute("preventa", preventa);
                        
                    break;
                case "Agregar":
                    
                    String descripcion = request.getParameter("txtDescripcion");
                    String precio = request.getParameter("txtPrecioPreventa");
                    String peli = request.getParameter("txtPelicula_id");
                    
                    preventa.setDescripcion(descripcion);
                    preventa.setPrecioPreventa(Double.parseDouble(precio));
                    preventa.setPelicula_id(Integer.parseInt(peli));
                    preventaDAO.agregar(preventa);

                    request.getRequestDispatcher("Controlador?menu=PreventaAdmin&accion=listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    String codsPreventa = request.getParameter("Codigo");
                    int codVerific = Integer.parseInt(codsPreventa);

                    preventaDAO.eliminar(codVerific);
                    request.getRequestDispatcher("Controlador?menu=PreventaAdmin&accion=listar").forward(request, response);

                    break;
                case "Actualizar":
                    String des = request.getParameter("txtDescripcion");
                    String pre = request.getParameter("txtPrecioPreventa");
                    String codpeli = request.getParameter("txtPelicula_id");
                    int codigopreventas = Integer.parseInt(request.getParameter("cod"));
                    System.out.println(request.getParameter("cod"));
                    
                    preventa.setPelicula_id(Integer.parseInt(codpeli));
                    preventa.setDescripcion(des);
                    preventa.setPrecioPreventa(Double.parseDouble(pre));
                    preventa.setIdPreventa(codigopreventas);
            
                    
                    preventaDAO.actualizar(preventa);
                   
                    request.getRequestDispatcher("Controlador?menu=PreventaAdmin&accion=listar").forward(request, response);
                    break;
                default:
                    break;
            }
            request.getRequestDispatcher("PreventaAdmin.jsp").forward(request, response);
            
            
            
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
