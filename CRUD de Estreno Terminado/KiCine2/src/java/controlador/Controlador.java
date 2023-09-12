/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estreno;
import modelo.Usuario;
import modeloDAO.EstrenoDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    Estreno estreno =  new Estreno();
    // DAOS
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    EstrenoDAO estrenoDAO = new EstrenoDAO();
    
    
    int codEstreno;

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
            throws ServletException, IOException, ParseException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println(menu);
        System.out.println(accion);
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        } else if (menu.equals("Cartelera")) {
            request.getRequestDispatcher("Cartelera.jsp").forward(request, response);

        } else if (menu.equals("Cine")) {
            request.getRequestDispatcher("Cine.jsp").forward(request, response);

        } else if (menu.equals("Comentario")) {
            request.getRequestDispatcher("Comentario.jsp").forward(request, response);
        
               
            
        } else if (menu.equals("Estreno")) {
            switch(accion){
                case "listar":
                    List listaEstreno = estrenoDAO.listar();
                    request.setAttribute("estreno", listaEstreno);
                    break;
                
                case "Agregar":
                    int id_pelicula = Integer.parseInt(request.getParameter("txtId_pelicula"));
                    String descripcionEstreno = request.getParameter("txtDescripcionEstreno");
                    String fechaEstreno = request.getParameter("txtFechaEstreno");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    
                    java.util.Date date = dateFormat.parse(fechaEstreno);
                    
                    estreno.setPelicula_id(id_pelicula);
                    estreno.setDescripcionEstreno(descripcionEstreno);
                    estreno.setFechaEstreno(date);
                    estrenoDAO.agregar(estreno);
                    request.getRequestDispatcher("Controlador?menu=Estreno&accion=listar").forward(request, response);
                    break;
                
                case "Editar":    
                    codEstreno = Integer.parseInt(request.getParameter("codigoEstreno"));
                    Estreno e = estrenoDAO.listarCodigoEstreno(codEstreno);
                    request.setAttribute("list", e);
                    request.getRequestDispatcher("Controlador?menu=Estreno&accion=listar").forward(request, response);
                    break;
                    
                case "Actualizar":
                    int id_pelicula1 = Integer.parseInt(request.getParameter("txtId_pelicula"));
                    String descripcionEstreno1 = request.getParameter("txtDescripcionEstreno");
                    String fechaEstreno1 = request.getParameter("txtFechaEstreno");
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    
                    java.util.Date date1 = dateFormat1.parse(fechaEstreno1);
                    
                    estreno.setPelicula_id(id_pelicula1);
                    estreno.setDescripcionEstreno(descripcionEstreno1);
                    estreno.setFechaEstreno(date1);
                    estreno.setIdEstreno(codEstreno);
                    estrenoDAO.actualizar(estreno);
                    request.getRequestDispatcher("Controlador?menu=Estreno&accion=listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    codEstreno = Integer.parseInt(request.getParameter("codigoEstreno"));
                    estrenoDAO.eliminar(codEstreno);
                    request.getRequestDispatcher("Controlador?menu=Estreno&accion=listar").forward(request, response);
                    break; 
                    
                case "BuscarPelicula":
                    int codP = Integer.parseInt(request.getParameter("txtIdPelicula"));
                    estreno = estrenoDAO.listarCodigoEstreno(codP);
                    request.setAttribute("estreno", estreno);
                    break;
            }       
            request.getRequestDispatcher("Estreno.jsp").forward(request, response);
            
        } else if (menu.equals("Factura")) {
            request.getRequestDispatcher("Factura.jsp").forward(request, response);

        } 
        
        else if (menu.equals("FuncionEspecial")) {
            request.getRequestDispatcher("FuncionEspecial.jsp").forward(request, response);

        } else if (menu.equals("EstrenoUsuario")) {
            request.getRequestDispatcher("EstrenoUsuario.jsp").forward(request, response);    
            
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
