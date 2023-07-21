/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Windows 10
 */
public class Login {
    private int codigoUsuario;
    private String usuario;
    private String contrasena;

    
    
    public Login() {
        
        
    }
    

    public Login(int codigoUsuario, String usuario, String contrasena) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    
    
}
