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
public class Examen {
    public int ID,IDClase,numPreguntas;

    public Examen(int ID, int IDClase, int numPreguntas) {
        this.ID = ID;
        this.IDClase = IDClase;
        this.numPreguntas = numPreguntas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDClase() {
        return IDClase;
    }

    public void setIDClase(int IDClase) {
        this.IDClase = IDClase;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }
    
    
}
