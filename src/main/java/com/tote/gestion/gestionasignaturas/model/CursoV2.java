/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.model;


/**
 *
 * @author Tautvydas
 */
public class CursoV2 {
    
    private int id;
    private String titulo;
    private int horas;
    private Nivel nivel;
    private boolean activo;

    public CursoV2(int id, String titulo, int horas, Nivel nivel, boolean activo) {
        this.id = id;
        this.titulo = titulo;
        this.horas = horas;
        this.nivel = nivel;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
      
    
}
