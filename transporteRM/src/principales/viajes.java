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
public class viajes {
    
    int id_viaje;
    String placa;
    String fecha;
    String dia;
    String recorrido;
    int unidad;
    int valor_m3;
    int m3;
    int km;
    int total;
    int id_vehiculo;

    public viajes() {
    }

    public viajes(int id_viaje, String placa, String fecha, String dia, String recorrido, int unidad, int valor_m3, int m3, int km, int total, int id_vehiculo) {
        this.id_viaje = id_viaje;
        this.placa = placa;
        this.fecha = fecha;
        this.dia = dia;
        this.recorrido = recorrido;
        this.unidad = unidad;
        this.valor_m3 = valor_m3;
        this.m3 = m3;
        this.km = km;
        this.total = total;
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public int getValor_m3() {
        return valor_m3;
    }

    public void setValor_m3(int valor_m3) {
        this.valor_m3 = valor_m3;
    }

    public int getM3() {
        return m3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

        
}
