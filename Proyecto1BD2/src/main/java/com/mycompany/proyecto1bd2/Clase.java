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
public class Clase {
    public int IDClase;
    public String Nombre;

    public Clase(int IDClase, String Nombre) {
        this.IDClase = IDClase;
        this.Nombre = Nombre;
    }

    public int getIDClase() {
        return IDClase;
    }

    public void setIDClase(int IDClase) {
        this.IDClase = IDClase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
