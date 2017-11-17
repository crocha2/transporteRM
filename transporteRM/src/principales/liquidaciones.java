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
public class liquidaciones {
    
    int id_liquidacion;
    String numero;
    String nombre;
    String conductor;
    String placa;
    String fecha;
    String fecha_inicio;
    String fecha_fin;
    int sub_total;
    int gran_total;
    int id_desciento;
    int id_cliente;
    int id_viaje;
    int id_vehiculo;
    String estado;

    public liquidaciones() {
    }

    public liquidaciones(int id_liquidacion, String numero, String nombre, String conductor, String placa, String fecha, String fecha_inicio, String fecha_fin, int sub_total, int gran_total, int id_desciento, int id_cliente, int id_viaje, int id_vehiculo, String estado) {
        this.id_liquidacion = id_liquidacion;
        this.numero = numero;
        this.nombre = nombre;
        this.conductor = conductor;
        this.placa = placa;
        this.fecha = fecha;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.sub_total = sub_total;
        this.gran_total = gran_total;
        this.id_desciento = id_desciento;
        this.id_cliente = id_cliente;
        this.id_viaje = id_viaje;
        this.id_vehiculo = id_vehiculo;
        this.estado = estado;
    }

    public int getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(int id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public int getGran_total() {
        return gran_total;
    }

    public void setGran_total(int gran_total) {
        this.gran_total = gran_total;
    }

    public int getId_desciento() {
        return id_desciento;
    }

    public void setId_desciento(int id_desciento) {
        this.id_desciento = id_desciento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
   
}
