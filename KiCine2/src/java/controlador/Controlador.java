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
import modelo.Entrada;
import modelo.Estreno;
import modelo.Usuario;
import modeloDAO.EntradaDAO;
import modeloDAO.EstrenoDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    Estreno estreno = new Estreno();
    Entrada entrada = new Entrada();
    // DAOS
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    EstrenoDAO estrenoDAO = new EstrenoDAO();

    EntradaDAO entradaDAO = new EntradaDAO();

    int idEntrada;

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
            switch (accion) {
                case "listar":
                    List listaEstreno = estrenoDAO.listar();
                    request.setAttribute("estreno", listaEstreno);
                    break;

                case "Agregar":
                    int id_pelicula = Integer.parseInt(request.getParameter("txtId_pelicula"));
                    String descripcionEstreno = request.getParameter("txtDescripcionEstreno");
                    String fechaEstreno = request.getParameter("txtFechaEstreno");
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

                    java.util.Date fecha = formatoFecha.parse(fechaEstreno);

                    estreno.setPelicula_id(id_pelicula);
                    estreno.setDescripcionEstreno(descripcionEstreno);
                    estreno.setFecha_estreno(fecha);

                    request.getRequestDispatcher("Controlador?menu=Estreno&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Estreno.jsp").forward(request, response);

        } else if (menu.equals("Entrada")) {
            switch (accion) {
                case "listar":
                    List listaEntrada = entradaDAO.listar();
                    System.out.println("size" + listaEntrada.size());
                    request.setAttribute("entradas", listaEntrada);
                    break;

                case "agregar":
                    String horario = request.getParameter("txtHorarioP_id");
                    String cine = request.getParameter("txtCine_id");
                    String preventa = request.getParameter("txtPreventa_id");
                    String promocion = request.getParameter("txtPromocion_id");
                    String funcion = request.getParameter("txtFuncionEspecial_id");
                    String cantidadEntradas = request.getParameter("txtCantidadEntradas");
                    String pagoTotal = request.getParameter("txtPagoTotal");

                    entrada.setHorarioP_id(Integer.parseInt(horario));
                    entrada.setCine_id(Integer.parseInt(cine));
                    entrada.setPreventa_id(Integer.parseInt(preventa));
                    entrada.setPromocion_id(Integer.parseInt(promocion));
                    entrada.setFuncionEspecial_id(Integer.parseInt(funcion));
                    entrada.setCantidadEntradas(Integer.parseInt(cantidadEntradas));
                    entrada.setPagoTotal(Double.parseDouble(pagoTotal));
                    entradaDAO.agregar(entrada);
                    request.getRequestDispatcher("Controlador?menu=Entrada&accion=listar").forward(request, response);
                    break;

                case "Eliminar":
                    idEntrada = Integer.parseInt(request.getParameter("id"));
                    entradaDAO.Eliminar(idEntrada);
                    request.getRequestDispatcher("Controlador?menu=Entrada&accion=listar").forward(request, response);
                    break;

                case "Editar":
                    idEntrada = Integer.parseInt(request.getParameter("idEntrada"));
                    Entrada e = entradaDAO.listarCodigoEntrada(idEntrada);
                    request.setAttribute("entrada", e);
                    request.getRequestDispatcher("Controlador?menu=Entrada&accion=listar").forward(request, response);
                    break;

                case "Actualizar":
                    String horario_E = request.getParameter("txtHorarioP_id");
                    String cine_E = request.getParameter("txtCine_id");
                    String preventa_E = request.getParameter("txtPreventa_id");
                    String promocion_E = request.getParameter("txtPromocion_id");
                    String funcion_E = request.getParameter("txtFuncionEspecial_id");
                    String cantidadEntradas_E = request.getParameter("txtCantidadEntradas");
                    String pagoTotal_E = request.getParameter("txtPagoTotal");
                    entrada.setIdEntrada(idEntrada);
                    entrada.setHorarioP_id(Integer.parseInt(horario_E));
                    entrada.setCine_id(Integer.parseInt(cine_E));
                    entrada.setPreventa_id(Integer.parseInt(preventa_E));
                    entrada.setPromocion_id(Integer.parseInt(promocion_E));
                    entrada.setFuncionEspecial_id(Integer.parseInt(funcion_E));
                    entrada.setCantidadEntradas(Integer.parseInt(cantidadEntradas_E));
                    entrada.setPagoTotal(Double.parseDouble(pagoTotal_E));
                    entradaDAO.actualizar(entrada);
                    request.getRequestDispatcher("Controlador?menu=Entrada&accion=listar").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("Entrada.jsp").forward(request, response);
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
