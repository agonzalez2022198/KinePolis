/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Estreno;
import modelo.Pelicula;
import modelo.Usuario;
import modeloDAO.EstrenoDAO;
import modeloDAO.PeliculaDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
@MultipartConfig
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    Estreno estreno = new Estreno();
    // DAOS
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    EstrenoDAO estrenoDAO = new EstrenoDAO();

    Pelicula pelicula = new Pelicula();
    PeliculaDAO peliculaDAO = new PeliculaDAO();

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

            switch (accion) {
                case "listar":
                    List<Pelicula> lista = peliculaDAO.listar();
                    request.setAttribute("lista", lista);
                    break;

                default:
            }
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

        } else if (menu.equals("Factura")) {
            request.getRequestDispatcher("Factura.jsp").forward(request, response);

        } else if (menu.equals("FuncionEspecial")) {
            request.getRequestDispatcher("FuncionEspecial.jsp").forward(request, response);

        } else if (menu.equals("HorariosProyeccion")) {
            request.getRequestDispatcher("HorariosProyeccion.jsp").forward(request, response);

        } else if (menu.equals("Pelicula")) {

            if (accion != null) {
                switch (accion) {
                    case "Agregar":

                        String titulo = request.getParameter("titulo");
                        String genero = request.getParameter("genero");
                        String director = request.getParameter("director");
                        int duracion = Integer.parseInt(request.getParameter("duracion"));
                        String sinopsis = request.getParameter("sinopsis");

                        String lanzamiento = request.getParameter("lanzamiento");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = dateFormat.parse(lanzamiento);

                        String calificacion = request.getParameter("calificacion");
                        String idioma = request.getParameter("idioma");

                        pelicula.setTitulo(titulo);
                        pelicula.setGenero(genero);
                        pelicula.setDirector(director);
                        pelicula.setDuracion(duracion);
                        pelicula.setSinopsis(sinopsis);
                        pelicula.setAno_lanzamiento(date);
                        pelicula.setCalificacion(calificacion);
                        pelicula.setIdioma(idioma);
                        Part part = request.getPart("foto");
                        InputStream inputStream = part.getInputStream();
                        pelicula.setFoto(inputStream);
                        peliculaDAO.agregar(pelicula);
                        break;
                    default:

                }
            } else {
                request.getRequestDispatcher("Pelicula.jsp").forward(request, response);
            }
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
            } else if (accion.equals("actualizar")) {

                String contraAnterior = request.getParameter("contrasena");
                String contraInv = request.getParameter("contrasenaInv");

                String contraNew = request.getParameter("contrasenaNew");

                int id = Integer.parseInt(request.getParameter("idUsere"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                Part part = request.getPart("foto");
                InputStream inputStream = part.getInputStream();


                if (contraAnterior.equals(contraInv)) {
                    usuario.setIdUsuario(id);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setCorreo_electronico(correo);
                    usuario.setContrasena(contraNew);
                    usuario.setFoto(inputStream);
                    usuarioDAO.actualizar(usuario);
                    request.getRequestDispatcher("Controlador?menu=Principal&accion=listar").forward(request, response);
                }
                request.getRequestDispatcher("Controlador?menu=Principal&accion=listar").forward(request, response);
            } else if (accion.equals("listarUser")) {
                String contra = request.getParameter("contra");
                String user = request.getParameter("user");

                usuario = usuarioDAO.validar(user, contra);

                if (usuario.getCorreo_electronico() != null) {
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("ConfiguracionUsuario.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Controlador?menu=Principal&accion=listar").forward(request, response);
                }
            } else if (accion.equals("listarCod")) {

                int idUser = Integer.parseInt(request.getParameter("codigo"));

                Usuario usuario = usuarioDAO.listarPorCodigo(idUser);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("PerfilUsuario.jsp").forward(request, response);
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
