/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.model;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Tautvydas
 */
@ManagedBean
public class Profesor {
    
    private int id;
    private String nombre;
    private int idCurso;

    public Profesor(){
        
    }
    
    public Profesor(int id){
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object obj) {
       Profesor profesor = (Profesor) obj;
       return this.id == profesor.id;
    }

    
    
    
}
