/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.view;

import com.tote.gestion.gestionasignaturas.DAO.CursoDetailsDAO;
import com.tote.gestion.gestionasignaturas.DAO.NivelDetailsDAO;
import com.tote.gestion.gestionasignaturas.DAO.ProfesorDetailsDAO;
import com.tote.gestion.gestionasignaturas.DAO.TemarioDetailsDAO;
import com.tote.gestion.gestionasignaturas.model.Curso;
import com.tote.gestion.gestionasignaturas.model.CursoV2;
import com.tote.gestion.gestionasignaturas.model.Nivel;
import com.tote.gestion.gestionasignaturas.model.Profesor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tautvydas
 */
@ManagedBean
public class ProfesorView {

    private String profesorName;
    private boolean activado;
    private String titulo;
    private int horas;
    private String nivel;
    private Curso curso;
    private CursoV2 cursov2;
    private String file, fileName;

    @Autowired
    private ProfesorDetailsDAO profesorDetailsDAO;
    @Autowired
    private CursoDetailsDAO cursoDetailsDAO;
    @Autowired
    private NivelDetailsDAO nivelDetailsDAO;
    @Autowired
    private TemarioDetailsDAO temarioDetailsDAO;

    private List<Profesor> profesores;
    private List<String> listProfesor;

    private List<String> listNiveles;
    private List<Nivel> niveles;

    @PostConstruct
    public void init() {
        profesores = profesorDetailsDAO.getAllProfesor();
        niveles = nivelDetailsDAO.getAllNivel();
        listProfesor = new ArrayList<>();
        for (Profesor prof : profesores) {
            listProfesor.add(prof.getNombre());
        }
        listNiveles = new ArrayList<>();
        for (Nivel nivel : niveles) {
            listNiveles.add(nivel.getNivel());
        }
    }

    public void addCurso() {

        Nivel niv = null;
        Profesor profe = null;

        for (Profesor profesor : profesores) {
            if (profesor.getNombre().equals(profesorName)) {
                profe = profesor;
                break;
            }
        }

        for (Nivel level : niveles) {
            if (level.getNivel().equals(this.nivel)) {
                niv = level;
                break;
            }
        }

        cursov2 = new CursoV2(0, titulo, horas, niv, activado);

        cursoDetailsDAO.addCurso(cursov2);
        List<Curso> cursos = cursoDetailsDAO.getAllCursos();
        Curso cur = null;

        for (Curso curso : cursos) {
            if (curso.getTitulo().equals(cursov2.getTitulo())) {
                cur = curso;
                break;
            }
        }
        cursoDetailsDAO.addCursoImparte(profe.getId(), cur.getId());

        //addTemario(fileName, file, cur.getId());
    }

    public void handleFileUpload(FileUploadEvent event) {

        try {
            InputStream in = event.getFile().getInputstream();

            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            file = Base64.getEncoder().encodeToString(buffer);
            fileName = event.getFile().getFileName();

        } catch (IOException ex) {
            Logger.getLogger(ProfesorView.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void addTemario(String name, String file, int cursoId) {
        temarioDetailsDAO.addTemario(0, cursoId, name, file);
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getListNiveles() {
        return listNiveles;
    }

    public void setListNiveles(List<String> listNiveles) {
        this.listNiveles = listNiveles;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfesorName() {
        return profesorName;
    }

    public void setProfesorName(String profesorName) {
        this.profesorName = profesorName;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public ProfesorDetailsDAO getProfesorDetailsDAO() {
        return profesorDetailsDAO;
    }

    public void setProfesorDetailsDAO(ProfesorDetailsDAO profesorDetailsDAO) {
        this.profesorDetailsDAO = profesorDetailsDAO;
    }

    public NivelDetailsDAO getNivelDetailsDAO() {
        return nivelDetailsDAO;
    }

    public void setNivelDetailsDAO(NivelDetailsDAO nivelDetailsDAO) {
        this.nivelDetailsDAO = nivelDetailsDAO;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<String> getListProfesor() {
        return listProfesor;
    }

    public void setListProfesor(List<String> listProfesor) {
        this.listProfesor = listProfesor;
    }

    public List<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(List<Nivel> niveles) {
        this.niveles = niveles;
    }

    public TemarioDetailsDAO getTemarioDetailsDAO() {
        return temarioDetailsDAO;
    }

    public void setTemarioDetailsDAO(TemarioDetailsDAO temarioDetailsDAO) {
        this.temarioDetailsDAO = temarioDetailsDAO;
    }

}
