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
public class recorridos {
    
    int id_recorrido;
    String origen;
    String destino;
    String km_recorridos;

    public recorridos() {
    }

    public recorridos(int id_recorrido, String origen, String destino, String km_recorridos) {
        this.id_recorrido = id_recorrido;
        this.origen = origen;
        this.destino = destino;
        this.km_recorridos = km_recorridos;
    }

    public int getId_recorrido() {
        return id_recorrido;
    }

    public void setId_recorrido(int id_recorrido) {
        this.id_recorrido = id_recorrido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getKm_recorridos() {
        return km_recorridos;
    }

    public void setKm_recorridos(String km_recorridos) {
        this.km_recorridos = km_recorridos;
    }
    
    
    
}
