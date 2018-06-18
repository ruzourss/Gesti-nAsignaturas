/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.DAO;

import com.tote.gestion.gestionasignaturas.model.Curso;
import com.tote.gestion.gestionasignaturas.model.CursoV2;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 *
 * @author Tautvydas
 */
public interface CursoDetailsDAO {
    public List<Curso> getAllCursos();
    public Curso getCurso(int id);
    public int addCurso(CursoV2 curso);
    
    public void addCursoImparte(@Param("id_profesor") int id_profesor, @Param("id_curso") int id_curso);
    public List<Curso> getCursosAcctivos();
}
