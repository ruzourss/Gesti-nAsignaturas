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
public class Nivel {
    private int id;
    private String nivel;

    public Nivel() {
        id = 1;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
