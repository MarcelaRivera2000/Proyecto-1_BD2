/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1bd2;

/**
 *
 * @author HP
 */
public class Resultados {
    
    int Nota,idEstudiante,idExamen,idClase;

    public Resultados(int Nota, int idEstudiante, int idExamen,int idClase) {
        this.Nota = Nota;
        this.idEstudiante = idEstudiante;
        this.idExamen = idExamen;
        this.idClase = idClase;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
    
    
}
