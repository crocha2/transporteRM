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
public class conductores {
    
    int id_conductor;
    String cedula;
    String nombre_conductor;
    String departamento;
    String municipio;
    String direccion;
    String fecha_ingreso;
    String email;
    String telefono;
    String numero_licencia;
    String clase_categoria;
    String estado;

    public conductores() {
    }

    public conductores(int id_conductor, String cedula, String nombre_conductor, String departamento, String municipio, String direccion, String fecha_ingreso, String email, String telefono, String numero_licencia, String clase_categoria, String estado) {
        this.id_conductor = id_conductor;
        this.cedula = cedula;
        this.nombre_conductor = nombre_conductor;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.fecha_ingreso = fecha_ingreso;
        this.email = email;
        this.telefono = telefono;
        this.numero_licencia = numero_licencia;
        this.clase_categoria = clase_categoria;
        this.estado = estado;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_conductor() {
        return nombre_conductor;
    }

    public void setNombre_conductor(String nombre_conductor) {
        this.nombre_conductor = nombre_conductor;
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

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public String getClase_categoria() {
        return clase_categoria;
    }

    public void setClase_categoria(String clase_categoria) {
        this.clase_categoria = clase_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
