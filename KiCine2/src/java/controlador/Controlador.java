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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Cine;
import modelo.Comentario;
import modelo.Entrada;
import modelo.Estreno;
import modelo.Factura;
import modelo.FuncionEspecial;
import modelo.HorariosProyeccion;
import modelo.Pelicula;
import modelo.Preventa;
import modelo.Promocion;
import modelo.SalaCine;
import modelo.Usuario;
import modeloDAO.CineDAO;
import modeloDAO.ComentarioDAO;
import modeloDAO.EntradaDAO;
import modeloDAO.EstrenoDAO;
import modeloDAO.FacturaDAO;
import modeloDAO.FuncionEspecialDAO;
import modeloDAO.HorariosProyeccionDAO;
import modeloDAO.PeliculaDAO;
import modeloDAO.PreventaDAO;
import modeloDAO.PromocionDAO;
import modeloDAO.SalaCineDAO;
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

    Promocion promocion = new Promocion();
    PromocionDAO promocionDAO = new PromocionDAO();

    Preventa preventa = new Preventa();
    PreventaDAO preventaDAO = new PreventaDAO();

    HorariosProyeccion horario = new HorariosProyeccion();
    HorariosProyeccion horarios = new HorariosProyeccion();
    HorariosProyeccionDAO horarioDAO = new HorariosProyeccionDAO();

    Entrada entrada = new Entrada();
    EntradaDAO entradaDAO = new EntradaDAO();

    Cine cine = new Cine();
    CineDAO cineDAO = new CineDAO();

    Comentario comentario = new Comentario();
    ComentarioDAO comentarioDAO = new ComentarioDAO();

    SalaCine salaCine = new SalaCine();
    SalaCineDAO salaCineDAO = new SalaCineDAO();

    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();

    FuncionEspecial funcionEspecial = new FuncionEspecial();
    FuncionEspecialDAO funcionDAO = new FuncionEspecialDAO();

    int codPreventa, codEstreno, codCine, idEntrada, codComentario, codPromocion, idFuncion, idSalaCine, codHorario;

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

            /* --------------------------------------------- CARTELERA ------------------------------------------------------------------*/
        } else if (menu.equals("Cartelera")) {
            request.getRequestDispatcher("Cartelera.jsp").forward(request, response);

        } else if (menu.equals("HorariosProyeccion")) {
            switch (accion) {
                case "listar":
                    List listaHorarioP = horarioDAO.listar();
                    System.out.println("size" + listaHorarioP.size());
                    request.setAttribute("horarios", listaHorarioP);
                    break;

                case "Agregar":
                    String horario = request.getParameter("txtHorario");
                    String fecha = request.getParameter("txtFecha");
                    String asientos = request.getParameter("txtDisponibilidadAsientos");
                    String sala = request.getParameter("txtSala_id");
                    String pelicula = request.getParameter("txtPelicula_id");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");

                    java.util.Date date = dateFormat.parse(fecha);

                    java.util.Date d2 = (java.util.Date) format1.parse(horario);
                    java.sql.Time ppstime1 = new java.sql.Time(d2.getTime());

                    horarios.setHorario(ppstime1);
                    horarios.setFecha(date);
                    horarios.setDisponibilidadAsientos(Integer.parseInt(asientos));
                    horarios.setSala_id(Integer.parseInt(sala));
                    horarios.setPelicula_id(Integer.parseInt(pelicula));
                    horarioDAO.agregar(horarios);
                    request.getRequestDispatcher("Controlador?menu=HorariosProyeccion&accion=listar").forward(request, response);
                    break;

                case "Editar":
                    codHorario = Integer.parseInt(request.getParameter("idHorarioP"));
                    HorariosProyeccion hp = horarioDAO.listarIdHorarioP(codHorario);
                    request.setAttribute("list", hp);
                    request.getRequestDispatcher("Controlador?menu=HorariosProyeccion&accion=listar").forward(request, response);
                    break;

                case "Actualizar":

                    String horario1 = request.getParameter("txtHorario");
                    String fecha1 = request.getParameter("txtFecha");
                    String asientos1 = request.getParameter("txtDisponibilidadAsientos");
                    String sala1 = request.getParameter("txtSala_id");
                    String pelicula1 = request.getParameter("txtPelicula_id");

                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");

                    java.util.Date date1 = dateFormat1.parse(fecha1);

                    java.util.Date d1 = (java.util.Date) format.parse(horario1);
                    java.sql.Time ppstime = new java.sql.Time(d1.getTime());

                    horarios.setHorario(ppstime);
                    horarios.setFecha(date1);
                    horarios.setDisponibilidadAsientos(Integer.parseInt(asientos1));
                    horarios.setSala_id(Integer.parseInt(sala1));
                    horarios.setPelicula_id(Integer.parseInt(pelicula1));
                    horarios.setIdHorarioP(codHorario);
                    horarioDAO.actualizar(horarios);
                    request.getRequestDispatcher("Controlador?menu=HorariosProyeccion&accion=listar").forward(request, response);
                    break;

                case "Eliminar":
                    codHorario = Integer.parseInt(request.getParameter("idHorarioP"));
                    horarioDAO.eliminar(codHorario);
                    request.getRequestDispatcher("Controlador?menu=HorariosProyeccion&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("HorariosProyeccion.jsp").forward(request, response);
            /* --------------------------------------------- CINE ------------------------------------------------------------------*/
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


            /* --------------------------------------------- COMENTARIO ------------------------------------------------------------------*/
        }else if (menu.equals("comentarioP")) {
            switch (accion) {
                case "listarM":
                    List cm = comentarioDAO.listar();
                    request.setAttribute("cm", cm);
                    break;
            }
            request.getRequestDispatcher("ComentarioPrincipal.jsp").forward(request, response);
        } else if (menu.equals("Comentario")) {
            switch (accion) {
                case "listar":
                    String cod = request.getParameter("cod");
                    request.setAttribute("cod", cod);
                    break;

                case "Agregar":
                    String userID = request.getParameter("txtUsuario_id");
                    String text = request.getParameter("txtComentario");

                    comentario.setUsuario_id(Integer.parseInt(userID));
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
        } else if (menu.equals("ComentarioUsuario")) {

            switch ("accion") {
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

            request.getRequestDispatcher("ComentarioPrincipal.jsp").forward(request, response);
            /* --------------------------------------------- ESTRENO ------------------------------------------------------------------*/
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
            /* --------------------------------------------- FUNCION ESPECIAL ------------------------------------------------------------------*/
        } else if (menu.equals("Factura")) {
            switch (accion) {
                case "listar":
                    List listaFuncionEspecial = facturaDAO.listarPrincipal();
                    request.setAttribute("facturas", listaFuncionEspecial);
                    break;
            }

            request.getRequestDispatcher("FacturaPrincipal.jsp").forward(request, response);
        } else if (menu.equals("FuncionEspecial")) {
            switch (accion) {
                case "listar":
                    List listaFuncionEspecial = funcionDAO.listar();
                    request.setAttribute("funcionesEspeciales", listaFuncionEspecial);
                    break;

                case "Eliminar":
                    idFuncion = Integer.parseInt(request.getParameter("id"));
                    funcionDAO.Eliminar(idFuncion);
                    request.getRequestDispatcher("Controlador?menu=FuncionEspecial&accion=listar").forward(request, response);
                    break;

                case "agregar":
                    String tipo = request.getParameter("txtTipoFuncion");
                    String descripcion = request.getParameter("txtDescripcion");
                    String peliculaid = request.getParameter("txtPelicula_id");
                    String precio = request.getParameter("txtPrecio");

                    funcionEspecial.setTipoFuncion(tipo);
                    funcionEspecial.setDescripcion(descripcion);
                    funcionEspecial.setPelicula_id(Integer.parseInt(peliculaid));
                    funcionEspecial.setPrecio(Double.parseDouble(precio));
                    funcionDAO.agregar(funcionEspecial);
                    request.getRequestDispatcher("Controlador?menu=FuncionEspecial&accion=listar").forward(request, response);
                    break;

                case "Editar":
                    idFuncion = Integer.parseInt(request.getParameter("idFuncion"));
                    FuncionEspecial f = funcionDAO.listarCodigoFuncionEspecial(idFuncion);
                    request.setAttribute("funcionEspecial", f);
                    request.getRequestDispatcher("Controlador?menu=FuncionEspecial&accion=listar").forward(request, response);
                    break;

                case "Actualizar":
                    String tipo_f = request.getParameter("txtTipoFuncion");
                    String descripcion_f = request.getParameter("txtDescripcion");
                    String peliculaid_f = request.getParameter("txtPelicula_id");
                    String precio_f = request.getParameter("txtPrecio");
                    funcionEspecial.setIdFuncionEspecial(idFuncion);
                    funcionEspecial.setTipoFuncion(tipo_f);
                    funcionEspecial.setDescripcion(descripcion_f);
                    funcionEspecial.setPelicula_id(Integer.parseInt(peliculaid_f));
                    funcionEspecial.setPrecio(Double.parseDouble(precio_f));
                    funcionDAO.actualizar(funcionEspecial);
                    request.getRequestDispatcher("Controlador?menu=FuncionEspecial&accion=listar").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("FuncionEspecial.jsp").forward(request, response);
        } else if (menu.equals("HorariosProyeccion")) {
            request.getRequestDispatcher("HorariosProyeccion.jsp").forward(request, response);
            /* --------------------------------------------- ENTRADA ------------------------------------------------------------------*/
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
                    entrada.setCantidadEntradas(Integer.parseInt(cantidadEntradas_E));
                    entrada.setPagoTotal(Double.parseDouble(pagoTotal_E));
                    entradaDAO.actualizar(entrada);
                    request.getRequestDispatcher("Controlador?menu=Entrada&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Entrada.jsp").forward(request, response);
            /* --------------------------------------------- PREVENTA ------------------------------------------------------------------*/
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
            /* --------------------------------------------- PROMOCION ------------------------------------------------------------------*/
        } else if (menu.equals("Promocion")) {
            switch (accion) {
                case "Agregar":
                    String nPromocion = request.getParameter("txtNombrePromocion");
                    String desc = request.getParameter("txtDescripcion");
                    String fValidez = request.getParameter("txtFechasValidez");
                    String precio = request.getParameter("txtPrecio");
                    String pId = request.getParameter("txtPelicula_id");
                    promocion.setNombre_promopcion(nPromocion);
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
                    Promocion pre = promocionDAO.listarCodigoPromocion(codPromocion);
                    request.setAttribute("list", pre);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    String aNombrePromocion = request.getParameter("txtNombrePromocion");
                    String aDesc = request.getParameter("txtDescripcion");
                    String aFechasValidez = request.getParameter("txtFechasValidez");
                    String aPrecio = request.getParameter("txtPrecio");
                    String aPelicula_id = request.getParameter("txtPelicula_id");
                    promocion.setNombre_promopcion(aNombrePromocion);
                    promocion.setDescripcion(aDesc);
                    promocion.setFechasValidez(aFechasValidez);
                    promocion.setPrecio(Double.parseDouble(aPrecio));
                    promocion.setPelicula_id(Integer.parseInt(aPelicula_id));
                    promocion.setIdPromocion(codPromocion);
                    promocionDAO.actualizarPromocion(promocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    String idPromocion = request.getParameter("codigoPromocion");
                    promocionDAO.eliminarPromocion(codPromocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("Promocion.jsp").forward(request, response);
            /* --------------------------------------------- SALA CINE ------------------------------------------------------------------*/
        } else if (menu.equals("SalaCine")) {
            switch (accion) {
                case "listar":
                    List listaSalaCine = salaCineDAO.listar();
                    request.setAttribute("salaCine", listaSalaCine);
                    break;
                case "agregar":
                    int numeroSala = Integer.parseInt(request.getParameter("txtNumeroSala"));
                    int capacidad = Integer.parseInt(request.getParameter("txtCapacidad"));
                    String tipoSala = request.getParameter("txtTipoSala");
                    int cine_id = Integer.parseInt(request.getParameter("txtCine_id"));

                    salaCine.setNumeroSala(numeroSala);
                    salaCine.setCapacidad(capacidad);
                    salaCine.setTipoSala(tipoSala);
                    salaCine.setCine_id(cine_id);
                    salaCineDAO.agregar(salaCine);
                    request.getRequestDispatcher("Controlador?menu=SalaCine&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    idSalaCine = Integer.parseInt(request.getParameter("idSalaCine"));
                    salaCineDAO.Eliminar(idSalaCine);
                    request.getRequestDispatcher("Controlador?menu=SalaCine&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    idSalaCine = Integer.parseInt(request.getParameter("idSalaCine"));
                    SalaCine sc = salaCineDAO.listarCodigoSalaCine(idSalaCine);
                    request.setAttribute("list", sc);
                    request.getRequestDispatcher("Controlador?menu=SalaCine&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    int numeroSala_ = Integer.parseInt(request.getParameter("txtNumeroSala"));
                    int capacidad_ = Integer.parseInt(request.getParameter("txtCapacidad"));
                    String tipoSala_ = request.getParameter("txtTipoSala");
                    int cine_id_ = Integer.parseInt(request.getParameter("txtCine_id"));
                    salaCine.setIdSalaCine(idSalaCine);
                    salaCine.setNumeroSala((numeroSala_));
                    salaCine.setCapacidad((capacidad_));
                    salaCine.setTipoSala((tipoSala_));
                    salaCine.setCine_id((cine_id_));
                    salaCineDAO.actualizar(salaCine);
                    request.getRequestDispatcher("Controlador?menu=SalaCine&accion=listar").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("SalaCine.jsp").forward(request, response);
            /* --------------------------------------------- PELICULA ------------------------------------------------------------------*/
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
            /* --------------------------------------------- USUARIO ------------------------------------------------------------------*/
        } else if (menu.equals("usuario")) {

            if (accion.equals("agregar")) {
                List<Usuario> listaUsuarios = usuarioDAO.listar();
                String correoNuevo = request.getParameter("correo");
                System.out.println("size: " + listaUsuarios.size());
                boolean correoExistente = false;
                for (Usuario usuarioExistente : listaUsuarios) {
                    if (usuarioExistente.getCorreo_electronico().equals(correoNuevo)) {
                        correoExistente = true;
                        break;
                    }
                }
                if (correoExistente) {
                    request.setAttribute("txtDoble", "Correo Electrónico ya registrado");
                } else {
                    String name = request.getParameter("nombre");
                    String apell = request.getParameter("apellido");
                    String contra = request.getParameter("contrasena");

                    usuario.setNombre(name);
                    usuario.setApellido(apell);
                    usuario.setCorreo_electronico(correoNuevo); // Usamos el nuevo valor de correo
                    usuario.setContrasena(contra);
                    Part part = request.getPart("foto");
                    InputStream inputStream = part.getInputStream();
                    usuario.setFoto(inputStream);
                    usuarioDAO.agregar(usuario);
                    request.setAttribute("txtAgregado", "Usuario Creado");
                }

                request.getRequestDispatcher("AgregarUsuario.jsp").forward(request, response);
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

                //int codigo2 = Integer.parseInt(request.getParameter("cod"));
                if (contraAnterior.equals(contraInv)) {
                    usuario.setIdUsuario(id);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setCorreo_electronico(correo);
                    usuario.setContrasena(contraNew);
                    usuario.setFoto(inputStream);
                    usuarioDAO.actualizar(usuario);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
            } else if (accion.equals("login")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            /* --------------------------------------------- PROMO ------------------------------------------------------------------*/
        } else if (menu.equals("promo")) {

            switch (accion) {
                case "listarPrincipal":
                    List<Promocion> lista = promocionDAO.listar();
                    request.setAttribute("lista", lista);
                    break;
            }
            request.getRequestDispatcher("Promociones.jsp").forward(request, response);

        } else if (menu.equals("estrenoPrincipal")) {

            switch (accion) {
                case "listar":
                    List<Estreno> lista = estrenoDAO.listarInnerJoin();
                    request.setAttribute("lista", lista);
                    break;
            }
            request.getRequestDispatcher("EstrenoPrincipal.jsp").forward(request, response);
        } else if (menu.equals("funcionPrincipal")) {

            switch (accion) {
                case "listar":
                    List<FuncionEspecial> lista = funcionDAO.listarInnerJoin();
                    request.setAttribute("lista", lista);
                    break;
            }
            request.getRequestDispatcher("FuncionEspecialPrincipal.jsp").forward(request, response);
        } else if (menu.equals("preventaPrincipal")) {

            switch (accion) {
                case "listar":
                    List<Preventa> lista = preventaDAO.listarInnerJoin();
                    request.setAttribute("lista", lista);
                    break;
            }
            request.getRequestDispatcher("PreventaPrincipal.jsp").forward(request, response);
        } else if (menu.equals("PreventaCompra")) {

            switch (accion) {
                case "listar":
                    String prev = request.getParameter("prev");
                    String pre = request.getParameter("pre");
                    String codPeli = (request.getParameter("codee"));
                    List<HorariosProyeccion> lista = horarioDAO.listarInnerJoin(codPeli);
                    request.setAttribute("lista", lista);
                    request.setAttribute("prev", prev);
                    request.setAttribute("pre", pre);
                    break;
            }
            request.getRequestDispatcher("HorarioPrincipal.jsp").forward(request, response);
        } else if (menu.equals("compraBoletos")) {

            switch (accion) {
                case "listarCod":

                    //Cines
                    List cine = cineDAO.listar();
                    request.setAttribute("cine", cine);

                    String pre = request.getParameter("pre");
                    String prev = request.getParameter("prev");
                    String cod = request.getParameter("cod");

                    List<HorariosProyeccion> lista = horarioDAO.listarHorariosId(cod);
                    request.setAttribute("lista", lista);
                    request.setAttribute("prev", prev);
                    request.setAttribute("pre", pre);

                    break;
            }
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("realizarCompra")) {

            switch (accion) {

                case "compra":

                    int idHorario = Integer.parseInt(request.getParameter("idHorario"));

                    int idCine = Integer.parseInt(request.getParameter("idPrev"));

                    int idPrev = Integer.parseInt(request.getParameter("idPrev"));
                    int cantEntradas = Integer.parseInt(request.getParameter("cantidad-hidden"));
                    Double total = Double.parseDouble(request.getParameter("prev")) * cantEntradas;

                    entrada.setHorarioP_id(idHorario);
                    entrada.setCine_id(idCine);
                    entrada.setPreventa_id(idPrev);
                    entrada.setCantidadEntradas(cantEntradas);
                    entrada.setPagoTotal(total);
                    entradaDAO.agregar(entrada);
                    break;
            }
            request.getRequestDispatcher("FacturaPrincipal.jsp").forward(request, response);

        } else if (menu.equals("cinesListar")) {
            switch (accion) {
                case "listar":
                    //int idP = 0;
                    String codUser = request.getParameter("cod");
                    request.setAttribute("cod", codUser);

                    List cines = cineDAO.listarPrev();

                    request.setAttribute("cine", cines);

                    //List horarios = horarioDAO.listarPelis(idP);
                    //request.setAttribute("horarios", horarios);
                    //List preventas = preventaDAO.listarPorIdH(idP);
                    //request.setAttribute("peliculas", preventas);
                    //SalaCine salaCine = salaCineDAO.listarCine(idCine);
                    //request.setAttribute("sala", salaCine);
                    //List preventas = preventaDAO.listar();
                    //request.setAttribute("preventa", preventas);
                    //List horarios = horarioDAO.listarInnerJoin(menu);
                    //request.setAttribute("horario", horarios);
                    break;
            }
            request.getRequestDispatcher("CinePrincipal.jsp").forward(request, response);
        } else if (menu.equals("compraFinalP")) {
            switch (accion) {

                case "listar":
                    String codUser = request.getParameter("cod");
                    request.setAttribute("cod", codUser);

                    String idH = request.getParameter("idH");
                    String idC = request.getParameter("idC");
                    int idP = Integer.parseInt(request.getParameter("idP"));

                    request.setAttribute("idH", idH);
                    request.setAttribute("idC", idC);
                    //request.setAttribute("preventas", preventas);

                    List preventas = preventaDAO.listarPelis(idP);
                    request.setAttribute("preventas", preventas);

                    List horarios = horarioDAO.listarHorariosId(idH);
                    request.setAttribute("horarios", horarios);
            }
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("EntradaFinal")) {

            switch (accion) {

                case "Comprar":

                    int codUser = Integer.parseInt(request.getParameter("cod"));

                    int idH = Integer.parseInt(request.getParameter("idH"));
                    int idC = Integer.parseInt(request.getParameter("idC"));
                    int idP = Integer.parseInt(request.getParameter("idP"));

                    int cantEntradas = Integer.parseInt(request.getParameter("cantidad"));
                    Double pagoTotal = Double.parseDouble(request.getParameter("precio")) * cantEntradas;

                    Entrada entrada = new Entrada();

                    entrada.setHorarioP_id(idH);
                    entrada.setCine_id(idC);
                    entrada.setPreventa_id(idP);
                    entrada.setCantidadEntradas(cantEntradas);
                    entrada.setPagoTotal(pagoTotal);
                    entradaDAO.agregar(entrada);

                    Factura fac = new Factura();

                    Calendar calendar = Calendar.getInstance();
                    java.util.Date utilDate = calendar.getTime();

                    // Convertir la fecha a java.sql.Date
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    fac.setFecha_emision(sqlDate);
                    fac.setUsuario_id(codUser);
                    fac.setTotal_pago(pagoTotal);
                    //fac.setFecha_emision(fechaActual);
                    facturaDAO.agregar(fac);

                    List facturas = facturaDAO.listar(codUser);
                    request.setAttribute("facturas", facturas);

            }
            request.getRequestDispatcher("FacturaPrincipal.jsp").forward(request, response);
        } else if (menu.equals("InicioSesion")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if (menu.equals("Programadores")) {
            request.getRequestDispatcher("Programadores.jsp").forward(request, response);
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
