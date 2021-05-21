/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1bd2;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Alumno {
       public int ID;
       public String Nombre,user,contra;
       public ArrayList<String> ResultadoExam=new ArrayList();

    public Alumno(int ID, String Nombre, String user, String contra) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.user = user;
        this.contra = contra;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public ArrayList<String> getResultadoExam() {
        return ResultadoExam;
    }

    public void setResultadoExam(ArrayList<String> ResultadoExam) {
        this.ResultadoExam = ResultadoExam;
    }
    
    public void setExamen(String e){
        ResultadoExam.add(e);
    }
       
}
