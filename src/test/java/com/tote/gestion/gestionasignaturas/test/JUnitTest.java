/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tote.gestion.gestionasignaturas.test;

import com.tote.gestion.gestionasignaturas.DAO.CursoDetailsDAO;
import com.tote.gestion.gestionasignaturas.model.CursoV2;
import com.tote.gestion.gestionasignaturas.model.Nivel;
import com.tote.gestion.gestionasignaturas.model.Temario;
import com.tote.gestion.gestionasignaturas.view.CursoView;
import com.tote.gestion.gestionasignaturas.view.ProfesorView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Tautvydas
 */
public class JUnitTest {
    
    File file;
    ApplicationContext cxt;
    CursoView cursoView;
    ProfesorView profesorView;
    
    public JUnitTest() {
    }

    @Before
    public void setUp() {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "spring-config.xml";
        file = new File(path);
        System.err.println("path file: " + path +" "+file.exists());
        cxt = new FileSystemXmlApplicationContext(file.getAbsolutePath());
        cursoView = cxt.getBean(CursoView.class);
        profesorView = cxt.getBean(ProfesorView.class);
    }
    @Test
    public void testNotNullCursoView_true() {
        assertTrue(cursoView != null);
    }
    
    @Test
    public void testNotNullProfesorView_true() {
        assertTrue(profesorView != null);
    }
    
    @Test
    public void testProfesorViewListProfesorGreaterThanZero_true() {
        assertTrue(profesorView.getListProfesor().size() > 0);
    }
    
    @Test
    public void testProfesorViewListNivelesGreaterThanZero_true() {
        assertTrue(profesorView.getListNiveles().size() > 0);
    }
    
    @Test
    public void testProfesorViewListMethodInitIsRunning_true() {
        profesorView.init();
        assertTrue(profesorView.getListNiveles().size() > 0 && profesorView.getListProfesor().size() > 0);
    }
    
    @Test
    public void testCursoViewListGreaterThanZero_true() {
        assertTrue(cursoView.getCursoActivo().size() > 0);
    }
    
    @Test
    public void testCursoViewAddCurso_true() {
        CursoV2 curso = new CursoV2(0, "Java Prueba", 25, new Nivel(), true);
        assertTrue(cursoView.getCursoDetailsDAO().addCurso(curso) > 0);
    }
    
    @Test
    public void testCursoViewAddTemarioCurso_true() {
           
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsf.pdf";
            File file = new File(path);
            String fileBase64 = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            fileBase64 = Base64.getEncoder().encodeToString(buffer);
            
            profesorView.getTemarioDetailsDAO().addTemario(0, 2, file.getName(), fileBase64);
            
            Temario temario = profesorView.getTemarioDetailsDAO().getTemario(1);
            
            assertTrue(temario != null);
            
            profesorView.getTemarioDetailsDAO().deleteTemario(2);
            
            temario = profesorView.getTemarioDetailsDAO().getTemario(2);
            
            assertTrue(temario == null);
            
            inputStream.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testCursoGetTemarioAndWrite_true() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsf_copia.pdf";
        Temario temario = profesorView.getTemarioDetailsDAO().getTemario(1);
        byte temarioByte [] = Base64.getDecoder().decode(temario.getFichero());
        try {
            FileOutputStream out = new FileOutputStream(path);
            out.write(temarioByte);
            out.close();
            File file = new File(path);
            assertTrue(file.exists());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @After
    public void tearDown() {
        cursoView.destroy();
    }

}
