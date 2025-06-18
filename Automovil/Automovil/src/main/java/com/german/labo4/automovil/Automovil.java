package com.german.labo4.automovil;

public class Automovil implements IDescribible {

    private String marca;
    private String modelo;
    private String anio;
    private String imageURL;

    public Automovil() {}

    public Automovil(String marca, String modelo, String anio, String imageURL) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.imageURL = imageURL;
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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String getDescripcion() {
        return marca + " " + modelo + " (" + anio + ")";
    }
}