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
public class vehiculos {
    
    int id_vehiculo;
    String placa;
    String año_modelo;
    String fecha_ingreso;
    String clase;
    String marca;
    String modelo;
    String color;
    String metros_cubicos;
    String propio;
    String estado;
    int id_propietario;
    int id_conductor;

    public vehiculos() {
    }

    public vehiculos(int id_vehiculo, String placa, String año_modelo, String fecha_ingreso, String clase, String marca, String modelo, String color, String metros_cubicos, String propio, String estado, int id_propietario, int id_conductor) {
        this.id_vehiculo = id_vehiculo;
        this.placa = placa;
        this.año_modelo = año_modelo;
        this.fecha_ingreso = fecha_ingreso;
        this.clase = clase;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.metros_cubicos = metros_cubicos;
        this.propio = propio;
        this.estado = estado;
        this.id_propietario = id_propietario;
        this.id_conductor = id_conductor;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAño_modelo() {
        return año_modelo;
    }

    public void setAño_modelo(String año_modelo) {
        this.año_modelo = año_modelo;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetros_cubicos() {
        return metros_cubicos;
    }

    public void setMetros_cubicos(String metros_cubicos) {
        this.metros_cubicos = metros_cubicos;
    }

    public String getPropio() {
        return propio;
    }

    public void setPropio(String propio) {
        this.propio = propio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

   
    
    
    
    
}
