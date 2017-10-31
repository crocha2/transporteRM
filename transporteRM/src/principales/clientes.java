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
public class clientes {
    
    int id_cliente;
    String nit;
    String tipo_persona;
    String nombre;
    String departamento;
    String municipio;
    String direccion;
    String contacto;
    String email_contacto;
    String telefono_contacto;

    public clientes() {
    }

    public clientes(int id_cliente, String nit, String tipo_persona, String nombre, String departamento, String municipio, String direccion, String contacto, String email_contacto, String telefono_contacto) {
        this.id_cliente = id_cliente;
        this.nit = nit;
        this.tipo_persona = tipo_persona;
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.contacto = contacto;
        this.email_contacto = email_contacto;
        this.telefono_contacto = telefono_contacto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }
    
    
    
}
