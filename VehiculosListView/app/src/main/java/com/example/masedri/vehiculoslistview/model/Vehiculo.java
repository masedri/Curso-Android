package com.example.masedri.vehiculoslistview.model;

/**
 * Created by masedri on 19/1/17.
 */
// Esta clase represetan nuestro modelo de datos, la clase que vamos a mostrar en la activity.
public class Vehiculo {
    private String modelo;
    private String descripcion;
    private String fabricante;
    private int miniatura;
    private int imagen;

    public Vehiculo(String modelo, String descripcion, String fabricante, int miniatura, int imagen) {
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.miniatura = miniatura;
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(int miniatura) {
        this.miniatura = miniatura;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
