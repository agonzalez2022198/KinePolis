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
import modelo.Comentario;
import modelo.Pelicula;
import modelo.Usuario;
import modeloDAO.ComentarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {
    
    Comentario comentario = new Comentario();
    ComentarioDAO comentarioDAO = new ComentarioDAO();
    Usuario usuario = new Usuario();
    Pelicula pelicula = new Pelicula();
    int codComentario;
    int codUsuario;
    int codPelicula;

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
        if (menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(menu.equals("Comentario")){
            switch(accion){
                case "listar":
                    List listaComentario = comentarioDAO.listar();
                    request.setAttribute("comentarios", listaComentario);
                    break;
                    
                case "listarPelicula":
                    List listaPelicula = comentarioDAO.listarPeliculas();
                    request.setAttribute("peliculas", listaPelicula);
                    
                    break;
                    
                case "Agregar":
                    String userID = request.getParameter("txtUsuario_id");
                    String peliID = request.getParameter("txtPeliculaId");
                    String text = request.getParameter("txtComentario");
                    
                    comentario.setUsuario_id(Integer.parseInt(userID));
                    comentario.setPelicula_id(Integer.parseInt(peliID));
                    comentario.setTexto(text);
                    comentarioDAO.agregar(comentario);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codComentario = Integer.parseInt(request.getParameter("codigoComentario"));
                    Comentario c = comentarioDAO.listaComentario(codComentario);
                    request.setAttribute("comentario", c);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    String codUser = request.getParameter("txtNewUsuario_id");
                    String codPeli = request.getParameter("txtNewPeliculaId");
                    String txt = request.getParameter("txtNewComentario");
                    
//                    String codUse = request.getParameter("codUser"); ////////////////////////////////////////////////////////////
                    
                    comentario.setUsuario_id(Integer.parseInt(codUser));
                    comentario.setPelicula_id(Integer.parseInt(codPeli));
                    comentario.setTexto(txt);
                    comentario.setIdComentario(codComentario);
                    comentarioDAO.actualizar(comentario);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    break;
                case "BuscarUsuario":
                    int codComent = Integer.parseInt(request.getParameter("txtUsuario_id"));
                    Usuario usuario = comentarioDAO.listaUsuario(codComent);
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    
                    break;
                case "BuscarPelicula":
                    
                    
                    int codPel = Integer.parseInt(request.getParameter("txtPeliculaId"));
                    pelicula.setIdPelicula(codPel);
                    pelicula = comentarioDAO.listaPelicula(codPel);
                    request.setAttribute("pelicula", pelicula);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    break;
                
                case "Eliminar":
                    codComentario = Integer.parseInt(request.getParameter("codigoComentario"));
                    comentarioDAO.eliminar(codComentario);
                    request.getRequestDispatcher("Controlador?menu=Comentario&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Comentario.jsp").forward(request, response);
        }else if(menu.equals("ComentarioUsuario")){
        
            switch("accion"){
                case "listar":
                    List listaPelicula = comentarioDAO.listarPeliculas();
                    request.setAttribute("peliculas", listaPelicula);
                    break;
                case "Editar":
                    codComentario = Integer.parseInt(request.getParameter("codigoComentario"));
                    Comentario c = comentarioDAO.listaComentario(codComentario);
                    request.setAttribute("comentario", c);
                    break;
                
            }
            
            request.getRequestDispatcher("ComentarioUsuario.jsp").forward(request, response);
            
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
