package com.example.appholamundo1;

import java.io.Serializable;
import java.util.Random;

public class cotizacion {
    private int folio;

    private String descripcion;

    private float valorAuto;

    private float porEnganche;

    private int plazos;

    public cotizacion(int folio, String descripcion, float valorAuto, float porEnganche, int plazos) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.valorAuto = valorAuto;
        this.porEnganche = porEnganche;
        this.plazos = plazos;

    }

    public cotizacion (){
        this.folio = 0;
        this.descripcion = "";
        this.valorAuto = 0.0f;
        this.porEnganche = 0.0f;
        this.plazos = 0;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorAuto() {
        return valorAuto;
    }

    public void setValorAuto(float valorAuto) {
        this.valorAuto = valorAuto;
    }

    public float getPorEnganche() {
        return porEnganche;
    }

    public void setPorEnganche(float porEnganche) {
        this.porEnganche = porEnganche;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    //metodo de comportamineto
    public int generaId(){
        Random r = new Random();
        return  r.nextInt()%1000;
    }

    public float calcularPagoInicial(){
        return this.valorAuto * (this.porEnganche/100);
    }

    public float calcularPagoMensual(){
        return (this.valorAuto - this.calcularPagoInicial() ) / this.plazos;

    }


}
