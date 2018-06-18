/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.DAO;

import com.tote.gestion.gestionasignaturas.model.Temario;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Tautvydas
 */
public interface TemarioDetailsDAO {
    public void addTemario(@Param("id") int id, @Param("idCurso") int idCurso, @Param("nombre") String nombre, @Param("file") String file);
    public Temario getTemario(@Param("idTemario") int idTemario);
    public void deleteTemario(@Param("idCurso") int idCurso);
}
