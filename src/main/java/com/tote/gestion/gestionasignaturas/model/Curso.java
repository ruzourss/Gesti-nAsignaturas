/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.model;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.ByteArrayContent;

/**
 *
 * @author Tautvydas
 */
@ManagedBean
public class Curso {
    
    private int id;
    private String titulo;
    private String nivel;
    private int horas;
    private boolean activo;
    private ByteArrayContent temario;

    public Curso(){
        
    }
    
    public Curso(int id, String titulo, int horas, String nivel, boolean activo) {
        this.id = id;
        this.titulo = titulo;
        this.horas = horas;
        this.activo = activo;
        this.nivel = nivel;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ByteArrayContent getTemario() {
        return temario;
    }

    public void setTemario(ByteArrayContent temario) {
        this.temario = temario;
    }

    
    
}
