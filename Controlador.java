/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HorarioP;
import modelo.Usuario;
import modeloDAO.HorarioPDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    HorarioPDAO horarioPDAO = new HorarioPDAO();
    HorarioP hp = new HorarioP();
    int idH;

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

        } else if (menu.equals("HorariosP")) {

            request.getRequestDispatcher("HorariosP.jsp").forward(request, response);
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

        } else if (menu.equals("HorariosP")) {
            switch (accion) {
                case "listar":
                    List listaHorarioP = horarioPDAO.listar();
                    System.out.println("size" + listaHorarioP.size());
                    request.setAttribute("horarioP", listaHorarioP);
                    break;

                case "Agregar":
                    String horario = request.getParameter("txtHorario");
                    String fecha = request.getParameter("txtFecha");
                    String asientos = request.getParameter("txtDisponibilidadAsientos");
                    String sala = request.getParameter("txtSala_id");
                    String pelicula = request.getParameter("txtPelicula_id");
                    hp.setHorario(Time.valueOf(horario));
                    hp.setFecha(Date.valueOf(fecha));
                    hp.setDisponibilidadAsientos(Integer.parseInt(sala));
                    hp.setSala_id(Integer.parseInt(sala));
                    hp.setPelicula_id(Integer.parseInt(pelicula));
                    horarioPDAO.agregar(hp);
                    request.getRequestDispatcher("Controlador?menu=HorarioP&accio=listar").forward(request, response);
                    break;

                case "Editar":
                    idH = Integer.parseInt(request.getParameter("idHorarioP"));
                    HorarioP h = horarioPDAO.listaridHorarioP(idH);
                    request.setAttribute("horario", h);
                    request.getRequestDispatcher("Controlador?menu=HorarioP&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String a_id = request.getParameter("txtIdHorarioP");
                    String a_horario = request.getParameter("txtHorario");
                    String a_fecha = request.getParameter("txtFecha");
                    String a_asientos = request.getParameter("txtDisponibilidadAsientos");
                    String a_sala = request.getParameter("txtSala_id");
                    String a_pelicula = request.getParameter("txtPelicula_id");
                    hp.setIdHorarioP(idH);
                    hp.setHorario(Time.valueOf(a_horario));
                    hp.setFecha(Date.valueOf(a_fecha));
                    hp.setDisponibilidadAsientos(Integer.parseInt(a_sala));
                    hp.setSala_id(Integer.parseInt(a_sala));
                    hp.setPelicula_id(Integer.parseInt(a_pelicula));
                    horarioPDAO.actualizar(hp);
                    request.getRequestDispatcher("Controlador?menu=HorarioP&accion=listar").forward(request, response);
                    break;
                    
                    case "Eliminar":
                        idH = Integer.parseInt(request.getParameter("idHorarioP"));
                        horarioPDAO.eliminar(idH);
                    request.getRequestDispatcher("Controlador?menu=HorarioP&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("HorariosP.jsp").forward(request, response);

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
