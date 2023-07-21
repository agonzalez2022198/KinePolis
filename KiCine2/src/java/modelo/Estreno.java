
package modelo;

import java.util.Date;

public class Estreno {
    int idEstreno;
    int pelicula_id;
    Date fecha_estreno;
    int promocion_id;

    public Estreno() {
    }

    public Estreno(int idEstreno, int pelicula_id, Date fecha_estreno, int promocion_id) {
        this.idEstreno = idEstreno;
        this.pelicula_id = pelicula_id;
        this.fecha_estreno = fecha_estreno;
        this.promocion_id = promocion_id;
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

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public int getPromocion_id() {
        return promocion_id;
    }

    public void setPromocion_id(int promocion_id) {
        this.promocion_id = promocion_id;
    }
    
    
    
}
