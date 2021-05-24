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
public class Preguntas {
    public int ID,IDClase;
    public String Titulo,Descripcion;
    public boolean respuesta,puesta;

    public Preguntas(int ID, int IDClase, String Titulo, String Descripcion,boolean respuesta) {
        this.ID = ID;
        this.IDClase = IDClase;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.respuesta=respuesta;
        this.puesta=false;
    }

    public Preguntas() {
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

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public boolean getPuesta() {
        return puesta;
    }

    public void setPuesta(boolean puesta) {
        this.puesta = puesta;
    }
    
    
    
}
