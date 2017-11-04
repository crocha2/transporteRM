/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principales;

/**
 *
 * @author user
 */
public class propietarios {
    
    int id_propietario;
    String identificacion;
    String nombre_propietario;
    String departamento;
    String municipio;
    String direccion;
    String fecha_ingreso;
    String email;
    String telefono;
    String estado;

    public propietarios() {
    }

    public propietarios(int id_propietario, String identificacion, String nombre_propietario, String departamento, String municipio, String direccion, String fecha_ingreso, String email, String telefono, String estado) {
        this.id_propietario = id_propietario;
        this.identificacion = identificacion;
        this.nombre_propietario = nombre_propietario;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.fecha_ingreso = fecha_ingreso;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
