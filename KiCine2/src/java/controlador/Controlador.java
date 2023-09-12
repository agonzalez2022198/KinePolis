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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Cine;
import modelo.Comentario;
import modelo.Entrada;
import modelo.Estreno;
import modelo.Pelicula;
import modelo.Preventa;
import modelo.Promocion;
import modelo.SalaCine;
import modelo.Usuario;
import modeloDAO.CineDAO;
import modeloDAO.ComentarioDAO;
import modeloDAO.EntradaDAO;
import modeloDAO.EstrenoDAO;
import modeloDAO.PeliculaDAO;
import modeloDAO.PreventaDAO;
import modeloDAO.PromocionDAO;
import modeloDAO.SalaCineDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Windows 10
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    Comentario comentario = new Comentario();
    Estreno estreno = new Estreno();
    Preventa preventa = new Preventa();
    Pelicula pelicula = new Pelicula();
    Entrada entrada = new Entrada();
    SalaCine salaCine = new SalaCine();
    Cine cine = new Cine();
    Promocion promocion = new Promocion();
    // DAOS
    SalaCineDAO salaCineDAO = new SalaCineDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    EstrenoDAO estrenoDAO = new EstrenoDAO();
    CineDAO cineDAO = new CineDAO();
    EntradaDAO entradaDAO = new EntradaDAO();
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    ComentarioDAO comentarioDAO = new ComentarioDAO();
    PreventaDAO preventaDAO = new PreventaDAO();
    PromocionDAO promocionDAO = new PromocionDAO();
    
    int codPreventa, codEstreno, codCine, idEntrada, codComentario, codPromocion;
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

            switch (accion) {
                case "listar":
                    List listaCine = cineDAO.listar();
                    request.setAttribute("cine", listaCine);
                    break;
                case "agregar":
                    String nombre = request.getParameter("txtNombre");
                    String ubicacion = request.getParameter("txtUbicacion");
                    String telefono = request.getParameter("txtTelefono");
                    cine.setNombre(nombre);
                    cine.setUbicacion(ubicacion);
                    cine.setTelefono(telefono);
                    cineDAO.agregar(cine);
                    System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                    request.getRequestDispatcher("Controlador?menu=Cine&accion=listar").forward(request, response);
                    break;
                case "editar":
                    codCine = Integer.parseInt(request.getParameter("codigoCine"));
                    Cine c = cineDAO.listarCodigoCine(codCine);
                    request.setAttribute("list", c);
                    request.getRequestDispatcher("Controlador?menu=Cine&accion=listar").forward(request, response);
                    break;
                case "actualizar":
                    String nombreA = request.getParameter("txtNombre");
                    String ubicacionA = request.getParameter("txtUbicacion");
                    String telefonoA = request.getParameter("txtTelefono");
                    cine.setNombre(nombreA);
                    cine.setUbicacion(ubicacionA);
                    cine.setTelefono(telefonoA);
                    cine.setIdCine(codCine);
                    cineDAO.actualizar(cine);
                    request.getRequestDispatcher("Controlador?menu=Cine&accion=listar").forward(request, response);
                    break;
                case "eliminar":
                    codCine = Integer.parseInt(request.getParameter("codigoCine"));
                    cineDAO.eliminar(codCine);
                    request.getRequestDispatcher("Controlador?menu=Cine&accion=listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("Cine.jsp").forward(request, response);

        }else if(menu.equals("Comentario")){
            switch(accion){
                case "listar":
                    List listaComentario = comentarioDAO.listar();
                    request.setAttribute("comentarios", listaComentario);
                    break;
                    
                case "listarPelicula":
                   /* List listaPelicula = comentarioDAO.listaPelicula();
                    request.setAttribute("peliculas", listaPelicula);*/
                    
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
                   /* List listaPelicula = comentarioDAO.listaPelicula(); 
                      request.setAttribute("peliculas", listaPelicula); */
                    break;
                case "Editar":
                    codComentario = Integer.parseInt(request.getParameter("codigoComentario"));
                    Comentario c = comentarioDAO.listaComentario(codComentario);
                    request.setAttribute("comentario", c);
                    break;
                
            }
            
            request.getRequestDispatcher("ComentarioUsuario.jsp").forward(request, response);
        }else if (menu.equals("Estreno")) {
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

        } else if (menu.equals("FuncionEspecial")) {
            request.getRequestDispatcher("FuncionEspecial.jsp").forward(request, response);

        } else if (menu.equals("SalaCine")){
            switch(accion){
                case "listar":
                    List listaSalaCine = salaCineDAO.listar();
                    request.setAttribute("salaCine", listaSalaCine);
            }
            
            request.getRequestDispatcher("SalaCine.jsp").forward(request, response);
        } else if (menu.equals("HorariosProyeccion")) {
            request.getRequestDispatcher("HorariosProyeccion.jsp").forward(request, response);
            
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
            
            /* BRANDOOOOOOOOOOOOOOOOOOONNNNNNNNNN*/ 
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

        } else if (menu.equals("PreventaAdmin")) {
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
            
            /* ADOLFOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*/ 
        }else if (menu.equals("Promocion")){
                switch(accion){
                    case "Agregar":
                        String nPromocion = request.getParameter("txtNombrePromocion");
                        String desc = request.getParameter("txtDescripcion");
                        String fValidez = request.getParameter("txtFechasValidez");
                        String precio = request.getParameter("txtPrecio");
                        int pId = Integer.parseInt(request.getParameter("txtPelicula_id"));
                        promocion.setNombrePromocion(nPromocion);
                        promocion.setDescripcion(desc);
                        promocion.setFechasValidez(fValidez);
                        promocion.setPrecio(Double.parseDouble(precio));
                        promocion.setPelicula_id(pId);
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
                        Promocion pre = promocionDAO.listarCodigoPromocion(codPromocion);
                        request.setAttribute("list", pre);
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
            }else if (menu.equals("Pelicula")) {
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
            }

        } else if (menu.equals("InicioSesion")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
