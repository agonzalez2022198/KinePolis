
package modelo;

import java.util.Date;




public class Estreno {
    int idEstreno;
    int pelicula_id;
    String descripcionEstreno;
    Date fecha_estreno;

    public Estreno() {
    }

    public Estreno(int idEstreno, int pelicula_id, String descripcionEstreno, Date fecha_estreno) {
        this.idEstreno = idEstreno;
        this.pelicula_id = pelicula_id;
        this.descripcionEstreno = descripcionEstreno;
        this.fecha_estreno = fecha_estreno;
    }

    public int getIdEstreno() {
        return idEstreno;
    }

    public void setIdEstreno(int idEstreno) {
        this.idEstreno = idEstreno;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getDescripcionEstreno() {
        return descripcionEstreno;
    }

    public void setDescripcionEstreno(String descripcionEstreno) {
        this.descripcionEstreno = descripcionEstreno;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    
    
    
    
}
