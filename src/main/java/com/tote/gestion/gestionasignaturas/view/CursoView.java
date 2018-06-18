/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.view;

import com.tote.gestion.gestionasignaturas.DAO.CursoDetailsDAO;
import com.tote.gestion.gestionasignaturas.DAO.TemarioDetailsDAO;
import com.tote.gestion.gestionasignaturas.model.Curso;
import com.tote.gestion.gestionasignaturas.model.Temario;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.ByteArrayContent;
import org.primefaces.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tautvydas
 */

public class CursoView {

    @Autowired
    private CursoDetailsDAO cursoDetailsDAO;
    @Autowired
    private TemarioDetailsDAO temarioDetailsDAO;
    private Temario temario;

    private List<Curso> cursoActivo;

    @PostConstruct
    public void init() {
        cursoActivo = cursoDetailsDAO.getCursosAcctivos();
        temario = temarioDetailsDAO.getTemario(1);
        for (Curso curso : cursoActivo) {
            if(curso.getTitulo().equals("Introducción a JSF2")){
                byte [] temarioBinary = Base64.decode(temario.getFichero());
                curso.setTemario(new ByteArrayContent(temarioBinary, "application/pdf", temario.getNombre()));
            }
        }
    }

    public List<Curso> getCursoActivo() {
        return cursoActivo;
    }

    public void setCursoActivo(List<Curso> cursoActivo) {
        this.cursoActivo = cursoActivo;
    }

    public CursoDetailsDAO getCursoDetailsDAO() {
        return cursoDetailsDAO;
    }

    public void setCursoDetailsDAO(CursoDetailsDAO cursoDetailsDAO) {
        this.cursoDetailsDAO = cursoDetailsDAO;
    }

    public void destroy() {
        System.err.println("Bean ha sido destruido");
    }
}
